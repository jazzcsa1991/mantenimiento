package hts.backend.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nom_cat_tipo_registro")
public class NomCatTipoRegistro implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer tipoRegistroId;
	private String descripcion;


	@Id
	@Column(name = "TIPO_REGISTRO_ID", unique = true, nullable = false)
	public Integer getTipoRegistroId() {
		return tipoRegistroId;
	}

	public void setTipoRegistroId(Integer tipoRegistroId) {
		this.tipoRegistroId = tipoRegistroId;
	}


	@Column(name = "DESCRIPCION", nullable = false, length = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
