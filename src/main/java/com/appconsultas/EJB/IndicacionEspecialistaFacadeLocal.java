/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.IndicacionEspecialista;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bsf_o
 */
@Local
public interface IndicacionEspecialistaFacadeLocal {

    void create(IndicacionEspecialista indicacionEspecialista);

    void edit(IndicacionEspecialista indicacionEspecialista);

    void remove(IndicacionEspecialista indicacionEspecialista);

    IndicacionEspecialista find(Object id);

    List<IndicacionEspecialista> findAll();

    List<IndicacionEspecialista> findRange(int[] range);

    int count();
    
}
