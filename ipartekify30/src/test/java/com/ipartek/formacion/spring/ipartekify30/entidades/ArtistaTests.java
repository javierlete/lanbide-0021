package com.ipartek.formacion.spring.ipartekify30.entidades;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArtistaTests {
	@Test
	void setNombre() {
		Artista a = new Artista();
		a.setNombre("   Pepe    ");
		
		assertEquals("Pepe", a.getNombre());
		
		assertThrows(EntidadesException.class, () -> a.setNombre(null));
		
		assertThrows(EntidadesException.class, () -> a.setNombre(""));
		
		assertThrows(EntidadesException.class, () -> a.setNombre("    "));
	}
}
