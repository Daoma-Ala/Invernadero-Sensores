/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gateway_sensores.gateway.impl;

import com.mycompany.gateway_sensores.gateway.IGateway;
import com.mycompany.gateway_sensores.helpers.FactoryProtocol;
import com.mycompany.gateway_sensores.helpers.MessageProcess;
import com.mycompany.gateway_sensores.receiver.ProtocolReceiver;
import com.mycompany.gateway_sensores.sender.ProtocolSender;
import com.mycompany.gateway_sensores.message.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author daniel
 */
@lombok.Data
public class Gateway implements IGateway {

    private String series;
    private String exchange;
    private final List<ProtocolReceiver> sensors = new ArrayList<>();
    private ProtocolSender server;
    private final List<MessageFormat> mensajes = new ArrayList<>();
    private transient ScheduledExecutorService scheduler;
    private int captureTime;

    public Gateway() {
    }

    public Gateway(String series, int captureTime, String exchange) {
        this.series = series;
        this.exchange = exchange;
        this.captureTime = captureTime;
        setProtocolsReceiver(series);
        setProtocolSender(exchange);
    }

    private void setProtocolsReceiver(String series) {
        sensors.add(FactoryProtocol.createProtocolReceiverCoap(series, this));
        sensors.add(FactoryProtocol.createProtocolReceiverMqqt(series, this));
        server = FactoryProtocol.createProtocolSenderRabbit(series);
    }

    private void setProtocolSender(String exchange) {
        server = FactoryProtocol.createProtocolSenderRabbit(exchange);
    }

    public void startGateway() {
        startSensors();
        starServer();
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::sendMessageServer, 0, captureTime, TimeUnit.MINUTES);
    }

    private void startSensors() {
        for (ProtocolReceiver sensor : sensors) {
            sensor.connect();
            sensor.subscribe();
        }
    }

    private void starServer() {
        server.connect();
    }

    public void finishGateway() {
        for (ProtocolReceiver protocolReceiver : sensors) {
            protocolReceiver.desconnect();
        }
        if (scheduler != null) {
            scheduler.shutdown();
            try {
                if (!scheduler.awaitTermination(1, TimeUnit.MINUTES)) {
                    scheduler.shutdownNow();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                scheduler.shutdownNow();
            }
        }
    }

    private void sendMessageServer() {
        synchronized (mensajes) {
            if (!mensajes.isEmpty()) {
                String jsonPayload = MessageProcess.constructJsonArray(mensajes);
                server.send(jsonPayload);
                mensajes.clear();
            }
        }

    }

    @Override
    public void processMessage(MessageFormat message) {
        message.setGateway(series);
        this.mensajes.add(message);
    }

}
