package com.ipartek.formacion.ipartekify.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

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
}
