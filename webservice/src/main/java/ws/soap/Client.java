/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.soap;

import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {

    public static void main(String args[]) throws Exception {

        // URL do meu web service
        URL url = new URL("http://localhost:9876/protesto?wsdl");

        QName qname = new QName("http://soap.ws/", "ProtestoServerImplService");

        Service ws = Service.create(url, qname);
        System.out.println(ws.getServiceName());
        ProtestoServer cli = ws.getPort(ProtestoServer.class);

        System.out.println("CONSULTA TODOS"); 
        System.out.println(Arrays.toString(cli.consultarTodos()));
        System.out.println("-----------------");
        
        System.out.println("CONSULTA POR CNPJ"); 
        System.out.println(Arrays.toString(cli.consultarCNPJ("1612042264299")));
        System.out.println("-----------------");
        
        System.out.println("INSERE"); 
        //System.out.println(cli.inserirProtesto("027.614.870-36", "MORGANA", new Date(), 6000));
        System.out.println("-----------------");
        
        System.out.println("ALTERA"); 
        //System.out.println(cli.alterarProtesto(106, new Date(90), 5000));
        System.out.println("-----------------");
        
        System.out.println("EXCLUI"); 
        //System.out.println(cli.excluirProtesto(106));
        System.out.println("-----------------");
    }
}
