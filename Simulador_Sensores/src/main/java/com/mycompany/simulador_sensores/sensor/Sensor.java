/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador_sensores.sensor;

import com.mycompany.simulador_sensores.data.DataSen;
import com.mycompany.simulador_sensores.protocol.Protocol;
import com.mycompany.simulador_sensores.utils.MapperToJson;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Class abstract that models the behavior of sensors. This class serves as a
 * base for defining various types of sensors.
 *
 * @author daniel
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {

    /**
     * Series number associated with the sensor
     */
    private String serie;

    /**
     * Time interval (in seconds) at which the sensor sends data
     */
    private int timeInterval;

    /**
     * Current status of the sensor (true if active, false otherwise)
     */
    private boolean status;

    /**
     * Protocol used for communication by the sensor
     */
    private Protocol protocol;

    /**
     * Data interface used by the sensor to capture measurements
     */
    private List<DataSen> data;

    @JsonIgnore
    private transient ScheduledExecutorService scheduler;
    private static final Logger LOGGER = Logger.getLogger(Sensor.class.getName());

    /**
     * Starts the sensor operation. This method is used to initialize and begin
     * the sensor's data collection process.
     */
    public void startSensor() {
        if (isSensorRunning()) {
            LOGGER.info("The sensor is already running");
            return;
        }
        initializeScheduler();
        startDataCollection();
    }

    /**
     * Stops the sensor operation. This method is used to halt the sensor's data
     * collection process and perform any necessary cleanup.
     */
    public void stopSensor() {
        if (!status) {
            LOGGER.info("The sensor is not already running");
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

    private void takeData() {
        for (DataSen dataImp : data) {
            dataImp.sense();
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
