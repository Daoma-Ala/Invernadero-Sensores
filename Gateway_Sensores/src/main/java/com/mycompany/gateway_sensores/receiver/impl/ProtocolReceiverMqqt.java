/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gateway_sensores.receiver.impl;

import com.mycompany.gateway_sensores.gateway.IGateway;
import com.mycompany.gateway_sensores.helpers.MessageProcess;
import com.mycompany.gateway_sensores.receiver.ProtocolReceiver;
import com.mycompany.gateway_sensores.message.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author daniel
 */
public class ProtocolReceiverMqqt implements ProtocolReceiver {

    private transient MqttClient client;
    private final String broker;
    private final String clientId;
    private final String topic;
    private IGateway gateway;

    public ProtocolReceiverMqqt(String broker, String clientId, String topic, IGateway gateway) {
        this.broker = broker;
        this.clientId = clientId;
        this.topic = topic;
        this.gateway = gateway;
    }

    @Override
    public void subscribe() {
        try {
            client.subscribe(topic);
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("Conexión perdida con el broker");
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    String messageReceiver = new String(message.getPayload());
                    MessageFormat format = processMessage(messageReceiver);
                    System.out.println("Mensaje recibido del tema '" + topic
                            + "': " + format);

                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    System.out.println("Entrega completa");
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connect() {
        try {
            client = new MqttClient(broker, clientId, new MemoryPersistence());
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            client.connect(connOpts);
            System.out.println("Conectado al broker: " + broker);
        } catch (MqttException ex) {
            System.err.println("Error al conectarse al broker: " + ex.getMessage());
            Logger.getLogger(ProtocolReceiverMqqt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void desconnect() {
        if (client != null && client.isConnected()) {
            try {
                client.disconnect();
                System.out.println("Desconectado del broker");
            } catch (MqttException ex) {
                Logger.getLogger(ProtocolReceiverMqqt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private MessageFormat processMessage(String message) {
        MessageFormat proccesMessage = MessageProcess.messageFormat(message);
        gateway.processMessage(proccesMessage);
        return proccesMessage;
    }

}
