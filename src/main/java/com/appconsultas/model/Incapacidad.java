/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bsf_o
 */
@Entity
@Table(name = "incapacidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incapacidad.findAll", query = "SELECT i FROM Incapacidad i")
    , @NamedQuery(name = "Incapacidad.findByIdIncapcidad", query = "SELECT i FROM Incapacidad i WHERE i.idIncapcidad = :idIncapcidad")
    , @NamedQuery(name = "Incapacidad.findByTipoIncapacidad", query = "SELECT i FROM Incapacidad i WHERE i.tipoIncapacidad = :tipoIncapacidad")
    , @NamedQuery(name = "Incapacidad.findByTipoRiesgoIncapacidad", query = "SELECT i FROM Incapacidad i WHERE i.tipoRiesgoIncapacidad = :tipoRiesgoIncapacidad")
    , @NamedQuery(name = "Incapacidad.findByDiasIncapacidad", query = "SELECT i FROM Incapacidad i WHERE i.diasIncapacidad = :diasIncapacidad")
    , @NamedQuery(name = "Incapacidad.findByFechaInicio", query = "SELECT i FROM Incapacidad i WHERE i.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Incapacidad.findByFechaFin", query = "SELECT i FROM Incapacidad i WHERE i.fechaFin = :fechaFin")
    , @NamedQuery(name = "Incapacidad.findByObservaciones", query = "SELECT i FROM Incapacidad i WHERE i.observaciones = :observaciones")})
public class Incapacidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_incapcidad")
    private Integer idIncapcidad;
    @Size(max = 45)
    @Column(name = "tipo_incapacidad")
    private String tipoIncapacidad;
    @Size(max = 45)
    @Column(name = "tipo_riesgo_incapacidad")
    private String tipoRiesgoIncapacidad;
    @Column(name = "dias_incapacidad")
    private Integer diasIncapacidad;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Size(max = 45)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_episodio", referencedColumnName = "id_episodio")
    @ManyToOne(optional = false)
    private Episodio idEpisodio;

    public Incapacidad() {
    }

    public Incapacidad(Integer idIncapcidad) {
        this.idIncapcidad = idIncapcidad;
    }

    public Integer getIdIncapcidad() {
        return idIncapcidad;
    }

    public void setIdIncapcidad(Integer idIncapcidad) {
        this.idIncapcidad = idIncapcidad;
    }

    public String getTipoIncapacidad() {
        return tipoIncapacidad;
    }

    public void setTipoIncapacidad(String tipoIncapacidad) {
        this.tipoIncapacidad = tipoIncapacidad;
    }

    public String getTipoRiesgoIncapacidad() {
        return tipoRiesgoIncapacidad;
    }

    public void setTipoRiesgoIncapacidad(String tipoRiesgoIncapacidad) {
        this.tipoRiesgoIncapacidad = tipoRiesgoIncapacidad;
    }

    public Integer getDiasIncapacidad() {
        return diasIncapacidad;
    }

    public void setDiasIncapacidad(Integer diasIncapacidad) {
        this.diasIncapacidad = diasIncapacidad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Episodio getIdEpisodio() {
        return idEpisodio;
    }

    public void setIdEpisodio(Episodio idEpisodio) {
        this.idEpisodio = idEpisodio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIncapcidad != null ? idIncapcidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incapacidad)) {
            return false;
        }
        Incapacidad other = (Incapacidad) object;
        if ((this.idIncapcidad == null && other.idIncapcidad != null) || (this.idIncapcidad != null && !this.idIncapcidad.equals(other.idIncapcidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.Incapacidad[ idIncapcidad=" + idIncapcidad + " ]";
    }
    
}
