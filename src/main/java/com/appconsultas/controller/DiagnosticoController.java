/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.controller;

import com.appconsultas.EJB.DiagnosticoFacadeLocal;
import com.appconsultas.model.Diagnostico;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bsf_o
 */
@ViewScoped
@Named
public class DiagnosticoController implements Serializable {

    private Diagnostico diagnostico;
    private List<Diagnostico> lstDiagnosticos;
    @EJB
    private DiagnosticoFacadeLocal diagnosticoEJB;

    @PostConstruct
    public void init() {
        diagnostico = new Diagnostico();
        lstDiagnosticos = diagnosticoEJB.findAll();
    }

    public void registrarDiagnostico() {
        try {
            diagnosticoEJB.create(diagnostico);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Diagnostico registrado con exito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }
    }

    public void modificarDiagnostico() {
        try {
            diagnosticoEJB.edit(diagnostico);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Diagnostico modificado con exito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }
    }

    public void eliminarDiagnostico() {
        try {
            diagnosticoEJB.remove(diagnostico);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Diagnostico eliminado con exito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public List<Diagnostico> getLstDiagnosticos() {
        return lstDiagnosticos;
    }

    public void setLstDiagnosticos(List<Diagnostico> lstDiagnosticos) {
        this.lstDiagnosticos = lstDiagnosticos;
    }

}
