/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.simulador_sensores.protocol;

/**
 * Interface that defines methods for using the protocol
 *
 * @author daniel
 */
public interface Protocol {

    /**
     * Connects to the communication protocol
     */
    public void connect();

    /**
     * Disconnects from the communication protocol
     */
    public void disconnect();

    /**
     * Publishes a message to the protocol
     *
     * @param message message to be published
     */
    public void publish(String message);

}
