package Kaori.wiki.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios") //SEGÚN ESQUEMA YA ESCRITO
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long idUsuario;
	private String nombreUsuario;
	private Integer nivelUsuario; 	//Categorías (Sería más fácil tenerlo numérico en
									// backend y pasarlo a String para la UI no?)
	private String password;
	@OneToMany(mappedBy = "usuario")
	List<AvanceSerie> series;
	private String correo; // Información de contacto :p
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public Integer getNivelUsuario() {
		return nivelUsuario;
	}
	public void setNivelUsuario(Integer nivelUsuario) {
		this.nivelUsuario = nivelUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<AvanceSerie> getSeries() {
		return series;
	}
	/* Sin SET porque no tiene sentido, TODO Armar funcion para "Ver" un capitulo
	 * */
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	// TO DO: 
	// ----------------------------------------------------------------------------------
	
	//INCOMPLETO
	public void verNuevoCapitulo(Serie serie, Integer temporada, Integer capitulo) {
		
	}
}
