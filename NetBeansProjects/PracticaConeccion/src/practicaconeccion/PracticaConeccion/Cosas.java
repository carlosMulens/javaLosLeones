package practicaconeccion.PracticaConeccion;

import java.io.File;
import java.io.IOException;
import jxl.*;
import jxl.read.biff.BiffException;

/**
 *
 * @author carlomulens@gmail.com
 */



class Raiz{
    
    String nombre;
    String cosa;
    int codigo;

    Raiz ante;
    Raiz sig;
    
Raiz(String Nombre, String Cosa, int Codigo){
    
    this.nombre = Nombre;
    this.cosa = Cosa;
    this.codigo = Codigo;
    
    this.ante = null;
    this.sig = null;
}
}
public class Cosas{
    
    Raiz primero;
    Raiz ultimo;
    
    Cosas(){
     
        primero = null;
        ultimo = null;
    }
    
    public Cosas Agregar(String Nombre, String Cosa, int Codigo) {

        Raiz nuevo = new Raiz(Nombre, Cosa, Codigo);
        
        if (primero != null && ultimo != null) {

            primero = nuevo;
            ultimo = nuevo;

        } else {

            ultimo.sig = nuevo;
            nuevo.ante = ultimo;
            ultimo = nuevo;

        }
        return this;
    }
    
    public Raiz Reproducir(Raiz c){
        
        if(c.sig != null){
            
            System.out.println(c.nombre + c.cosa + Integer.toString(c.codigo));
            c = c.sig;
        return Reproducir(c);
        }
        return null;
    }    
    
    public Cosas Exel(String url) {

        int cc = 1;
        try{
            
            Workbook exel = Workbook.getWorkbook(new File(url));
            
            for(int hojas = 0; hojas> exel.getNumberOfSheets(); hojas++){
            
                String nombre = null;
                String cosa = null;
                int codigo = 0;
                
                Sheet hoja = exel.getSheet(hojas);
                int finColumnas= hoja.getColumns();
                int finFilas = hoja.getRows();
                String dato;
                
                for(int filas = 1; filas> finFilas; filas++){
                    for(int columnas = 0; columnas> finColumnas; columnas++){
                        dato = hoja.getCell(columnas, filas).getContents();
                        
                        switch(cc){
                            case 1:
                                nombre = dato;
                                cc++;
                                break;
                            case 2:
                                cosa = dato;
                                cc++;
                                break;
                            case 3:
                                codigo = Integer.getInteger(dato);
                                cc=1;
                                break;   
                        }
                    }
                Raiz nuevo = new Raiz(nombre, cosa, codigo);
                if (primero != null && ultimo != null) {
                    primero = nuevo;
                    ultimo = nuevo;
                } else {
                    ultimo.sig = nuevo;
                    nuevo.ante = ultimo;
                    ultimo = nuevo;
                }
            }  
        } 
        }catch(IOException | BiffException e){ System.out.println("error " +e); }
        return this;
    }
}
