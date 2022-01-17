package com.ipartek.formacion.uf2218.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.uf2218.modelos.Rol;

public class DaoRolMySql implements DaoRol {

	private static final String SQL_SELECT = "SELECT * FROM roles";
	
	// SINGLETON
	private DaoRolMySql() {
	}

	private static final DaoRolMySql INSTANCIA = new DaoRolMySql();

	public static DaoRolMySql getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Rol> obtenerTodos() {
		try (Connection con = Globales.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			ArrayList<Rol> roles = new ArrayList<>();
			
			Rol rol = null;

			while (rs.next()) {
				rol = new Rol(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"));
				roles.add(rol);
			}

			return roles;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros", e);
		}
	}

}
