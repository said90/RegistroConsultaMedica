/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bsf_o
 */
@Entity
@Table(name = "episodio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Episodio.findAll", query = "SELECT e FROM Episodio e")
    , @NamedQuery(name = "Episodio.findByIdEpisodio", query = "SELECT e FROM Episodio e WHERE e.idEpisodio = :idEpisodio")
    , @NamedQuery(name = "Episodio.findByFechaConsulta", query = "SELECT e FROM Episodio e WHERE e.fechaConsulta = :fechaConsulta")
    , @NamedQuery(name = "Episodio.findByActividadPrimaria", query = "SELECT e FROM Episodio e WHERE e.actividadPrimaria = :actividadPrimaria")
    , @NamedQuery(name = "Episodio.findByTipoConsultaPrimaria", query = "SELECT e FROM Episodio e WHERE e.tipoConsultaPrimaria = :tipoConsultaPrimaria")
    , @NamedQuery(name = "Episodio.findByActividadSecundaria", query = "SELECT e FROM Episodio e WHERE e.actividadSecundaria = :actividadSecundaria")
    , @NamedQuery(name = "Episodio.findByTipoActividadSecundaria", query = "SELECT e FROM Episodio e WHERE e.tipoActividadSecundaria = :tipoActividadSecundaria")
    , @NamedQuery(name = "Episodio.findByTemperatura", query = "SELECT e FROM Episodio e WHERE e.temperatura = :temperatura")
    , @NamedQuery(name = "Episodio.findByFrecuenciaCardiaca", query = "SELECT e FROM Episodio e WHERE e.frecuenciaCardiaca = :frecuenciaCardiaca")
    , @NamedQuery(name = "Episodio.findByFrecuenciaRespiratoria", query = "SELECT e FROM Episodio e WHERE e.frecuenciaRespiratoria = :frecuenciaRespiratoria")
    , @NamedQuery(name = "Episodio.findByPArterialSistolica", query = "SELECT e FROM Episodio e WHERE e.pArterialSistolica = :pArterialSistolica")
    , @NamedQuery(name = "Episodio.findByPArterialDiastolica", query = "SELECT e FROM Episodio e WHERE e.pArterialDiastolica = :pArterialDiastolica")
    , @NamedQuery(name = "Episodio.findByPeso", query = "SELECT e FROM Episodio e WHERE e.peso = :peso")
    , @NamedQuery(name = "Episodio.findByTalla", query = "SELECT e FROM Episodio e WHERE e.talla = :talla")
    , @NamedQuery(name = "Episodio.findByImc", query = "SELECT e FROM Episodio e WHERE e.imc = :imc")
    , @NamedQuery(name = "Episodio.findByDiagnosticosEncontrados", query = "SELECT e FROM Episodio e WHERE e.diagnosticosEncontrados = :diagnosticosEncontrados")
    , @NamedQuery(name = "Episodio.findByMedicamentosIndicados", query = "SELECT e FROM Episodio e WHERE e.medicamentosIndicados = :medicamentosIndicados")
    , @NamedQuery(name = "Episodio.findByExamenesClinicosIndicados", query = "SELECT e FROM Episodio e WHERE e.examenesClinicosIndicados = :examenesClinicosIndicados")
    , @NamedQuery(name = "Episodio.findByExamenesRadiologicosIndicados", query = "SELECT e FROM Episodio e WHERE e.examenesRadiologicosIndicados = :examenesRadiologicosIndicados")
    , @NamedQuery(name = "Episodio.findByNumeroReferencias", query = "SELECT e FROM Episodio e WHERE e.numeroReferencias = :numeroReferencias")
    , @NamedQuery(name = "Episodio.findBySubjetivo", query = "SELECT e FROM Episodio e WHERE e.subjetivo = :subjetivo")
    , @NamedQuery(name = "Episodio.findByObjetivo", query = "SELECT e FROM Episodio e WHERE e.objetivo = :objetivo")
    , @NamedQuery(name = "Episodio.findByAnalisis", query = "SELECT e FROM Episodio e WHERE e.analisis = :analisis")
    , @NamedQuery(name = "Episodio.findByPlan", query = "SELECT e FROM Episodio e WHERE e.plan = :plan")
    , @NamedQuery(name = "Episodio.findByAntecedentes", query = "SELECT e FROM Episodio e WHERE e.antecedentes = :antecedentes")})
