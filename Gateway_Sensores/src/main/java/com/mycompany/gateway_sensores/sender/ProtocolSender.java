/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gateway_sensores.sender;

/**
 *
 * @author daniel
 */
public interface ProtocolSender {

    public void connect();

    public void send(String message);

}
