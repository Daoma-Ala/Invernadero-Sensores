/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador_sensores.sensor.impl;

import com.mycompany.simulador_sensores.sensor.Sensor;
import lombok.Builder;

/**
 * Class representing a humidity sensor. This class implements the behavior
 * specific to humidity sensors.
 *
 * @author daniel
 */
@Builder
public class HumiditySensor extends Sensor {

    /**
     * Starts the humidity sensor operation. This method initializes and begins
     * the data collection process specific to humidity.
     */
    @Override
    public void startSensor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Stops the humidity sensor operation. This method halts the data
     * collection process and performs necessary cleanup specific to humidity.
     */
    @Override
    public void stopSensor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
