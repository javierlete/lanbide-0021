package com.ipartek.formacion.spring;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Fabrica {
	private Salida salida;
	private Entrada entrada;
	
	public Fabrica() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Properties prop = new Properties();
		
		prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("fabrica.properties"));
		
		String strSalida = prop.getProperty("salida");
		String strEntrada = prop.getProperty("entrada");
		
		salida = (Salida) Class.forName(strSalida).getDeclaredConstructor().newInstance();
		entrada = (Entrada) Class.forName(strEntrada).getDeclaredConstructor().newInstance();
	}
	
	public Salida getSalida() {
		return salida;
	}
	
	public Entrada getEntrada() {
		return entrada;
	}
}
