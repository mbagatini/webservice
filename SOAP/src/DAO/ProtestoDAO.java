/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import entidade.Protesto;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ProtestoDAO {

    private String converteData(Date d) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(d);
        return date;
    }

    public String salvar(Protesto objeto) {
        try {
            String sql = "INSERT INTO protesto VALUES (DEFAULT,"
                    + "'" + objeto.getCnpj() + "', "
                    + "'" + objeto.getNome() + "',"
                    + "'" + converteData(objeto.getData()) + "',"
                    + "'" + objeto.getValor() + "')";

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            return e.toString();
        }
        return null;
    }

    public String atualizar(Protesto o) {
        try {
            String sql = "UPDATE protesto SET "
                    + "nome = '" + o.getNome() + "', "
                    + "data = '" + converteData(o.getData()) + "',"
                    + "valor = '" + o.getValor() + "' "
                    + "WHERE id = " + o.getId();

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e);
            return e.toString();
        }
        return null;
    }

    public String excluir(int id) {
        try {
            String sql = "DELETE FROM protesto "
                    + "WHERE id = " + id;

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return e.toString();
        }
        return null;
    }

    public ArrayList<Protesto> consultarTodos() {
        ArrayList<Protesto> obj = new ArrayList<>();

        try {
            String sql = "SELECT * FROM protesto"
                    + " ORDER BY data ";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Protesto o = new Protesto();

                o.setId(resultado.getInt("id"));
                o.setCnpj(resultado.getString("cnpj"));
                o.setNome(resultado.getString("nome"));
                o.setData(resultado.getDate("data"));
                o.setValor(resultado.getDouble("valor"));

                obj.add(o);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return obj;
    }

    public Protesto consultarID(int id) {
        try {
            String sql = "SELECT * FROM protesto"
                    + " WHERE id = " + id;

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Protesto u = new Protesto();

                u.setId(resultado.getInt("id"));
                u.setCnpj(resultado.getString("cnpj"));
                u.setNome(resultado.getString("nome"));
                u.setData(resultado.getDate("data"));
                u.setValor(resultado.getDouble("valor"));

                return u;
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return null;
    }

    public ArrayList<Protesto> consultarCNPJ(String cnpj) {
        ArrayList<Protesto> obj = new ArrayList<>();

        try {
            String sql = "SELECT * FROM protesto"
                    + " WHERE cnpj = '" + cnpj + "'"
                    + " ORDER BY data ";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Protesto u = new Protesto();

                u.setId(resultado.getInt("id"));
                u.setCnpj(resultado.getString("cnpj"));
                u.setNome(resultado.getString("nome"));
                u.setData(resultado.getDate("data"));
                u.setValor(resultado.getDouble("valor"));

                obj.add(u);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return obj;
    }

}
