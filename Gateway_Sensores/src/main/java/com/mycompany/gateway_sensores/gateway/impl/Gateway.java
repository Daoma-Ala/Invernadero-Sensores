/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gateway_sensores.gateway.impl;

import com.mycompany.gateway_sensores.gateway.IGateway;
import com.mycompany.gateway_sensores.receiver.factory.FactoryProtocol;
import com.mycompany.gateway_sensores.helpers.MessageProcess;
import com.mycompany.gateway_sensores.receiver.ProtocolReceiver;
import com.mycompany.gateway_sensores.sender.ProtocolSender;
import com.mycompany.utilities.formatoGateway.MessageFormat;
import com.mycompany.gateway_sensores.utils.oberser.Observable;
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
@lombok.EqualsAndHashCode
public class Gateway implements IGateway {

    private String series;
    private boolean status;
    private final List<ProtocolReceiver> sensors = new ArrayList<>();
    private ProtocolSender server;
    private final List<MessageFormat> mensajes = new ArrayList<>();
    private transient ScheduledExecutorService scheduler;
    private int captureTime;
    private final List<Observable> observables = new ArrayList<>();

    public Gateway() {
    }

    public Gateway(String series, int captureTime) {
        this.series = series;
        this.captureTime = captureTime;
        setProtocolsReceiver(series);
        setProtocolSender();
    }

    private void setProtocolsReceiver(String series) {
        sensors.add(FactoryProtocol.createProtocolReceiverCoap(series, this));
        sensors.add(FactoryProtocol.createProtocolReceiverMqqt(series, this));

    }

    private void setProtocolSender() {
        server = FactoryProtocol.createProtocolSenderRabbit();
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

    public void startGateway() {
        startSensors();
        starServer();
        status = true;
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::sendMessageServer, 0, captureTime, TimeUnit.MINUTES);
    }

    public void finishGateway() {
        status = false;
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
        notificar();

    }

    public void addObservable(Observable observable) {
        this.observables.add(observable);
    }

    private void notificar() {
        for (Observable observable : observables) {
            observable.update();
        }
    }
}
