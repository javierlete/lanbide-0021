package com.ipartek.formacion.mf0966;

import java.sql.*;

public class JdbcBasico {

	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost:3306/mf0966_0021";
		final String USUARIO = "root";
		final String PASSWORD = "admin";

		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		PreparedStatement pst = null;

		try {
			con = DriverManager.getConnection(URL, USUARIO, PASSWORD);

			int numeroRegistrosModificados;

			long id;
			String email, password, nombre;

			// Obtener todos
			final String SQL_SELECT = "SELECT * FROM usuarios";

			st = con.createStatement();
			rs = st.executeQuery(SQL_SELECT);

			while (rs.next()) {
				System.out.printf("%s, %s, %s, %s\n", rs.getLong("id"), rs.getString("email"), rs.getString("password"),
						rs.getString("nombre"));
			}

			rs.close();
			
			// Obtener por id
			id = 1;
			final String SQL_SELECT_ID = "SELECT * FROM usuarios WHERE id = ?";

			pst = con.prepareStatement(SQL_SELECT_ID);

			pst.setLong(1, id);

			rs = pst.executeQuery();

			if (rs.next()) {
				System.out.printf("%s, %s, %s, %s\n", rs.getLong("id"), rs.getString("email"), rs.getString("password"),
						rs.getString("nombre"));
			} else {
				System.out.println("No se ha encontrado ese ID");
			}

			pst.close();
			
			// Insertar
			email = "nuevo@nuevez.net";
			password = "nueva";
			nombre = "Nuevo Nuevez";

			final String SQL_INSERT = "INSERT INTO usuarios (email, password, nombre) VALUES (?,?,?)";

			pst = con.prepareStatement(SQL_INSERT);

			pst.setString(1, email);
			pst.setString(2, password);
			pst.setString(3, nombre);

			numeroRegistrosModificados = pst.executeUpdate();

			System.out.println(numeroRegistrosModificados);

			// Modificar
			email = "modificado@modificadez.net";
			password = "modificada";
			nombre = "Modificado Modificadez";
			id = 5;

			final String SQL_UPDATE = "UPDATE usuarios SET email=?, password=?, nombre=? WHERE id=?";

			pst = con.prepareStatement(SQL_UPDATE);

			pst.setString(1, email);
			pst.setString(2, password);
			pst.setString(3, nombre);
			pst.setLong(4, id);

			numeroRegistrosModificados = pst.executeUpdate();

			System.out.println(numeroRegistrosModificados);

			// Borrar
			id = 5;
			final String SQL_DELETE = "DELETE FROM usuarios WHERE id=?";

			pst = con.prepareStatement(SQL_DELETE);

			pst.setLong(1, id);

			numeroRegistrosModificados = pst.executeUpdate();

			System.out.println(numeroRegistrosModificados);

			System.out.println("HECHO");
		} catch (SQLException e) {
			System.err.println("Error en el acceso a la base de datos");
			System.err.println(e.getMessage());
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}

			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}

		}
	}

}
