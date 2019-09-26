/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author morgana
 */
public class ClienteRodolfo {

    public static void main(String args[]) {

        ClienteRodolfo cli = new ClienteRodolfo();
        try {
//            System.out.println("-------- LISTANDO TODOS --------");
//            cli.sendPost("acao=select");

//            System.out.println("-------- LISTANDO POR ID --------");
//            cli.sendPost("acao=select&id=5");
//            
//            System.out.println("-------- INSERINDO --------");
//            cli.sendPost("acao=insert&id=null&datahora=null&valortotal=6443.00&cliente=11");
//            
//            System.out.println("-------- EXCLUINDO --------");
//            cli.sendPost("acao=delete&id=8");


            // SOAP
            System.out.println("-------- LISTANDO TODOS --------");
            cli.sendGet();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            Logger.getLogger(ClienteRodolfo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // HTTP GET request
    private void sendGet() throws Exception {

        String url = "https://infosulst.com.br//api//soapServer2.php?acao=select";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    // HTTP POST request
    private void sendPost(String param) throws Exception {

        String url = "https://infosulst.com.br//api//rest.php";
        //String url = "https://infosulst.com.br//api//soapServer.php";

        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");

        String urlParameters = param;

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

}
