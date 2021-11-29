package com.ipartek.formacion.poo.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServicioMayusculador {

	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) {
		System.out.println("Arrancado servicio MAYUSCULADOR");
		
		try (ServerSocket ss = new ServerSocket(1234);
				Socket s = ss.accept();
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				Scanner sc = new Scanner(is);
				PrintWriter pw = new PrintWriter(os, AUTO_FLUSH)) {
			pw.println("Bienvenido al servicio MAYUSCULADOR");
			// pw.flush();
			
			String texto = sc.nextLine();
			
			pw.println(texto.toUpperCase());
		} catch (IOException e) {
			System.err.println("Ha habido un error al gestionar el servidor");
			e.printStackTrace();
		}
	}

}
