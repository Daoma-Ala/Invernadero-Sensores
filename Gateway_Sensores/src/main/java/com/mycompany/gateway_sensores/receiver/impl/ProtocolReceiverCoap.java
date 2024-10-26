/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gateway_sensores.receiver.impl;

import org.eclipse.californium.core.CoapServer;

import com.mycompany.gateway_sensores.receiver.IProtocolReceiver;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 *
 * @author daniel
 */
public class ProtocolReceiverCoap implements IProtocolReceiver {

    private final CoapServer coapServer;
    private final String resource;

    public ProtocolReceiverCoap(String resource) {
        this.resource = resource;
        this.coapServer = new CoapServer();
    }

    @Override
    public void subscribe() {
        coapServer.add(new CoapResource(resource) {
            @Override
            public void handlePOST(CoapExchange exchange) {
                String payload = exchange.getRequestText();
                System.out.println("Mensaje recibido del sensor: " + payload);
                processMessage(payload);
                exchange.respond(CoAP.ResponseCode.CREATED);
            }
        });
    }

    @Override
    public void connect() {
        coapServer.start();
        System.out.println("Servidor CoAP encendido");
    }

    @Override
    public void desconnect() {
        coapServer.stop();
        System.out.println("Servidor CoAP detenido");
    }

    private void processMessage(String message) {
//        MessageFormat proccesMessage = messageProcess.messageFormat(message);
//        gateway.processMessage(proccesMessage);
    }

}
