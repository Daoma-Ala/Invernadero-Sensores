/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador_sensores.dao.iml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.simulador_sensores.dao.SensorDAO;
import com.mycompany.simulador_sensores.protocol.impl.CoapProtocol;
import com.mycompany.simulador_sensores.sensor.Sensor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class SensorDAOImpl implements SensorDAO {

    private static final Logger LOGGER = Logger.getLogger(CoapProtocol.class.getName());
    private final String folderPath = "sensors";
    private final ObjectMapper mapper = new ObjectMapper();
    private final String typeDocument = ".json";
    private static SensorDAOImpl sensorDAOImpl;

    private SensorDAOImpl() {
    }

    public static synchronized SensorDAOImpl getInstance() {
        if (sensorDAOImpl == null) {
            sensorDAOImpl = new SensorDAOImpl();
        }
        return sensorDAOImpl;
    }

    @Override
    public void addSensor(Sensor sensor) {
        String nombreDocumento = nameDocument(sensor.getSerie());
        if (validateExistenceSensor(nombreDocumento)) {
            LOGGER.log(Level.SEVERE, "Error: An already exists "
                    + "sensor with specified file name");
            return;
        }
        try {
            mapper.writeValue(new File(nombreDocumento), sensor);
            LOGGER.info("Sensor saved successfully " + nombreDocumento);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Sensor saving error: ", ex);
        }
    }

    @Override
    public void updateSensor(Sensor sensor) {
        String nombreDocumento = nameDocument(sensor.getSerie());
        if (!validateExistenceSensor(nombreDocumento)) {
            LOGGER.log(Level.SEVERE, "Error: An already exists "
                    + "sensor with specified file name");
            return;
        }
        try {
            mapper.writeValue(new File(nombreDocumento), sensor);
            LOGGER.info("Sensor updated successfully " + nombreDocumento);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Sensor update error: ", ex);
        }
    }

    @Override
    public Sensor readSensor(String serie) {
        String nombreDocumento = nameDocument(serie);
        if (validateExistenceSensor(nombreDocumento)) {
            try {
                Sensor sensor = mapper.readValue(new File(nombreDocumento), Sensor.class);
                LOGGER.info("Sensor loaded correctly since" + nombreDocumento);
                return sensor;
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "Error when consulting sensor: ", ex);
            }
        }
        LOGGER.log(Level.SEVERE, "Error: An already exists "
                + "sensor with specified file name");
        return null;
    }

    @Override
    public List<Sensor> readAllSensors() {
        List<Sensor> sensores = new ArrayList<>();
        File folder = new File(folderPath);
        File[] archivos = folder.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().endsWith(typeDocument)) {
                    try {
                        Sensor sensor = mapper.readValue(archivo, Sensor.class);
                        sensores.add(sensor);
                    } catch (IOException ex) {
                        LOGGER.log(Level.SEVERE, "Error when consulting sensor: ", ex);
                    }
                }
            }
        }

        return sensores;
    }

    private String nameDocument(String serie) {
        return folderPath + File.separator + "sensor_" + serie + typeDocument;
    }

    private boolean validateExistenceSensor(String path) {
        File archivoNuevo = new File(path);
        if (archivoNuevo.exists()) {
            return true;
        }
        return false;
    }

}
