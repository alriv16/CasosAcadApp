/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasosAcadEntities;

import casosacadmvn.casosacadlibmvn.Paso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alejandra
 */
@Local
public interface PasoFacadeLocal {

    void create(Paso paso);

    Paso crear(Paso paso);

    boolean create2(Paso paso);

    Paso editarBoolean(Paso paso);

    void edit(Paso paso);

    boolean edit2(Paso paso);

    void remove(Paso paso);

    Paso find(Object id);

    List<Paso> findAll();

    List<Paso> findRange(int[] range);

    int count();

}
