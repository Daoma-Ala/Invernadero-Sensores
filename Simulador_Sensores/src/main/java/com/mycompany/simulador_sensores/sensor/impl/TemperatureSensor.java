/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador_sensores.sensor.impl;

import com.mycompany.simulador_sensores.sensor.Sensor;
import lombok.Builder;

/**
 * Class representing a temperature sensor. This class implements the behavior
 * specific to temperature sensors.
 *
 * @author daniel
 */
@Builder
public class TemperatureSensor extends Sensor {

    /**
     * Starts the temperature sensor operation. This method initializes and
     * begins the data collection process specific to temperature.
     */
    @Override
    public void startSensor() {

        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Stops the temperature sensor operation. This method halts the data
     * collection process and performs necessary cleanup specific to
     * temperature.
     */
    @Override
    public void stopSensor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
