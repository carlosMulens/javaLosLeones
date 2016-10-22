/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
/**
 *
 * @author CarlosMulens carlosmulens@gmail.com
 */
public class Productos {
    String codigo;
    String stock;
    String presio;
    String nombre;
    public JTable jt;
    
    
    Coneccion cnn= new Coneccion();
    
    public boolean InsertarProducto(String cod,String st,String pre, String nom){
        
        try{
            
            codigo= cod;
            stock=st;
            presio=pre;
            nombre=nom;
            String query = "INSERT INTO PRODUCTOS(CODIGO,STOCK,PRESIO,NOMBRE) VALUES("+codigo+","+stock+","+ presio +",'"+nombre+"')";
            
            cnn.Ejecutar(query);
            return true;   
        }catch(Exception e){
            System.out.println("error en insertar productos"+e);
            return false;
        }
    }
    
        public boolean Eliminar(String cod){
        
        try{
            
            codigo= cod;

            String query = "DELETE FROM PRODUCTOS WHERE CODIGO == "+codigo+"";
            
            cnn.Ejecutar(query);
            return true;   
        }catch(Exception e){
            System.out.println("error en eliminar"+e);
            return false;
        }
    }
        public boolean modificar(String caso,String codigo, String nuevobalor){
            String query;
            boolean eje;
            try{
                switch (caso) {
 
        case "stock":
            stock =nuevobalor;
            query ="UPDATE PRODUCTOS SET STOCK="+stock+" WHERE CODIGO="+codigo+"";
            cnn.Ejecutar(query);
            eje = true;
        break;
 
        case "presio":
            presio =nuevobalor;
            query ="UPDATE PRODUCTOS SET PRESIO="+presio+" WHERE CODIGO="+codigo+"";
            cnn.Ejecutar(query);
            eje=true;
        break;
        
        case "nombre":
            nombre = nuevobalor;
            query ="UPDATE PRODUCTOS SET NOMBRE='"+nombre+"' WHERE CODIGO="+codigo+"";
            cnn.Ejecutar(query);
            eje=true;
        break;
        default:
        //sentencias;
            eje=false;
        break;   
    }      
       
    }catch(Exception e){
        System.out.println("error en modificar"+e);
        eje=false;
        }
            return eje;
    }  
        
    public JTable BuscarTodoProductos(JTable tabla) throws SQLException{
        //"SELECT * FROM PRODUCTOS" - "SELECT * FROM PRODUCTOS"
        //modificacion
        //1-modelo de columnas
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO");
        modelo.addColumn("STOCK");
        modelo.addColumn("CODIGO");
        //2-llenar nuevas filas
        String defaulColum[] = new String[4];

        try {
            ResultSet resultado = cnn.Extraer("SELECT * FROM PRODUCTOS");
            
            int index=0;
            while(resultado.next()){
                defaulColum[0]= resultado.getString("NOMBRE");
                defaulColum[1]= resultado.getString("PRESIO");
                defaulColum[2]= resultado.getString("STOCK");
                defaulColum[3]= resultado.getString("CODIGO");
                
                modelo.addRow(defaulColum);
                
                index++;
            }
        //3-asignar modelo a la tabla
        tabla.setModel(modelo);
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tabla;
    }    
    
        public JTable BuscarCodigoProductos(JTable tabla, String codigo) throws SQLException{
        
         //modificacion
        //1-modelo de columnas
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO");
        modelo.addColumn("STOCK");
        modelo.addColumn("CODIGO");
        //2-llenar nuevas filas
        String defaulColum[] = new String[4];

        try {
            ResultSet resultado = cnn.Extraer("SELECT * FROM PRODUCTOS WHERE CODIGO == "+codigo+"");
            
                defaulColum[0]= resultado.getString("NOMBRE");
                defaulColum[1]= resultado.getString("PRESIO");
                defaulColum[2]= resultado.getString("STOCK");
                defaulColum[3]= resultado.getString("CODIGO");
                
                modelo.addRow(defaulColum);

        //3-asignar modelo a la tabla
        tabla.setModel(modelo);
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tabla;
    }
        
        public JTable BuscarNombreProductos(JTable tabla, String nombre) throws SQLException{
        
         //modificacion
        //1-modelo de columnas
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO");
        modelo.addColumn("STOCK");
        modelo.addColumn("CODIGO");
        //2-llenar nuevas filas
        String defaulColum[] = new String[4];

        try {
            ResultSet resultado = cnn.Extraer("SELECT * FROM PRODUCTOS WHERE NOMBRE == '"+nombre+"'");
            
                int index=0;
            while(resultado.next()){
                defaulColum[0]= resultado.getString("NOMBRE");
                defaulColum[1]= resultado.getString("PRESIO");
                defaulColum[2]= resultado.getString("STOCK");
                defaulColum[3]= resultado.getString("CODIGO");
                
                modelo.addRow(defaulColum);
                
                index++;
            }

        //3-asignar modelo a la tabla
        tabla.setModel(modelo);
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tabla;
    }
        
    public JTable BuscarPrecioProductos(JTable tabla, String precio) throws SQLException{
        
         //modificacion
        //1-modelo de columnas
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO");
        modelo.addColumn("STOCK");
        modelo.addColumn("CODIGO");
        //2-llenar nuevas filas
        String defaulColum[] = new String[4];

        try {
            ResultSet resultado = cnn.Extraer("SELECT * FROM PRODUCTOS WHERE PRESIO == "+precio+"");
            
                int index=0;
            while(resultado.next()){
                defaulColum[0]= resultado.getString("NOMBRE");
                defaulColum[1]= resultado.getString("PRESIO");
                defaulColum[2]= resultado.getString("STOCK");
                defaulColum[3]= resultado.getString("CODIGO");
                
                modelo.addRow(defaulColum);
                
                index++;
            }

        //3-asignar modelo a la tabla
        tabla.setModel(modelo);
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tabla;
    }
    
    public JTable BuscarStockProductos(JTable tabla, String stock) throws SQLException{
        
         //modificacion
        //1-modelo de columnas
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO");
        modelo.addColumn("STOCK");
        modelo.addColumn("CODIGO");
        //2-llenar nuevas filas
        String defaulColum[] = new String[4];

        try {
            ResultSet resultado = cnn.Extraer("SELECT * FROM PRODUCTOS WHERE STOCK == "+stock+"");
            
                int index=0;
            while(resultado.next()){
                defaulColum[0]= resultado.getString("NOMBRE");
                defaulColum[1]= resultado.getString("PRESIO");
                defaulColum[2]= resultado.getString("STOCK");
                defaulColum[3]= resultado.getString("CODIGO");
                
                modelo.addRow(defaulColum);
                
                index++;
            }

        //3-asignar modelo a la tabla
        tabla.setModel(modelo);
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tabla;
    }
        
    
}