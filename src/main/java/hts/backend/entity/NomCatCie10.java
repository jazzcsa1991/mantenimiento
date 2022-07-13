package hts.backend.entity;

import hts.backend.entity.CoreContrarreferencia;
import hts.backend.entity.CoreReferencia;
import hts.backend.entity.CoreReferenciasExternas;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "nom_cat_cie_10")
public class NomCatCie10 implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cie10Id;
	private String letra;
	private String clave;
	private String a;
	private String nombre;
	private Integer lsex;
	private String linf;
	private String lsup;
	private String triv;
	private String errad;
	private String NInter;
	private String nin;
	private String ninmtobs;
	private String noCbd;
	private String noAph;
	private String fetal;
	private Integer capitulo;
	private Integer lista1;
	private Integer grupo1;
	private Integer lista5;
	private String actualizacionesCie10;
	private String yearModifi;
	private String yearAplicacion;
	private String prinmorta;
	private String prinmorbi;
	private String lmMorbi;
	private String lmMorta;
	private Integer lgbd165;
	private Integer lomsbeck;
	private Integer lgbd190;
	private String notdiaria;
	private String notsemanal;
	private String sistemaEspecial;
	private String birmm;
	private Integer pocoUtil;
	private String epiMorta;
	private String epiMortaM5;
	private Integer edadMin;
	private Integer edadMax;

	private String causes;
	private String suive;

	private Set<PacDiagnosticoEvento> pacDiagnosticoEventos = new HashSet<>(0);
	private Set<CoreContrarreferencia> coreContrarreferencias = new HashSet<>(0);
	private Set<CoreReferencia> coreReferencias = new HashSet<>(0);
	private Set<Interconsulta> nomCatCie10ByCie10Id = new HashSet<>(0);
	private Set<CoreReferenciasExternas> coreReferenciasExternas = new HashSet<>(0);
	private Set<HspAltaMedica> hspAltaMedicasByCie10Id= new HashSet<>(0);

	@OneToMany(mappedBy = "nomCatCie10ByCie10Id") public Set<HspAltaMedica> getHspAltaMedicasByCie10Id() {
		return hspAltaMedicasByCie10Id;
	}

	public void setHspAltaMedicasByCie10Id(Set<HspAltaMedica> hspAltaMedicasByCie10Id) {
		this.hspAltaMedicasByCie10Id = hspAltaMedicasByCie10Id;
	}





	@Id
	@Column(name = "CIE_10_ID", unique = true, nullable = false, precision = 22)
	public Integer getCie10Id() {
		return this.cie10Id;
	}

	public void setCie10Id(Integer cie10Id) {
		this.cie10Id = cie10Id;
	}

	@Column(name = "ES_CAUSES", nullable = false, length = 10)
	public String getCauses() {	return this.causes;	}

	public void setCauses(String causes) {	this.causes = causes; }
	@Column(name = "ES_SUIVE_MORTA", nullable = false, length = 10)
	public String getSuive() { return this.suive; }

	public void setSuive(String suive) { this.suive = suive; }

	@Column(name = "LETRA", nullable = false, length = 1)
	public String getLetra() {
		return this.letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}


	@Column(name = "CLAVE", nullable = false, length = 4)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}


	@Column(name = "ASTERISCO", nullable = false, length = 1)
	public String getA() {
		return this.a;
	}

	public void setA(String a) {
		this.a = a;
	}


	@Column(name = "NOMBRE", nullable = false, length = 241)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name = "LSEX", precision = 22)
	public Integer getLsex() {
		return this.lsex;
	}

	public void setLsex(Integer lsex) {
		this.lsex = lsex;
	}


	@Column(name = "LINF", length = 4)
	public String getLinf() {
		return this.linf;
	}

	public void setLinf(String linf) {
		this.linf = linf;
	}


	@Column(name = "LSUP", length = 4)
	public String getLsup() {
		return this.lsup;
	}

	public void setLsup(String lsup) {
		this.lsup = lsup;
	}


	@Column(name = "TRIVIAL", nullable = false, length = 1)
	public String getTriv() {
		return this.triv;
	}

	public void setTriv(String triv) {
		this.triv = triv;
	}


	@Column(name = "ERRADICADO", length = 1)
	public String getErrad() {
		return this.errad;
	}

	public void setErrad(String errad) {
		this.errad = errad;
	}


	@Column(name = "N_INTER", length = 1)
	public String getNInter() {
		return this.NInter;
	}

	public void setNInter(String NInter) {
		this.NInter = NInter;
	}


	@Column(name = "NIN", nullable = false, length = 1)
	public String getNin() {
		return this.nin;
	}

	public void setNin(String nin) {
		this.nin = nin;
	}


	@Column(name = "NINMTOBS", length = 1)
	public String getNinmtobs() {
		return this.ninmtobs;
	}

	public void setNinmtobs(String ninmtobs) {
		this.ninmtobs = ninmtobs;
	}


	@Column(name = "NO_CBD", nullable = false, length = 1)
	public String getNoCbd() {
		return this.noCbd;
	}

	public void setNoCbd(String noCbd) {
		this.noCbd = noCbd;
	}


	@Column(name = "NO_APH", nullable = false, length = 1)
	public String getNoAph() {
		return this.noAph;
	}

	public void setNoAph(String noAph) {
		this.noAph = noAph;
	}


	@Column(name = "FETAL", length = 1)
	public String getFetal() {
		return this.fetal;
	}

	public void setFetal(String fetal) {
		this.fetal = fetal;
	}


	@Column(name = "DIA_CAPITULO_TYPE", nullable = false, precision = 22)
	public Integer getCapitulo() {
		return this.capitulo;
	}

	public void setCapitulo(Integer capitulo) {
		this.capitulo = capitulo;
	}


	@Column(name = "LISTA1", precision = 22)
	public Integer getLista1() {
		return this.lista1;
	}

	public void setLista1(Integer lista1) {
		this.lista1 = lista1;
	}


