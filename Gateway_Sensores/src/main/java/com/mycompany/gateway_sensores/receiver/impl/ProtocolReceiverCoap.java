/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gateway_sensores.receiver.impl;

import com.mycompany.gateway_sensores.gateway.IGateway;
import com.mycompany.gateway_sensores.helpers.MessageProcess;
import org.eclipse.californium.core.CoapServer;
import com.mycompany.utilities.formatoGateway.MessageFormat;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;
import com.mycompany.gateway_sensores.receiver.ProtocolReceiver;
import com.mycompany.gateway_sensores.receiver.impl.protocolCoap.ServerCoap;

/**
 *
 * @author daniel
 */
public class ProtocolReceiverCoap implements ProtocolReceiver {

    private final CoapServer coapServer = ServerCoap.getInstance();
    private final String resource;
    private IGateway gateway;

    public ProtocolReceiverCoap(String resource, IGateway gateway) {
        this.resource = resource;
        this.gateway = gateway;
    }

    @Override
    public void subscribe() {
        coapServer.add(new CoapResource(resource) {
            @Override
            public void handlePOST(CoapExchange exchange) {
                String payload = exchange.getRequestText();
                System.out.println("Mensaje recibido del sensor: " + payload);
                processMessage(payload);
                exchange.respond(CoAP.ResponseCode.CONTENT, "Request received");
            }
        });
    }

    @Override
    public void connect() {
        ServerCoap.connect(this);
        System.out.println("Servidor CoAP encendido");
    }

    @Override
    public void desconnect() {
        coapServer.remove(new CoapResource(resource));
        ServerCoap.desconnect(this);
    }

    private void processMessage(String message) {
        MessageFormat proccesMessage = MessageProcess.messageFormat(message);
        gateway.processMessage(proccesMessage);
    }

}
