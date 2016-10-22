/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author carlo carlosmulens@gmail.com
 */
public class GestionDB {
    String usuario="root";
    String baseDatos="empresa";
    String contrsena="12345";
    String url="jdbc:mysql://localhost:3306";
    Connection coneccion;
    Statement sentencia;
    PreparedStatement preSentencia=null;
    ResultSet resultado=null;
public void Conectar(){
    try{        
        Class.forName("com.mysql.jdbc.Driver");
        coneccion = DriverManager.getConnection(url,usuario,contrsena);
        sentencia = coneccion.createStatement();       
    }catch(Exception e){
        System.err.println("ERROR: "+e);
    }
    System.out.println("coneccion realisada con exito");
}
public void insertar(String nombre,String apellido){
    String sql="INSERT INTO CLIENTE(NOMBRE,APELLIDO)VALUES('"+nombre+"','"+apellido+"')";
    try{
        Conectar();
        sentencia.executeUpdate(sql);
        sentencia.close();
        coneccion.close();
        System.out.println("insercion realisada con exito");
    }catch(Exception e){
        System.err.println("ERROR AL insertar"+e);
        System.out.println("error");
    }   
}
public void Leer(){
    String sql = "SELECT * FROM EMPLEADOS";
    
    try{
        Conectar();
        preSentencia=coneccion.prepareCall(sql);
        resultado= preSentencia.executeQuery();
        System.out.println("datos extraidos correctamente");
            while(resultado.next()){
            System.out.println(resultado.getString("ID"));
            System.out.println(resultado.getString("NOMBRE"));
            System.out.println(resultado.getString("APELLIDO"));   
            }
            System.out.println("los datos se mostraron correctamente");
            resultado.close();
            preSentencia.close();
            coneccion.close();
            System.out.println("la coneccion a sido serrada correctamente");
    }catch(Exception e){
        System.err.println("NO SE PUDO MOSTRAR EL RESULTADO"+e);
    } 
}
}