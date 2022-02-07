package com.ipartek.formacion.ipartekify.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.ipartekify.modelos.Lista;
import com.ipartek.formacion.ipartekify.modelos.Usuario;

public class DaoUsuarioMySql implements DaoUsuario {

	@Override
	public void favoritoCancion(Long idUsuario, Long idCancion) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call usuarios_favorito_cancion(?,?)}");
				) {
			cs.setLong(1, idUsuario);
			cs.setLong(2, idCancion);
			
			cs.executeUpdate();
		} catch (SQLException e) {
			throw new DalException("No se ha podido crear el favorito", e);
		}
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call usuarios_buscar_email(?)}");
				) {
			cs.setString(1, email);
			
			ResultSet rs = cs.executeQuery();
			
			Usuario usuario = null;
			
			if(rs.next()) {
				usuario = new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"), rs.getString("rol"));
			}
			
			return usuario;
		} catch (SQLException e) {
			throw new DalException("No se ha podido leer el usuario", e);
		}
	}

	@Override
	public void insertarLista(Long idUsuario, Lista nuevaLista) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call usuarios_lista_insertar(?, ?, ?)}");
				) {
			cs.setLong(1, idUsuario);
			cs.setString(2, nuevaLista.getNombre());
			cs.setString(3, nuevaLista.getDescripcion());
			
			cs.executeUpdate();
		} catch (SQLException e) {
			throw new DalException("No se ha podido insertar la lista", e);
		}
	}
}
