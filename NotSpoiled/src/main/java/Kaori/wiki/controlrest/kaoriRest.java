package Kaori.wiki.controlrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
