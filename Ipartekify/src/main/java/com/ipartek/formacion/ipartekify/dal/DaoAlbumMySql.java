package com.ipartek.formacion.ipartekify.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.Duration;
import java.time.Year;
import java.util.ArrayList;

import com.ipartek.formacion.ipartekify.modelos.Album;
import com.ipartek.formacion.ipartekify.modelos.Cancion;

public class DaoAlbumMySql implements DaoAlbum {

	@Override
	public Iterable<Album> obtenerTodos(long idArtista) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call albumes_select_artista(?)}");
				) {
			cs.setLong(1, idArtista);
			
			ResultSet rs = cs.executeQuery();
			
			ArrayList<Album> albumes = new ArrayList<>();
			
			Album album = null;
			Year anno;
			
			while(rs.next()) {
				anno = Year.of(rs.getDate("anno").toLocalDate().getYear());
				album = new Album(rs.getLong("id"), rs.getString("nombre"), anno, rs.getString("foto"), null);
				
				albumes.add(album);
			}
			
			return albumes;
		} catch (SQLException e) {
			throw new DalException("No se han podido obtener los álbumes", e);
		}
	}

	@Override
	public Album obtenerPorId(long id) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call albumes_select_id(?)}");
				) {
			cs.setLong(1, id);
			
			ResultSet rs = cs.executeQuery();
			
			Album album = null;
			Year anno;
			
			if(rs.next()) {
				anno = Year.of(rs.getDate("anno").toLocalDate().getYear());
				album = new Album(rs.getLong("id"), rs.getString("nombre"), anno, rs.getString("foto"), null);				
			}
			
			try(CallableStatement csCanciones = con.prepareCall("{call canciones_select_album(?)}")) {
				csCanciones.setLong(1, id);
				
				ResultSet rsCanciones = csCanciones.executeQuery();
				
				Cancion cancion;
				
				while(rsCanciones.next()) {
					Time rsTiempo = rsCanciones.getTime("tiempo");
					Duration tiempo = Globales.timeADuration(rsTiempo);
					cancion = new Cancion(rsCanciones.getLong("id"), rsCanciones.getString("nombre"), tiempo, rsCanciones.getString("mp3"), album);
					
					album.getCanciones().add(cancion);
				}
			}
			
			return album;
		} catch (SQLException e) {
			throw new DalException("No se ha podido obtener el album", e);
		}
	}
}
