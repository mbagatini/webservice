/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protesto.web;

import dao.*;
import entidade.Protesto;
import java.util.ArrayList;

import javax.jws.WebService;

@WebService(endpointInterface = "protesto.web.ProtestoServer")
public class ProtestoServerImpl implements ProtestoServer {

    ProtestoDAO p = new ProtestoDAO();

    /*
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
        <Body>
            <consultarTodos xmlns="http://web.protesto/"/>
        </Body>
    </Envelope>
    */
    @Override
    public Protesto[] consultarTodos() {
        ArrayList<Protesto> a = p.consultarTodos();
        Protesto[] pro = new Protesto[a.size()];
        
        for (int i = 0; i < a.size(); i++) {
            pro[i] = a.get(i);
        }
        
        return pro;
    }
}
