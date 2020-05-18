package Kaori.wiki.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Kaori.wiki.entidades.Articulo;
import Kaori.wiki.entidades.Capitulo;
import Kaori.wiki.entidades.Serie;
import Kaori.wiki.entidades.Snippet;
import Kaori.wiki.entidades.Usuario;
import Kaori.wiki.repositorios.Articulo_Repositorio;
//import Kaori.wiki.repositorios.AvanceSerieKey_Respositorio;
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
	//AvanceSerieKey_Respositorio avanceSerieKey_Respositorio;
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
	
	public List<Snippet> listarSnippet(){ //deberiamos poner un condicionl para que solo admins tengan acceso
		return this.snippet_Repositorio.findAll();
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
	public List<Usuario> obtenerUsuarios(){
		return this.usuario_Repositorio.findAll();
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
	//EN TEORÍA LA DE SEARCH BAR
	public List<Articulo> obtenerArticulo(String busqueda) {
		String[] aux = busqueda.split(" ");
		List<Articulo> articulos = this.obtenerArticulos();
		List<Articulo> res = new ArrayList<Articulo>();
		for(Articulo auxArt:articulos) {
			if(auxArt.getTituloArticulo() == busqueda || auxArt.getSerie().getNombre() == busqueda){
				res.add(auxArt);
			}else{
				for(short i = 0; i < aux.length;i++) {
					if (auxArt.getSerie().getNombre() == aux[i]) { res.add(auxArt); }
				}
			}
		}
		return articulos;
	}
	
	public void actualizarAvanceSerie(Usuario usuario, Serie serie, Integer temporada, Integer capitulo) {
		usuario.ActualizarCapitulo(serie, temporada, capitulo);
	}
	
	public Serie registrarSerie(Serie nuevo) {
		return serie_Repositorio.save(nuevo);
	}
	public Serie buscarSerie(String titulo) {
		//TODO: APRENDER QUERYS
		List<Serie> series = (List<Serie>) serie_Repositorio.findAll();
		for(Serie aux:series) {
			if(aux.getNombre() == titulo) {
				return aux;
			}
		}
		return null;
	}
	
}
