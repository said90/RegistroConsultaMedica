/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.controller;

import com.appconsultas.EJB.TipoUsuarioFacadeLocal;
import com.appconsultas.model.TipoUsuario;
import com.appconsultas.model.Usuario;
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
public class TipoUsuarioController implements Serializable {

    private TipoUsuario tipoUsuario;
    private List<Usuario> usuarios;
    private List<TipoUsuario> tiposUsuarios;

    @EJB
    private TipoUsuarioFacadeLocal tipoUsuarioEJB;
    @EJB

    @PostConstruct
    public void init() {
        tipoUsuario = new TipoUsuario();

        tiposUsuarios = tipoUsuarioEJB.findAll();
    }

    

    public void registrarTipoUsuario() {
        try {
            tipoUsuarioEJB.create(tipoUsuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Tipo de Usuario registrado con éxito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }

    }

    public void modificarTipoUsuario() {
        try {
            tipoUsuarioEJB.edit(tipoUsuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Tipo de Usuario modificado con éxito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }

    }

    public void eliminarTipoUsuario() {
        try {
            tipoUsuarioEJB.remove(tipoUsuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Tipo de Usuario modificado con éxito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }

    }

   

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<TipoUsuario> getTiposUsuarios() {
        return tiposUsuarios;
    }

    public void setTiposUsuarios(List<TipoUsuario> tiposUsuarios) {
        this.tiposUsuarios = tiposUsuarios;
    }

   

}
