
package practicaconeccion.PracticaConeccion;

import java.sql.*;
import java.util.Scanner;

public class Coneccion extends Cosas{

    Connection cnn = null;
    //contructor de la coneccion
    public Connection coneccion(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost/pruevas?user=root&password=");
            System.out.println("coneccion establesida");
        }
        catch(ClassNotFoundException | SQLException e){System.out.println(e.getMessage());}
        
        return cnn;
    }
    //ejecuta tambien u  update y un delete
    public int AgragarRegistro(String query){
        
        int afectadas= 0;
        
        try{
            
            //coneccion();
            Statement sentencia = cnn.createStatement();
            afectadas = sentencia.executeUpdate(query);
            
        }
        catch(Exception e){System.out.println(e.getMessage());}

        return afectadas;
    }
    
    public void mostrar(String query){
        
        
        try{
            Statement consulta = cnn.createStatement();
            ResultSet datos = consulta.executeQuery(query);
            
            while(datos.next()){
                System.out.println(datos.getString(1) +"  *  "+ datos.getString(2) +"  *   "+ datos.getString(3));
        }
  
        }
        catch(Exception e){System.out.println(e.getMessage());} 
    }
    
    
    
    public static void main(String[] args) {
        
        Coneccion motor = new Coneccion();
        //arrancar la coneccion
        motor.coneccion();
        //agregar dato
        if(motor.AgragarRegistro("insert into cosa(nombre, cosa, codigo) values('peludito', 'sepillo de dientes', '4');")>0)
            System.out.println("exito");
        //eliminar una fila
        if(motor.AgragarRegistro("delete from cosa where codigo = 4;")>0)
            System.out.println("exito");
        //modificar una fila
        if(motor.AgragarRegistro("update cosa set nombre = 'fetichino', cosa = 'pepino' where codigo = 1;")>0)
            System.out.println("exito");
        //mostrar todo
        System.out.println("nombre"+"    /    "+"cosa"+"    /    "+"codigo");
        motor.mostrar("select * from cosa;");
        //llenar objeto con exel y         
        
    }  
}
