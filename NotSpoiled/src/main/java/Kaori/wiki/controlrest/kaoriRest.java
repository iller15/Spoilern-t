package Kaori.wiki.controlrest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kaori.wiki.entidades.Articulo;
import Kaori.wiki.entidades.Capitulo;
import Kaori.wiki.entidades.Serie;
import Kaori.wiki.entidades.Snippet;
import Kaori.wiki.entidades.Temporada;
import Kaori.wiki.entidades.Usuario;

import Kaori.wiki.servicios.Servicios_web;

@RestController
@RequestMapping("/api")
public class kaoriRest {
	@Autowired
	private Servicios_web servicio;
	
	@RequestMapping(path = "/test")
    public String testto() {
        return "Holo, funciono!";
    }


	
	
//USUARIO
	
	@PostMapping("/regusuario")
	public Usuario registrarUsuario(@RequestBody Usuario usuario) {
		return servicio.registrarUsuario(usuario);
	}
	
	@GetMapping("/usuarios")
	public List<Usuario> verUsuarios(){
		return servicio.obtenerUsuarios();
	}
	
//SERIE
	
	@PostMapping("/regSerie")
	public Serie registrarSerie(@RequestBody Serie serie) {
		boolean unico = false;
		Integer cont = 1;
		Articulo articulo = new Articulo();
		//Para obtener la fecha actual;
		Date date = new Date();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
		serie.setAutoIdSerie();
		//verifica si el id dado a la series unico, si no se le cambia el ultimo digito de este aumentandolo en 1
		while(unico) {
			for(int i = 0; i < servicio.listSeries().size();i++) { //estoy seguro de que se puede mejorar con un catch y la funcion ya existente de encontrar por id
				if( serie.getIdSerie() != servicio.listSeries().get(i).getIdSerie() ) {
					unico = true;
					}
				else {
					serie.setIdSerie(serie.getIdSerie() + cont.toString());
					cont += 1;
				}
			}
		}
		//creando el articulo principal de la serie
		//Serie
		articulo.setSerie(serie);
		//titulo
		articulo.setTituloArticulo(serie.getNombre());
		//fecha
		formatoFecha.format(date);
		articulo.setFechaPublicacion(date);
		
		//guardando el articulo en la DB
		registrarArticulo(articulo);
		
		return servicio.registrarSerie(serie);
	}
	
	@GetMapping("/listSeries")
	public List<Serie> listSerie(){
		return this.servicio.listSeries();
	}
	
	
	//TODO: SOLO COMO TESTEO
	@PostMapping("/actualiza/{usuario}/{serie}")
	public String actualizarSerie(@PathVariable(value = "usuario") Long usuarioId, @PathVariable(value = "serie") String serieId) {
		//TODO: Formulario
		Usuario usuario = servicio.buscarUsuarioId(usuarioId);
		Serie serie = servicio.buscarSerieId(serieId);
		servicio.actualizarAvanceSerie(usuario, serie, 1, 1);
		return "TEST, FUNCIONA";
	}

//TEMPORADA
	@PostMapping("/regTemporada-{idSerie}")
	public Temporada registrarTemporada(@PathVariable(value = "idSerie")String idSerie, @RequestBody Temporada temporada) {
		Serie serie = servicio.buscarSerieId(idSerie);
		Integer nTemporadas = serie.getTemporadas().size();
		nTemporadas +=1;
		temporada.setSerie(serie);
		temporada.setNumTemporada(serie.getTemporadas().size()+1);
		temporada.setIdtemporada(idSerie+ "S"+ nTemporadas.toString());
		return servicio.registrarTemporada(temporada);
	}
	
//CAPITULO
	
	//El usuario no tiene que poner ni idCapitulo ni temporada ni numero de capitulo
	@PostMapping("/regCapitulo-{idTemporada}") 
	public Capitulo registrarCapitulo(@PathVariable(value = "idTemporada")String idTemporada, @RequestBody Capitulo capitulo) {
		Temporada temporada = servicio.buscarTemporadaId(idTemporada);
		Integer ncap= temporada.getCapitulos().size();
		ncap +=1;
		capitulo.setNumCap(ncap);
		capitulo.setIdCapitulo(idTemporada + "C" + ncap.toString());
		capitulo.setTemporada(temporada);
		
		return servicio.registrarCapitulo(capitulo);
	}
	
	@GetMapping("/listCapitulo")
	public List<Capitulo> listCapitulo(){
		return servicio.listarCapitulo();
	}
	
	
//SNIPPET
	
	@PostMapping("/snippet-{idCapitulo}")
	public Snippet registrarSnippet(@RequestBody Snippet snippet, @PathVariable(value = "idCapitulo") String idCapitulo) {
		snippet.setCapitulo(servicio.buscarCapituloId(idCapitulo));
		//creo que hay un problema aqui para mi porque elimine un par de snippets
		//tira que ya existe un snippet con ese id;
		
		
		return servicio.registrarSnippet(snippet);
	}
	
	@GetMapping("/listSnippet")
	public List<Snippet> listarSnippet(){
		return servicio.listarSnippet();
	}

//ARTICULO
	
	//Seccion articulos
	@GetMapping("/listArticulo")
	public List<Articulo> listarArticulos(){
		return servicio.obtenerArticulos(); 
	}
	
	@GetMapping("/articulo-{idArticulo}")
	public Articulo obtenerArticulo(@PathVariable(value = "idArticulo")Long idArticulo) {
		return servicio.obtenerArticulo(idArticulo);
	}
	
	@GetMapping("/articulo-{idArticulo}-{idCapitulo}")
	public List<Snippet> obtenerSnippetsFiltrados(@PathVariable(value = "idArticulo")String idArticulo,@PathVariable(value = "idCapitulo")String idCapitulo) {
		Long id= (long) 1;
		return servicio.filtrarArticulo(id,idCapitulo);
	}
	
	@GetMapping("/articuloid")
	public List<Snippet> obtenerSnippetsFiltrado() {
		Long id= (long) 1;
		return servicio.filtrarArticulo(id,"SwknuS1C1");
	}
	
	@PostMapping("/regArticulo")
	public Articulo registrarArticulo(Articulo articulo) {
		return servicio.registrarArticulo(articulo);
	}
	
	
}



	
	