/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador_sensores.data.impl;

import com.mycompany.simulador_sensores.data.DataSen;
import lombok.Builder;
import lombok.Data;

/**
 * Class that defines the temperature for sensors
 *
 * @author daniel
 */
@Data
@Builder
public class TemperatureData implements DataSen {

    private float value;
    private TemperatureData temperatureData;

    /**
     * Method for sensing data
     */
    @Override
    public void sense() {
        int min = 10;
        int max = 30;
        this.value = (float) (min + Math.random() * (max - min));
    }

}
