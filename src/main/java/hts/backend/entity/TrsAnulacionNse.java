package hts.backend.entity;


import javax.persistence.*;
import java.util.Date;


/**
 * Created by SASA Desarrollo on 04/07/2017.
 */
@Entity
@Table(name = "trs_anulacion_nse")
public class TrsAnulacionNse implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer anulacionNseId;
	private TrsCondicionesEconomicas trsCondicionesEconomicas;
	private TrsNseUnicaOcasion trsNseUnicaOcasion;
	private CatMotivoAnulacionNse catMotivoAnulacionNse;
	private String comentarios;
	private Date fechaRegistro;
	private String usuarioRegistro;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ANULACION_NSE_ID") public Integer getAnulacionNseId() {
		return anulacionNseId;
	}

	public void setAnulacionNseId(Integer anulacionNseId) {
		this.anulacionNseId = anulacionNseId;
	}

	@ManyToOne
	@JoinColumn(name = "CONDICIONES_ECONOMICAS_ID")
	public TrsCondicionesEconomicas getTrsCondicionesEconomicas() {
		return trsCondicionesEconomicas;
	}

	public void setTrsCondicionesEconomicas(TrsCondicionesEconomicas trsCondicionesEconomicas) {
		this.trsCondicionesEconomicas = trsCondicionesEconomicas;
	}

	@ManyToOne
	@JoinColumn(name = "NSE_UNICA_OCACION_ID")
	public TrsNseUnicaOcasion getTrsNseUnicaOcasion() {
		return trsNseUnicaOcasion;
	}

	public void setTrsNseUnicaOcasion(TrsNseUnicaOcasion trsNseUnicaOcasion) {
		this.trsNseUnicaOcasion = trsNseUnicaOcasion;
	}

	@ManyToOne
	@JoinColumn(name = "MOTIVO_ANULACION_NSE_ID")
	public CatMotivoAnulacionNse getCatMotivoAnulacionNse() {
		return catMotivoAnulacionNse;
	}

	public void setCatMotivoAnulacionNse(CatMotivoAnulacionNse catMotivoAnulacionNse) {
		this.catMotivoAnulacionNse = catMotivoAnulacionNse;
	}


	@Basic @Column(name = "COMENTARIOS") public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Basic @Column(name = "FECHA_REGISTRO") public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Basic @Column(name = "USUARIO_REGISTRO") public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

}
