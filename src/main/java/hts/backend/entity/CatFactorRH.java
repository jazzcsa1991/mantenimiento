package hts.backend.entity;


import javax.persistence.*;


@Entity
@Table(name = "cat_factor_rh")
public class CatFactorRH {

	private int idFactorRH;
	private String cveFactorRH;
	private String descripcion;
	
	
	
	public CatFactorRH(int idFactorRH, String cveFactorRH, String descripcion) {
		super();
		this.idFactorRH = idFactorRH;
		this.cveFactorRH = cveFactorRH;
		this.descripcion = descripcion;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FACTOR_RH", unique = true, nullable = false)
	public int getIdFactorRH() {
		return idFactorRH;
	}
	public void setIdFactorRH(int idFactorRH) {
		this.idFactorRH = idFactorRH;
	}
	
	@Column(name = "CVE_FACTOR_RH", nullable = false)
	public String getCveFactorRH() {
		return cveFactorRH;
	}
	public void setCveFactorRH(String cveFactorRH) {
		this.cveFactorRH = cveFactorRH;
	}
	
	@Column(name = "DESCRIPCION", nullable = false)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
