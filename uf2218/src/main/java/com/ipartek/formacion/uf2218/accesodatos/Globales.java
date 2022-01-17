package com.ipartek.formacion.uf2218.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Globales {
	static final String URL = "jdbc:mysql://localhost:3306/mf0966_0021";
	static final String USUARIO = "root";
	static final String PASSWORD = "admin";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha podido cargar el driver: " + e.getMessage(), e);
		}
	}
	
	static Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(Globales.URL, Globales.USUARIO, Globales.PASSWORD);
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar con la base de datos: " + e.getMessage(), e);
		}
	}
}
