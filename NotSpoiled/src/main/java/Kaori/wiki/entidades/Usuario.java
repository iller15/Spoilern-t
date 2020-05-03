package Kaori.wiki.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long idUsuario;
	private String nombreUsuario;
	private Integer nivelUsuario; 	//Categorías (Sería más fácil tenerlo numérico en
									// backend y pasarlo a String para la UI no?)
	private String password;
	/*@ManyToMany
	@JoinTable(
			name = "Usuario_Serie_tlb",
			joinColumns = @JoinColumn(name = "idUsuario"),
			inverseJoinColumns = @JoinColumn(name = "idSerie")
	)
	List<Serie> series;*/ 
	// A CREAR NUEVA TABLA PARA GUARDAR LOS ATRIBUTOS DE AVANCE POR SERIE
}
