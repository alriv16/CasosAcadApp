/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paginas;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import casosacadmvn.casosacadlibmvn.TipoRequisito;
import CasosAcadEntities.TipoRequisitoFacadeLocal;
import java.io.Serializable;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
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
  
     
    private List<TipoRequisito> registro;
  
    private TipoRequisito tipo_requisito;

    public TipoRequisito getTipo_requisito() {
        return tipo_requisito;
    }

    public void setTipo_requisito(TipoRequisito tipo_requisito) {
        this.tipo_requisito = tipo_requisito;
    }
    
    @PostConstruct
    public void iniciarModelo(){
    try{
        this.registro=tReq.findAll();
    } catch(Exception ex){
    
    }
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
    
    public TipoRequisito CrearNuevo(){
            this.tipo_requisito= new TipoRequisito();
            this.tipo_requisito.setActivo(true);
                return this.tipo_requisito;
    }
    
    public void crearNuevoHandler(ActionEvent ae){
        this.CrearNuevo();
    }
    
    
    
}
