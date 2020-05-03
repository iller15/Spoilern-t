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
	
	private Integer capitulo;

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

	public Integer getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(Integer capitulo) {
		this.capitulo = capitulo;
	}
	
}
