/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.controller;

import com.appconsultas.EJB.ExamenRadiologicoFacadeLocal;
import com.appconsultas.model.ExamenRadiologico;
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
public class ExamenRadiologicoController implements Serializable {

    private ExamenRadiologico examenRadiologico;
    private List<ExamenRadiologico> lstExamenesRadiologicos;
    
    @EJB
    private ExamenRadiologicoFacadeLocal examenRadiologicoEJB;

    @PostConstruct
    public void init() {
        examenRadiologico = new ExamenRadiologico();
        lstExamenesRadiologicos = examenRadiologicoEJB.findAll();
    }

    public void registrarExamenRadiologico() {
        try {
            examenRadiologicoEJB.create(examenRadiologico);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Examen Radiologico registrado con exito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }
    }

    public void modificarExamenRadiologico() {
        try {
            examenRadiologicoEJB.edit(examenRadiologico);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Examen Radiologico modificado con exito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }
    }

    public void eliminarExamenRadiologico() {
        try {
            examenRadiologicoEJB.remove(examenRadiologico);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Examen Radiologico eliminado con exito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }
    }

    public ExamenRadiologico getExamenRadiologico() {
        return examenRadiologico;
    }

    public void setExamenRadiologico(ExamenRadiologico examenRadiologico) {
        this.examenRadiologico = examenRadiologico;
    }

    public List<ExamenRadiologico> getLstExamenesRadiologicos() {
        return lstExamenesRadiologicos;
    }

    public void setLstExamenesRadiologicos(List<ExamenRadiologico> lstExamenesRadiologicos) {
        this.lstExamenesRadiologicos = lstExamenesRadiologicos;
    }
    
    
}
