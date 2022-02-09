package com.ipartek.formacion.ipartekify.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.ipartek.formacion.ipartekify.modelos.Artista;

class DaoArtistaMySql implements DaoArtista {

	private static final Logger LOGGER = Logger.getLogger(DaoArtistaMySql.class.getName());
	
	@Override
	public Artista insertar(Artista artista) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call artistas_insertar(?,?)}");
				) {
			cs.setString(1, artista.getNombre());
			cs.setString(2, artista.getInformacion());
			
			cs.executeUpdate();
			
			ResultSet rs = cs.getResultSet();
			
			rs.next();
			
			artista.setId(rs.getLong(1));
			
			LOGGER.info(artista.toString());
			
			return artista;
		} catch (SQLException e) {
			throw new DalException("No se ha podido insertar el artista", e);
		}
	}

	@Override
	public Artista modificar(Artista artista) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call artistas_modificar(?,?,?)}");
				) {
			cs.setString(1, artista.getNombre());
			cs.setString(2, artista.getInformacion());
			cs.setLong(3, artista.getId());
			
			cs.executeUpdate();
			
			return artista;
		} catch (SQLException e) {
			throw new DalException("No se ha podido insertar el artista", e);
		}
	}

	@Override
	public void borrar(long id) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call artistas_delete(?)}");
				) {
			cs.setLong(1, id);
			
			cs.executeUpdate();
		} catch (SQLException e) {
			throw new DalException("No se ha podido borrar el artista", e);
		}
	}

	@Override
	public Iterable<Artista> obtenerTodos() {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call artistas_select()}");
				ResultSet rs = cs.executeQuery()) {
			ArrayList<Artista> artistas = new ArrayList<>();
			
			Artista artista;
			
			while(rs.next()) {
				artista = new Artista(rs.getLong("id"), rs.getString("nombre"), rs.getString("informacion"));
				
				artistas.add(artista);
			}
			
			return artistas;
		} catch (SQLException e) {
			throw new DalException("No se han podido obtener los artistas", e);
		}
	}

	@Override
	public Artista obtenerPorId(long id) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call artistas_select_id(?)}");
				) {
			cs.setLong(1, id);
			
			ResultSet rs = cs.executeQuery();
			
			Artista artista = null;
			
			if(rs.next()) {
				artista = new Artista(rs.getLong("id"), rs.getString("nombre"), rs.getString("informacion"));
			}
			
			return artista;
		} catch (SQLException e) {
			throw new DalException("No se han podido obtener los artistas", e);
		}
	}

}
