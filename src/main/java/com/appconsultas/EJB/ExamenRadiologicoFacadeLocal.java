/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.ExamenRadiologico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bsf_o
 */
@Local
public interface ExamenRadiologicoFacadeLocal {

    void create(ExamenRadiologico examenRadiologico);

    void edit(ExamenRadiologico examenRadiologico);

    void remove(ExamenRadiologico examenRadiologico);

    ExamenRadiologico find(Object id);

    List<ExamenRadiologico> findAll();

    List<ExamenRadiologico> findRange(int[] range);

    int count();
    
}
