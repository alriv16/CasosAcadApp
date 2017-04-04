/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paginas;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import casosacadmvn.casosacadlibmvn.TipoRequisito;
import CasosAcadEntities.TipoRequisitoFacadeLocal;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandra
 */

@Named(value = "frmTipoRequisito")
@ViewScoped
public class frmTipoRequisito implements Serializable {
 
    /**
     * Creates a new instance of frmTipoRequisito
     */
    public frmTipoRequisito() {
        
    }
    
     @EJB
    private TipoRequisitoFacadeLocal tReq;
    private TipoRequisito tRequisitoSeleccionado;
    private boolean editarE,editarS;

    public boolean isEditarS() {
        return editarS;
    }
    
    
    public TipoRequisito gettRequisitoSeleccionado() {
        return tRequisitoSeleccionado;
    }

    public void settRequisitoSeleccionado(TipoRequisito tRequisitoSeleccionado) {
        this.tRequisitoSeleccionado = tRequisitoSeleccionado;
    }
     
    private List<TipoRequisito> registro;
  
    private TipoRequisito tipo_requisito=new TipoRequisito();

    public TipoRequisito getTipo_requisito() {
        return tipo_requisito;
    }

    public void setTipo_requisito(TipoRequisito tipo_requisito) {
        this.tipo_requisito = tipo_requisito;
    }
    
    /**
     *
     * @return
     */
   
   public List<TipoRequisito> findAll() {
        List<TipoRequisito> salida = null;

        try {
            salida = this.tReq.findAll();

            return salida;

        } catch (Exception e) {

            Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(),e);

        }

        return salida;

    }

    public TipoRequisitoFacadeLocal gettReq() {
        return tReq;
    }

    public void settReq(TipoRequisitoFacadeLocal tReq) {
        this.tReq = tReq;
    }

    public List<TipoRequisito> getRegistro() {
        return registro;
    }

    public void setRegistro(List<TipoRequisito> registro) {
        this.registro = registro;
    }
    
    public String crear(){
        try {
            this.tReq.create(this.tipo_requisito);
        this.tipo_requisito=new TipoRequisito();
        return "TipoRequisito";
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(),e);
        }
        return "TipoRequisito";
}
    
    
   public void borrar(TipoRequisito tr){
        try {
           this.tReq.remove(tr);

       } catch (Exception e) {
           Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(),e);
       }
}

   public void mostrar(){
      editarS=true;
      editarE=false;
   
   }
   public void ocultar(){
   editarE=false;
   editarS=false;
   
   }
   
   
    public void editar(TipoRequisito tr) {
        try {
             this.tipo_requisito= tr;
        editarE=true;
        editarS=false;
        
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(),e);
            System.out.println("Error"+e.getMessage());
        }
      
}
    public String Guardar() {
        
        try {
            editarE=false;
        editarS=true;
        this.tReq.edit(this.tipo_requisito);
        return "TipoRequisito";
        } catch (Exception e) {
           Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(),e);
           System.out.println("Error"+e.getMessage());
        }
        return "TipoRequisito";
}
    
    public boolean isEdit(){
    return editarE;  
    }
   
 public String cancelar(){
    return "TipoRequisito";
    }
    
  
  
    
    
}
