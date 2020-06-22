package Kaori.wiki.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "AvanceSerie")
public class AvanceSerie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long idAvanceSerie;
	
	
	@ManyToOne
	@JoinColumn(name = "series")
	private Usuario usuario;
	
	@JsonIgnoreProperties
	@ManyToOne
	@JoinColumn(name = "usuarios")
	private Serie serie;
	
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCapitulo", referencedColumnName = "id")
	private Capitulo capitulo;
	
	public AvanceSerie() {}
	
	public AvanceSerie(Usuario usuario, Serie serie, Capitulo capitulo) {
		this.usuario = usuario;
		this.serie = serie;
		this.capitulo = capitulo;
	}
	
	/*
	public AvanceSerieKey getIdAvanceSerie() {
		return idAvanceSerie;
	}
	public void setIdAvanceSerie(AvanceSerieKey idAvanceSerie) {
		this.idAvanceSerie = idAvanceSerie;
	}*/
	
	public long getIdAvanceSerie() {
		return idAvanceSerie;
	}
	public void setIdAvanceSerie(long idAvanceSerie) {
		this.idAvanceSerie = idAvanceSerie;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Capitulo getCapitulo() {
		return capitulo;
	}
	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}
	
}
