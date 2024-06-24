/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador_sensores.sensor.impl;

import com.mycompany.simulador_sensores.sensor.Sensor;
import com.mycompany.simulador_sensores.utils.MapperToJson;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import lombok.experimental.SuperBuilder;

/**
 * Class representing a humidity sensor. This class implements the behavior
 * specific to humidity sensors.
 *
 * @author daniel
 */
@SuperBuilder
public class HumiditySensor extends Sensor {

    /**
     * Starts the humidity sensor operation. This method initializes and begins
     * the data collection process specific to humidity.
     */
    @Override
    public void startSensor() {
        if (isSensorRunning()) {
            LOGGER.info("The humidity sensor is already running");
            return;
        }
        initializeScheduler();
        startDataCollection();
    }

    /**
     * Stops the humidity sensor operation. This method halts the data
     * collection process and performs necessary cleanup specific to humidity.
     */
    @Override
    public void stopSensor() {
        if (!status) {
            LOGGER.info("The humidity sensor is not already running");
            return;
        }
        setStatus(false);
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdownNow();
        }
        try {
            protocol.disconnect();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    private boolean isSensorRunning() {
        return status && scheduler != null && !scheduler.isShutdown();
    }

    private void initializeScheduler() {
        setStatus(true);
        if (scheduler == null || scheduler.isShutdown()) {
            scheduler = Executors.newScheduledThreadPool(1);
        }
    }

    private void startDataCollection() {
        try {
            protocol.connect();
            Runnable metodo = () -> {
                takeData();
                publishData();
            };
            scheduler.scheduleAtFixedRate(metodo, 0, timeInterval, TimeUnit.SECONDS);
        } catch (Exception ex) {
            setStatus(false);
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    private void publishData() {
        try {
            protocol.publish(MapperToJson.mapperToJsonSensor(this));
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        System.out.println(this.toString());
    }

}
