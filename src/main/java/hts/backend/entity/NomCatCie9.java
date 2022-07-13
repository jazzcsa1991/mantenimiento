package hts.backend.entity;

import hts.backend.entity.BqrTipoProcedimientoCie9;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "nom_cat_cie_9")
public class NomCatCie9 implements java.io.Serializable {
	private Integer cie9Id;
	private Integer capitulo;
	private String cveProc;
	private Integer cveEdi;
	private Integer edadI;
	private Integer cveEdf;
	private Integer edadF;
	private Integer sexo;
	private Integer nivel;
	private String proced;
	private String descrip;
	private Set<BqrTipoProcedimientoCie9> bqrTipoProcedimientoCie9sByCie9Id;

	@OneToMany(mappedBy = "nomCatCie9ByCie9Id") public Set<BqrTipoProcedimientoCie9> getBqrTipoProcedimientoCie9sByCie9Id() {
		return bqrTipoProcedimientoCie9sByCie9Id;
	}

	public void setBqrTipoProcedimientoCie9sByCie9Id(Set<BqrTipoProcedimientoCie9> bqrTipoProcedimientoCie9sByCie9Id) {
		this.bqrTipoProcedimientoCie9sByCie9Id = bqrTipoProcedimientoCie9sByCie9Id;
	}

	@Id
	@Column(name = "CIE_9_ID")
	public Integer getCie9Id() {
		return cie9Id;
	}

	public void setCie9Id(Integer cie9Id) {
		this.cie9Id = cie9Id;
	}

	@Basic
	@Column(name = "CAPITULO")
	public Integer getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(Integer capitulo) {
		this.capitulo = capitulo;
	}

	@Basic
	@Column(name = "CVE_PROC")
	public String getCveProc() {
		return cveProc;
	}

	public void setCveProc(String cveProc) {
		this.cveProc = cveProc;
	}

	@Basic
	@Column(name = "CVE_EDI")
	public Integer getCveEdi() {
		return cveEdi;
	}

	public void setCveEdi(Integer cveEdi) {
		this.cveEdi = cveEdi;
	}

	@Basic
	@Column(name = "EDAD_I")
	public Integer getEdadI() {
		return edadI;
	}

	public void setEdadI(Integer edadI) {
		this.edadI = edadI;
	}

	@Basic
	@Column(name = "CVE_EDF")
	public Integer getCveEdf() {
		return cveEdf;
	}

	public void setCveEdf(Integer cveEdf) {
		this.cveEdf = cveEdf;
	}

	@Basic
	@Column(name = "EDAD_F")
	public Integer getEdadF() {
		return edadF;
	}

	public void setEdadF(Integer edadF) {
		this.edadF = edadF;
	}

	@Basic
	@Column(name = "SEXO")
	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	@Basic
	@Column(name = "NIVEL")
	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	@Basic
	@Column(name = "PROCED")
	public String getProced() {
		return proced;
	}

	public void setProced(String proced) {
		this.proced = proced;
	}

	@Basic
	@Column(name = "DESCRIP")
	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
}
