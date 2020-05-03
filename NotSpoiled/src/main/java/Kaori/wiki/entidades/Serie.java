package Kaori.wiki.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Series")
public class Serie {
	@Id
	private String idSerie;
	private String nombre;
	
	@OneToMany(mappedBy = "serie")
	private List<Personaje> personajes;
	
	@OneToMany(mappedBy = "serie")
	private List<Temporada> temporadas;
	
	@OneToMany(mappedBy = "serie")
	private List<Articulo> articulos;
	
	@OneToMany(mappedBy = "serie")
	List<AvanceSerie> usuarios;
	
	//Getters and setters
	public String getIdSerie() {
		return idSerie;
	}
	public void setIdSerie(String idSerie) {
		this.idSerie = idSerie;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}
	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

	public List<Temporada> getTemporadas() {
		return temporadas;
	}
	public void setTemporadas(List<Temporada> temporadas) {
		this.temporadas = temporadas;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	//NUEVOS MÉTODOS
	public void addArticulos(Articulo nuevo) {
		articulos.add(nuevo);
	}

	public Capitulo getCapitulo(int temporada, int capitulo) { // Puede ser NULL
		if(this.temporadas.size() > temporada) {
			return temporadas.get(temporada).getCapitulo(capitulo); //x2 a lo de null
		}
		return null;
	}
}
