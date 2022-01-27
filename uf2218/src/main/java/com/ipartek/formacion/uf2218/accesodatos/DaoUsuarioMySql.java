package com.ipartek.formacion.uf2218.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ipartek.formacion.uf2218.modelos.Rol;
import com.ipartek.formacion.uf2218.modelos.Usuario;

public class DaoUsuarioMySql implements DaoUsuario {
	private static final String ORDEN_POR_DEFECTO = "nombre";
	private static final int TAMANO_PAGINA = 5;
	private static final String ORDER_BY = " ORDER BY ";
	private static final String LIMIT = " LIMIT ?," + TAMANO_PAGINA;
	private static final String SQL_SELECT = "SELECT * FROM usuarios u JOIN roles r ON u.roles_id = r.id";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE u.id = ?";
	private static final String SQL_SELECT_EMAIL = SQL_SELECT + " WHERE u.email = ?";
	private static final String SQL_SELECT_BUSCAR = SQL_SELECT
			+ " WHERE u.email LIKE ? OR u.nombre LIKE ? OR r.nombre LIKE ?";
	private static final String SQL_INSERT = "INSERT INTO usuarios (email, password, nombre, roles_id) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE usuarios SET email=?, password=?, nombre=?, roles_id=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id=?";

	private static final Map<String, String> ordenaciones = new HashMap<>() {// Enter all data for mapping
		private static final long serialVersionUID = -8533110483047257043L;
		
		{
			put(ORDEN_POR_DEFECTO, "u.nombre");
			put("rol", "r.nombre");
		}

		@Override
		public String get(Object key) {
			String col = super.get(key);
			return null == col ? "u.nombre" : col;
		}
	};

	// SINGLETON
	private DaoUsuarioMySql() {
	}

	private static final DaoUsuarioMySql INSTANCIA = new DaoUsuarioMySql();

	public static DaoUsuarioMySql getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Usuario> obtenerTodos() {
		return obtenerTodos(1);
	}
	
	@Override
	public Iterable<Usuario> obtenerTodos(int pagina) {
		return obtenerTodos(pagina, ORDEN_POR_DEFECTO);
	}
	

	@Override
	public Iterable<Usuario> obtenerTodos(int pagina, String orden) {
		try (Connection con = Globales.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT + ORDER_BY + ordenaciones.get(orden) + LIMIT);) {
			pst.setInt(1, paginaToOffset(pagina));

			ResultSet rs = pst.executeQuery();
			ArrayList<Usuario> usuarios = new ArrayList<>();
			Usuario usuario = null;
			Rol rol = null;

			while (rs.next()) {
				rol = new Rol(rs.getLong("r.id"), rs.getString("r.nombre"), rs.getString("r.descripcion"));
				usuario = new Usuario(rs.getLong("u.id"), rs.getString("u.email"), rs.getString("u.password"),
						rs.getString("u.nombre"), rol);
				usuarios.add(usuario);
			}

			return usuarios;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros", e);
		}
	}

	@Override
	public Usuario obtenerPorId(long id) {
		try (Connection con = Globales.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {
			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				Usuario usuario = null;
				Rol rol = null;

				if (rs.next()) {
					rol = new Rol(rs.getLong("r.id"), rs.getString("r.nombre"), rs.getString("r.descripcion"));
					usuario = new Usuario(rs.getLong("u.id"), rs.getString("u.email"), rs.getString("u.password"),
							rs.getString("u.nombre"), rol);
				}

				return usuario;
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el registro id: " + id, e);
		}
	}

	@Override
	public Usuario insertar(Usuario usuario) {
		try (Connection con = Globales.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getPassword());
			pst.setString(3, usuario.getNombre());
			pst.setLong(4, usuario.getRol().getId());

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
		try (Connection con = Globales.obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {
			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getPassword());
			pst.setString(3, usuario.getNombre());
			pst.setLong(4, usuario.getRol().getId());
			pst.setLong(5, usuario.getId());

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
		try (Connection con = Globales.obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {
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
		try (Connection con = Globales.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_EMAIL);) {
			pst.setString(1, email);

			try (ResultSet rs = pst.executeQuery()) {
				Usuario usuario = null;
				Rol rol = null;

				if (rs.next()) {
					rol = new Rol(rs.getLong("r.id"), rs.getString("r.nombre"), rs.getString("r.descripcion"));
					usuario = new Usuario(rs.getLong("u.id"), rs.getString("u.email"), rs.getString("u.password"),
							rs.getString("u.nombre"), rol);
				}

				return usuario;
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el registro email: " + email, e);
		}
	}

	@Override
	public Iterable<Usuario> buscar(String termino) {
		return buscar(termino, 1);
	}
	
	@Override
	public Iterable<Usuario> buscar(String termino, int pagina) {
		return buscar(termino, pagina, ORDEN_POR_DEFECTO);
	}

	@Override
	public Iterable<Usuario> buscar(String termino, int pagina, String orden) {
		try (Connection con = Globales.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_BUSCAR + ORDER_BY + ordenaciones.get(orden) + LIMIT);) {
			String like = "%" + termino + "%";
			pst.setString(1, like);
			pst.setString(2, like);
			pst.setString(3, like);
			pst.setInt(4, paginaToOffset(pagina));

			try (ResultSet rs = pst.executeQuery()) {
				Usuario usuario = null;
				Rol rol = null;

				ArrayList<Usuario> usuarios = new ArrayList<>();

				while (rs.next()) {
					rol = new Rol(rs.getLong("r.id"), rs.getString("r.nombre"), rs.getString("r.descripcion"));
					usuario = new Usuario(rs.getLong("u.id"), rs.getString("u.email"), rs.getString("u.password"),
							rs.getString("u.nombre"), rol);
					usuarios.add(usuario);
				}

				return usuarios;
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido hacer la búsqueda", e);
		}
	}

	private int paginaToOffset(int pagina) {
		return (pagina - 1) * TAMANO_PAGINA;
	}
}
