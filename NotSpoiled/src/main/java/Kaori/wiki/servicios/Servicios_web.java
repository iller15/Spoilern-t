package Kaori.wiki.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Kaori.wiki.entidades.Articulo;
import Kaori.wiki.entidades.Snippet;
import Kaori.wiki.entidades.Usuario;
import Kaori.wiki.repositorios.Articulo_Repositorio;
import Kaori.wiki.repositorios.AvanceSerieKey_Respositorio;
import Kaori.wiki.repositorios.AvanceSerie_Repositorio;
import Kaori.wiki.repositorios.Capitulo_Repositorio;
import Kaori.wiki.repositorios.Personaje_Repositorio;
import Kaori.wiki.repositorios.Serie_Repositorio;
import Kaori.wiki.repositorios.Snippet_Repositorio;
import Kaori.wiki.repositorios.Temporadas_Repositorio;
import Kaori.wiki.repositorios.Usuario_Repositorio;

@Service
public class Servicios_web {
	// todos los repositorios;
	@Autowired
	Articulo_Repositorio articulo_Repositorio;
	@Autowired
	AvanceSerie_Repositorio  avanceSerie_Repositorio;
	AvanceSerieKey_Respositorio avanceSerieKey_Respositorio;
	@Autowired
	Capitulo_Repositorio capitulo_Repositorio;
	@Autowired
	Personaje_Repositorio personaje_Repositorio;
	@Autowired
	Serie_Repositorio serie_Repositorio;
	@Autowired
	Snippet_Repositorio snippet_Repositorio;
	@Autowired
	Temporadas_Repositorio temporadas_Repositorio;
	@Autowired
	Usuario_Repositorio usuario_Repositorio;
	
	//Funciones de la pagina;
	
	public Snippet registrarSnippet(Snippet snippet) {
		return snippet_Repositorio.save(snippet);
	}
	
	@Transactional
	public Usuario registrarUsuario(Usuario nuevo) {
		return usuario_Repositorio.save(nuevo);
	}
	//POR FAVOR LEER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public List<Usuario> buscarUsuario(String nombre){
		List<Usuario> todos = this.usuario_Repositorio.findAll();
		List<Usuario> tocayos = new ArrayList<Usuario>();
		for(Usuario usuario:todos) {
			if (usuario.getNombreUsuario() == nombre) { tocayos.add(usuario); }
		}
		return tocayos;
	}
	
	@Transactional
	public Articulo registrarArticulo(Articulo nuevo) {
		return articulo_Repositorio.save(nuevo);
	}

	public List<Articulo> obtenerArticulos(){
		return articulo_Repositorio.findAll();
	}
	public Articulo obtenerArticulo(Long id){
		Optional<Articulo> aux = this.articulo_Repositorio.findById(id);
		return aux.get();
	}
}
