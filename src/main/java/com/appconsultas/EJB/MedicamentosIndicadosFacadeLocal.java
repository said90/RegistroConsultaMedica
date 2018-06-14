/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appconsultas.EJB;

import com.appconsultas.model.MedicamentosIndicados;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bsf_o
 */
@Local
public interface MedicamentosIndicadosFacadeLocal {

    void create(MedicamentosIndicados medicamentosIndicados);

    void edit(MedicamentosIndicados medicamentosIndicados);

    void remove(MedicamentosIndicados medicamentosIndicados);

    MedicamentosIndicados find(Object id);

    List<MedicamentosIndicados> findAll();

    List<MedicamentosIndicados> findRange(int[] range);

    int count();
    
}
