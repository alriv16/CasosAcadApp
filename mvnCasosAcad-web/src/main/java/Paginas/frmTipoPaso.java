/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paginas;

import CasosAcadEntities.TipoPasoFacadeLocal;
import casosacadmvn.casosacadlibmvn.TipoPaso;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author alejandra
 */
@Named(value = "frmTipoPaso")
@ViewScoped
public class frmTipoPaso implements Serializable{

    @EJB
    private TipoPasoFacadeLocal tipoPasoFacade;
    
    private List<TipoPaso> registro;
    private TipoPaso tipoPaso= new TipoPaso();
    
    

    /**
     * Creates a new instance of frmTipoPaso
     */
    public frmTipoPaso() {
    }
    
      @PostConstruct
    public void iniciarModelo(){
    try{
        this.registro=tipoPasoFacade.findAll();
    } catch(Exception ex){
    
    }
    }

    public TipoPasoFacadeLocal getTipoPasoFacade() {
        return tipoPasoFacade;
    }

    public void setTipoPasoFacade(TipoPasoFacadeLocal tipoPasoFacade) {
        this.tipoPasoFacade = tipoPasoFacade;
    }

    public List<TipoPaso> getRegistro() {
        return registro;
    }

    public void setRegistro(List<TipoPaso> registro) {
        this.registro = registro;
    }
    
    public String crear(){
            this.tipoPasoFacade.create(this.tipoPaso);
        this.tipoPaso=new TipoPaso();
        return "tipoPaso";

}
    public void borrar(TipoPaso tp){
        this.tipoPasoFacade.remove(tp);

}

    public String editar(TipoPaso tp) {

        this.tipoPaso= tp;
        return "Editar";
}
    public String Editar() {

        this.tipoPasoFacade.edit(this.tipoPaso);
        return "index";
}
    
    
    
    
}
