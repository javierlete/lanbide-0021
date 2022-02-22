package com.ipartek.formacion.spring;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

// DI: Dependency Injection
// IoC: Inversion of Control

public class App 
{
    public static void main( String[] args ) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException
    {
    	Fabrica fabrica = new Fabrica();
    	
    	Salida salida = fabrica.getSalida();
    	Entrada entrada = fabrica.getEntrada();
        
    	salida.mostrar(entrada.recibir());
    }
}
