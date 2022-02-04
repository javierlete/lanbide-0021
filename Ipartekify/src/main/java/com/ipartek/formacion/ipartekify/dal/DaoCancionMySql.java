package com.ipartek.formacion.ipartekify.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;

import com.ipartek.formacion.ipartekify.modelos.Album;
import com.ipartek.formacion.ipartekify.modelos.Cancion;

public class DaoCancionMySql implements DaoCancion {

	@Override
	public Cancion obtenerPorId(long id) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call canciones_select_id(?)}");) {
			cs.setLong(1, id);

			ResultSet rs = cs.executeQuery();

			Cancion cancion = null;
			Album album = new Album();

			if (rs.next()) {
				album.setId(rs.getLong("albumes_id"));
				Time rsTiempo = rs.getTime("tiempo");
				Duration tiempo = Globales.timeADuration(rsTiempo);
				// FIXME Añadir favorito
				cancion = new Cancion(rs.getLong("id"), rs.getString("nombre"), tiempo, rs.getString("mp3"), false,
						album);
			}

			return cancion;
		} catch (SQLException e) {
			throw new DalException("No se ha podido obtener la canción " + id, e);
		}
	}

	@Override
	public Iterable<Cancion> buscarFavoritas(long idUsuario) {
		try (
				Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call canciones_select_usuario(?)}")) {
			cs.setLong(1, idUsuario);

			ResultSet rs = cs.executeQuery();

			Cancion cancion;
			ArrayList<Cancion> canciones = new ArrayList<>();
			
			while (rs.next()) {
				Time rsTiempo = rs.getTime("tiempo");
				Duration tiempo = Globales.timeADuration(rsTiempo);
				cancion = new Cancion(rs.getLong("id"), rs.getString("nombre"), tiempo,
						rs.getString("mp3"), true, new Album(rs.getLong("albumes_id"), null, null, null, null));
				canciones.add(cancion);
			}

			return canciones;
		} catch (SQLException e) {
			throw new DalException("No se han podido obtener las canciones favoritas", e);
		}
	}

}
