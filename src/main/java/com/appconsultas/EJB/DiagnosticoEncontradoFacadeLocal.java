/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.DiagnosticoEncontrado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bsf_o
 */
@Local
public interface DiagnosticoEncontradoFacadeLocal {

    void create(DiagnosticoEncontrado diagnosticoEncontrado);

    void edit(DiagnosticoEncontrado diagnosticoEncontrado);

    void remove(DiagnosticoEncontrado diagnosticoEncontrado);

    DiagnosticoEncontrado find(Object id);

    List<DiagnosticoEncontrado> findAll();

    List<DiagnosticoEncontrado> findRange(int[] range);

    int count();
    
}
