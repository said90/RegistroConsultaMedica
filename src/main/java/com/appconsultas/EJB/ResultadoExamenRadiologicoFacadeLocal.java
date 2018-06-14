/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.ResultadoExamenRadiologico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bsf_o
 */
@Local
public interface ResultadoExamenRadiologicoFacadeLocal {

    void create(ResultadoExamenRadiologico resultadoExamenRadiologico);

    void edit(ResultadoExamenRadiologico resultadoExamenRadiologico);

    void remove(ResultadoExamenRadiologico resultadoExamenRadiologico);

    ResultadoExamenRadiologico find(Object id);

    List<ResultadoExamenRadiologico> findAll();

    List<ResultadoExamenRadiologico> findRange(int[] range);

    int count();
    
}
