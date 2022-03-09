package com.ipartek.formacion.spring.ipartekify30.controladores;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.ipartekify30.entidades.Artista;
import com.ipartek.formacion.spring.ipartekify30.modelos.ArtistaDTO;
import com.ipartek.formacion.spring.ipartekify30.servicios.IpartekifyService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final String ADMIN_VISTA = "admin";
	private static final String ARTISTA_FORM = ADMIN_VISTA + "_artista";
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
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
		
		servicio.artistaBorrar(id);
		
		return index(modelo);
	}
	
	@GetMapping("artistas/seleccionar/{id}")
	public String artistaSeleccionar(@PathVariable long id, Model modelo) {
		log.info("artistaSeleccionar " + id);
		modelo.addAttribute("artista", servicio.obtenerArtista(id));
		return index(modelo);
	}
	
	@GetMapping("artistas/editar/{id}")
	public String artistaEditar(@PathVariable long id, Model modelo) {
		log.info("artistaEditar " + id);
		modelo.addAttribute("artista", servicio.obtenerArtista(id));
		return ARTISTA_FORM;
	}
	
	@GetMapping("artistas/agregar")
	public String artistaAgregar() {
		log.info("artistaAgregar");
		return ARTISTA_FORM;
	}
	
	@PostMapping("artistas/guardar")
	public String artistaGuardar(ArtistaDTO artistaDTO) {
		log.info(artistaDTO.toString());
		
		Artista artista = modelMapper.map(artistaDTO, Artista.class);
		
		if(artistaDTO.getId() != null) {
			servicio.artistaAgregar(artista);
		} else {
			servicio.artistaModificar(artista);
		}
		
		return "redirect:/" + ADMIN_VISTA;
	}
}
