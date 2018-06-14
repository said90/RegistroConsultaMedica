/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.Incapacidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bsf_o
 */
@Local
public interface IncapacidadFacadeLocal {

    void create(Incapacidad incapacidad);

    void edit(Incapacidad incapacidad);

    void remove(Incapacidad incapacidad);

    Incapacidad find(Object id);

    List<Incapacidad> findAll();

    List<Incapacidad> findRange(int[] range);

    int count();
    
}
