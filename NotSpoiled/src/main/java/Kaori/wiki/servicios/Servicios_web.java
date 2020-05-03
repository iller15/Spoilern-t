package Kaori.wiki.servicios;

import org.springframework.stereotype.Service;

import Kaori.wiki.entidades.Snippet;
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
	Articulo_Repositorio articulo_Repositorio;
	AvanceSerie_Repositorio  avanceSerie_Repositorio;
	AvanceSerieKey_Respositorio avanceSerieKey_Respositorio;
	Capitulo_Repositorio capitulo_Repositorio;
	Personaje_Repositorio personaje_Repositorio;
	Serie_Repositorio serie_Repositorio;
	Snippet_Repositorio snippet_Repositorio;
	Temporadas_Repositorio temporadas_Repositorio;
	Usuario_Repositorio usuario_Repositorio;
	
	//Funciones de la pagina;
	
	public Snippet RegistrarSnippet(Snippet snippet) {
		return snippet_Repositorio.save(snippet);
	}
	
	

}
