/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.rest;

import dao.ProtestoDAO;
import entidade.Protesto;
import java.util.Date;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adm
 */

@Path("/protesto")
public class ProtestoService {
    
    ProtestoDAO protestoDAO;
    
    public ProtestoService(){
        protestoDAO = new ProtestoDAO();
    }
    
    @GET
    @Path("/list")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Protesto> consultarTodos() {
        System.out.println("---------------- Listando protestos");
        List<Protesto> p = protestoDAO.consultarTodos();
        return p;
    }
    
    @GET
    @Path("/listcnpj/{cnpj}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Protesto> consultarCNPJ(@PathParam("cnpj")String cnpj) {
        System.out.println("---------------- Listando protestos por CNPJ " + cnpj);
        List<Protesto> p = protestoDAO.consultarCNPJ(cnpj);
        return p;
    }
    
    @POST
    @Path("/add")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean inserirProtesto(Protesto p) {
        System.out.println("---------------- Inserindo protestos "+p.toString());
        try {
            return (protestoDAO.salvar(p) == null);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @POST
    @Path("/add/{cnpj}/{nome}/{data}/{valor}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean inserirProtesto(@PathParam("cnpj")String cnpj, @PathParam("nome")String nome, @PathParam("data")Date data, @PathParam("valor")double valor) {
        System.out.println("---------------- Inserindo protestos "+cnpj+" "+nome+" "+data+" "+valor+" ");
        try {
            Protesto p = new Protesto(cnpj, nome, data, valor);
            return (protestoDAO.salvar(p) == null);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean excluirProtesto(@PathParam("id")int id) {
       System.out.println("---------------- Excluindo protestos");
        try {
            return (protestoDAO.excluir(id) == null);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @PUT
    @Path("/edit/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean alterarProtesto(@PathParam("id")int id, Protesto o) {
        System.out.println("---------------- Alterando protestos");
        try {
            Protesto p = protestoDAO.consultarID(id);
            p.setData(o.getData());
            p.setValor(o.getValor());
            return (protestoDAO.atualizar(p) == null);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @PUT
    @Path("/edit/{id}/{data}/{valor}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean alterarProtesto(@PathParam("id")int id, @PathParam("data")Date data, @PathParam("valor")double valor) {
        System.out.println("---------------- Alterando protestos");
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
