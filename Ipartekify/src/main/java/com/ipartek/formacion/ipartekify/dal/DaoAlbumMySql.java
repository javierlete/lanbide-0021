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
import com.ipartek.formacion.ipartekify.modelos.Artista;
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
		// TODO Se puede mejorar con un procedimiento almacenado específico que no pida favoritos
		return obtenerPorId(0, id);
	}
	
	@Override
	public Album obtenerPorId(long idUsuario, long id) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call albumes_select_id(?)}");
				) {
			cs.setLong(1, id);
			
			ResultSet rs = cs.executeQuery();
			
			Album album = null;
			Year anno;
			
			if(rs.next()) {
				anno = Year.of(rs.getDate("anno").toLocalDate().getYear());
				album = new Album(rs.getLong("id"), rs.getString("nombre"), anno, rs.getString("foto"), new Artista(rs.getLong("artistas_id"), null, null));				
			}
			
			try(CallableStatement csCanciones = con.prepareCall("{call canciones_select_album(?,?)}")) {
				csCanciones.setLong(1, idUsuario);
				csCanciones.setLong(2, id);
				
				ResultSet rsCanciones = csCanciones.executeQuery();
				
				Cancion cancion;
				
				while(rsCanciones.next()) {
					Time rsTiempo = rsCanciones.getTime("tiempo");
					Duration tiempo = Globales.timeADuration(rsTiempo);
					cancion = new Cancion(rsCanciones.getLong("id"), rsCanciones.getString("nombre"), tiempo, rsCanciones.getString("mp3"), rsCanciones.getBoolean("favorito"), album);
					
					album.getCanciones().add(cancion);
				}
			}
			
			return album;
		} catch (SQLException e) {
			throw new DalException("No se ha podido obtener el album", e);
		}
	}
	
	@Override
	public Album insertar(Album album) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call albumes_insertar(?,?,?,?)}");
				) {
			cs.setString(1, album.getNombre());
			cs.setInt(2, album.getAnno().getValue());
			cs.setString(3, album.getFoto());
			cs.setLong(4, album.getArtista().getId());
			
			cs.executeUpdate();
			
			ResultSet rs = cs.getResultSet();
			
			rs.next();
			
			album.setId(rs.getLong(1));
			
			return album;
		} catch (SQLException e) {
			throw new DalException("No se ha podido insertar el álbum", e);
		}
	}

	@Override
	public Album modificar(Album album) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call albumes_modificar(?,?,?,?,?)}");
				) {
			cs.setLong(1, album.getId());
			cs.setString(2, album.getNombre());
			cs.setInt(3, album.getAnno().getValue());
			cs.setString(4, album.getFoto());
			cs.setLong(5, album.getArtista().getId());
			
			cs.executeUpdate();
			
			return album;
		} catch (SQLException e) {
			throw new DalException("No se ha podido modificar el álbum", e);
		}
	}

	@Override
	public void borrar(long id) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call albumes_borrar(?)}");
				) {
			cs.setLong(1, id);
			
			cs.executeUpdate();
		} catch (SQLException e) {
			throw new DalException("No se ha podido borrar el álbum", e);
		}
	}
}
