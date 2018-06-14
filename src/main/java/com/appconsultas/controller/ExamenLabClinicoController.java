/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.controller;

import com.appconsultas.EJB.ExamenLabClinicoFacadeLocal;
import com.appconsultas.model.ExamenLabClinico;
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
public class ExamenLabClinicoController implements Serializable {

    private ExamenLabClinico examenLabClinico;
    private List<ExamenLabClinico> lstExamenesClinicos;
    @EJB
    private ExamenLabClinicoFacadeLocal examenLabClinicoEJB;

    @PostConstruct
    public void init() {
        examenLabClinico = new ExamenLabClinico();
        lstExamenesClinicos = examenLabClinicoEJB.findAll();
    }

    public void registrarExamenLabClinico() {
        try {
            examenLabClinicoEJB.create(examenLabClinico);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Examen de laboratorio clinico registrado con exito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }
    }

    public void modificarExamenLabClinico() {
        try {
            examenLabClinicoEJB.edit(examenLabClinico);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Examen de laboratorio clinico modificado con exito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }
    }

    public void eliminarExamenLabClinico() {
        try {
            examenLabClinicoEJB.remove(examenLabClinico);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Examen de laboratorio clinico eliminado con exito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }
    }

    public ExamenLabClinico getExamenLabClinico() {
        return examenLabClinico;
    }

    public void setExamenLabClinico(ExamenLabClinico examenLabClinico) {
        this.examenLabClinico = examenLabClinico;
    }

    public List<ExamenLabClinico> getLstExamenesClinicos() {
        return lstExamenesClinicos;
    }

    public void setLstExamenesClinicos(List<ExamenLabClinico> lstExamenesClinicos) {
        this.lstExamenesClinicos = lstExamenesClinicos;
    }

}
