package com.ipartek.formacion.spring.uf1643.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipartek.formacion.spring.uf1643.servicios.LibroService;

@Controller
public class LibrosController {
	private static final String INDEX = "index";
	private static final String LIBROS = "libros";
	
	@Autowired
	private LibroService servicio;
	
	@GetMapping("/")
	public String listado(Model modelo) {
		modelo.addAttribute(LIBROS, servicio.listado());
		return INDEX;
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable long id, Model modelo) {
		modelo.addAttribute("libro", servicio.detalle(id));
		return listado(modelo);
	}
	
	@GetMapping("/titulo")
	public String titulo(@RequestParam String titulo, Model modelo) {
		modelo.addAttribute(LIBROS, servicio.filtroPorNombre(titulo));
		return INDEX;
	}
	
	@GetMapping("/isbn")
	public String isbn(@RequestParam String isbn, Model modelo) {
		modelo.addAttribute(LIBROS, servicio.filtroPorIsbn(isbn));
		return INDEX;	
	}
	
	@GetMapping("/combi")
	public String combi(@RequestParam String combi, Model modelo) {
		modelo.addAttribute(LIBROS, servicio.filtroCombinado(combi));
		return INDEX;	
	}
}
