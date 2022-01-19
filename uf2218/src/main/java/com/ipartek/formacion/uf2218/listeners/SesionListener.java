package com.ipartek.formacion.uf2218.listeners;

import java.util.TreeMap;
import java.util.logging.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.uf2218.modelos.Usuario;

@WebListener
public class SesionListener implements HttpSessionListener {
	private static final Logger LOGGER = Logger.getLogger(SesionListener.class.getName());

	public void sessionCreated(HttpSessionEvent se) {
		LOGGER.info("Creando el equipo inicial");
		se.getSession().setAttribute("equipo", new TreeMap<Long, Usuario>());
	}
}
