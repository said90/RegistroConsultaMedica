/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.controller;

import com.appconsultas.EJB.EspecialistaFacadeLocal;
import com.appconsultas.model.Especialista;
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
public class EspecialistasController implements Serializable {

    private Especialista especialista;
    private List<Especialista> lstEspecialistas;
    @EJB
    private EspecialistaFacadeLocal especialistaEJB;

    @PostConstruct
    public void init() {
        especialista = new Especialista();
        lstEspecialistas = especialistaEJB.findAll();
    }

    public void registrarEspecialista() {
        try {
            especialistaEJB.create(especialista);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Especialista de salud registrado con exito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }
    }

    public void modificarEspecialista() {

        try {
            especialistaEJB.edit(especialista);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Especialista de salud modificado con exito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }
    }

    public void eliminarEspecialista() {

        try {
            especialistaEJB.remove(especialista);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Especialista de salud eliminado con exito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public List<Especialista> getLstEspecialistas() {
        return lstEspecialistas;
    }

    public void setLstEspecialistas(List<Especialista> lstEspecialistas) {
        this.lstEspecialistas = lstEspecialistas;
    }

}
