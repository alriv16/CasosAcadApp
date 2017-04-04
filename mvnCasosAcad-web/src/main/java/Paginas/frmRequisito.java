/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paginas;

import CasosAcadEntities.RequisitoFacadeLocal;
import CasosAcadEntities.TipoRequisitoFacadeLocal;
import casosacadmvn.casosacadlibmvn.Requisito;
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
@Named(value = "frmRequisito")
@ViewScoped
public class frmRequisito implements Serializable{

    @EJB
    private TipoRequisitoFacadeLocal tipoRequisitoFacade;
    
     @EJB
    private RequisitoFacadeLocal requisitoFacade;
     
     private Requisito tipoRequisito= new Requisito();

    public TipoRequisitoFacadeLocal getTipoRequisitoFacade() {
        return tipoRequisitoFacade;
    }

    public void setTipoRequisitoFacade(TipoRequisitoFacadeLocal tipoRequisitoFacade) {
        this.tipoRequisitoFacade = tipoRequisitoFacade;
    }

    public RequisitoFacadeLocal getRequisitoFacade() {
        return requisitoFacade;
    }

    public void setRequisitoFacade(RequisitoFacadeLocal requisitoFacade) {
        this.requisitoFacade = requisitoFacade;
    }

    public Requisito getTipoRequisito() {
        return tipoRequisito;
    }

    public void setTipoRequisito(Requisito tipoRequisito) {
        this.tipoRequisito = tipoRequisito;
    }

    public List<TipoRequisito> getListaTipo() {
        return listaTipo;
    }

    public void setListaTipo(List<TipoRequisito> listaTipo) {
        this.listaTipo = listaTipo;
    }
    private List<TipoRequisito> listaTipo;
    /**
     * Creates a new instance of frmRequisito
     */
      @PostConstruct
    private void init(){
    this.listaTipo=this.tipoRequisitoFacade.findAll();
    
    }
     
    public frmRequisito() {
    }
    
     public void btnCrearAction(ActionEvent ae){
       try {
           if(this.tipoRequisito != null && this.requisitoFacade != null) {
               boolean resultado;
               resultado = this.requisitoFacade.create2(tipoRequisito);
               FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, resultado?"Creado con exito":"Error", null);
              
               FacesContext.getCurrentInstance().addMessage(null, msj);
           }
       } catch (Exception e) {
       }
   }
     
     public String borrar(Requisito requisito) {

        try {
            this.requisitoFacade.remove(requisito);
            return "Requisito";
        } catch (Exception e) {
            System.out.println("Error al eliminar de la lista: " + e);
        }

        return "Requisito";
    }
     
     public Integer getTipoSeleccionado(){
     if(tipoRequisito != null){
            if(tipoRequisito.getIdTipoRequisito()!= null){
                return this.tipoRequisito.getIdTipoRequisito().getIdTipoRequisito();
            } else {
                return null;
            }         
        } else {
            return null;
        }
    }
    
    public void setTipoSeleccionado(Integer idTipo){
        if(idTipo >= 0 && !this.listaTipo.isEmpty()){
            for(TipoRequisito tre : this.getListaTipo()) {
                if(Objects.equals(tre.getIdTipoRequisito(), idTipo)) {
                    if(this.tipoRequisito.getIdTipoRequisito() != null) {
                        this.tipoRequisito.getIdTipoRequisito().setIdTipoRequisito(idTipo);
                    } else {
                        this.tipoRequisito.setIdTipoRequisito(tre);
                    }
                }
            }
        }
    
    }
    public List<Requisito> findAll() {
        List<Requisito> salida = null;

        try {
            salida = this.requisitoFacade.findAll();

            return salida;

        } catch (Exception e) {

            System.out.println("Se ha producido un error al llenar la lista: " + e);

        }

        return salida;

    }
    
}
