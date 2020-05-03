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
@Table(name = "Usuarios") //SEGÃšN ESQUEMA YA ESCRITO
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long idUsuario;
	private String nombreUsuario;
	private Integer nivelUsuario; 	//CategorÃ­as (SerÃ­a mÃ¡s fÃ¡cil tenerlo numÃ©rico en
									// backend y pasarlo a String para la UI no?)
	private String password;
	@OneToMany(mappedBy = "usuario")
	List<AvanceSerie> series;
	private String correo; // InformaciÃ³n de contacto :p
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
	
	public boolean veSerie(Serie serie) {
		for (AvanceSerie temp: series) {
			if (temp.getSerie().getIdSerie() == serie.getIdSerie()) { return true; }
		}
		return false;
	}
	public AvanceSerie getSerieV(Serie serie) { // posible NULL
		for (AvanceSerie temp: series) {
			if (temp.getSerie().getIdSerie() == serie.getIdSerie()) { return temp; }
		}
		return null;
	}
	public Capitulo ultCapVisto(Serie serie) {  // puede Devoler NULL
		for(AvanceSerie temp: series) {
			if(temp.getSerie().getIdSerie() == serie.getIdSerie()) { return temp.getCapitulo(); }
			return null;
		}
		return null;
	}
	
	//INCOMPLETO: CASO 1 (FEO), 2 y ERRORES
	// TODO Implementar mÃ¡s funciones en las demÃ¡s clases para facilitar
	public void verNuevoCapitulo(Serie serie, Integer temporada, Integer capitulo) {
		AvanceSerie t_serieV = this.getSerieV(serie);
		Capitulo nuevoCap = serie.getCapitulo(temporada, capitulo);
		if (t_serieV != null) {
			//CASO 1: ES UNA SERIE QUE ESTÁ VIENDO
			if(nuevoCap != null) {
				t_serieV.setCapitulo(nuevoCap);
			}
		}else {
			//CASO 2: La serie no la ha visto
			if(nuevoCap != null) {
				t_serieV = new AvanceSerie(this,serie, nuevoCap);
			}
			//NO HACE NADA SI EL INPUT ES INVALIDO
		}
		//MANEJO DE ERRORES
		//TODO: todo
	}
}