//	@Column(name = "GRUPO1", precision = 22)
//	public Integer getGrupo1() {
//		return this.grupo1;
//	}
//
//	public void setGrupo1(Integer grupo1) {
//		this.grupo1 = grupo1;
//	}


	@Column(name = "LISTA5", precision = 22)
	public Integer getLista5() {
		return this.lista5;
	}

	public void setLista5(Integer lista5) {
		this.lista5 = lista5;
	}


//	@Column(name = "ACTUALIZACIONES_CIE_10", length = 4)
//	public String getActualizacionesCie10() {
//		return this.actualizacionesCie10;
//	}
//
//	public void setActualizacionesCie10(String actualizacionesCie10) {
//		this.actualizacionesCie10 = actualizacionesCie10;
//	}


	@Column(name = "YEAR_MODIFI", length = 119)
	public String getYearModifi() {
		return this.yearModifi;
	}

	public void setYearModifi(String yearModifi) {
		this.yearModifi = yearModifi;
	}


	@Column(name = "YEAR_APLICACION", nullable = false, precision = 22)
	public String getYearAplicacion() {
		return this.yearAplicacion;
	}

	public void setYearAplicacion(String yearAplicacion) {
		this.yearAplicacion = yearAplicacion;
	}


	@Column(name = "PRINMORTA", length = 4)
	public String getPrinmorta() {
		return this.prinmorta;
	}

	public void setPrinmorta(String prinmorta) {
		this.prinmorta = prinmorta;
	}


	@Column(name = "PRINMORBI", length = 4)
	public String getPrinmorbi() {
		return this.prinmorbi;
	}

	public void setPrinmorbi(String prinmorbi) {
		this.prinmorbi = prinmorbi;
	}


	@Column(name = "LM_MORBI", length = 4)
	public String getLmMorbi() {
		return this.lmMorbi;
	}

	public void setLmMorbi(String lmMorbi) {
		this.lmMorbi = lmMorbi;
	}


	@Column(name = "LM_MORTA", length = 4)
	public String getLmMorta() {
		return this.lmMorta;
	}

	public void setLmMorta(String lmMorta) {
		this.lmMorta = lmMorta;
	}


	@Column(name = "LGBD165", precision = 22)
	public Integer getLgbd165() {
		return this.lgbd165;
	}

	public void setLgbd165(Integer lgbd165) {
		this.lgbd165 = lgbd165;
	}


	@Column(name = "LOMSBECK", precision = 22)
	public Integer getLomsbeck() {
		return this.lomsbeck;
	}

	public void setLomsbeck(Integer lomsbeck) {
		this.lomsbeck = lomsbeck;
	}


	@Column(name = "LGBD190", precision = 22)
	public Integer getLgbd190() {
		return this.lgbd190;
	}

	public void setLgbd190(Integer lgbd190) {
		this.lgbd190 = lgbd190;
	}


	@Column(name = "NOTDIARIA", nullable = false, length = 1)
	public String getNotdiaria() {
		return this.notdiaria;
	}

	public void setNotdiaria(String notdiaria) {
		this.notdiaria = notdiaria;
	}


	@Column(name = "NOTSEMANAL", nullable = false, length = 1)
	public String getNotsemanal() {
		return this.notsemanal;
	}

	public void setNotsemanal(String notsemanal) {
		this.notsemanal = notsemanal;
	}


	@Column(name = "SISTEMA_ESPECIAL", nullable = false, length = 1)
	public String getSistemaEspecial() {
		return this.sistemaEspecial;
	}

	public void setSistemaEspecial(String sistemaEspecial) {
		this.sistemaEspecial = sistemaEspecial;
	}


	@Column(name = "BIRMM", nullable = false, length = 1)
	public String getBirmm() {
		return this.birmm;
	}

	public void setBirmm(String birmm) {
		this.birmm = birmm;
	}


