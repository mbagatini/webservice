/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.ProtestoDAO;

/**
 *
 * @author adm
 */
public class TesteDAO {
    
    public static void main(String[] args) {
        ProtestoDAO p = new ProtestoDAO();
        
        System.out.println("TODOS");
        System.out.println(p.consultarTodos().toString());
        System.out.println("-----------------");
        
        System.out.println("POR CNPJ");
        System.out.println(p.consultarCNPJ("1612042264299").toString());
        System.out.println("-----------------");
        
        System.out.println("INSERE");
        //System.out.println(p.salvar(new Protesto("01010101", "TESTE", new Date(50), 0)));
        System.out.println("-----------------");
    }
    
}
