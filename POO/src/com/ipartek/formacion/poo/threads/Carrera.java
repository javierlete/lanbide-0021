package com.ipartek.formacion.poo.threads;

public class Carrera {

	public static void main(String[] args) {
		Corredor c1 = new Corredor(1);
		Corredor c2 = new Corredor(2);
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		
		System.out.println("¡BANG!");
		
		t1.start();
		t2.start();
		
		System.out.println("Inicio de la carrera");
		
		while(c1.getPosicion() < 100 || c2.getPosicion() < 100) {
			System.out.println(c1);
			System.out.println(c2);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			
		}
		
		System.out.println(c1.getPosicion());
		System.out.println(c2.getPosicion());
		System.out.println(Corredor.getPasos());
	}

}
