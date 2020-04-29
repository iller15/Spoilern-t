package Kaori.wiki.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Personajes")
public class Personaje {
	@Id
	private String idPersonaje;
	private String Nombre;
	
	@ManyToOne
	@JoinColumn(name = "idSeries")
	private Serie serie;

	public String getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(String idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	
	//posiblemente falta poer list snippets
	
	
	
}
