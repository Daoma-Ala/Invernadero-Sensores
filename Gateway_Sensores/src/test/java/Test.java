
import com.mycompany.gateway_sensores.dao.GatewayDAO;
import com.mycompany.gateway_sensores.dao.impl.GatewayDAOImpl;
import com.mycompany.gateway_sensores.gateway.impl.Gateway;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author daniel
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        GatewayDAO gatewayDAO = GatewayDAOImpl.getInstance();

        gatewayDAO.addGateway(new Gateway("asd", 2, "123"));

        Gateway gateway = gatewayDAO.readGateway("asd");

        System.out.println(gateway.getCaptureTime());

    }

}
