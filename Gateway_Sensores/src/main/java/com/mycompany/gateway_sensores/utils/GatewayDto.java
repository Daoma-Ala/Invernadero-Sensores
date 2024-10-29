/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gateway_sensores.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycompany.gateway_sensores.gateway.impl.Gateway;

/**
 *
 * @author daniel
 */
@lombok.Data
public class GatewayDto {

    private String series;
    private int captureTime;
    private String exchange;
    private boolean status;

    public GatewayDto() {
    }

    public GatewayDto(Gateway gateway) {
        this.series = gateway.getSeries();
        this.captureTime = gateway.getCaptureTime();
        this.exchange = gateway.getExchange();
        this.status = gateway.isStatus();
    }

    @JsonIgnore
    public Gateway getObjectGateway() {
        Gateway gateway = new Gateway(series, captureTime, exchange);
        gateway.setStatus(status);
        return gateway;
    }

}
