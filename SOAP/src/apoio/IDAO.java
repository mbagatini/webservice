/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.util.ArrayList;

/**
 *
 * @author pretto
 */
public interface IDAO <T> {

    public String salvar (T objeto);

    public String atualizar(T o);

    public String excluir(String cnpj);

    public ArrayList<T> consultarTodos();
   
    public ArrayList<T> consultar(String criterio);

    public Object consultarCNPJ(String cnpj);
    
}
