package Kaori.wiki.entidades;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "AvanceSerie")
public class AvanceSerie implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AvanceSerieKey idAvanceSerie;
	
	@ManyToOne
	@MapsId("idUsuario")
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@ManyToOne
	@MapsId("idSerie")
	@JoinColumn(name = "idSerie")
	private Serie serie;
	
	private Capitulo capitulo;

	public AvanceSerie(Usuario usuario, Serie serie, Capitulo capitulo) {
		this.usuario = usuario;
		this.serie = serie;
		this.capitulo = capitulo;
	}
	
	public AvanceSerieKey getIdAvanceSerie() {
		return idAvanceSerie;
	}
	public void setIdAvanceSerie(AvanceSerieKey idAvanceSerie) {
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
