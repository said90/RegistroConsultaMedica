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
@Table(name = "examen_lab_clinico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamenLabClinico.findAll", query = "SELECT e FROM ExamenLabClinico e")
    , @NamedQuery(name = "ExamenLabClinico.findByIdExamenLabClinico", query = "SELECT e FROM ExamenLabClinico e WHERE e.idExamenLabClinico = :idExamenLabClinico")
    , @NamedQuery(name = "ExamenLabClinico.findByDescripcion", query = "SELECT e FROM ExamenLabClinico e WHERE e.descripcion = :descripcion")})
public class ExamenLabClinico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_examen_lab_clinico")
    private Integer idExamenLabClinico;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExamenLabClinico")
    private List<ExamenClinicoIndicado> examenClinicoIndicadoList;

    public ExamenLabClinico() {
    }

    public ExamenLabClinico(Integer idExamenLabClinico) {
        this.idExamenLabClinico = idExamenLabClinico;
    }

    public Integer getIdExamenLabClinico() {
        return idExamenLabClinico;
    }

    public void setIdExamenLabClinico(Integer idExamenLabClinico) {
        this.idExamenLabClinico = idExamenLabClinico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<ExamenClinicoIndicado> getExamenClinicoIndicadoList() {
        return examenClinicoIndicadoList;
    }

    public void setExamenClinicoIndicadoList(List<ExamenClinicoIndicado> examenClinicoIndicadoList) {
        this.examenClinicoIndicadoList = examenClinicoIndicadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExamenLabClinico != null ? idExamenLabClinico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamenLabClinico)) {
            return false;
        }
        ExamenLabClinico other = (ExamenLabClinico) object;
        if ((this.idExamenLabClinico == null && other.idExamenLabClinico != null) || (this.idExamenLabClinico != null && !this.idExamenLabClinico.equals(other.idExamenLabClinico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.ExamenLabClinico[ idExamenLabClinico=" + idExamenLabClinico + " ]";
    }
    
}
