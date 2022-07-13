package hts.backend.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cat_tipo_captura")
public class CatTipoCaptura implements java.io.Serializable {

	private Integer tipoCapturaId;
	private String nombre;
	private Set<BitacoraTriage> bitacoraTriages;

	@Id
	@Column(name = "TIPO_CAPTURA_ID", nullable = false)
	public Integer getTipoCapturaId() {
		return tipoCapturaId;
	}

	public void setTipoCapturaId(Integer tipoCapturaId) {
		this.tipoCapturaId = tipoCapturaId;
	}

	@Basic
	@Column(name = "NOMBRE", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(mappedBy = "catTipoCaptura")
	public Set<BitacoraTriage> getBitacoraTriages() {
		return bitacoraTriages;
	}

	public void setBitacoraTriages(Set<BitacoraTriage> bitacoraTriages) {
		this.bitacoraTriages = bitacoraTriages;
	}
}
