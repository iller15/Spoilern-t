package Kaori.wiki.controlrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kaori.wiki.entidades.Snippet;
import Kaori.wiki.entidades.Usuario;
import Kaori.wiki.servicios.Servicios_web;

@RestController
@RequestMapping("/api")
public class kaoriRest {
	@Autowired
	private Servicios_web servicio;
	
	@PostMapping("/regusuario")
	public Usuario registrarUsuario(@RequestBody Usuario usuario) {
		return servicio.registrarUsuario(usuario);
	}
/*	@PostMapping("/regserie")
	public Serie registrarUsuario(@RequestBody Serie serie) {
		
	}
*/	
	@GetMapping("/usuarios")
	public List<Usuario> verUsuarios(){
		return servicio.obtenerUsuarios();
	}
	
	@RequestMapping(path = "/test")
    public String testto() {
        return "Holo, funciono!";
    }
	
	@PostMapping("/snippet")
	public Snippet registrarSnippet(@RequestBody Snippet snippet) {
		return servicio.registrarSnippet(snippet);
	}
	
	@GetMapping("/listSnippet")
	public List<Snippet> listarSnippet(){
		return servicio.listarSnippet();
	}
}
