/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.controller;

import com.appconsultas.EJB.AgendaFacadeLocal;
import com.appconsultas.EJB.MedicoFacadeLocal;
import com.appconsultas.EJB.PacienteFacadeLocal;
import com.appconsultas.model.Agenda;
import com.appconsultas.model.Medico;
import com.appconsultas.model.Paciente;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author bsf_o
 */
@ViewScoped
@Named
public class AgendaController implements Serializable {

    private Paciente paciente;
    private Medico medico;
    private Agenda cita;
    private ScheduleModel eventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();

    List<Paciente> lstPacientes;
    List<Medico> lstMedicos;
    List<Agenda> lstCitas;

    @EJB
    private PacienteFacadeLocal pacienteEJB;
    @EJB
    private MedicoFacadeLocal medicoEJB;
    @EJB
    private AgendaFacadeLocal agendaEJB;

    @PostConstruct
    public void init() {
        paciente = new Paciente();
        eventModel = new DefaultScheduleModel();
        medico = new Medico();
        cita = new Agenda();
        lstPacientes = pacienteEJB.findAll();
        lstMedicos = medicoEJB.findAll();
        lstCitas = agendaEJB.findAll();
        llenarSchedule();
    }

    public void llenarSchedule() {
        int minutos = 30;
        Calendar calendar = Calendar.getInstance();
        for (Agenda ca : lstCitas) {
            calendar.setTime(ca.getFechaCita());
            calendar.add(Calendar.MINUTE, minutos);
            eventModel.addEvent(new DefaultScheduleEvent("Paciente: " + ca.getIdPaciente().getIdPersona().getNombres() + "  " + ca.getIdPaciente().getIdPersona().getApellidos()
                    + " - " + "Medico Asignado: " + " Dr." + ca.getIdMedico().getIdPersona().getNombres() + ca.getIdMedico().getIdPersona().getApellidos()
                    + " - " + "Motivo de consulta: " + ca.getMotivoConsulta(),
                    ca.getFechaCita(), calendar.getTime()));
           
            
        }
    }

    public void registarCita() {
        try {
            agendaEJB.create(cita);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Cita registrada con exito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }

    }

    public void modificarCita() {
        try {
            agendaEJB.edit(cita);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Cita modificada con exito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }
    }

    public void eliminarCita() {
        try {
            agendaEJB.remove(cita);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Cita eliminada con exito"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" + e.getMessage()));
        }
    }

    public void onDateSelect(SelectEvent selectEvent) {
        int dia = 1;
        Calendar calendar = Calendar.getInstance();
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
        calendar.setTime(event.getStartDate());
        cita.setFechaCita(calendar.getTime());
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Agenda getCita() {
        return cita;
    }

    public void setCita(Agenda cita) {
        this.cita = cita;
    }

    public List<Paciente> getLstPacientes() {
        return lstPacientes;
    }

    public void setLstPacientes(List<Paciente> lstPacientes) {
        this.lstPacientes = lstPacientes;
    }

    public List<Medico> getLstMedicos() {
        return lstMedicos;
    }

    public void setLstMedicos(List<Medico> lstMedicos) {
        this.lstMedicos = lstMedicos;
    }

    public List<Agenda> getLstCitas() {
        return lstCitas;
    }

    public void setLstCitas(List<Agenda> lstCitas) {
        this.lstCitas = lstCitas;
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

}
