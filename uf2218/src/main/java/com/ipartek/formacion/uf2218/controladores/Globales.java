package com.ipartek.formacion.uf2218.controladores;

import java.util.Properties;

import com.ipartek.formacion.uf2218.accesodatos.DaoEvento;
import com.ipartek.formacion.uf2218.accesodatos.DaoRol;
import com.ipartek.formacion.uf2218.accesodatos.DaoUsuario;
import com.ipartek.formacion.uf2218.accesodatos.FabricaDao;
import com.ipartek.formacion.uf2218.accesodatos.FabricaDaoImpl;

public class Globales {
	public static final FabricaDao FABRICA;
	public static final DaoUsuario DAO_USUARIO;
	public static final DaoRol DAO_ROL;
	public static final DaoEvento DAO_EVENTO;

	static {
		String tipo;
		try {
			Properties prop = new Properties();
			prop.load(Globales.class.getResourceAsStream("/configuracion.properties"));
			
			tipo = prop.getProperty("accesodatos.tipo");
		} catch (Exception e) {
			System.err.println("NO SE HA PODIDO CARGAR LA PROPIEDAD");
			tipo = "memoria";
		}
		
		FABRICA = new FabricaDaoImpl(tipo);
		DAO_USUARIO = FABRICA.getUsuario();
		DAO_ROL = FABRICA.getRol();
		DAO_EVENTO = FABRICA.getEvento();
	}
}
