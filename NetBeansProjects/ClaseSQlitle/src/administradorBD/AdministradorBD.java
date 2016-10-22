/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administradorBD;
import java.sql.*;
/**
 *
 * @author carlomulens@gmail.com
 */
public class AdministradorBD {
    
    Connection coneccion = null;
    Statement sentens = null;
    String url = "jdbc:sqlite:empresa.sqlite";
    String cadena = "org.sqlite.JDBC";
    
    public void Crear() throws ClassNotFoundException{
        
        try{
            Class.forName(cadena);
            coneccion =DriverManager.getConnection(url);
            sentens = coneccion.createStatement();
            String sql = "CREATE TABLE CLIENTE(ID INTEGER PRIMARY KEY NOT NULL, NOMBRE TEXT, APELLIDO TEXT, EDAD INTEGER)";
            sentens.executeUpdate(sql);
            sentens.close();
            coneccion.close();
        }catch(SQLException e){
            System.err.println("Error" + e);
            System.exit(0);
        }
    }
    
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
     public void modificar() throws ClassNotFoundException{
        try{
            Class.forName(cadena);
            coneccion = DriverManager.getConnection(url);
            coneccion.setAutoCommit(false);
            sentens = coneccion.createStatement();
            String sql = "UPDATE CLIENTE SET NOMBRE='POKEMON' WHERE ID=1";
            sentens.executeUpdate(sql);
            sentens.close();
            coneccion.commit();
            coneccion.close();
            
        }catch(SQLException e){
            System.out.printf("error"+e);
        }   
        }
     
     public void mostrar() throws ClassNotFoundException{
        
        try{
            Class.forName(cadena);
            coneccion = DriverManager.getConnection(url);
            sentens = coneccion.createStatement();
            String sql = "SELECT * FROM CLIENTE";
            ResultSet resultado = sentens.executeQuery(sql);
            while(resultado.next()){
                
                int id = resultado.getInt("ID");
                String nombre = resultado.getString("NOMBRE");
                String apellido = resultado.getString("APELLIDO");
                int edad = resultado.getInt("EDAD");
                
               System.out.println("id       :"+id+
                                  "Nombre   :"+nombre+
                                  "Apellido :"+apellido+
                                  "Edad     :"+edad);
               System.out.println("---");                
            }
            sentens.close();
            coneccion.close();
            resultado.close();
        }catch(SQLException e){
            System.out.printf("error"+e);
        }   
        }
    
}

