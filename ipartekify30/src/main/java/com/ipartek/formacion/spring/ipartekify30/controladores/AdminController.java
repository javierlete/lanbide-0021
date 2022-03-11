package com.ipartek.formacion.spring.ipartekify30.controladores;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ipartek.formacion.spring.ipartekify30.entidades.Alerta;
import com.ipartek.formacion.spring.ipartekify30.entidades.Artista;
import com.ipartek.formacion.spring.ipartekify30.modelos.ArtistaDTO;
import com.ipartek.formacion.spring.ipartekify30.servicios.IpartekifyService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final String ALERTA = "alerta";
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
		Artista artista = servicio.obtenerArtista(id);
		
		ArtistaDTO artistaDTO;
		
		if(artista == null) {
			artistaDTO = new ArtistaDTO();
		} else {
			artistaDTO = modelMapper.map(artista, ArtistaDTO.class);
		}
		
		modelo.addAttribute("artistaDTO", artistaDTO);
		modelo.addAttribute(ALERTA, new Alerta("Modifica los datos del artista", "info"));
		
		return ARTISTA_FORM;
	}
	
	@GetMapping("artistas/agregar")
	public String artistaAgregar(ArtistaDTO artistaDTO, Model modelo) {
		log.info("artistaAgregar");
		modelo.addAttribute(ALERTA, new Alerta("Introduce el nuevo artista", "info"));
		return ARTISTA_FORM;
	}
	
	@PostMapping("artistas/guardar")
	public String artistaGuardar(@Valid ArtistaDTO artistaDTO, BindingResult bindingResult, Model modelo, RedirectAttributes atributos) {
		log.info(artistaDTO.toString());
		
		if(bindingResult.hasErrors()) {
			modelo.addAttribute(ALERTA, new Alerta("Los datos no son válidos. Revisa los campos", "danger"));
			return ARTISTA_FORM;
		}
		
		Artista artista = modelMapper.map(artistaDTO, Artista.class);
		
		Alerta alerta;
		
		if(artista.getId() != null) {
			servicio.artistaAgregar(artista);
			alerta = new Alerta("Se ha agregado el artista", "success");
		} else {
			servicio.artistaModificar(artista);
			alerta = new Alerta("Se ha modificado el artista", "success");
		}
		
		atributos.addFlashAttribute(ALERTA, alerta);
		
		return "redirect:/" + ADMIN_VISTA;
	}
}
