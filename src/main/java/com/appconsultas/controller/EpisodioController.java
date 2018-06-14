/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.controller;

import com.appconsultas.ClaseAuxiliares.diagnosticoEncontradoLS;
import com.appconsultas.EJB.AgendaFacadeLocal;
import com.appconsultas.EJB.DiagnosticoEncontradoFacadeLocal;
import com.appconsultas.EJB.EpisodioFacadeLocal;
import com.appconsultas.EJB.ExamenClinicoIndicadoFacadeLocal;
import com.appconsultas.EJB.ExamenRadiologicoIndicadoFacadeLocal;
import com.appconsultas.EJB.MedicamentosIndicadosFacadeLocal;
import com.appconsultas.EJB.ReferenciaFacadeLocal;
import com.appconsultas.model.Agenda;
import com.appconsultas.model.Diagnostico;
import com.appconsultas.model.DiagnosticoEncontrado;
import com.appconsultas.model.Episodio;
import com.appconsultas.model.Especialista;
import com.appconsultas.model.ExamenClinicoIndicado;
import com.appconsultas.model.ExamenLabClinico;
import com.appconsultas.model.ExamenRadiologico;
import com.appconsultas.model.ExamenRadiologicoIndicado;
import com.appconsultas.model.Medicamento;
import com.appconsultas.model.MedicamentosIndicados;
import com.appconsultas.model.Referencia;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
public class EpisodioController implements Serializable {

    private Episodio episodio;
    private Agenda cita;

    private ExamenLabClinico examLab;
    private ExamenClinicoIndicado examLabInd;
    private ExamenRadiologico examRad;
    private ExamenRadiologicoIndicado examRadiInd;
    private Especialista especialista;
    private Referencia referencia;
    private Diagnostico diagnostico;
    private DiagnosticoEncontrado diagnosticoEncontrado;
    private Medicamento medicamento;
    private MedicamentosIndicados medicamentoIndicado;
    private diagnosticoEncontradoLS diagnosticoEncontradoLs;

    private List<Episodio> lstEpisodios;
    private List<Agenda> lstCitas;
    private List<ExamenClinicoIndicado> lstExamenesCliniIndicados;
    private List<ExamenRadiologicoIndicado> lstExamRadioIndicados;
    private List<DiagnosticoEncontrado> lstDiagnosticosEncontrados;
    private List<MedicamentosIndicados> lstMedicamentosIndicados;
    private List<Referencia> lstReferencias;
    private List<diagnosticoEncontradoLS> lstDiagnosticoLs;

    private ScheduleModel eventModel;
    private ScheduleEvent event;

    @EJB
    private AgendaFacadeLocal agendaEJB;
    @EJB
    private EpisodioFacadeLocal episodioEJB;
    @EJB
    private DiagnosticoEncontradoFacadeLocal diagnosticoEncontradoEJB;
    @EJB
    private MedicamentosIndicadosFacadeLocal medicamentosIndicadosEJB;
    @EJB
    private ExamenClinicoIndicadoFacadeLocal examenClinicoEJB;
    @EJB
    private ExamenRadiologicoIndicadoFacadeLocal examentRadiologicoEJB;
    @EJB
    private ReferenciaFacadeLocal referenciaEJB;

    @PostConstruct
    public void init() {
        episodio = new Episodio();
        lstCitas = agendaEJB.findAll();
        lstDiagnosticosEncontrados = new ArrayList<>();
        lstMedicamentosIndicados = new ArrayList<>();
        lstExamRadioIndicados = new ArrayList<>();
        lstExamenesCliniIndicados = new ArrayList<>();
        lstReferencias = new ArrayList<>();
        cita = new Agenda();
        medicamento = new Medicamento();
        medicamentoIndicado = new MedicamentosIndicados();
        examLab = new ExamenLabClinico();
        examLabInd = new ExamenClinicoIndicado();
        examRad = new ExamenRadiologico();
        examRadiInd = new ExamenRadiologicoIndicado();
        diagnostico = new Diagnostico();
        diagnosticoEncontrado = new DiagnosticoEncontrado();
        especialista = new Especialista();
        referencia = new Referencia();
        eventModel = new DefaultScheduleModel();
        event = new DefaultScheduleEvent();
        llenarSchedule();
        diagnosticoEncontradoLs = new diagnosticoEncontradoLS();
    }

