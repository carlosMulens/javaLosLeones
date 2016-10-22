
package radio2;

import java.util.Scanner;

/**
 *
 * @author carlo #carlosmuulens@gmail.com
 */


    /**
     * @param args the command line arguments
     */
    
    class nodo {

    String tema;
    nodo siguiente;
    nodo anterior;

    nodo(String t) {

        this.tema = t;
        this.siguiente = null;
        this.anterior = null;
    }
}

public class Radio2 {

    nodo primero;
    nodo ultimo;

    Radio2() {
        primero = null;
        ultimo = null;
}
    Scanner leer = new Scanner(System.in);
    
    public Radio2 Punch() {
        
        System.out.println("ingresa el nombre del tema");
        nodo nuevo = new nodo(leer.nextLine());

        if (primero == null && ultimo == null) {

            primero = nuevo;
            ultimo = nuevo;
        } else {

            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
        return this;
    }
    
    public void imprimir() {
        nodo actual;
        actual = primero;
        
        System.out.println("imprimiendo");
        
        while (actual != null) {
            System.out.println("*"+actual.tema+"*");
            actual = actual.siguiente;
        }
    }

    public void reproducir() {
        nodo actual;
        actual = primero;
        while (actual != null) {
            
            System.out.println("*" + actual.tema + "*");
            System.out.println("1: siguiente");
            System.out.println("2: anterior");
            
            int opcion =leer.nextInt(); 
            
        switch (opcion) {
            case 1://SIGUIENTE
                     
                actual = actual.siguiente;
                break;
            case 2://ANTERIOR
                    
                 actual = actual.anterior;
                break;
            default:
                break;
            }
        }
    }
    
    
    
    public nodo ImprimirRR(nodo aux){
        
           if(aux != null){
               System.out.println("imprimiendo recurcivamente");
               System.out.println("*"+aux.tema+"*");
            return ImprimirRR(aux.siguiente);
        } 
           else{
            return null;
           }
    }
    
    public void delete(){
        
        primero = null;
        ultimo = null;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Radio2 motor = new Radio2();
            
        motor.Punch();
        motor.Punch();
        motor.Punch();
       //motor.ImprimirRR(motor.primero);
        motor.reproducir();
        motor.Punch();
        motor.Punch();
        motor.Punch();
        motor.ImprimirRR(motor.primero);
        motor.delete();
        motor.ImprimirRR(motor.primero);
        
    }
    
}
