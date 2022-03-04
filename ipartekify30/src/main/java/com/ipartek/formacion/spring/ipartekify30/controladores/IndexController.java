package com.ipartek.formacion.spring.ipartekify30.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.ipartekify30.servicios.IpartekifyService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private IpartekifyService servicio;
	
	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("artistas", servicio.obtenerArtistas());
		return "index";
	}
	
	@GetMapping("artistas/{id}/albumes")
	public String albumes(@PathVariable long id, Model modelo) {
		modelo.addAttribute("albumes", servicio.obtenerAlbumesPorIdArtista(id));
		return index(modelo);
	}
}
