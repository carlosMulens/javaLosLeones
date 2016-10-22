package radio;

import java.util.Scanner;

class nodo {
    
    String tema;
    nodo siguiente;
    nodo anterior;

    nodo(String REF) {
        
        this.tema = REF;
        this.siguiente = null;
        this.anterior = null;
    }
}
public class Radio {

    nodo primero;
    nodo ultimo;

    Radio() {
        primero = null;
        ultimo = null;
    }
    
    Scanner leer = new Scanner(System.in);
    
    public Radio punch(){
        
        System.out.println("ingresa el nombre del tema");
        nodo nuevo = new nodo(leer.nextLine());
        
        if(primero == null && ultimo == null){
            primero = nuevo;
            ultimo = nuevo;
        }
        else{
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
        return this;
    }   
    
    nodo lista;
    
    public void Retroseder(){
        
        lista = primero;
        
    }   
    
    public void delete(){
        
        primero = null;
        ultimo = null;
        
        System.out.println("la pila esta basia");
    }
    
    public void reproducir(){
                
        if(primero == null){
            
            System.out.println("*" + primero.tema + "*");
            System.out.println("1: siguiente");
            System.out.println("2: anterior");
                
                int opcion =leer.nextInt();
            
            switch (opcion) { 
                case 1://SIGUIENTE
                     
                    primero = primero.siguiente;
                    reproducir();
                    break;
                case 2://ANTERIOR
                    
                    primero = primero.anterior;
                    reproducir();
                    break;
                default:
                    Retroseder();
                    break;
                    
            } 
        }
        else{
            System.out.println("*fin*");
            Retroseder();
        }         
    }
    
    public void imprimir() {
        
        
        
        if(primero != null){
            
        System.out.println("*" + lista.tema + "*");    
        primero = lista.siguiente;
        
        imprimir();
        }
        else{
            System.out.println("fin");
            Retroseder();
        }
    }

    
    
    public static void main(String[] args) {
                
        Radio motor = new Radio();
        
        motor.punch();
        motor.punch();
        motor.punch();
        //motor.reproducir();
        motor.imprimir();
        /*motor.punch();
        motor.punch();
        motor.punch();
        motor.imprimir();
        motor.delete(); 
        motor.imprimir();
        */
    }
}
