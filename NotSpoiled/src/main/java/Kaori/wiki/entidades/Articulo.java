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
	//private Date fechaPublicacion;
	//private List<String> palabrasClave;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name = "Articulo_Serie_tlb",
			joinColumns = @JoinColumn(name = "idArticulo"),
			inverseJoinColumns = @JoinColumn(name = "idSnippet")
	)
	private List<Snippet> spoilersEnArticulo;
	
}
