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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bsf_o
 */
@Entity
@Table(name = "diagnostico_encontrado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagnosticoEncontrado.findAll", query = "SELECT d FROM DiagnosticoEncontrado d")
    , @NamedQuery(name = "DiagnosticoEncontrado.findByIdDiagnosticoEncontrado", query = "SELECT d FROM DiagnosticoEncontrado d WHERE d.idDiagnosticoEncontrado = :idDiagnosticoEncontrado")
    , @NamedQuery(name = "DiagnosticoEncontrado.findByEstado", query = "SELECT d FROM DiagnosticoEncontrado d WHERE d.estado = :estado")})
public class DiagnosticoEncontrado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diagnostico_encontrado")
    private Integer idDiagnosticoEncontrado;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_diagnostico", referencedColumnName = "id_diagnostico")
    @ManyToOne()
    private Diagnostico idDiagnostico;
    @JoinColumn(name = "id_episodio", referencedColumnName = "id_episodio")
    @ManyToOne()
    private Episodio idEpisodio;

    public DiagnosticoEncontrado() {
    }

    public DiagnosticoEncontrado(Integer idDiagnosticoEncontrado) {
        this.idDiagnosticoEncontrado = idDiagnosticoEncontrado;
    }

    public Integer getIdDiagnosticoEncontrado() {
        return idDiagnosticoEncontrado;
    }

    public void setIdDiagnosticoEncontrado(Integer idDiagnosticoEncontrado) {
        this.idDiagnosticoEncontrado = idDiagnosticoEncontrado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Diagnostico getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Diagnostico idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
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
        hash += (idDiagnosticoEncontrado != null ? idDiagnosticoEncontrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnosticoEncontrado)) {
            return false;
        }
        DiagnosticoEncontrado other = (DiagnosticoEncontrado) object;
        if ((this.idDiagnosticoEncontrado == null && other.idDiagnosticoEncontrado != null) || (this.idDiagnosticoEncontrado != null && !this.idDiagnosticoEncontrado.equals(other.idDiagnosticoEncontrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.DiagnosticoEncontrado[ idDiagnosticoEncontrado=" + idDiagnosticoEncontrado + " ]";
    }
    
}
