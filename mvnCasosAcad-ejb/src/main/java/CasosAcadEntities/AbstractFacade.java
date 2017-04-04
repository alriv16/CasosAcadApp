/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasosAcadEntities;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.validator.Validator;
import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.OneToMany;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.persistence.*;

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
    
      public boolean create2(T entity) {
//        getEntityManager().persist(entity);
        boolean salida = false;
        T e=this.crear(entity);
        if (e != null) {
            salida=true;}
        try {
            EntityManager em = this.getEntityManager();
            if (em!=null) {
                em.persist(entity);
                salida=true;
            }
            
        } catch (Exception ex) {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);}
        return salida;
                
    }
      public T crear (T entity){
        T salida=null;
        try {
            EntityManager em = this.getEntityManager();
            if (em!=null && entity!= null) {
                em.persist(entity);
                          
            }
            
        } catch (Exception e) {
        java.util.logging.Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(),e);
        }
        return salida;
              
    }
      public T editarBoolean(T entity) {
        T salida = null;
        try {
            EntityManager em = this.getEntityManager();
            if(em!=null && entity != null) {
                em.merge(entity);
                salida = entity;
            }
        }catch(Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(),e);
        }
        return salida;
    }
       public boolean edit2(T entity) {
        boolean salida =false;
        T e = editarBoolean(entity);
        if(e!=null){
            salida = true;
        }
        return salida;
    }
    
      
}
