package hts.backend.entity;

import hts.backend.entity.CoreEventoAseguradoraConcepto;
import hts.backend.entity.PacEvento;
import hts.backend.entity.PacAseguradora;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by SASA Desarrollo on 26/05/2017.
 */
@Entity
@Table(name = "pac_evento_aseguradora")
public class PacEventoAseguradora implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer eventoAseguradoraId;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private PacAseguradora pacAseguradora;
	private PacEvento pacEvento;




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EVENTO_ASEGURADORA_ID")
	public Integer getEventoAseguradoraId() {
		return eventoAseguradoraId;
	}

	public void setEventoAseguradoraId(Integer eventoAseguradoraId) {
		this.eventoAseguradoraId = eventoAseguradoraId;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAC_ASEGURADORA_ID")
	public PacAseguradora getPacAseguradora() {
		return pacAseguradora;
	}

	public void setPacAseguradora(PacAseguradora pacAseguradora) {
		this.pacAseguradora = pacAseguradora;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EVENTO_ID")
	public PacEvento getPacEvento() {
		return pacEvento;
	}

	public void setPacEvento(PacEvento pacEvento) {
		this.pacEvento = pacEvento;
	}




}
