/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador_sensores.sensor;

import com.mycompany.simulador_sensores.data.DataSen;
import com.mycompany.simulador_sensores.protocol.Protocol;
import com.mycompany.simulador_sensores.protocol.impl.CoapProtocol;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;
import lombok.Data;

/**
 * Class abstract that models the behavior of sensors. This class serves as a
 * base for defining various types of sensors.
 *
 * @author daniel
 */
@Data
public abstract class Sensor {

    /**
     * Series number associated with the sensor
     */
    protected String serie;

    /**
     * Time interval (in seconds) at which the sensor sends data
     */
    protected int timeInterval;

    /**
     * Current status of the sensor (true if active, false otherwise)
     */
    protected boolean status;

    /**
     * Protocol used for communication by the sensor
     */
    protected Protocol protocol;

    /**
     * Data interface used by the sensor to capture measurements
     */
    protected DataSen data;

    protected transient ScheduledExecutorService scheduler;
    protected static final Logger LOGGER = Logger.getLogger(Sensor.class.getName());

    /**
     * Starts the sensor operation. This method is used to initialize and begin
     * the sensor's data collection process.
     */
    protected abstract void startSensor();

    /**
     * Stops the sensor operation. This method is used to halt the sensor's data
     * collection process and perform any necessary cleanup.
     */
    protected abstract void stopSensor();

    protected void takeData() {
        this.data.sense();
    }

}
