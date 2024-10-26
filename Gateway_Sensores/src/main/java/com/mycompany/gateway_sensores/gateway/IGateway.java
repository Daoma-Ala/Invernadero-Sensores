/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.gateway_sensores.gateway;

import com.mycompany.gateway_sensores.message.MessageFormat;

/**
 *
 * @author daniel
 */
public interface IGateway {

    public void processMessage(MessageFormat message);
}
