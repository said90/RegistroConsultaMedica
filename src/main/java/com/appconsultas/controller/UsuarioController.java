/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.controller;

import com.appconsultas.EJB.PersonaFacadeLocal;
import com.appconsultas.EJB.TipoUsuarioFacadeLocal;
import com.appconsultas.EJB.UsuarioFacadeLocal;
import com.appconsultas.model.Persona;
import com.appconsultas.model.TipoUsuario;
import com.appconsultas.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bsf_o
 */
@Named
@ViewScoped
public class UsuarioController implements Serializable {

    private Usuario usuario;
    private Persona persona;
    private TipoUsuario tipoUsuario;
    private List<Usuario> usuarios;
    private List<TipoUsuario> tiposUsuarios;

    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    @EJB
    private PersonaFacadeLocal personaEJB;
    @EJB
    private TipoUsuarioFacadeLocal tipoUsuarioEJB;
    @EJB

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        persona = new Persona();
        usuarios = usuarioEJB.findAll();
        tiposUsuarios = tipoUsuarioEJB.findAll();
    }

    public void registarUsuario() {
        try {
            usuario.setIdPersona(persona);
            usuarioEJB.create(usuario);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registro exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", e.getMessage().concat(" Comuniquese con el administrador de la aplicación.")));
        }
    }

    public void modificarUsuario() {
        try {

            usuarioEJB.edit(usuario);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se midifico exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", e.getMessage().concat(" Comuniquese con el administrador de la aplicación.")));
        }
    }

    public void eliminarUsuario() {
        try {
            usuarioEJB.remove(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Usuario Eliminado con éxito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }
    }

    

    public String iniciarSesion() {
        String redireccion = null;

        try {
            Usuario us;
            us = usuarioEJB.iniciarSesion(usuario);

            if (us != null) {

                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                redireccion = "/plantilla.xhtml?faces-redirect=true";

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Las credenciales no coinciden."));

            }
        } catch (Exception e) {
        }

        return redireccion;
    }

    public void verificarSesion() {
        try {

            FacesContext contexto = FacesContext.getCurrentInstance();
            Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            if (us == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/login.xhtml?faces-redirect=true");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Usted no ha iniciado sesión"));

            }

        } catch (Exception e) {
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;

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
