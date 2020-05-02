package Kaori.wiki.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Snippet")
public class Snippet {
	@Id
	@Column(unique = true)
	private String idSnippet;
	
	private String description;
	private String texto;
	
	@Column(nullable = true)
	private List<Personaje> personaje; //Puede no referirse ningun personaje en especifico;
	// @dante mandame un mensaje cuando veas esto xD,// private Capitulo ultimoCap;

	@ManyToMany(mappedBy = "spoilersEnArticulo")
	private List<Articulo> articulos;
	
	public String getIdSnippet() {
		return idSnippet;
	}

	public void setIdSnippet(String idSnippet) {
		this.idSnippet = idSnippet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Personaje> getPersonaje() {
		return personaje;
	}

	public void setPersonaje(List<Personaje> personaje) {
		this.personaje = personaje;
	}
	
	
	
	
}
