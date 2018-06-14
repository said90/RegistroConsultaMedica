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
@Table(name = "examen_radiologico_indicado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamenRadiologicoIndicado.findAll", query = "SELECT e FROM ExamenRadiologicoIndicado e")
    , @NamedQuery(name = "ExamenRadiologicoIndicado.findByIdExamenRadiologicoIndicados", query = "SELECT e FROM ExamenRadiologicoIndicado e WHERE e.idExamenRadiologicoIndicados = :idExamenRadiologicoIndicados")
    , @NamedQuery(name = "ExamenRadiologicoIndicado.findByJustificacion", query = "SELECT e FROM ExamenRadiologicoIndicado e WHERE e.justificacion = :justificacion")})
public class ExamenRadiologicoIndicado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_examen_radiologico_indicados")
    private Integer idExamenRadiologicoIndicados;
    @Size(max = 45)
    @Column(name = "justificacion")
    private String justificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExamenRadiologicoIndicados")
    private List<ResultadoExamenRadiologico> resultadoExamenRadiologicoList;
    @JoinColumn(name = "id_episodio", referencedColumnName = "id_episodio")
    @ManyToOne(optional = false)
    private Episodio idEpisodio;
    @JoinColumn(name = "id_examen_radiologico", referencedColumnName = "id_examen_radiologico")
    @ManyToOne(optional = false)
    private ExamenRadiologico idExamenRadiologico;

    public ExamenRadiologicoIndicado() {
    }

    public ExamenRadiologicoIndicado(Integer idExamenRadiologicoIndicados) {
        this.idExamenRadiologicoIndicados = idExamenRadiologicoIndicados;
    }

    public Integer getIdExamenRadiologicoIndicados() {
        return idExamenRadiologicoIndicados;
    }

    public void setIdExamenRadiologicoIndicados(Integer idExamenRadiologicoIndicados) {
        this.idExamenRadiologicoIndicados = idExamenRadiologicoIndicados;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    @XmlTransient
    public List<ResultadoExamenRadiologico> getResultadoExamenRadiologicoList() {
        return resultadoExamenRadiologicoList;
    }

    public void setResultadoExamenRadiologicoList(List<ResultadoExamenRadiologico> resultadoExamenRadiologicoList) {
        this.resultadoExamenRadiologicoList = resultadoExamenRadiologicoList;
    }

    public Episodio getIdEpisodio() {
        return idEpisodio;
    }

    public void setIdEpisodio(Episodio idEpisodio) {
        this.idEpisodio = idEpisodio;
    }

    public ExamenRadiologico getIdExamenRadiologico() {
        return idExamenRadiologico;
    }

    public void setIdExamenRadiologico(ExamenRadiologico idExamenRadiologico) {
        this.idExamenRadiologico = idExamenRadiologico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExamenRadiologicoIndicados != null ? idExamenRadiologicoIndicados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamenRadiologicoIndicado)) {
            return false;
        }
        ExamenRadiologicoIndicado other = (ExamenRadiologicoIndicado) object;
        if ((this.idExamenRadiologicoIndicados == null && other.idExamenRadiologicoIndicados != null) || (this.idExamenRadiologicoIndicados != null && !this.idExamenRadiologicoIndicados.equals(other.idExamenRadiologicoIndicados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.ExamenRadiologicoIndicado[ idExamenRadiologicoIndicados=" + idExamenRadiologicoIndicados + " ]";
    }
    
}
