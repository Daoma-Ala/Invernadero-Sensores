/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gateway_sensores.helpers;

import com.mycompany.gateway_sensores.gateway.IGateway;
import com.mycompany.gateway_sensores.receiver.ProtocolReceiver;
import com.mycompany.gateway_sensores.receiver.impl.ProtocolReceiverCoap;
import com.mycompany.gateway_sensores.receiver.impl.ProtocolReceiverMqqt;
import com.mycompany.gateway_sensores.sender.ProtocolSender;
import com.mycompany.gateway_sensores.sender.impl.ProtocolSenderRabbit;

/**
 *
 * @author daniel
 */
public class FactoryProtocol {

    public static ProtocolReceiver createProtocolReceiverCoap(String serie,
            IGateway gateway) {
        String coapServerUri = "coap://localhost:5683/" + serie;
        return new ProtocolReceiverCoap(coapServerUri, gateway);
    }

    public static ProtocolReceiver createProtocolReceiverMqqt(String serie,
            IGateway gateway) {
        String broker = "tcp://broker.emqx.io:1883";
        String topic = "sensor/" + serie;
        String clienteId = serie;
        return new ProtocolReceiverMqqt(broker, clienteId, topic, gateway);
    }

    public static ProtocolSender createProtocolSenderRabbit(String exchange) {
        return new ProtocolSenderRabbit(exchange);
    }
}
