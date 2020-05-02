package Kaori.wiki.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Capitulos")
public class Capitulo {
	@Id
	private String idCapitulo;
	private int numCap;
	private String tituloCap;
	
	@ManyToOne
	@JoinColumn(name = "idTemporada")
	private Temporada temporada;

	public String getIdCapitulo() {
		return idCapitulo;
	}

	public void setIdCapitulo(String idCapitulo) {
		this.idCapitulo = idCapitulo;
	}

	public int getNumCap() {
		return numCap;
	}

	public void setNumCap(int numCap) {
		this.numCap = numCap;
	}

	public String getTituloCap() {
		return tituloCap;
	}

	public void setTituloCap(String tituloCap) {
		this.tituloCap = tituloCap;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}
	
	
	
}