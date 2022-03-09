package com.ipartek.formacion.spring.ipartekify30.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.ipartekify30.servicios.IpartekifyService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final String ADMIN_VISTA = "admin";
	private static final String ARTISTA_FORM = ADMIN_VISTA + "/artista/";
	
	@Autowired
	private IpartekifyService servicio;
	
	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("artistas", servicio.obtenerArtistas());
		return ADMIN_VISTA;
	}
	
	@GetMapping("artistas/borrar/{id}")
	public String artistaBorrar(@PathVariable long id, Model modelo) {
		log.info("artistaBorrar " + id);
		return index(modelo);
	}
	
	@GetMapping("artistas/seleccionar/{id}")
	public String artistaSeleccionar(@PathVariable long id, Model modelo) {
		log.info("artistaSeleccionar " + id);
		modelo.addAttribute("artista", servicio.obtenerArtista(id));
		return index(modelo);
	}
	
	@GetMapping("artistas/editar/{id}")
	public String artistaEditar(@PathVariable long id) {
		log.info("artistaEditar " + id);
		return ARTISTA_FORM + id;
	}
	
	@GetMapping("artistas/agregar")
	public String artistaAgregar() {
		log.info("artistaAgregar");
		return ARTISTA_FORM;
	}
}
