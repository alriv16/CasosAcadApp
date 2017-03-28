/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasosAcadEntities;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.validator.Validator;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

/**
 *
 * @author alejandra
 */
public abstract class AbstractFacade<T> {

    private final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        try{
        if(entity!=null&&getEntityManager()!=null){
        getEntityManager().persist(entity);}
        }catch(Exception e){
        Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(),e);
        }
    }

    public void edit(T entity) {
        try{
         if(entity!=null&&getEntityManager()!=null)   
        getEntityManager().merge(entity);
        }catch(Exception e){
        Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(),e);
        }
        
    }

    public void remove(T entity) {
        try{
            if(entity!=null&&getEntityManager()!=null){
        getEntityManager().remove(getEntityManager().merge(entity));}
        }catch(Exception e){
        Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(),e);
        }
    }

    public T find(Object id) {
        try{
           if(id!=null&&getEntityManager()!=null){ 
        return getEntityManager().find(entityClass, id);}
        }catch(Exception e){
        Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(),e);
        
        } 
        return null;
    }

    public List<T> findAll() {
        try{ 
            if(getEntityManager()!=null){
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
        }
        }catch(Exception e){
          //return new ArrayList<>();
        Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(),e);
        
        }     
       return null;
        
    }

    public List<T> findRange(int[] range) {
        
        try{
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
        }catch(Exception e){
        Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(),e);
        }
        return null;
    }

    public int count() {
        
        try{
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
        }catch(Exception e){
        Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(),e);
        }
        return 0;
    }
    
}
