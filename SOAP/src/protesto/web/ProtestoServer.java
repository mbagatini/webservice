/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protesto.web;

import entidade.Protesto;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ProtestoServer {

    @WebMethod(operationName = "inserir")
    public boolean inserirProtesto(@WebParam(name = "cnpj")String cnpj, @WebParam(name = "nome")String nome, @WebParam(name = "data")Date data, @WebParam(name = "valor")double valor);
    
    @WebMethod(operationName = "alterar")
    public boolean alterarProtesto(@WebParam(name = "id")int id, @WebParam(name = "data")Date data, @WebParam(name = "valor")double valor);

    @WebMethod(operationName = "excluir")
    public boolean excluirProtesto(@WebParam(name = "id") int id);

    @WebMethod(operationName = "consultarCNPJ")
    @WebResult(name = "retorno")
    public Protesto[] consultarCNPJ(@WebParam(name = "cnpj") String cnpj);

    @WebMethod
    @WebResult(name = "retorno")
    public Protesto[] consultarTodos();

}
