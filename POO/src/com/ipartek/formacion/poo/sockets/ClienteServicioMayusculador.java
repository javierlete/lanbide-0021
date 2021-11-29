package com.ipartek.formacion.poo.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteServicioMayusculador {

	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) {
		try (Socket s = new Socket("localhost", 1234);
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				Scanner sc = new Scanner(is);
				PrintWriter pw = new PrintWriter(os, AUTO_FLUSH)) {
			System.out.println(sc.nextLine());
			
			pw.println("Prueba de texto a poner en mayúsculas");
			
			System.out.println(sc.nextLine());
		} catch (IOException e) {
			System.err.println("Ha habido un error al gestionar el cliente");
			e.printStackTrace();
		}
	}

}
