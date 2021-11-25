package com.ipartek.formacion.poo.pruebas;

import java.util.ArrayList;

import com.ipartek.formacion.poo.entidades.interfaces.Balon;
import com.ipartek.formacion.poo.entidades.interfaces.Comestible;
import com.ipartek.formacion.poo.entidades.interfaces.Naranja;
import com.ipartek.formacion.poo.entidades.interfaces.Rodable;

public class InterfacesPrueba {
	public static void main(String[] args) {
		ArrayList<Rodable> rodables = new ArrayList<>();
		
		rodables.add(new Balon());
		rodables.add(new Naranja());
		
		Comestible comestible = null;
		
		for(Rodable rodable: rodables) {
			if(rodable instanceof Comestible) {
				comestible = (Comestible)rodable;
				comestible.comer();
			}
			
			rodable.rodar();
			
			if(rodable instanceof Comestible) {
				comestible.comer();
			}
		
		}
	}
}
