package Kaori.wiki.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Articulos_tbl")
public class Articulo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idArticulo;
	
	private String tituloArticulo;
	private Date fechaPublicacion;
	//private List<String> palabrasClave;
	//Otra vez estoy pensando en cómo hacer esto bien para facilitar el proceso de búsqueda
	//Que maybe deba aparecer una tabla PalabraClave (ManyToMany) y 
	//Búsqueda busca por palabras sucede por Serie, Personaje, o palabras 
	//(Biografía, Boda, Impacto, idk xd, tampoco sería tan extenso)
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name = "Articulo_Serie_tlb",
			joinColumns = @JoinColumn(name = "idArticulo"),
			inverseJoinColumns = @JoinColumn(name = "idSnippet")
	)
	private List<Snippet> spoilersEnArticulo;
	// private List<Integer> ordenSnippets; // Para mantener el orden de escritura
	// INNECESARIO A MENOS QUE SE QUIERA ORDENAR CON STRINGS EN MEDIO
	
	@ManyToOne
	@JoinColumn(name = "idSeries")
	private Serie serie; //De qué serie hablamos

	public Long getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(Long idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getTituloArticulo() {
		return tituloArticulo;
	}
	public void setTituloArticulo(String tituloArticulo) {
		this.tituloArticulo = tituloArticulo;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public List<Snippet> getSpoilersEnArticulo() {
		return spoilersEnArticulo;
	}
	public void setSpoilersEnArticulo(List<Snippet> spoilersEnArticulo) {
		this.spoilersEnArticulo = spoilersEnArticulo;
	}
/*
	public List<Integer> getOrdenSnippets() {
		return ordenSnippets;
	}
	public void setOrdenSnippets(List<Integer> ordenSnippets) {
		this.ordenSnippets = ordenSnippets;
	}
*/
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}

}
