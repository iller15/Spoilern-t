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
import Kaori.wiki.entidades.Temporada;
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
	
	//AUXILIAR
	public static Boolean similares(String s1, String s2) { //S1: Original | S2: Busqueda
	    if(s1 == s2) { return true; }
	    s1 = s1.toLowerCase();
	    s2 = s2.toLowerCase();
	    int iguales = 0;
	    int umbral = s1.length()*(3/5);
	    for(int i = 0; i < s1.length(); i++) {
	    	for(int j = 0; j < s2.length(); j++) {
	    		if(s1.charAt(i) == s2.charAt(j)) { iguales++; }
	    		else if (s1.charAt(i) != s2.charAt(j)) {
	    			if(iguales > umbral) { return true; }
	    		}
	    	}
	    }
	    return false;
	}
	
	//--------------------------------------------------------------------
	//FUNCIONES DE LA PAGINA Y ENTIDADES

	
//SNIPPET
	
	public Snippet registrarSnippet(Snippet snippet) {
		Integer nSnippets = snippet.getCapitulo().getSpoilers().size() + 1;
		snippet.setIdSnippet(snippet.getCapitulo().getIdCapitulo() + "SNP" + nSnippets );
		
		return snippet_Repositorio.save(snippet);
	}
	
	public List<Snippet> listarSnippet(){ //deberiamos poner un condicionl para que solo admins tengan acceso
		return this.snippet_Repositorio.findAll();
	}

	
//USUARIO

	@Transactional
	public Usuario registrarUsuario(Usuario nuevo) {
		return usuario_Repositorio.save(nuevo);
	}
	//ESTRICTO
	public Usuario buscarUsuarioNombre(String nombre){
		List<Usuario> todos = this.usuario_Repositorio.findAll();
		for(Usuario usuario:todos) {
			if (usuario.getNombreUsuario() == nombre) { return usuario; }
		}
		return null;
	}
	public Usuario buscarUsuarioId(Long idUsuario) {
		return usuario_Repositorio.findById(idUsuario).get();
	}
	public List<Usuario> obtenerUsuarios(){
		return this.usuario_Repositorio.findAll();
	}
	
// ARTICULOS
	
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

//AVANCESERIES
	
	public void actualizarAvanceSerie(Usuario usuario, Serie serie, Integer temporada, Integer capitulo) {
		usuario.ActualizarCapitulo(serie, temporada, capitulo);
	}
	
//SERIES
	
	//TODO: FORMULARIOS EN FRONT
	public Serie registrarSerie(Serie nuevo) {
		return serie_Repositorio.save(nuevo);
	}
	
	public List<Serie> listSeries(){
		return (List<Serie>) serie_Repositorio.findAll();
	}
	
	public Serie buscarSerieTitulo(String titulo) {
		//TODO: APRENDER QUERYS
		List<Serie> series = (List<Serie>) serie_Repositorio.findAll();
		for(Serie aux:series) {
			if(this.similares(aux.getNombre(),titulo)) {
				return aux;
			}
		}
		return null;
	}
	public Serie buscarSerieId(String idSerie) {
		return serie_Repositorio.findById(idSerie).get();
	}
	
//TEMPORADA
	
	public Temporada buscarTemporadaId(String idTemporada) {
		return temporadas_Repositorio.findById(idTemporada).get();
	}
	
	public void addTemporada(Serie serie, Temporada temporada) {
		serie.addTemporada(temporada);
	}
	
	public Temporada registrarTemporada(Temporada temporada) {
		return temporadas_Repositorio.save(temporada);
	}
	
	public void addCapitulo(Serie serie, Integer temporada, Capitulo nuevo) {
		serie.getTemporada(temporada).addCapitulo(nuevo);
	}
	
//CAPITULOS
	
	public Capitulo registrarCapitulo(Capitulo capitulo) {
		return capitulo_Repositorio.save(capitulo);
	}
	public Capitulo buscarCapituloId(String idCapitulo) {
		return capitulo_Repositorio.findById(idCapitulo).get();
	}
	public List<Capitulo> listarCapitulo(){
		return (List<Capitulo>) capitulo_Repositorio.findAll();
	}
	
}


