/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author xp
 */
public class GestorConexion {
    Connection conn1; 
    String cadena_error = "";
   
    public GestorConexion() {
        conn1 = null;
        
        
        try {
            String url1 = "jdbc:mysql://localhost:3306/discografica?"
                    + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String password = "root";
            
            conn1 =  DriverManager.getConnection(url1, user, password);
            
//            ResultSetMetaData metaDatos = rs.getMetaData();
            
            
            if (conn1 != null) {
                System.out.println("Conectado a discográfica…");
            } 
            
        } catch (SQLException ex) {
            System.out.println("ERROR: dirección o usuario/clave no válida");
            ex.printStackTrace();
            cadena_error = ex.toString();
        }
    }   
    
    public void addColumna(String nombre){
        try {
            conn1.setAutoCommit(false);
            
            Statement sta = conn1.createStatement();
        
            sta.executeUpdate("ALTER TABLE album ADD "+ nombre +" VARCHAR(30)");

            sta.close();
            
            conn1.commit();
            
           System.out.println("has añadido una columna");
        } catch (Exception e) {
            System.out.println("Error");
            try {
                    if(conn1 != null){
                        conn1.rollback();
                    }
                } catch (Exception se2) {
                    se2.printStackTrace();
                    cadena_error = se2.toString();
                }
             e.printStackTrace();
             cadena_error = e.toString();
        }  
    }
    
    public void CerrarConexion(){
        try {
            conn1.close();
            System.out.println("Conexion cerrada");
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion");
            e.printStackTrace();
            cadena_error = e.toString();
        }
    }
    
    public void insertarDatosCancion(String id,String noombre, String duracioon, String letrass, String Id_Albuum){
        try {
            conn1.setAutoCommit(false);
            
            Statement sta = conn1.createStatement();

            sta.executeUpdate("INSERT INTO cancion VALUES('"+ id +"', '"+ noombre +"', '"+ duracioon +"', '"+ letrass +"', '"+ Id_Albuum +"')");

            System.out.println("insertado guay");
            
            sta.close();
            
            conn1.commit();
        } catch (Exception e) {
            System.out.println("Error");
               
            try {
                if(conn1 != null){
                    conn1.rollback();
                }
            } catch (Exception se2) {
                se2.printStackTrace();
                cadena_error = se2.toString();
            }
               
            e.printStackTrace();
            cadena_error = e.toString();
        }
    }
    public void insertarDatosAlbum(String idAlbum,String noombreAlbum, String AnoPublicacion){
        try {
            conn1.setAutoCommit(false);
            
            Statement sta = conn1.createStatement();

            sta.executeUpdate("INSERT INTO album VALUES('"+ idAlbum +"', '"+ noombreAlbum +"', '"+ AnoPublicacion +"')");
            
            System.out.println("insertado guay");
            
            sta.close();
            
            conn1.commit();
        } catch (Exception e) {
            System.out.println("Error");
               
            try {
                if(conn1 != null){
                    conn1.rollback();
                }
            } catch (Exception se2) {
                se2.printStackTrace();
                cadena_error = se2.toString();
            }
            e.printStackTrace();
            cadena_error = e.toString();
        }
    }
}
