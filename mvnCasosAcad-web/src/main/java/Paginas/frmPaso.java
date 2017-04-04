/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paginas;

import CasosAcadEntities.PasoFacadeLocal;
import CasosAcadEntities.TipoPasoFacadeLocal;
import casosacadmvn.casosacadlibmvn.Paso;
import casosacadmvn.casosacadlibmvn.Requisito;
import casosacadmvn.casosacadlibmvn.TipoPaso;
import casosacadmvn.casosacadlibmvn.TipoRequisito;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author alejandra
 */
@Named(value = "frmPaso")
@ViewScoped
public class frmPaso implements Serializable{

    @EJB
    private PasoFacadeLocal pasoFacade;

    @EJB
    private TipoPasoFacadeLocal tipoPasoFacade;
    
    private Paso paso= new Paso();
     private boolean edit;
     private List<TipoPaso> listaTipo;

    public PasoFacadeLocal getPasoFacade() {
        return pasoFacade;
    }

    public void setPasoFacade(PasoFacadeLocal pasoFacade) {
        this.pasoFacade = pasoFacade;
    }

    public TipoPasoFacadeLocal getTipoPasoFacade() {
        return tipoPasoFacade;
    }

    public void setTipoPasoFacade(TipoPasoFacadeLocal tipoPasoFacade) {
        this.tipoPasoFacade = tipoPasoFacade;
    }

    public Paso getPaso() {
        return paso;
    }

    public void setPaso(Paso paso) {
        this.paso = paso;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public List<TipoPaso> getListaTipo() {
        return listaTipo;
    }

    public void setListaTipo(List<TipoPaso> listaTipo) {
        this.listaTipo = listaTipo;
    }

    @PostConstruct
    private void init(){
    this.listaTipo=this.tipoPasoFacade.findAll();
    
    }
    /**
     * Creates a new instance of frmPaso
     */
    public frmPaso() {
    }
    
     public void btnCrearAction(ActionEvent ae){
       try {
           if(this.paso != null && this.pasoFacade != null) {
               boolean resultado;
               resultado = this.pasoFacade.create2(paso);
               FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, resultado?"Creado con exito":"Error", null);
              
               FacesContext.getCurrentInstance().addMessage(null, msj);
           }
       } catch (Exception e) {
       }
   }
    
      public String borrar(Paso paso) {

        try {
            this.pasoFacade.remove(paso);
            return "Paso";
        } catch (Exception e) {
            System.out.println("Error al eliminar de la lista: " + e);
        }

        return "Paso";
    }
     
     public Integer getTipoSeleccionado(){
     if(paso != null){
            if(paso.getIdTipoPaso()!= null){
                return this.paso.getIdTipoPaso().getIdTipoPaso();
            } else {
                return null;
            }         
        } else {
            return null;
        }
    }
    
    public void setTipoSeleccionado(Integer idTipo){
        if(idTipo >= 0 && !this.listaTipo.isEmpty()){
            for(TipoPaso tpa : this.getListaTipo()) {
                if(Objects.equals(tpa.getIdTipoPaso(), idTipo)) {
                    if(this.paso.getIdTipoPaso()!= null) {
                        this.paso.getIdTipoPaso().setIdTipoPaso(idTipo);
                    } else {
                        this.paso.setIdTipoPaso(tpa);
                    }
                }
            }
        }
    
    }
    public List<Paso> findAll() {
        List<Paso> salida = null;

        try {
            salida = this.pasoFacade.findAll();

            return salida;

        } catch (Exception e) {

            System.out.println("Se ha producido un error al llenar la lista: " + e);

        }

        return salida;

    }
    
     public void btnModificarAction(ActionEvent ae) {
       try {
           edit=false;
           if(this.paso!= null && this.paso != null) {
               boolean resultado = this.pasoFacade.edit2(paso);
               FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, resultado?"Editado con exito":"Error", null);
               FacesContext.getCurrentInstance().addMessage(null, msj);
               
           }
       } catch (Exception e) {
           System.out.println("ERROR: "+ e.getMessage());
       }
   }
     
     public void editar(Paso seleccionado){
        edit=true;
         this.paso= seleccionado;
        
     }
     
     public String MostrarNuevo(){
     return "AgregarPaso";
     }
     
     public String cancelar(){
    return "Paso";
    }
     
    
}
