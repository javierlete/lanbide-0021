package com.ipartek.formacion.poo.threads;

public class Corredor implements Runnable {
	private static Pasos pasos = new Pasos();
	
	private static final int meta = 100;
	
	private int dorsal;
	private int posicion;
	
	public Corredor(int dorsal) {
		posicion = 1;
		this.dorsal = dorsal;
	}
	
	public void correr() {
		for(posicion = 1; posicion <= meta; posicion ++) {
			//System.out.println("DORSAL: " + dorsal + ", POSICION: " + posicion);
			
			try {
				Thread.sleep((int)(Math.random() * 1000));
			} catch (InterruptedException e) {}
			
			synchronized(pasos) {
				pasos.incrementar();
			}
		}
	}

	@Override
	public String toString() {
		return "Corredor [dorsal=" + dorsal + ", posicion=" + posicion + "]";
	}

	@Override
	public void run() {
		correr();
	}
	
	public static int getPasos() {
		return pasos.getCuantos();
	}

	public int getPosicion() {
		return posicion;
	}
	
	static class Pasos {
		private int cuantos = 0;
		
		public int getCuantos() {
			return cuantos;
		}
		
		public void incrementar() {
			cuantos++;
		}
	}
}
