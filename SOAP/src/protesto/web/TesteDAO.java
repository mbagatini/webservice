/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protesto.web;

import dao.ProtestoDAO;
import entidade.Protesto;
import java.util.Date;

/**
 *
 * @author adm
 */
public class TesteDAO {
    
    public static void main(String[] args) {
        ProtestoDAO p = new ProtestoDAO();
        
//        Protesto po = new Protesto();
//        po.setCnpj("123455698");
//        po.setNome("Meu nome");
//        po.setData(new java.sql.Date(0));
//        po.setValor(300);
//        
//        p.salvar(po);
        
        p.consultarTodos();
    }
    
}
