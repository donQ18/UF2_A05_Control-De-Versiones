/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control_de_versiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jukniz
 */
public class Controlador {
    private ArrayList<persona> listapersonas =new ArrayList<persona>();
   

    public Controlador() {
    }
    
  
    public boolean Insertar(persona person) {
       boolean ok=false;
         Connection conexion = null;
        Constantes constantes = new Constantes();
       int cambios=0;
        Statement sentencia = null;
       try{
            //cargar driver
            Class.forName("com.mysql.jdbc.Driver");

            //establecer la conexion con la bbdd
            conexion = DriverManager.getConnection(constantes.conexion, constantes.user, constantes.pass);

            sentencia = conexion.createStatement();
            cambios=sentencia.executeUpdate("Insert into personas values('"+person.getDNI()+"', '"+person.getNombre()+"', '"+person.getPrimer_Apellido()+"', '"+person.getSegundo_Apellido()+"', "+person.getEdad()+", '"+person.getSexo()+"');");
            if(cambios!=0){
                ok=true;
            }
        } catch (Exception t) {
            System.out.println(t);
         } finally {

            if (conexion != null) {
                try {
                    conexion.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
         
             if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
       return ok;
    }

    public ArrayList<persona> getListapersonas() {
        return listapersonas;
    }

    public void setListapersonas(ArrayList<persona> listapersonas) {
        this.listapersonas = listapersonas;
    }
    
}
