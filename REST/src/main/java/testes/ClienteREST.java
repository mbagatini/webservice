/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import entidade.Protesto;
import java.util.Date;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author morgana
 */
public class ClienteREST {

    public static void main(String args[]) {

        ClienteREST r = new ClienteREST();

        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://localhost:8080/rest");

        System.out.println("-------- LISTANDO TODOS --------");
        WebTarget resourceWebTarget = webTarget.path("rest//protesto//list");
        Invocation.Builder invocationBuilder
                = resourceWebTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.get();
        r.getResponse(response);

        System.out.println("-------- LISTANDO CNPJ --------");
        String cnpj = "01010101";
        resourceWebTarget = webTarget.path("rest//protesto//listcnpj//" + cnpj);
        invocationBuilder
                = resourceWebTarget.request(MediaType.APPLICATION_JSON_TYPE);

        response = invocationBuilder.get();
        r.getResponse(response);

        System.out.println("-------- INSERINDO --------");
        /*
        Protesto obj = new Protesto("01010101", "Teste REST", new Date(90), 74747);
        resourceWebTarget = webTarget.path("rest//protesto//add");
        Invocation.Builder deleteInvocationBuilder = resourceWebTarget.request();
        Response post = deleteInvocationBuilder.post(Entity.entity(obj, MediaType.APPLICATION_JSON_TYPE));
        r.getResponse(post);
         */

        System.out.println("-------- EXCLUINDO --------");
        /*
        String id = "104";
        resourceWebTarget = webTarget.path("rest//protesto//delete//"+ id);
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response delete = invocationBuilder.delete();
        r.getResponse(delete);
         */

        System.out.println("-------- ALTERANDO --------");
        /*
        Protesto obj = new Protesto("01010101", "Teste REST", new Date(90), 90);
        String idEdit = "108";
        resourceWebTarget = webTarget.path("rest//protesto//edit//"+idEdit);
        Invocation.Builder deleteInvocationBuilder = resourceWebTarget.request();
        Response put = deleteInvocationBuilder.put(Entity.entity(obj, MediaType.APPLICATION_JSON_TYPE));
        r.getResponse(put);
         */

    }

    public void getResponse(Response response) {
        System.out.println("-- Response --");
        System.out.println(response.getStatus());
        String p = response.readEntity(String.class);
        System.out.println(p);
    }

}
