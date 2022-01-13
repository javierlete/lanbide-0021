package com.ipartek.formacion.uf2218.accesodatos;

public class FabricaDaoImpl implements FabricaDao {

	private String tipo;
	
	public FabricaDaoImpl(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public DaoUsuario getUsuario() {
		switch(tipo) {
		case "mysql": return DaoUsuarioMySql.getInstancia();
		case "memoria": return DaoUsuarioMemoria.getInstancia();
		default: throw new AccesoDatosException("NO ESTÁ IMPLEMENTADO");
		}
	}
}
