package com.ipartek.formacion.ipartekify.dal;

import com.ipartek.formacion.ipartekify.modelos.Cancion;

public interface DaoCancion extends Dao<Cancion> {
	Iterable<Cancion> buscarFavoritas(long idUsuario);
}
