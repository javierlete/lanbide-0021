package com.ipartek.formacion.ipartekify.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.Duration;

import com.ipartek.formacion.ipartekify.modelos.Album;
import com.ipartek.formacion.ipartekify.modelos.Cancion;

public class DaoCancionMySql implements DaoCancion {

	@Override
	public Cancion obtenerPorId(long id) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call canciones_select_id(?)}");
				) {
			cs.setLong(1, id);
			
			ResultSet rs = cs.executeQuery();
			
			Cancion cancion = null;
			Album album = new Album();
			
			if(rs.next()) {
				album.setId(rs.getLong("albumes_id"));
				Time rsTiempo = rs.getTime("tiempo");
				Duration tiempo = Globales.timeADuration(rsTiempo);
				cancion = new Cancion(rs.getLong("id"), rs.getString("nombre"), tiempo, rs.getString("mp3"), album);
			}
			
			return cancion;
		} catch (SQLException e) {
			throw new DalException("No se ha podido obtener la canción " + id, e);
		}
	}
	
}
