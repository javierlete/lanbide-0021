package com.ipartek.formacion.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// DI: Dependency Injection
// IoC: Inversion of Control

public class App 
{
    public static void main( String[] args )
    {
    	try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("aplicacion.xml")) {
			Salida salida = context.getBean("salida", Salida.class);
			Entrada entrada = context.getBean("entrada", Entrada.class);
			
			salida.mostrar(entrada.recibir());
		} catch (BeansException e) {
			e.printStackTrace();
		}
    }
}
