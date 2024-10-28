/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.gateway_sensores.dao;

import com.mycompany.gateway_sensores.gateway.impl.Gateway;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface GatewayDAO {

    public void addGateway(Gateway gateway);

    public void updateGateway(Gateway gateway);

    public Gateway readGateway(String serie);

    public List<Gateway> readAllGateways();
}
