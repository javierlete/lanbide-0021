package com.ipartek.formacion.spring.uf1643.controladores;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipartek.formacion.spring.uf1643.entidades.Libro;
import com.ipartek.formacion.spring.uf1643.modelos.LibroForm;
import com.ipartek.formacion.spring.uf1643.servicios.LibroService;
import com.ipartek.formacion.spring.uf1643.servicios.ServiciosException;

@Controller
public class LibrosController {
	private static final String INDEX = "index";
	private static final String LIBROS = "libros";
	private static final String LIBRO = "libroForm";

	private static final ModelMapper mapper = new ModelMapper();

	@Autowired
	private LibroService servicio;

	@GetMapping("/")
	public String listado(Model modelo) {
		modelo.addAttribute(LIBROS, servicio.listado());
		
		if (modelo.getAttribute(LIBRO) == null) {
			modelo.addAttribute(LIBRO, new LibroForm());
		}
		
		return INDEX;
	}

	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable long id, Model modelo) {
		modelo.addAttribute(LIBRO, servicio.detalle(id));
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

	@PostMapping("/guardar")
	public String guardar(@Valid LibroForm libroForm, BindingResult result, Model modelo) {

		if (!result.hasErrors()) {
			try {
				servicio.guardar(mapper.map(libroForm, Libro.class));
			} catch (ServiciosException se) {
				result.addError(new ObjectError("globalError", "Error al guardar: " + se.getMessage() + ", " + se.getCause().getMessage()));
			}
		}
		return listado(modelo);
	}
}
