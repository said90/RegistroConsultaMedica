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
@Table(name = "medicamentos_indicados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedicamentosIndicados.findAll", query = "SELECT m FROM MedicamentosIndicados m")
    , @NamedQuery(name = "MedicamentosIndicados.findByIdMedicamentosIndicados", query = "SELECT m FROM MedicamentosIndicados m WHERE m.idMedicamentosIndicados = :idMedicamentosIndicados")
    , @NamedQuery(name = "MedicamentosIndicados.findByCantidad", query = "SELECT m FROM MedicamentosIndicados m WHERE m.cantidad = :cantidad")
    , @NamedQuery(name = "MedicamentosIndicados.findByDosis", query = "SELECT m FROM MedicamentosIndicados m WHERE m.dosis = :dosis")})
public class MedicamentosIndicados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medicamentos_indicados")
    private Integer idMedicamentosIndicados;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private Float cantidad;
    @Size(max = 45)
    @Column(name = "dosis")
    private String dosis;
    @JoinColumn(name = "id_episodio", referencedColumnName = "id_episodio")
    @ManyToOne(optional = false)
    private Episodio idEpisodio;
    @JoinColumn(name = "id_medicamento", referencedColumnName = "id_medicamento")
    @ManyToOne(optional = false)
    private Medicamento idMedicamento;

    public MedicamentosIndicados() {
    }

    public MedicamentosIndicados(Integer idMedicamentosIndicados) {
        this.idMedicamentosIndicados = idMedicamentosIndicados;
    }

    public Integer getIdMedicamentosIndicados() {
        return idMedicamentosIndicados;
    }

    public void setIdMedicamentosIndicados(Integer idMedicamentosIndicados) {
        this.idMedicamentosIndicados = idMedicamentosIndicados;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public Episodio getIdEpisodio() {
        return idEpisodio;
    }

    public void setIdEpisodio(Episodio idEpisodio) {
        this.idEpisodio = idEpisodio;
    }

    public Medicamento getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Medicamento idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicamentosIndicados != null ? idMedicamentosIndicados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicamentosIndicados)) {
            return false;
        }
        MedicamentosIndicados other = (MedicamentosIndicados) object;
        if ((this.idMedicamentosIndicados == null && other.idMedicamentosIndicados != null) || (this.idMedicamentosIndicados != null && !this.idMedicamentosIndicados.equals(other.idMedicamentosIndicados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.MedicamentosIndicados[ idMedicamentosIndicados=" + idMedicamentosIndicados + " ]";
    }
    
}
