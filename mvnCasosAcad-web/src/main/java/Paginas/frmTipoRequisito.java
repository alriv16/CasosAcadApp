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
import java.util.ArrayList;
import javax.faces.component.html.HtmlDataTable;

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
   
    public List<TipoRequisito> findAll(){
    return this.tReq.findAll();}

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
        this.tReq.create(this.tipo_requisito);
        this.tipo_requisito=new TipoRequisito();
        return "index";

}
    public void borrar(TipoRequisito tr){
        this.tReq.remove(tr);

}

    public String editar(TipoRequisito tr) {

        this.tipo_requisito= tr;
        this.tReq.edit(tipo_requisito);
        return "Editar";
}
    public String Editar() {

        this.tReq.edit(this.tipo_requisito);
        return "index";
}
    
    
    
    
    
    
}
