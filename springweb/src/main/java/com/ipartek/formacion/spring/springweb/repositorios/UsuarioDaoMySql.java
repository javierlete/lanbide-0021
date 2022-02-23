package com.ipartek.formacion.spring.springweb.repositorios;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.springweb.entidades.Usuario;

@Repository
public class UsuarioDaoMySql implements UsuarioDao {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public Iterable<Usuario> obtenerTodos() {
		return jdbc.query("SELECT * FROM usuarios", new BeanPropertyRowMapper<Usuario>(Usuario.class));
	}

	@Override
	public Usuario obtenerPorId(long id) {
		return jdbc.queryForObject("SELECT * FROM usuarios WHERE id = ?",
				new BeanPropertyRowMapper<Usuario>(Usuario.class), id);
	}

	@Override
	public Usuario insertar(Usuario usuario) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbc.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO usuarios (email, password, rol) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getPassword());
			ps.setString(3, usuario.getRol());
			return ps;
		}, keyHolder);

		BigInteger id = (BigInteger) keyHolder.getKey();

		usuario.setId(id.longValue());

		return usuario;
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		jdbc.update("UPDATE usuarios SET email = ?, password = ?, rol = ? WHERE id = ?", usuario.getEmail(),
				usuario.getPassword(), usuario.getRol(), usuario.getId());
		return usuario;
	}

	@Override
	public void borrar(long id) {
		jdbc.update("DELETE FROM usuarios WHERE id = ?", id);
	}

}
