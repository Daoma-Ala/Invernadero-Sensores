/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import com.mycompany.simulador_sensores.protocol.impl.CoapProtocol;
import org.eclipse.californium.core.CoapClient;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author daniel
 */
public class CoapProtocolTest {

    private CoapProtocol coapProtocol;

    @Mock
    private CoapClient coapClientMock;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        coapProtocol = coapProtocol.builder()
                .client(coapClientMock)
                .coapServerUri("coap://example.com/test")
                .build();
    }

}
