/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador_sensores.sensor;

import com.mycompany.simulador_sensores.protocol.Protocol;
import lombok.Data;

/**
 *
 * @author daniel
 */
@Data
public abstract class Sensor {

    protected String serie;
    protected int timeInterval;
    protected boolean status;
    protected Protocol protocol;

    public abstract void startSensor();

    public abstract void stopSensor();
}
