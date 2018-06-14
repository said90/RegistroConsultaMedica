/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.ExamenClinicoIndicado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bsf_o
 */
@Local
public interface ExamenClinicoIndicadoFacadeLocal {

    void create(ExamenClinicoIndicado examenClinicoIndicado);

    void edit(ExamenClinicoIndicado examenClinicoIndicado);

    void remove(ExamenClinicoIndicado examenClinicoIndicado);

    ExamenClinicoIndicado find(Object id);

    List<ExamenClinicoIndicado> findAll();

    List<ExamenClinicoIndicado> findRange(int[] range);

    int count();
    
}
