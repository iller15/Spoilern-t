package Kaori.wiki.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AvanceSerieKey implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "Id_Usuario")
	Long idUsuario;
	@Column(name = "Id_Serie")
	Long idSerie;
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getIdSerie() {
		return idSerie;
	}
	public void setIdSerie(Long idSerie) {
		this.idSerie = idSerie;
	}
	
	//HashCode & Equals, NECESARIOS SEGÚN https://www.baeldung.com/jpa-many-to-many
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSerie == null) ? 0 : idSerie.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvanceSerieKey other = (AvanceSerieKey) obj;
		if (idSerie == null) {
			if (other.idSerie != null)
				return false;
		} else if (!idSerie.equals(other.idSerie))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}

}
