package com.ipartek.formacion.uf2218.accesodatos;

public interface FabricaDao {
	DaoUsuario getUsuario();

	DaoRol getRol();

	DaoEvento getEvento();
}
