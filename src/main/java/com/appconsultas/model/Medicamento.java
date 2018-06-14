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
@Table(name = "medicamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m")
    , @NamedQuery(name = "Medicamento.findByIdMedicamento", query = "SELECT m FROM Medicamento m WHERE m.idMedicamento = :idMedicamento")
    , @NamedQuery(name = "Medicamento.findByNombreComercial", query = "SELECT m FROM Medicamento m WHERE m.nombreComercial = :nombreComercial")
    , @NamedQuery(name = "Medicamento.findByNombreGenerico", query = "SELECT m FROM Medicamento m WHERE m.nombreGenerico = :nombreGenerico")
    , @NamedQuery(name = "Medicamento.findByComposicion", query = "SELECT m FROM Medicamento m WHERE m.composicion = :composicion")
    , @NamedQuery(name = "Medicamento.findByPresentacion", query = "SELECT m FROM Medicamento m WHERE m.presentacion = :presentacion")})
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medicamento")
    private Integer idMedicamento;
    @Size(max = 45)
    @Column(name = "nombre_comercial")
    private String nombreComercial;
    @Size(max = 45)
    @Column(name = "nombre_generico")
    private String nombreGenerico;
    @Size(max = 45)
    @Column(name = "composicion")
    private String composicion;
    @Size(max = 45)
    @Column(name = "presentacion")
    private String presentacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedicamento")
    private List<MedicamentosIndicados> medicamentosIndicadosList;

    public Medicamento() {
    }

    public Medicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Integer getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNombreGenerico() {
        return nombreGenerico;
    }

    public void setNombreGenerico(String nombreGenerico) {
        this.nombreGenerico = nombreGenerico;
    }

    public String getComposicion() {
        return composicion;
    }

    public void setComposicion(String composicion) {
        this.composicion = composicion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    @XmlTransient
    public List<MedicamentosIndicados> getMedicamentosIndicadosList() {
        return medicamentosIndicadosList;
    }

    public void setMedicamentosIndicadosList(List<MedicamentosIndicados> medicamentosIndicadosList) {
        this.medicamentosIndicadosList = medicamentosIndicadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicamento != null ? idMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.idMedicamento == null && other.idMedicamento != null) || (this.idMedicamento != null && !this.idMedicamento.equals(other.idMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appconsultas.model.Medicamento[ idMedicamento=" + idMedicamento + " ]";
    }
    
}
