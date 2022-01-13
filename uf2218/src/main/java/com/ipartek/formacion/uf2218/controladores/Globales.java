package com.ipartek.formacion.uf2218.controladores;

import com.ipartek.formacion.uf2218.accesodatos.DaoUsuario;
import com.ipartek.formacion.uf2218.accesodatos.FabricaDao;
import com.ipartek.formacion.uf2218.accesodatos.FabricaDaoImpl;

public class Globales {
	public static final FabricaDao FABRICA = new FabricaDaoImpl("memoria");
	public static final DaoUsuario DAO = FABRICA.getUsuario();
}
