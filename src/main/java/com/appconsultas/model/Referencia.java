/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.model;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bsf_o
 */
@Entity
@Table(name = "referencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referencia.findAll", query = "SELECT r FROM Referencia r")
    , @NamedQuery(name = "Referencia.findByIdReferencia", query = "SELECT r FROM Referencia r WHERE r.idReferencia = :idReferencia")
    , @NamedQuery(name = "Referencia.findByMotivoReferencia", query = "SELECT r FROM Referencia r WHERE r.motivoReferencia = :motivoReferencia")})
public class Referencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_referencia")
    private Integer idReferencia;
    @Size(max = 45)
    @Column(name = "motivo_referencia")
    private String motivoReferencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReferencia")
    private List<IndicacionEspecialista> indicacionEspecialistaList;
    @JoinColumn(name = "id_episodio", referencedColumnName = "id_episodio")
    @ManyToOne(optional = false)
    private Episodio idEpisodio;
    @JoinColumn(name = "id_especialista", referencedColumnName = "id_especialista")
    @ManyToOne(optional = false)
    private Especialista idEspecialista;

    public Referencia() {
    }

    public Referencia(Integer idReferencia) {
        this.idReferencia = idReferencia;
    }

    public Integer getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(Integer idReferencia) {
        this.idReferencia = idReferencia;
    }

    public String getMotivoReferencia() {
        return motivoReferencia;
    }

    public void setMotivoReferencia(String motivoReferencia) {
        this.motivoReferencia = motivoReferencia;
    }

    @XmlTransient
    public List<IndicacionEspecialista> getIndicacionEspecialistaList() {
        return indicacionEspecialistaList;
    }

    public void setIndicacionEspecialistaList(List<IndicacionEspecialista> indicacionEspecialistaList) {
        this.indicacionEspecialistaList = indicacionEspecialistaList;
    }

    public Episodio getIdEpisodio() {
        return idEpisodio;
    }

    public void setIdEpisodio(Episodio idEpisodio) {
        this.idEpisodio = idEpisodio;
    }

    public Especialista getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(Especialista idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReferencia != null ? idReferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referencia)) {
            return false;
        }
        Referencia other = (Referencia) object;
        if ((this.idReferencia == null && other.idReferencia != null) || (this.idReferencia != null && !this.idReferencia.equals(other.idReferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.Referencia[ idReferencia=" + idReferencia + " ]";
    }
    
}
