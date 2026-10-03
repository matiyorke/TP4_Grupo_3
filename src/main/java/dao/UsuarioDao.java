package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import dominio.Usuario;

public class UsuarioDao {
	
    private String host = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "SegurosGroup";

    public UsuarioDao() {}
    
}