public class Episodio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_episodio")
    private Integer idEpisodio;
    @Column(name = "fecha_consulta")
    @Temporal(TemporalType.DATE)
    private Date fechaConsulta;
    @Size(max = 45)
    @Column(name = "actividad_primaria")
    private String actividadPrimaria;
    @Size(max = 45)
    @Column(name = "tipo_consulta_primaria")
    private String tipoConsultaPrimaria;
    @Size(max = 45)
    @Column(name = "actividad_secundaria")
    private String actividadSecundaria;
    @Size(max = 45)
    @Column(name = "tipo_actividad_secundaria")
    private String tipoActividadSecundaria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "temperatura")
    private Float temperatura;
    @Column(name = "frecuencia_cardiaca")
    private Float frecuenciaCardiaca;
    @Column(name = "frecuencia_respiratoria")
    private Float frecuenciaRespiratoria;
    @Column(name = "p_arterial_sistolica")
    private Float pArterialSistolica;
    @Column(name = "p_arterial_diastolica")
    private Float pArterialDiastolica;
    @Column(name = "peso")
    private Float peso;
    @Column(name = "talla")
    private Float talla;
    @Column(name = "imc")
    private Float imc;
    @Column(name = "diagnosticos_encontrados")
    private Integer diagnosticosEncontrados;
    @Column(name = "medicamentos_indicados")
    private Integer medicamentosIndicados;
    @Column(name = "examenes_clinicos_indicados")
    private Integer examenesClinicosIndicados;
    @Column(name = "examenes_radiologicos_indicados")
    private Integer examenesRadiologicosIndicados;
    @Column(name = "numero_referencias")
    private Integer numeroReferencias;
    @Size(max = 255)
    @Column(name = "subjetivo")
    private String subjetivo;
    @Size(max = 255)
    @Column(name = "objetivo")
    private String objetivo;
    @Size(max = 255)
    @Column(name = "analisis")
    private String analisis;
    @Size(max = 255)
    @Column(name = "plan")
    private String plan;
    @Size(max = 300)
    @Column(name = "antecedentes")
    private String antecedentes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEpisodio")
    private List<Incapacidad> incapacidadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEpisodio")
    private List<MedicamentosIndicados> medicamentosIndicadosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEpisodio")
    private List<DiagnosticoEncontrado> diagnosticoEncontradoList;
    @JoinColumn(name = "id_agenda", referencedColumnName = "id_agenda")
    @ManyToOne()
    private Agenda idAgenda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEpisodio")
    private List<ExamenRadiologicoIndicado> examenRadiologicoIndicadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEpisodio")
    private List<ExamenClinicoIndicado> examenClinicoIndicadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEpisodio")
    private List<Referencia> referenciaList;

    public Episodio() {
    }

    public Episodio(Integer idEpisodio) {
        this.idEpisodio = idEpisodio;
    }

    public Integer getIdEpisodio() {
        return idEpisodio;
    }

    public void setIdEpisodio(Integer idEpisodio) {
        this.idEpisodio = idEpisodio;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getActividadPrimaria() {
        return actividadPrimaria;
    }

    public void setActividadPrimaria(String actividadPrimaria) {
        this.actividadPrimaria = actividadPrimaria;
    }

    public String getTipoConsultaPrimaria() {
        return tipoConsultaPrimaria;
    }

    public void setTipoConsultaPrimaria(String tipoConsultaPrimaria) {
        this.tipoConsultaPrimaria = tipoConsultaPrimaria;
    }

    public String getActividadSecundaria() {
        return actividadSecundaria;
    }

    public void setActividadSecundaria(String actividadSecundaria) {
        this.actividadSecundaria = actividadSecundaria;
    }

    public String getTipoActividadSecundaria() {
        return tipoActividadSecundaria;
    }

    public void setTipoActividadSecundaria(String tipoActividadSecundaria) {
        this.tipoActividadSecundaria = tipoActividadSecundaria;
    }

    public Float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Float temperatura) {
        this.temperatura = temperatura;
    }

    public Float getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(Float frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public Float getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(Float frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public Float getPArterialSistolica() {
        return pArterialSistolica;
    }

    public void setPArterialSistolica(Float pArterialSistolica) {
        this.pArterialSistolica = pArterialSistolica;
    }

    public Float getPArterialDiastolica() {
        return pArterialDiastolica;
    }

    public void setPArterialDiastolica(Float pArterialDiastolica) {
        this.pArterialDiastolica = pArterialDiastolica;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getTalla() {
        return talla;
    }

    public void setTalla(Float talla) {
        this.talla = talla;
    }

    public Float getImc() {
        return imc;
    }

    public void setImc(Float imc) {
        this.imc = imc;
    }

    public Integer getDiagnosticosEncontrados() {
        return diagnosticosEncontrados;
    }

    public void setDiagnosticosEncontrados(Integer diagnosticosEncontrados) {
        this.diagnosticosEncontrados = diagnosticosEncontrados;
    }

    public Integer getMedicamentosIndicados() {
        return medicamentosIndicados;
    }

    public void setMedicamentosIndicados(Integer medicamentosIndicados) {
        this.medicamentosIndicados = medicamentosIndicados;
    }

    public Integer getExamenesClinicosIndicados() {
        return examenesClinicosIndicados;
    }

    public void setExamenesClinicosIndicados(Integer examenesClinicosIndicados) {
        this.examenesClinicosIndicados = examenesClinicosIndicados;
    }

    public Integer getExamenesRadiologicosIndicados() {
        return examenesRadiologicosIndicados;
    }

    public void setExamenesRadiologicosIndicados(Integer examenesRadiologicosIndicados) {
        this.examenesRadiologicosIndicados = examenesRadiologicosIndicados;
    }

    public Integer getNumeroReferencias() {
        return numeroReferencias;
    }

    public void setNumeroReferencias(Integer numeroReferencias) {
        this.numeroReferencias = numeroReferencias;
    }

    public String getSubjetivo() {
        return subjetivo;
    }

    public void setSubjetivo(String subjetivo) {
        this.subjetivo = subjetivo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getAnalisis() {
        return analisis;
    }

    public void setAnalisis(String analisis) {
        this.analisis = analisis;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    @XmlTransient
    public List<Incapacidad> getIncapacidadList() {
        return incapacidadList;
    }

    public void setIncapacidadList(List<Incapacidad> incapacidadList) {
        this.incapacidadList = incapacidadList;
    }

    @XmlTransient
    public List<MedicamentosIndicados> getMedicamentosIndicadosList() {
        return medicamentosIndicadosList;
    }

    public void setMedicamentosIndicadosList(List<MedicamentosIndicados> medicamentosIndicadosList) {
        this.medicamentosIndicadosList = medicamentosIndicadosList;
    }

    @XmlTransient
    public List<DiagnosticoEncontrado> getDiagnosticoEncontradoList() {
        return diagnosticoEncontradoList;
    }

    public void setDiagnosticoEncontradoList(List<DiagnosticoEncontrado> diagnosticoEncontradoList) {
        this.diagnosticoEncontradoList = diagnosticoEncontradoList;
    }

    public Agenda getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Agenda idAgenda) {
        this.idAgenda = idAgenda;
    }

    @XmlTransient
    public List<ExamenRadiologicoIndicado> getExamenRadiologicoIndicadoList() {
        return examenRadiologicoIndicadoList;
    }

    public void setExamenRadiologicoIndicadoList(List<ExamenRadiologicoIndicado> examenRadiologicoIndicadoList) {
        this.examenRadiologicoIndicadoList = examenRadiologicoIndicadoList;
    }

    @XmlTransient
    public List<ExamenClinicoIndicado> getExamenClinicoIndicadoList() {
        return examenClinicoIndicadoList;
    }

    public void setExamenClinicoIndicadoList(List<ExamenClinicoIndicado> examenClinicoIndicadoList) {
        this.examenClinicoIndicadoList = examenClinicoIndicadoList;
    }

    @XmlTransient
    public List<Referencia> getReferenciaList() {
        return referenciaList;
    }

    public void setReferenciaList(List<Referencia> referenciaList) {
        this.referenciaList = referenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEpisodio != null ? idEpisodio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Episodio)) {
            return false;
        }
        Episodio other = (Episodio) object;
        if ((this.idEpisodio == null && other.idEpisodio != null) || (this.idEpisodio != null && !this.idEpisodio.equals(other.idEpisodio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.Episodio[ idEpisodio=" + idEpisodio + " ]";
    }
    
}
