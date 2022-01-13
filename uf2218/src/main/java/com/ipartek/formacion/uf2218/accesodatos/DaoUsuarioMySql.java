package com.ipartek.formacion.uf2218.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.uf2218.modelos.Usuario;

public class DaoUsuarioMySql implements DaoUsuario {
	private static final String URL = "jdbc:mysql://localhost:3306/mf0966_0021";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "admin";

	private static final String SQL_SELECT = "SELECT * FROM usuarios";
	private static final String SQL_SELECT_ID = "SELECT * FROM usuarios WHERE id = ?";
	private static final String SQL_SELECT_EMAIL = "SELECT * FROM usuarios WHERE email = ?";
	private static final String SQL_INSERT = "INSERT INTO usuarios (email, password, nombre) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE usuarios SET email=?, password=?, nombre=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id=?";

	// SINGLETON
	private DaoUsuarioMySql() {
	}

	private static final DaoUsuarioMySql INSTANCIA = new DaoUsuarioMySql();

	public static DaoUsuarioMySql getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha podido cargar el driver: " + e.getMessage(), e);
		}
	}
	
	private Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(URL, USUARIO, PASSWORD);
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar con la base de datos: " + e.getMessage(), e);
		}
	}

	@Override
	public Iterable<Usuario> obtenerTodos() {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			ArrayList<Usuario> usuarios = new ArrayList<>();
			Usuario usuario = null;

			while (rs.next()) {
				usuario = new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"),
						rs.getString("nombre"));
				usuarios.add(usuario);
			}

			return usuarios;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros", e);
		}
	}

	@Override
	public Usuario obtenerPorId(long id) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {
			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				Usuario usuario = null;

				if (rs.next()) {
					usuario = new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"),
							rs.getString("nombre"));
				}

				return usuario;
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el registro id: " + id, e);
		}
	}

	@Override
	public Usuario insertar(Usuario usuario) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getPassword());
			pst.setString(3, usuario.getNombre());

			int numeroRegistrosModificados = pst.executeUpdate();

			try (ResultSet rs = pst.getGeneratedKeys()) {
				if (rs.next()) {
					usuario.setId(rs.getLong(1));
				}
			}

			if (numeroRegistrosModificados != 1) {
				throw new AccesoDatosException("No se ha insertado ningún registro");
			}

			return usuario;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar el registro " + usuario, e);
		}
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {
			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getPassword());
			pst.setString(3, usuario.getNombre());
			pst.setLong(4, usuario.getId());

			int numeroRegistrosModificados = pst.executeUpdate();

			if (numeroRegistrosModificados != 1) {
				throw new AccesoDatosException("No se ha modificado ningún registro");
			}

			return usuario;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido modificar el registro " + usuario, e);
		}
	}

	@Override
	public void borrar(long id) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {
			pst.setLong(1, id);

			int numeroRegistrosModificados = pst.executeUpdate();

			if (numeroRegistrosModificados != 1) {
				throw new AccesoDatosException("No se ha borrado ningún registro");
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el registro id: " + id, e);
		}
	}

	@Override
	public Usuario obtenerPorEmail(String email) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_EMAIL);) {
			pst.setString(1, email);

			try (ResultSet rs = pst.executeQuery()) {
				Usuario usuario = null;

				if (rs.next()) {
					usuario = new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"),
							rs.getString("nombre"));
				}

				return usuario;
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el registro email: " + email, e);
		}
	}

}
