package Kaori.wiki.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AvanceSerie")
public class AvanceSerie implements Serializable {
	private static final long serialVersionUID = 1L;

	//@EmbeddedId
	//private AvanceSerieKey idAvanceSerie;
	
	/*@ManyToOne
	@MapsId("Id_Usuario")
	@JoinColumn(name = "Id_Usuario")
	private Usuario usuario;
	@ManyToOne
	@MapsId("Id_Serie")
	@JoinColumn(name = "Id_Serie")
	private Serie serie;*/
	
	@Id
	private Long idAvanceSerie;
	
	@ManyToOne
	@JoinColumn(name = "series")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "usuarios")
	private Serie serie;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCapitulo", referencedColumnName = "id")
	private Capitulo capitulo;

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
