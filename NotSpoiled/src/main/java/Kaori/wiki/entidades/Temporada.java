package Kaori.wiki.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Temporadas")
public class Temporada {
	
	@Id
	private String idtemporada;
	//Numero de Temporada;
	private int numTemporada;
	//Fechas de emision de la serie.
	private String Fecha_inicio;
	private String Fecha_Final;
	
	@ManyToOne
	@JoinColumn(name = "idSeries")
	private Serie serie;
	
	@OneToMany
	private List<Capitulo> capitulo;

	
	public String getIdtemporada() {
		return idtemporada;
	}

	public void setIdtemporada(String idtemporada) {
		this.idtemporada = idtemporada;
	}

	public int getNumTemporada() {
		return numTemporada;
	}

	public void setNumTemporada(int numTemporada) {
		this.numTemporada = numTemporada;
	}

	public String getFecha_inicio() {
		return Fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		Fecha_inicio = fecha_inicio;
	}

	public String getFecha_Final() {
		return Fecha_Final;
	}

	public void setFecha_Final(String fecha_Final) {
		Fecha_Final = fecha_Final;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public List<Capitulo> getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(List<Capitulo> capitulo) {
		this.capitulo = capitulo;
	} 
	
	
	
	
}
