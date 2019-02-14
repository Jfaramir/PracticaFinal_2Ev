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
            String url1 = "jdbc:mysql://localhost:3306/spotify?"
                    + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String password = "";
            
            conn1 =  DriverManager.getConnection(url1, user, password);
            
//            ResultSetMetaData metaDatos = rs.getMetaData();
            
            
            if (conn1 != null) {
                System.out.println("Conectado a spotify…");
                cadena_error = "Conectado a spotify…";
            } 
            
        } catch (SQLException ex) {
            System.out.println("ERROR: dirección o usuario/clave no válida");
            ex.printStackTrace();
            cadena_error = ex.toString();
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
    
    
    public void insertarDatos(String tabla, String Id, String nombre, String numero_canciones, String Anno_lanzamiento, String Id_artista){
        try {
            conn1.setAutoCommit(false);
            
            Statement sta = conn1.createStatement();

            sta.executeUpdate("INSERT INTO "+ tabla +" VALUES('"+ Id +"', '"+ nombre +"', '"+ numero_canciones +"', '"+ Anno_lanzamiento +"', '"+ Id_artista +"')");
            
            System.out.println("insertado guay");
            
            sta.close();
            
            conn1.commit();
            
            cadena_error = "Datos insertados correctamente";
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
    
     public void dropColumna(String tabla, String Id){
        try {
            conn1.setAutoCommit(false);
            
            Statement sta = conn1.createStatement();
        
            sta.executeUpdate("DELETE FROM "+ tabla +" where Id = '"+ Id +"' ");
            
            sta.close();
            
            conn1.commit();
            
            cadena_error = ("Has borrado la fila correctamente");
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
    
     public void ModificarDatos(String tabla, String Id, String nombre, String numero_canciones, String Anno_lanzamiento, String dat5, String Column1, String Column2, String Column3, String Column4, String Column5){
        try {
            conn1.setAutoCommit(false);
            
            Statement sta = conn1.createStatement();

            sta.executeUpdate("UPDATE "+ tabla +" SET "+Column1+ "='"+ Id +"', "+Column2+ " = '"+ nombre +"',"+Column3+ " = '"+ numero_canciones +"',"+Column4+ " = '"+ Anno_lanzamiento +"',"+Column5+ " = '"+ dat5 +"' WHERE  Id = '"+ Id +"'");
            
            sta.close();
            
            conn1.commit();
            
            cadena_error = "Modificado correctamente";
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