//	public void setPocoUtil(Integer pocoUtil) {
//		this.pocoUtil = pocoUtil;
//	}
//
//	@Column(name = "POCO_UTIL", nullable = false, precision = 22)
//	public Integer getPocoUtil() {
//		return this.pocoUtil;
//	}


	@Column(name = "EPI_MORTA", nullable = false, length = 1)
	public String getEpiMorta() {
		return this.epiMorta;
	}

	public void setEpiMorta(String epiMorta) {
		this.epiMorta = epiMorta;
	}


	@Column(name = "EPI_MORTA_M5", nullable = false, length = 1)
	public String getEpiMortaM5() {
		return this.epiMortaM5;
	}

	public void setEpiMortaM5(String epiMortaM5) {
		this.epiMortaM5 = epiMortaM5;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatCie10")
	public Set<PacDiagnosticoEvento> getPacDiagnosticoEventos() {
		return pacDiagnosticoEventos;
	}

	public void setPacDiagnosticoEventos(Set<PacDiagnosticoEvento> pacDiagnosticoEventos) {
		this.pacDiagnosticoEventos = pacDiagnosticoEventos;
	}


	@Basic
	@Column(name = "EDAD_MIN")
	public Integer getEdadMin() {
		return edadMin;
	}

	public void setEdadMin(Integer edadMin) {
		this.edadMin = edadMin;
	}

	@Basic
	@Column(name = "EDAD_MAX")
	public Integer getEdadMax() {
		return edadMax;
	}

	public void setEdadMax(Integer edadMax) {
		this.edadMax = edadMax;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatCie10")
	public Set<CoreContrarreferencia> getCoreContrarreferencias() {
		return coreContrarreferencias;
	}

	public void setCoreContrarreferencias(Set<CoreContrarreferencia> coreContrarreferencias) {
		this.coreContrarreferencias = coreContrarreferencias;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatCie10")
	public Set<CoreReferencia> getCoreReferencias() {
		return coreReferencias;
	}

	public void setCoreReferencias(Set<CoreReferencia> coreReferencias) {
		this.coreReferencias = coreReferencias;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nomCatCie10")
	public Set<CoreReferenciasExternas> getCoreReferenciasExternas() {
		return coreReferenciasExternas;
	}

	public void setCoreReferenciasExternas(Set<CoreReferenciasExternas> coreReferenciasExternas) {
		this.coreReferenciasExternas = coreReferenciasExternas;
	}


	@OneToMany(mappedBy = "nomCatCie10ByCie10Id")
	public Set<Interconsulta> getInterconsultasByCie10Id() {
		return nomCatCie10ByCie10Id;
	}

	public void setInterconsultasByCie10Id(Set<Interconsulta> interconsultasByCie10Id) {
		this.nomCatCie10ByCie10Id = nomCatCie10ByCie10Id;
	}
}