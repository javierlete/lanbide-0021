package com.ipartek.formacion.uf2218.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.ipartek.formacion.uf2218.modelos.Evento;
import com.ipartek.formacion.uf2218.modelos.Rol;
import com.ipartek.formacion.uf2218.modelos.Usuario;

public class DaoEventoMySql implements DaoEvento {
	private static final String SQL_SELECT = "SELECT * FROM eventos e\r\n"
			+ "JOIN usuarios u ON u.id = e.responsable_id JOIN roles r ON u.roles_id = r.id\r\n";
	private static final String SQL_SELECT_ID = SQL_SELECT + "WHERE e.id = ?";
	private static final String SQL_SELECT_PARTICIPANTES = "SELECT * FROM participantes p\r\n"
			+ "JOIN usuarios u ON u.id = p.usuarios_id JOIN roles r ON u.roles_id = r.id\r\n"
			+ "WHERE p.eventos_id = ?";
	private static final String SQL_INSERT = "INSERT INTO eventos (nombre, fecha, responsable_id) VALUES (?, ?, ?)";
	private static final String SQL_INSERT_PARTICIPANTE = "INSERT INTO participantes (eventos_id, usuarios_id) VALUES (?,?)";

	// SINGLETON
	private DaoEventoMySql() {
	}

	private static final DaoEventoMySql INSTANCIA = new DaoEventoMySql();

	public static DaoEvento getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Evento> obtenerTodos() {
		try (Connection con = Globales.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery();) {
			Evento evento = null;
			Usuario responsable = null;
			Rol rol = null;

			ArrayList<Evento> eventos = new ArrayList<>();
			
			while (rs.next()) {
				rol = new Rol(rs.getLong("r.id"), rs.getString("r.nombre"), rs.getString("r.descripcion"));
				responsable = new Usuario(rs.getLong("u.id"), rs.getString("u.email"), rs.getString("u.password"),
						rs.getString("u.nombre"), rol);
				evento = new Evento(rs.getLong("e.id"), rs.getString("e.nombre"),
						(LocalDateTime) rs.getObject("e.fecha"), responsable);
				
				eventos.add(evento);
			}

			return eventos;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener los registros", e);
		}

	}

	@Override
	public Evento obtenerPorId(long id) {
		try (Connection con = Globales.obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();

			Evento evento = null;
			Usuario responsable = null;
			Rol rol = null;

			if (rs.next()) {
				rol = new Rol(rs.getLong("r.id"), rs.getString("r.nombre"), rs.getString("r.descripcion"));
				responsable = new Usuario(rs.getLong("u.id"), rs.getString("u.email"), rs.getString("u.password"),
						rs.getString("u.nombre"), rol);
				evento = new Evento(rs.getLong("e.id"), rs.getString("e.nombre"),
						(LocalDateTime) rs.getObject("e.fecha"), responsable);

				PreparedStatement pstParticipantes = con.prepareStatement(SQL_SELECT_PARTICIPANTES);
				pstParticipantes.setLong(1, id);
				ResultSet rsParticipantes = pstParticipantes.executeQuery();

				Usuario participante = null;
				Rol rolParticipante = null;

				while (rsParticipantes.next()) {
					rolParticipante = new Rol(rsParticipantes.getLong("r.id"), rsParticipantes.getString("r.nombre"),
							rsParticipantes.getString("r.descripcion"));
					participante = new Usuario(rsParticipantes.getLong("u.id"), rsParticipantes.getString("u.email"),
							rsParticipantes.getString("u.password"), rsParticipantes.getString("u.nombre"),
							rolParticipante);
					evento.getParticipantes().add(participante);
				}
			}

			return evento;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el registro " + id, e);
		}

	}

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
				for (Usuario participante : evento.getParticipantes()) {
					pstParticipante.setLong(1, id);
					pstParticipante.setLong(2, participante.getId());

					pstParticipante.executeUpdate();
				}
			}

			return evento;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar el registro " + evento, e);
		}
	}

}
