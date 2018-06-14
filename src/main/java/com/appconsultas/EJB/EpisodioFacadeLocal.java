/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.Agenda;
import com.appconsultas.model.Episodio;
import java.util.List;
import javax.ejb.Local;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author bsf_o
 */
@Local
public interface EpisodioFacadeLocal {

    void create(Episodio episodio);

    void edit(Episodio episodio);

    void remove(Episodio episodio);

    Episodio find(Object id);

    List<Episodio> findAll();

    List<Episodio> findRange(int[] range);

    int count();
    
    Agenda obtenerCita(SelectEvent selectEvent);
}
