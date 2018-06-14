/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.ExamenLabClinico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bsf_o
 */
@Local
public interface ExamenLabClinicoFacadeLocal {

    void create(ExamenLabClinico examenLabClinico);

    void edit(ExamenLabClinico examenLabClinico);

    void remove(ExamenLabClinico examenLabClinico);

    ExamenLabClinico find(Object id);

    List<ExamenLabClinico> findAll();

    List<ExamenLabClinico> findRange(int[] range);

    int count();
    
}
