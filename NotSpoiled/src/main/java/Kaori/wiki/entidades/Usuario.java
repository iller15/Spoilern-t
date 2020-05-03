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
	
	//INCOMPLETO: CASO 1 (FEO), 2 y ERRORES
	// TODO Implementar mÃ¡s funciones en las demÃ¡s clases para facilitar
	public void verNuevoCapitulo(Serie serie, Integer temporada, Integer capitulo) {
		String newSerieId = serie.getIdSerie();
		String newCap;
		for(AvanceSerie temp: series) {
			//por cada serie que (ha visto/estÃ¡ viendo) el usuario llamada TEMP
			if (temp.getSerie().getIdSerie() == newSerieId) {
				//CASO 1: ES UNA SERIE QUE ESTÃ� VIENDO
				newCap = temp.getSerie().getIdSerie();
				if(temp.getSerie().getTemporadas().size() > temporada) {
					newCap = newCap + temporada.toString();
					if (temp.getSerie().getTemporadas().get(temporada).getCapitulo().size() > capitulo) {
						newCap = newCap + capitulo.toString();
						temp.setCapitulo(capitulo);
					}
				}else {
					//ERROR: Temporada fuera
					//prueba 2
									}
				break;
			}
		}
		//CASO 2: La serie no la ha visto
		//TODO: todo
		//MANEJO DE ERRORES
		//TODO: todo
	}
}
