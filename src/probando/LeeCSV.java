/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probando;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import com.csvreader.CsvReader;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class LeeCSV {
 
    public static void main(String[] args) throws IOException {
     try{
        List<Usuario> usuarios = new ArrayList<Usuario>();
        CsvReader usuarios_import = new CsvReader("/home/edd/NetBeansProjects/probando/src/probando/solicitudesTPI135_2017.csv");
        usuarios_import.readHeaders();
         try {
             while (usuarios_import.readRecord())
             {
                 String codigo = usuarios_import.get(0);
                String numero = usuarios_import.get(1);
                 String columna = usuarios_import.get(2);
                 
                 
                 usuarios.add(new Usuario(codigo, numero, columna));
             }} catch (IOException ex) {
             Logger.getLogger(LeeCSV.class.getName()).log(Level.SEVERE, null, ex);
         }
        usuarios_import.close();
        for(Usuario us : usuarios){
         
            System.out.println(us.getCodigo() + "|" + us.getNumero()+ "| "
                    + us.getColumna() + " - " );
        }
    }
    catch (FileNotFoundException e) 
    {e.printStackTrace();} 
}}