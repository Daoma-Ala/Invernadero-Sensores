/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gateway_sensores.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.gateway_sensores.dao.GatewayDAO;
import com.mycompany.gateway_sensores.gateway.impl.Gateway;
import com.mycompany.gateway_sensores.utils.GatewayDto;
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
public class GatewayDAOImpl implements GatewayDAO {

    private static final Logger LOGGER = Logger.getLogger(GatewayDAOImpl.class.getName());
    private final String folderPath = "gateways";
    private final ObjectMapper mapper = new ObjectMapper();
    private final String typeDocument = ".json";
    private static GatewayDAOImpl gatewayDAOImpl;

    public GatewayDAOImpl() {
    }

    public static synchronized GatewayDAOImpl getInstance() {
        if (gatewayDAOImpl == null) {
            gatewayDAOImpl = new GatewayDAOImpl();
        }
        return gatewayDAOImpl;
    }

    @Override
    public void addGateway(Gateway gateway) {
        String nombreDocumento = nameDocument(gateway.getSeries());
        if (validateExistenceGateway(nombreDocumento)) {
            LOGGER.log(Level.SEVERE, "Error: An already exists "
                    + "gateway with specified file name");
            throw new IllegalArgumentException("Ya existe un gateway con la serie: " + gateway.getSeries());
        }
        try {
            GatewayDto gatewayDto = new GatewayDto(gateway);
            mapper.writeValue(new File(nombreDocumento), gatewayDto);
            LOGGER.info("Gateway saved successfully " + nombreDocumento);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Gateway saving error: ", ex);
        }
    }

    @Override
    public void updateGateway(Gateway gateway) {
        String nombreDocumento = nameDocument(gateway.getSeries());
        if (!validateExistenceGateway(nombreDocumento)) {
            LOGGER.log(Level.SEVERE, "Error: An already exists "
                    + "gateway with specified file name");
            return;
        }
        try {
            mapper.writeValue(new File(nombreDocumento), new GatewayDto(gateway));
            LOGGER.info("Gateway updated successfully " + nombreDocumento);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Gateway update error: ", ex);
        }
    }

    @Override
    public Gateway readGateway(String serie) {

        String nombreDocumento = nameDocument(serie);
        if (validateExistenceGateway(nombreDocumento)) {
            try {
                GatewayDto gatewayDto = mapper.readValue(new File(nombreDocumento), GatewayDto.class);
                LOGGER.info("Gateway loaded correctly since" + nombreDocumento);
                return gatewayDto.getObjectGateway();
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "Error when consulting gateway: ", ex);
            }
        }
        LOGGER.log(Level.SEVERE, "Error: An already exists "
                + "gateway with specified file name");
        return null;
    }

    @Override
    public List<Gateway> readAllGateways() {

        List<Gateway> gateways = new ArrayList<>();
        File folder = new File(folderPath);
        File[] archivos = folder.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().endsWith(typeDocument)) {
                    try {
                        GatewayDto gatewayDto = mapper.readValue(archivo, GatewayDto.class);
                        gateways.add(gatewayDto.getObjectGateway());
                    } catch (IOException ex) {
                        LOGGER.log(Level.SEVERE, "Error when consulting gateway: ", ex);
                    }
                }
            }
        }

        return gateways;
    }

    private String nameDocument(String serie) {
        return folderPath + File.separator + "gateway_" + serie + typeDocument;
    }

    private boolean validateExistenceGateway(String path) {
        File archivoNuevo = new File(path);
        if (archivoNuevo.exists()) {
            return true;
        }
        return false;
    }

}
