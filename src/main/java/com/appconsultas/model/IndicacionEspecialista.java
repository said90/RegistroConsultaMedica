/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bsf_o
 */
@Entity
@Table(name = "indicacion_especialista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IndicacionEspecialista.findAll", query = "SELECT i FROM IndicacionEspecialista i")
    , @NamedQuery(name = "IndicacionEspecialista.findByIdIndicacionEspecialista", query = "SELECT i FROM IndicacionEspecialista i WHERE i.idIndicacionEspecialista = :idIndicacionEspecialista")
    , @NamedQuery(name = "IndicacionEspecialista.findByIndicacion", query = "SELECT i FROM IndicacionEspecialista i WHERE i.indicacion = :indicacion")})
public class IndicacionEspecialista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_indicacion_especialista")
    private Integer idIndicacionEspecialista;
    @Size(max = 100)
    @Column(name = "indicacion")
    private String indicacion;
    @JoinColumn(name = "id_referencia", referencedColumnName = "id_referencia")
    @ManyToOne(optional = false)
    private Referencia idReferencia;

    public IndicacionEspecialista() {
    }

    public IndicacionEspecialista(Integer idIndicacionEspecialista) {
        this.idIndicacionEspecialista = idIndicacionEspecialista;
    }

    public Integer getIdIndicacionEspecialista() {
        return idIndicacionEspecialista;
    }

    public void setIdIndicacionEspecialista(Integer idIndicacionEspecialista) {
        this.idIndicacionEspecialista = idIndicacionEspecialista;
    }

    public String getIndicacion() {
        return indicacion;
    }

    public void setIndicacion(String indicacion) {
        this.indicacion = indicacion;
    }

    public Referencia getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(Referencia idReferencia) {
        this.idReferencia = idReferencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIndicacionEspecialista != null ? idIndicacionEspecialista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndicacionEspecialista)) {
            return false;
        }
        IndicacionEspecialista other = (IndicacionEspecialista) object;
        if ((this.idIndicacionEspecialista == null && other.idIndicacionEspecialista != null) || (this.idIndicacionEspecialista != null && !this.idIndicacionEspecialista.equals(other.idIndicacionEspecialista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.IndicacionEspecialista[ idIndicacionEspecialista=" + idIndicacionEspecialista + " ]";
    }
    
}
