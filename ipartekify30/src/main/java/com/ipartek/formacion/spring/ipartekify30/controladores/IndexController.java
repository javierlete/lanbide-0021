package com.ipartek.formacion.spring.ipartekify30.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ipartek.formacion.spring.ipartekify30.configuraciones.WebSecurityConfig;
import com.ipartek.formacion.spring.ipartekify30.entidades.Album;
import com.ipartek.formacion.spring.ipartekify30.entidades.Cancion;
import com.ipartek.formacion.spring.ipartekify30.entidades.Lista;
import com.ipartek.formacion.spring.ipartekify30.entidades.Usuario;
import com.ipartek.formacion.spring.ipartekify30.servicios.IpartekifyService;

@Controller
@RequestMapping("/")
@SessionAttributes("usuario")
public class IndexController {
	private static final String ALBUM_TEXTO = "album";

	@Autowired
	private IpartekifyService servicio;
	
	private Usuario usuario;
	
	public IndexController(WebSecurityConfig config) {
		usuario = config.getUsuario();
	}
	
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

	@GetMapping("albumes/{idAlbum}")
	public String album(@PathVariable long idAlbum, Model modelo) {
		Album album = servicio.obtenerAlbum(idAlbum);
		modelo.addAttribute(ALBUM_TEXTO, album);
		return artista(album.getArtista().getId(), modelo);
	}

	@GetMapping("canciones/{idCancion}")
	public String cancion(@PathVariable long idCancion, Model modelo,
			@RequestParam(required = false) String favoritas) {
		Cancion cancion = servicio.obtenerCancion(idCancion);
		modelo.addAttribute("cancion", cancion);

		if (favoritas == null) {
			return album(cancion.getAlbum().getId(), modelo);
		} else {
			return favoritas(modelo);
		}
	}

	@GetMapping("canciones/{idCancion}/favorito")
	public String conmutarCancionFavorita(@PathVariable long idCancion, Model modelo) {
		Cancion cancion = servicio.obtenerCancion(idCancion);

		if (usuario.getCancionesFavoritas().contains(cancion)) {
			usuario.getCancionesFavoritas().remove(cancion);
		} else {
			usuario.getCancionesFavoritas().add(cancion);
		}

		servicio.guardarUsuario(usuario);

		modelo.addAttribute("cancion", cancion);

		return album(cancion.getAlbum().getId(), modelo);
	}

	@GetMapping("favoritas")
	public String favoritas(Model modelo) {
		Album album = new Album(0L, "Canciones favoritas", null, null, null, null);
		album.setCanciones(usuario.getCancionesFavoritas());
		modelo.addAttribute(ALBUM_TEXTO, album);
		return index(modelo);
	}

	@RequestMapping("agregarLista")
	public String agregarLista(@RequestParam(name = "nueva-lista") String nuevaLista, Model modelo) {
		servicio.nuevaLista(nuevaLista, usuario);

		return index(modelo);
	}

	@GetMapping("listas/{idLista}/agregar/{idCancion}")
	public String agregarCancionLista(@PathVariable long idLista, @PathVariable long idCancion, Model modelo) {
		servicio.agregarCancionLista(idLista, idCancion);

		Cancion cancion = servicio.obtenerCancion(idCancion);

		return album(cancion.getAlbum().getId(), modelo);
	}

	@GetMapping("listas/{idLista}/quitar/{idCancion}")
	public String quitarCancionLista(@PathVariable long idLista, @PathVariable long idCancion, Model modelo) {
		servicio.quitarCancionLista(idLista, idCancion);

		return lista(idLista, modelo);
	}

	@GetMapping("listas/{idLista}")
	public String lista(@PathVariable long idLista, Model modelo) {
		Lista lista = servicio.obtenerLista(idLista);
		Album album = new Album(-lista.getId(), lista.getNombre(), null, null, null, null);
		album.setCanciones(lista.getCanciones());
		modelo.addAttribute(ALBUM_TEXTO, album);
		return index(modelo);
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@PostMapping("logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/login";
	}
}
