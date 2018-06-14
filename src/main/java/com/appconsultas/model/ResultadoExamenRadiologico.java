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
@Table(name = "resultado_examen_radiologico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultadoExamenRadiologico.findAll", query = "SELECT r FROM ResultadoExamenRadiologico r")
    , @NamedQuery(name = "ResultadoExamenRadiologico.findByIdResultadoExamenRadiologico", query = "SELECT r FROM ResultadoExamenRadiologico r WHERE r.idResultadoExamenRadiologico = :idResultadoExamenRadiologico")
    , @NamedQuery(name = "ResultadoExamenRadiologico.findByResultado", query = "SELECT r FROM ResultadoExamenRadiologico r WHERE r.resultado = :resultado")})
public class ResultadoExamenRadiologico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_resultado_examen_radiologico")
    private Integer idResultadoExamenRadiologico;
    @Size(max = 45)
    @Column(name = "resultado")
    private String resultado;
    @JoinColumn(name = "id_examen_radiologico_indicados", referencedColumnName = "id_examen_radiologico_indicados")
    @ManyToOne(optional = false)
    private ExamenRadiologicoIndicado idExamenRadiologicoIndicados;

    public ResultadoExamenRadiologico() {
    }

    public ResultadoExamenRadiologico(Integer idResultadoExamenRadiologico) {
        this.idResultadoExamenRadiologico = idResultadoExamenRadiologico;
    }

    public Integer getIdResultadoExamenRadiologico() {
        return idResultadoExamenRadiologico;
    }

    public void setIdResultadoExamenRadiologico(Integer idResultadoExamenRadiologico) {
        this.idResultadoExamenRadiologico = idResultadoExamenRadiologico;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public ExamenRadiologicoIndicado getIdExamenRadiologicoIndicados() {
        return idExamenRadiologicoIndicados;
    }

    public void setIdExamenRadiologicoIndicados(ExamenRadiologicoIndicado idExamenRadiologicoIndicados) {
        this.idExamenRadiologicoIndicados = idExamenRadiologicoIndicados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultadoExamenRadiologico != null ? idResultadoExamenRadiologico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultadoExamenRadiologico)) {
            return false;
        }
        ResultadoExamenRadiologico other = (ResultadoExamenRadiologico) object;
        if ((this.idResultadoExamenRadiologico == null && other.idResultadoExamenRadiologico != null) || (this.idResultadoExamenRadiologico != null && !this.idResultadoExamenRadiologico.equals(other.idResultadoExamenRadiologico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.ResultadoExamenRadiologico[ idResultadoExamenRadiologico=" + idResultadoExamenRadiologico + " ]";
    }
    
}
