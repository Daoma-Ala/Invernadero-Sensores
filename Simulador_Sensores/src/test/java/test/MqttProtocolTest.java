/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import com.mycompany.simulador_sensores.protocol.impl.MqttProtocol;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author daniel
 */
public class MqttProtocolTest {

    @Mock
    private MqttClient mqttClient;

    private MqttProtocol mqttProtocol;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mqttProtocol = MqttProtocol.builder()
                .broker("tcp://broker.emqx.io:1883")
                .clientId("testClient")
                .topic("testTopic")
                .client(mqttClient)
                .build();
    }

    @Test
    void testPublish() throws MqttException {
        doNothing().when(mqttClient).publish(anyString(), any(MqttMessage.class));

        String message = "Test Message";
        mqttProtocol.publish(message);

        verify(mqttClient, times(1)).publish(eq("testTopic"), any(MqttMessage.class)); // Cambiado anyString() por eq("testTopic")
    }

}
