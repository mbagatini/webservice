/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.soap;

import dao.*;
import entidade.Protesto;
import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebService;

@WebService(endpointInterface = "ws.soap.ProtestoServer")
public class ProtestoServerImpl implements ProtestoServer {

    ProtestoDAO protestoDAO = new ProtestoDAO();

    /*
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
        <Body>
            <consultarTodos xmlns="http://soap.protesto/"/>
        </Body>
    </Envelope>
     */
    @Override
    public Protesto[] consultarTodos() {
        ArrayList<Protesto> a = protestoDAO.consultarTodos();
        Protesto[] pro = new Protesto[a.size()];

        for (int i = 0; i < a.size(); i++) {
            pro[i] = a.get(i);
        }

        return pro;
    }

    /*
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
        <Body>
            <consultarCNPJ xmlns="http://soap.protesto/">
                <cnpj>[string]</cnpj>
            </consultarCNPJ>
        </Body>
    </Envelope>
     */
    @Override
    public Protesto[] consultarCNPJ(String cnpj) {
        ArrayList<Protesto> a = protestoDAO.consultarCNPJ(cnpj);
        Protesto[] pro = new Protesto[a.size()];

        for (int i = 0; i < a.size(); i++) {
            pro[i] = a.get(i);
        }

        return pro;
    }

    @Override
    public boolean inserirProtesto(String cnpj, String nome, Date data, double valor) {
        try {
            Protesto p = new Protesto(cnpj, nome, data, valor);
            return (protestoDAO.salvar(p) == null);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean excluirProtesto(int id) {
        try {
            return (protestoDAO.excluir(id) == null);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean alterarProtesto(int id, Date data, double valor) {
        try {
            Protesto p = protestoDAO.consultarID(id);
            p.setData(data);
            p.setValor(valor);
            return (protestoDAO.atualizar(p) == null);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
