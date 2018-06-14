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
@Table(name = "resultado_lab_clinico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultadoLabClinico.findAll", query = "SELECT r FROM ResultadoLabClinico r")
    , @NamedQuery(name = "ResultadoLabClinico.findByIdResultadosLabClinico", query = "SELECT r FROM ResultadoLabClinico r WHERE r.idResultadosLabClinico = :idResultadosLabClinico")
    , @NamedQuery(name = "ResultadoLabClinico.findByResultado", query = "SELECT r FROM ResultadoLabClinico r WHERE r.resultado = :resultado")})
public class ResultadoLabClinico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_resultados_lab_clinico")
    private Integer idResultadosLabClinico;
    @Size(max = 45)
    @Column(name = "resultado")
    private String resultado;
    @JoinColumn(name = "id_examen_clinico_indicado", referencedColumnName = "id_examen_clinico_indicado")
    @ManyToOne(optional = false)
    private ExamenClinicoIndicado idExamenClinicoIndicado;

    public ResultadoLabClinico() {
    }

    public ResultadoLabClinico(Integer idResultadosLabClinico) {
        this.idResultadosLabClinico = idResultadosLabClinico;
    }

    public Integer getIdResultadosLabClinico() {
        return idResultadosLabClinico;
    }

    public void setIdResultadosLabClinico(Integer idResultadosLabClinico) {
        this.idResultadosLabClinico = idResultadosLabClinico;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public ExamenClinicoIndicado getIdExamenClinicoIndicado() {
        return idExamenClinicoIndicado;
    }

    public void setIdExamenClinicoIndicado(ExamenClinicoIndicado idExamenClinicoIndicado) {
        this.idExamenClinicoIndicado = idExamenClinicoIndicado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultadosLabClinico != null ? idResultadosLabClinico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultadoLabClinico)) {
            return false;
        }
        ResultadoLabClinico other = (ResultadoLabClinico) object;
        if ((this.idResultadosLabClinico == null && other.idResultadosLabClinico != null) || (this.idResultadosLabClinico != null && !this.idResultadosLabClinico.equals(other.idResultadosLabClinico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.ResultadoLabClinico[ idResultadosLabClinico=" + idResultadosLabClinico + " ]";
    }
    
}
