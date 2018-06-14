/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.ExamenRadiologicoIndicado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bsf_o
 */
@Local
public interface ExamenRadiologicoIndicadoFacadeLocal {

    void create(ExamenRadiologicoIndicado examenRadiologicoIndicado);

    void edit(ExamenRadiologicoIndicado examenRadiologicoIndicado);

    void remove(ExamenRadiologicoIndicado examenRadiologicoIndicado);

    ExamenRadiologicoIndicado find(Object id);

    List<ExamenRadiologicoIndicado> findAll();

    List<ExamenRadiologicoIndicado> findRange(int[] range);

    int count();
    
}
