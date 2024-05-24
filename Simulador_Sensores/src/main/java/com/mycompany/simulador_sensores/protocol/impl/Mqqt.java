/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador_sensores.protocol.impl;

import com.mycompany.simulador_sensores.protocol.Protocol;

/**
 * Class that implements the logic for sending messages asynchronously using the
 * Mqqt protocol
 *
 * @author daniel
 */
public class Mqqt implements Protocol {

    /**
     * Connects to the Mqqt communication protocol
     */
    @Override
    public void connect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Disconnects from the Mqqt communication protocol
     */
    @Override
    public void disconnect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Publishes a message to the Mqqt protocol
     *
     * @param message message to be published
     */
    @Override
    public void publish(String message) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
