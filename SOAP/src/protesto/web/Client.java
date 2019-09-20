/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protesto.web;

// https://www.devmedia.com.br/desenvolvendo-e-usando-web-services-em-java/37261
import dao.ProtestoDAO;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {

    public static void main(String args[]) throws Exception {
        
        // URL do meu web service
        URL url = new URL("http://localhost:9876/protesto?wsdl");

        QName qname = new QName("http://web.protesto/", "ProtestoServerImplService");

        Service ws = Service.create(url, qname);
        System.out.println(ws.getServiceName());
        ProtestoServer cli = ws.getPort(ProtestoServer.class);

        System.out.println("Retorno: " + cli.consultarTodos());

    }
}
