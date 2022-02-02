package com.ipartek.formacion.ipartekify.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.time.Duration;

public class Globales {
	private static final String URL = "jdbc:mysql://localhost:3306/ipartekify";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "admin";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new DalException("No se ha podido cargar el driver: " + e.getMessage(), e);
		}
	}
	
	static Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(Globales.URL, Globales.USUARIO, Globales.PASSWORD);
		} catch (SQLException e) {
			throw new DalException("Error al conectar con la base de datos: " + e.getMessage(), e);
		}
	}
	
	static Duration timeADuration(Time rsTiempo) {
		// FIXME Conversión CHAPUCERA sin tener en cuenta el cambio horario
		return Duration.ofMillis(rsTiempo.getTime() + 1000 * 60 * 60);
	}
}
