/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.ResultadoLabClinico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bsf_o
 */
@Local
public interface ResultadoLabClinicoFacadeLocal {

    void create(ResultadoLabClinico resultadoLabClinico);

    void edit(ResultadoLabClinico resultadoLabClinico);

    void remove(ResultadoLabClinico resultadoLabClinico);

    ResultadoLabClinico find(Object id);

    List<ResultadoLabClinico> findAll();

    List<ResultadoLabClinico> findRange(int[] range);

    int count();
    
}
