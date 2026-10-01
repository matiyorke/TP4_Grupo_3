package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.TipoSeguros;

public class TipoSegurosDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "SegurosGroup";

	public TipoSegurosDao() {

	}

	public ArrayList<TipoSeguros> obtenerTodosLosTipos() {
		ArrayList<TipoSeguros> lTipos = new ArrayList<TipoSeguros>();

		Connection cn = null;

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			String query = "Select * from tipoSeguros";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				TipoSeguros x = new TipoSeguros();

				x.setIdTipo(rs.getInt("idTipo"));
				x.setDescripcion(rs.getString("descripcion"));

				lTipos.add(x);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return lTipos;
	}
}