/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.Agenda;
import com.appconsultas.model.Episodio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author bsf_o
 */
@Stateless
public class EpisodioFacade extends AbstractFacade<Episodio> implements EpisodioFacadeLocal {

    @PersistenceContext(unitName = "PUConsulta_medica")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EpisodioFacade() {
        super(Episodio.class);
    }

    @Override
    public Agenda obtenerCita(SelectEvent selectEvent) {
        Agenda cita = new Agenda();
        List<Agenda> lstAgenda;
        Query q = em.createNativeQuery("select * from agenda\n"
                + "where agenda.fecha_cita = 1 and");
        return cita;
    }

}
