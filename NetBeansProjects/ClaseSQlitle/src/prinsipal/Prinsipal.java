/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prinsipal;

import administradorBD.AdministradorBD;

/**
 *
 * @author carlo
 */
public class Prinsipal {
    public static void main(String[] args) throws ClassNotFoundException{
        
        AdministradorBD addBD = new AdministradorBD();
        
        addBD.Crear();
        addBD.Ejecutar("INSER INTO CLIENTE(ID,NOMBRE,APELLIDO,EDAD) VALUES(1,JUANITO,MACANA,900)");
        addBD.mostrar();
        addBD.modificar();
        addBD.mostrar();
        
    }
}
