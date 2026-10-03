package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Seguro;

public class SeguroDao {

    private String host = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "SegurosGroup";

    public SeguroDao() {

    }
    
    public int agregarSeguro(Seguro seguro) {
        String query = "Insert into seguros(descripcion,idTipo,costoContratacion,costoAsegurado) values('"
                + seguro.getDescripcion() + "','"
                + seguro.getIdTipo() + "','"
                + seguro.getCostoContratacion() + "','"
                + seguro.getCostoAsegurado() + "')";

        Connection cn = null;
        int filas = 0;

        try {
            cn = DriverManager.getConnection(host + dbName, user, pass);
            Statement st = cn.createStatement();
            filas = st.executeUpdate(query);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return filas;
    }
    public int bajaSeguro(int idSeguro) {
        String query = "delete from seguros where idSeguro='" + idSeguro + "'";

        Connection cn = null;
        int filas = 0;

        try {
            cn = DriverManager.getConnection(host + dbName, user, pass);
            Statement st = cn.createStatement();
            filas = st.executeUpdate(query);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return filas;
    }
    public int modificarSeguro(Seguro seguro) {
        String query = "update seguros set descripcion='"+ seguro.getDescripcion()+ "', idTipo='" + seguro.getIdTipo()+ "', costoContratacion='" + seguro.getCostoContratacion()+ "', costoAsegurado='" + seguro.getCostoAsegurado()+ "' where idSeguro='" + seguro.getIdSeguro() + "'";

        Connection cn = null;
        int filas = 0;

        try {
            cn = DriverManager.getConnection(host + dbName, user, pass);
            Statement st = cn.createStatement();
            filas = st.executeUpdate(query);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return filas;
    }
    public Seguro obtenerSeguro(int id) {
        Seguro x = new Seguro();

        Connection cn = null;

        try {
            cn = DriverManager.getConnection(host + dbName, user, pass);
            Statement st = cn.createStatement();

            String query = "Select * from seguros where idSeguro=" + id;
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                x.setIdSeguro(rs.getInt("idSeguro"));
                x.setDescripcion(rs.getString("descripcion"));
                x.setIdTipo(rs.getInt("idTipo"));
                x.setCostoContratacion(rs.getDouble("costoContratacion"));
                x.setCostoAsegurado(rs.getDouble("costoAsegurado"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return x;
    }
    public ArrayList<Seguro> obtenerTodosLosSeguros() {
        ArrayList<Seguro> lSeguro = new ArrayList<Seguro>();

        Connection cn = null;

        try {
            cn = DriverManager.getConnection(host + dbName, user, pass);
            String query = "Select * from seguros";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Seguro x = new Seguro();

                x.setIdSeguro(rs.getInt("idSeguro"));
                x.setDescripcion(rs.getString("descripcion"));
                x.setIdTipo(rs.getInt("idTipo"));
                x.setCostoContratacion(rs.getDouble("costoContratacion"));
                x.setCostoAsegurado(rs.getDouble("costoAsegurado"));

                lSeguro.add(x);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return lSeguro;
    }

    public int obtenerProximoId() {
        int proximoId = 1;

        Connection cn = null;

        try {
            cn = DriverManager.getConnection(host + dbName, user, pass);
            Statement st = cn.createStatement();

            String query = "Select IFNULL(MAX(idSeguro), 0) + 1 as proximoId from seguros";
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                proximoId = rs.getInt("proximoId");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return proximoId;
    }
}

