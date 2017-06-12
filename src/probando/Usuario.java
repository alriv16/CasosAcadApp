/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probando;

/**
 *
 * @author edd
 */
public class Usuario {
 
    private String codigo;
    private String numero;
    private String columna;
   
 
    public Usuario(String codigo, String numero, String columna) {
        setCodigo(codigo);
        setNumero(numero);
        setColumna(columna);
        
}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

   
}