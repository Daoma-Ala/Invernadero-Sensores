/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gateway_sensores.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.utilities.formatGateway.Data;
import com.mycompany.utilities.formatGateway.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author daniel
 */
public class MessageProcess {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static MessageFormat messageFormat(String message) {

        try {
            JsonNode rootNode = mapper.readTree(message);
            String serie = rootNode.get("serie").asText();
            int interval = rootNode.get("timeInterval").asInt();
            String date = rootNode.get("captureData").asText();
            List<Data> data = parseDataNodes(rootNode.get("data"));

            return new MessageFormat(serie, date, data, interval);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error procesando JSON", e);
        }
    }

    private static List<Data> parseDataNodes(JsonNode medicionesNode) {
        List<Data> data = new ArrayList<>();
        if (medicionesNode != null) {
            for (JsonNode medidaNode : medicionesNode) {
                String type = medidaNode.get("type").asText();
                Optional<String> magnitude = getMagnitudeByType(medidaNode, type);
                float value = medidaNode.get("value").floatValue();
                data.add(new Data(type, magnitude.orElse(null), value));
            }
        }
        return data;
    }

    private static Optional<String> getMagnitudeByType(JsonNode medidaNode, String type) {
        if ("temperature".equals(type) && medidaNode.has("temperatureUnit")) {
            return Optional.of(medidaNode.get("temperatureUnit").asText());
        } else if ("humidity".equals(type) && medidaNode.has("humidityUnit")) {
            return Optional.of(medidaNode.get("humidityUnit").asText());
        }
        return Optional.empty();
    }

}
