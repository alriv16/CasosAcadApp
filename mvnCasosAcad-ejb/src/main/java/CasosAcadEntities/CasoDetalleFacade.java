/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasosAcadEntities;

import casosacadmvn.casosacadlibmvn.CasoDetalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alejandra
 */
@Stateless
public class CasoDetalleFacade extends AbstractFacade<CasoDetalle> implements CasoDetalleFacadeLocal {

    @PersistenceContext(unitName = "CasosAcadmvn_mvnCasosAcad-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CasoDetalleFacade() {
        super(CasoDetalle.class);
    }
    
}
