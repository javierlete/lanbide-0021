package com.ipartek.formacion.ipartekify.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;

import com.ipartek.formacion.ipartekify.modelos.Album;

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
			throw new DalException("No se han podido obtener los artistas", e);
		}
	}

}
