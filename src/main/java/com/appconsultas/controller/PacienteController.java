/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.controller;

import com.appconsultas.EJB.PacienteFacadeLocal;
import com.appconsultas.EJB.PersonaFacadeLocal;
import com.appconsultas.model.Paciente;
import com.appconsultas.model.Persona;
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
public class PacienteController implements Serializable {

    private Persona persona;
    private Paciente paciente;
    private List<Persona> lstPersonas;
    private List<Paciente> lstPacientes;
    @EJB
    private PersonaFacadeLocal personaEJB;
    @EJB
    private PacienteFacadeLocal pacienteEJB;

    @PostConstruct
    public void init() {
        persona = new Persona();
        paciente = new Paciente();
        lstPacientes = pacienteEJB.findAll();
        lstPersonas = personaEJB.findAll();
    }

    public void regitrarPaciente() {
        try {
            paciente.setIdPersona(persona);
            pacienteEJB.create(paciente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Paciente registrado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", e.getMessage().concat(" Comuniquese con el administrador de la aplicación.")));
        }
    }

    public void modificarPaciente() {
        try {
            pacienteEJB.edit(paciente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Paciente modificado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", e.getMessage().concat(" Comuniquese con el administrador de la aplicación.")));
        }
    }

    public void eliminarPaciente() {
        try {
            pacienteEJB.remove(paciente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Paciente eliminado exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", e.getMessage().concat(" Comuniquese con el administrador de la aplicación.")));
        }
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }

    public List<Paciente> getLstPacientes() {
        return lstPacientes;
    }

    public void setLstPacientes(List<Paciente> lstPacientes) {
        this.lstPacientes = lstPacientes;
    }

}