    public void registrarEpisodio() {
        episodio.setDiagnosticosEncontrados(lstDiagnosticosEncontrados.size());
        episodio.setExamenesClinicosIndicados(lstExamenesCliniIndicados.size());
        episodio.setExamenesRadiologicosIndicados(lstExamRadioIndicados.size());
        episodio.setMedicamentosIndicados(lstMedicamentosIndicados.size());
        episodioEJB.create(episodio);
        if (lstDiagnosticosEncontrados.size() > 0) {
            for (DiagnosticoEncontrado diagnostico1 : lstDiagnosticosEncontrados) {
                diagnostico1.setIdEpisodio(episodio);
                diagnosticoEncontradoEJB.create(diagnostico1);
            }
        }

        if (lstExamenesCliniIndicados.size() > 0) {
            for (ExamenClinicoIndicado lab : lstExamenesCliniIndicados) {
                lab.setIdEpisodio(episodio);
                examenClinicoEJB.create(lab);
            }
        }

        if (lstExamRadioIndicados.size() > 0) {
            for (ExamenRadiologicoIndicado rad : lstExamRadioIndicados) {
                rad.setIdEpisodio(episodio);
                examentRadiologicoEJB.create(rad);
            }
        }

        if (lstMedicamentosIndicados.size() > 0) {
            for (MedicamentosIndicados medicina : lstMedicamentosIndicados) {
                medicina.setIdEpisodio(episodio);
                medicamentosIndicadosEJB.create(medicina);
            }
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Consulta Guardada con Exito!"));
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
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
                    ca.getFechaCita(), calendar.getTime(), ca));

        }
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
        cita = (Agenda) event.getData();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SIMED/consultamedica/consultaPaciente.xhtml?faces-redirect=true");

        } catch (Exception e) {
        }

    }

    public void agregarDiagnostico() {
        if (diagnostico != null) {
            lstDiagnosticosEncontrados.add(diagnosticoEncontrado);
            diagnosticoEncontrado = new DiagnosticoEncontrado();
        }

    }

    public void removerDiagnostico(DiagnosticoEncontrado diag) {
        lstDiagnosticosEncontrados.remove(diag);
    }

    public void agregarMedicamento() {
        if (medicamento != null) {
            lstMedicamentosIndicados.add(medicamentoIndicado);
            medicamentoIndicado = new MedicamentosIndicados();
        }

    }

    public void removerMedicamento(MedicamentosIndicados med) {
        lstMedicamentosIndicados.remove(med);
    }

    public void agregarExamLab() {
        if (examLab != null) {
            lstExamenesCliniIndicados.add(examLabInd);
            examLabInd = new ExamenClinicoIndicado();
        }

    }

    public void removerExamLab(ExamenClinicoIndicado exlab) {
        lstExamenesCliniIndicados.remove(exlab);
    }

    public void agregarExamRadiologico() {
        if (examRad != null) {
            lstExamRadioIndicados.add(examRadiInd);
            examRadiInd = new ExamenRadiologicoIndicado();
        }

    }

    public void removerExamRad(ExamenRadiologicoIndicado exrad) {
        lstExamRadioIndicados.remove(exrad);
    }

    public void agregarReferencia() {
        if (especialista != null) {
            lstReferencias.add(referencia);
            referencia = new Referencia();
        }

    }

    public void removerEspecialista(Referencia esp) {
        lstReferencias.remove(esp);
    }

    public Episodio getEpisodio() {
        return episodio;
    }

    public void setEpisodio(Episodio episodio) {
        this.episodio = episodio;
    }

    public List<Episodio> getLstEpisodios() {
        return lstEpisodios;
    }

    public void setLstEpisodios(List<Episodio> lstEpisodios) {
        this.lstEpisodios = lstEpisodios;
    }

    public Agenda getCita() {
        return cita;
    }

    public void setCita(Agenda cita) {
        this.cita = cita;
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

    public ExamenLabClinico getExamLab() {
        return examLab;
    }

    public void setExamLab(ExamenLabClinico examLab) {
        this.examLab = examLab;
    }

    public ExamenRadiologico getExamRad() {
        return examRad;
    }

    public void setExamRad(ExamenRadiologico examRad) {
        this.examRad = examRad;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public DiagnosticoEncontrado getDiagnosticoEncontrado() {
        return diagnosticoEncontrado;
    }

    public void setDiagnosticoEncontrado(DiagnosticoEncontrado diagnosticoEncontrado) {
        this.diagnosticoEncontrado = diagnosticoEncontrado;
    }

    public List<ExamenClinicoIndicado> getLstExamenesCliniIndicados() {
        return lstExamenesCliniIndicados;
    }

    public void setLstExamenesCliniIndicados(List<ExamenClinicoIndicado> lstExamenesCliniIndicados) {
        this.lstExamenesCliniIndicados = lstExamenesCliniIndicados;
    }

    public List<ExamenRadiologicoIndicado> getLstExamRadioIndicados() {
        return lstExamRadioIndicados;
    }

    public void setLstExamRadioIndicados(List<ExamenRadiologicoIndicado> lstExamRadioIndicados) {
        this.lstExamRadioIndicados = lstExamRadioIndicados;
    }

    public List<DiagnosticoEncontrado> getLstDiagnosticosEncontrados() {
        return lstDiagnosticosEncontrados;
    }

    public void setLstDiagnosticosEncontrados(List<DiagnosticoEncontrado> lstDiagnosticosEncontrados) {
        this.lstDiagnosticosEncontrados = lstDiagnosticosEncontrados;
    }

    public List<MedicamentosIndicados> getLstMedicamentosIndicados() {
        return lstMedicamentosIndicados;
    }

    public void setLstMedicamentosIndicados(List<MedicamentosIndicados> lstMedicamentosIndicados) {
        this.lstMedicamentosIndicados = lstMedicamentosIndicados;
    }

    public List<Referencia> getLstReferencias() {
        return lstReferencias;
    }

    public void setLstReferencias(List<Referencia> lstReferencias) {
        this.lstReferencias = lstReferencias;
    }

    public ExamenClinicoIndicado getExamLabInd() {
        return examLabInd;
    }

    public void setExamLabInd(ExamenClinicoIndicado examLabInd) {
        this.examLabInd = examLabInd;
    }

    public ExamenRadiologicoIndicado getExamRadiInd() {
        return examRadiInd;
    }

    public void setExamRadiInd(ExamenRadiologicoIndicado examRadiInd) {
        this.examRadiInd = examRadiInd;
    }

    public Referencia getReferencia() {
        return referencia;
    }

    public void setReferencia(Referencia referencia) {
        this.referencia = referencia;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public MedicamentosIndicados getMedicamentoIndicado() {
        return medicamentoIndicado;
    }

    public void setMedicamentoIndicado(MedicamentosIndicados medicamentoIndicado) {
        this.medicamentoIndicado = medicamentoIndicado;
    }

    public List<diagnosticoEncontradoLS> getLstDiagnosticoLs() {
        return lstDiagnosticoLs;
    }

    public void setLstDiagnosticoLs(List<diagnosticoEncontradoLS> lstDiagnosticoLs) {
        this.lstDiagnosticoLs = lstDiagnosticoLs;
    }

    public diagnosticoEncontradoLS getDiagnosticoEncontradoLs() {
        return diagnosticoEncontradoLs;
    }

    public void setDiagnosticoEncontradoLs(diagnosticoEncontradoLS diagnosticoEncontradoLs) {
        this.diagnosticoEncontradoLs = diagnosticoEncontradoLs;
    }

}
