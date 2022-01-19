package com.ipartek.formacion.uf2218.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ipartek.formacion.uf2218.modelos.Evento;
import com.ipartek.formacion.uf2218.modelos.Usuario;

public class DaoEventoMySql implements DaoEvento {
	private static final String SQL_INSERT = "INSERT INTO eventos (nombre, fecha, responsable_id) VALUES (?, ?, ?)";
	private static final String SQL_INSERT_PARTICIPANTE = "INSERT INTO participantes (eventos_id, usuarios_id) VALUES (?,?)";

	// SINGLETON
	private DaoEventoMySql() {}
	private static final DaoEventoMySql INSTANCIA = new DaoEventoMySql();
	public static DaoEvento getInstancia() { return INSTANCIA; }
	// FIN SINGLETON
	
	@Override
	public Evento insertar(Evento evento) {
		try (Connection con = Globales.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, evento.getNombre());
			pst.setObject(2, evento.getFecha());
			pst.setLong(3, evento.getResponsable().getId());
			
			pst.executeUpdate();
			
			Long id;
			
			try (ResultSet rs = pst.getGeneratedKeys()) {
				rs.next();
				id = rs.getLong(1);
			}

			evento.setId(id);
			
			try (PreparedStatement pstParticipante = con.prepareStatement(SQL_INSERT_PARTICIPANTE)) {
				for(Usuario participante: evento.getParticipantes()) {
					pstParticipante.setLong(1, id);
					pstParticipante.setLong(2, participante.getId());
					
					pstParticipante.executeUpdate();
				}
			}
			
			return evento;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar el registro " + evento,e);
		}
	}

	
}
