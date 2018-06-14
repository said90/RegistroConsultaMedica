/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.Especialista;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bsf_o
 */
@Local
public interface EspecialistaFacadeLocal {

    void create(Especialista especialista);

    void edit(Especialista especialista);

    void remove(Especialista especialista);

    Especialista find(Object id);

    List<Especialista> findAll();

    List<Especialista> findRange(int[] range);

    int count();
    
}
