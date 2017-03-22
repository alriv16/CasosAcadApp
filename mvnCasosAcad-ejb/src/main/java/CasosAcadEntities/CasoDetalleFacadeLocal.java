/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasosAcadEntities;

import casosacadmvn.casosacadlibmvn.CasoDetalle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alejandra
 */
@Local
public interface CasoDetalleFacadeLocal {

    void create(CasoDetalle casoDetalle);

    void edit(CasoDetalle casoDetalle);

    void remove(CasoDetalle casoDetalle);

    CasoDetalle find(Object id);

    List<CasoDetalle> findAll();

    List<CasoDetalle> findRange(int[] range);

    int count();
    
}
