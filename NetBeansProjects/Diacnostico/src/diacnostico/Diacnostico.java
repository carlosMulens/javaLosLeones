/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diacnostico;

import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class Diacnostico {

    public boolean MayorMenorE(int edad){
        
        return edad > 18;
    }
    public boolean EsPar(int numero){
        
        numero = numero-2;
        if(numero <= 0){
            
            EsPar(numero);
            
        }
        
        return numero == 0;
    }
    public void Numeros(){
        
        for(int numero =0; numero <= 50; numero++){
            System.out.println(numero);  
        } 
    }
    public void Pares(){
        for(int numero =0; numero <= 50;numero = numero + 2){
            
            System.out.println(numero);
        }
    }
    public void Impares(){
        for(int numero =-1; numero <= 50;numero = numero + 2){
            
            System.out.println(numero);
        }
    }
    
    public void NumerosGrandes(){
        
        int numero = 30;
        do {   
            
            System.out.println(numero);
            numero--;
            
        } while (numero == -150);     
    }
    
    public void Multiplos(){
        int mul = 3;
        while(mul == 50){
            System.out.println(mul * 5);
            mul++;
        }
    }
    
    public void DiasSemana(int dia){
        switch(dia){
            case 1:
                System.out.println("lunes");
                break;
            case 2:
                System.out.println("martes");
                break;
            case 3:
                System.out.println("muercoles");
                break;
            case 4:
                System.out.println("jueves");
                break;
            case 5:
                System.out.println("viernes");
                break;
            case 6:
                System.out.println("savado");
                break;
            case 7:
                System.out.println("domingo");
                break;
            default:
                System.out.println("opcion no valida");
                break;    
    }
    }
    public void calculadora(int primero, int segundo){
        
        System.out.println("inserte la opcion que corresponde");
        System.out.println("1.- suma");
        System.out.println("2.- resta");
        System.out.println("3.- divicion");
        System.out.println("4.- multiplicacion");
        
        Scanner leer = new Scanner(System.in);
        
        switch(leer.nextInt()){
            case 1:
                System.out.println(primero + segundo);
                break;
            case 2:
                System.out.println(primero - segundo);
                break;
            case 3:
                System.out.println(primero * segundo);
                break;
            case 4:
                System.out.println(primero / segundo);
                break;
            default:
                System.out.println("opcion no valida");
                break;    
        }
    }
    
    public void Arre(){
        
        String arre[]= new String[10];
        Scanner leer = new Scanner(System.in);
        
        for(int cc = 0; cc <9; cc++){
            System.out.println("ingrese el nombre");
            
            arre[cc]= leer.nextLine();
        }
        for(int cc = 0; cc <9; cc++){
            System.out.println(arre[cc]);
        }
}
    
    public static void main(String[] args) {
        
        Diacnostico dis = new Diacnostico();
        /*
        //1
        if(dis.MayorMenorE(15)){
            System.out.println("eres mayor de edad");
        }else{
            System.out.println("NO eres mayor de edad");
        }
        //2
        if(dis.EsPar(10)){
            System.out.println("es par");
        }else{
            System.out.println("NO es par");
        }
        //3
        dis.Numeros();
        //4 
        dis.Impares();
        //5
        dis.Pares();
        //6

        dis.NumerosGrandes();*/
        //9
        //dis.Arre();
        Calculadora cal = new Calculadora();
        cal.setVisible(true);
        
    }
    
}
