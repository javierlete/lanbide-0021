package com.ipartek.formacion.poo.entidades.interfaces;

public class Naranja extends Fruto implements Comestible, Rodable {
	private boolean sucia = false;
	
	@Override
	public void rodar() {		
		System.out.println("Naranja rodando");
		sucia = true;
	}

	@Override
	public void comer() {
		if(sucia) {
			System.out.println("¡Que asco!");
		} else {
			System.out.println("¡Que rica!");
		}
	}

}
