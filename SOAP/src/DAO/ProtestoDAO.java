/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.Protesto;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProtestoDAO implements IDAO<Protesto> {

    @Override
    public String salvar(Protesto objeto) {
        try {
            String sql = "INSERT INTO protesto VALUES (DEFAULT,"
                    + "'" + objeto.getCnpj() + "', "
                    + "'" + objeto.getNome() + "',"
                    + "'" + objeto.getData() + "',"
                    + "'" + objeto.getValor() + "')";

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public String atualizar(Protesto o) {
        try {
            String sql = "UPDATE protesto SET "
                    + "nome = '" + o.getNome() + "', "
                    + "data = '" + o.getData() + "',"
                    + "valor = '" + o.getValor() + "' "
                    + "WHERE cnpj = " + o.getCnpj();

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public String excluir(String cnpj) {
        try {
            String sql = "DELETE FROM protesto "
                    + "WHERE cnpj = '" + cnpj + "'";

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public ArrayList<Protesto> consultarTodos() {
        ArrayList<Protesto> usuarios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM protesto"
                    + " ORDER BY data ";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Protesto u = new Protesto();

                u.setId(resultado.getInt("id"));
                u.setCnpj(resultado.getString("cnpj"));
                u.setNome(resultado.getString("nome"));
                u.setData(resultado.getDate("data"));
                u.setValor(resultado.getDouble("valor"));

                usuarios.add(u);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return usuarios;
    }

    @Override
    public ArrayList<Protesto> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarCNPJ(String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
