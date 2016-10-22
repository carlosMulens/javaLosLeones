/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;

/**
 *
 * @author carlo carlosmulens@gmail.com
 */




public class Coneccion {
    Connection coneccion = null;
    Statement sentens = null;
    String url = "jdbc:sqlite:empresa.sqlite";
    String cadena = "org.sqlite.JDBC";
    
    
    //creacion
    
    public void Crear() throws ClassNotFoundException{
        
        try{
            Class.forName(cadena);
            coneccion =DriverManager.getConnection(url);
            sentens = coneccion.createStatement();
            String sql = "CREATE TABLE PRODUCTOS(CODIGO INTEGER PRIMARY KEY NOT NULL, STOCK INTEGER,PRESIO INTEGER, NOMBRE TEXT)";
            sentens.executeUpdate(sql);
            sentens.close();
            coneccion.close();
            
            System.out.println("EXITO");
        }catch(SQLException e){
            System.err.println("Error" + e);
            System.exit(0);
        }
    }
    
    
    //Metodo de crear; este metodo unserta, modifica y elimina campos segun la 'query'
    public void Ejecutar(String query) throws ClassNotFoundException{
        try{
            Class.forName(cadena);
            coneccion = DriverManager.getConnection(url);
            coneccion.setAutoCommit(false);
            sentens = coneccion.createStatement();
            String sql = query;
    //"INSER INTO CLIENTE(ID,NOMBRE,APELLIDO,EDAD) VALUES(1,JUANITO,MACANA,900)";
            sentens.executeUpdate(sql);
            sentens.close();
            coneccion.commit();
            coneccion.close();
            
        }catch(SQLException e){
            System.out.printf("error"+e);
        }   
    }
    
    public void MostrarComsola() throws ClassNotFoundException{
        
        try{
            Class.forName(cadena);
            coneccion = DriverManager.getConnection(url);
            sentens = coneccion.createStatement();
            String sql = "SELECT * FROM PRODUCTOS";
            ResultSet resultado = sentens.executeQuery(sql);
            while(resultado.next()){
                
                String codigo = resultado.getString("CODIGO");
                String stock = resultado.getString("STOCK");
                String precio = resultado.getString("PRESIO");
                String nombre = resultado.getString("NOMBRE");
                
               System.out.println("CODIGO :"+codigo+
                                  "STOCK  :"+stock+
                                  "PRECI  :"+precio+
                                  "NOMBRE :"+nombre);
               System.out.println("---");                
            }
            sentens.close();
            coneccion.close();
            resultado.close();
        }catch(SQLException e){
            System.out.printf("error"+e);
        } 
    }
    
    public ResultSet Extraer(String query)throws ClassNotFoundException{
     
        ResultSet resultado = null;
        try{
        Class.forName(cadena);
            coneccion = DriverManager.getConnection(url);
            sentens = coneccion.createStatement();
            
             resultado = sentens.executeQuery(query);
    }catch(SQLException e){
            System.out.printf("error"+e);
        }
    return resultado;
    }
}
    
   

