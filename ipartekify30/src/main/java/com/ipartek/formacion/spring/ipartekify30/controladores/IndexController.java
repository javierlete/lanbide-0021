package com.ipartek.formacion.spring.ipartekify30.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ipartek.formacion.spring.ipartekify30.entidades.Album;
import com.ipartek.formacion.spring.ipartekify30.entidades.Cancion;
import com.ipartek.formacion.spring.ipartekify30.entidades.Usuario;
import com.ipartek.formacion.spring.ipartekify30.servicios.IpartekifyService;

@Controller
@RequestMapping("/")
@SessionAttributes("usuario")
public class IndexController {
	@Autowired
	private IpartekifyService servicio;
	
	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("artistas", servicio.obtenerArtistas());
		return "index";
	}
	
	@GetMapping("artistas/{id}")
	public String artista(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("artista", servicio.obtenerArtista(id));
		return index(modelo);
	}
	
	@GetMapping("albumes/{id}")
	public String album(@PathVariable long id, Model modelo, Usuario usuario) {
		Album album = servicio.obtenerAlbum(id);
		modelo.addAttribute("album", album);
		return artista(album.getArtista().getId(), modelo);
	}
	
	@GetMapping("canciones/{id}")
	public String cancion(@PathVariable long id, Model modelo, Usuario usuario) {
		Cancion cancion = servicio.obtenerCancion(id);
		modelo.addAttribute("cancion", cancion);
		return album(cancion.getAlbum().getId(), modelo, usuario);
	}
}
