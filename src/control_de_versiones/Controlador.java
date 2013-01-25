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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jukniz
 */
public class Controlador {
    private ArrayList<persona> listapersonas =new ArrayList<persona>();
   private JTable Tabla = new JTable();
   

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
    
    public JTable getTabla(){
         Tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"DNI","Nombre","Primer_Apellido","Segundo_Apellido", "Edad", "Sexo"}
                ));
         CargarArraylist();
        LlenarTabla();
         Tabla.setEnabled(false);
        Tabla.getTableHeader().setEnabled(false);
        return Tabla;
    }
    
    public void CargarArraylist(){
         Connection conexion = null;
        Constantes constantes = new Constantes();
        Statement sentencia = null;
        boolean conectado = false;
        ResultSet result = null;
       

        try {
            //cargar driver
            Class.forName(constantes.driver);

            //establecer la conexion con la bbdd
            conexion = DriverManager.getConnection(constantes.conexion, constantes.user, constantes.pass);

            conectado = true;
        } catch (Exception e) {
            System.out.println(e);
        }

        if (conectado) {
            try {
                sentencia = conexion.createStatement();
                result = sentencia.executeQuery("Select * from personas");
                while (result.next()) {
                    persona Persona = new persona(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5), result.getString(6));
                    listapersonas.add(Persona);
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {

                if (conexion != null) {
                    try {
                        conexion.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                if (result != null) {
                    try {
                        result.close();
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
        }
    }
    
      public void LlenarTabla() {
        
           
        DefaultTableModel modeloTabla=(DefaultTableModel) Tabla.getModel();
        modeloTabla.setNumRows(0);
               

        for(persona apuntador : listapersonas){
            Object[] row ={apuntador.getDNI(), apuntador.getNombre(), apuntador.getPrimer_Apellido(), apuntador.getSegundo_Apellido(), apuntador.getEdad(), apuntador.getSexo()};
            modeloTabla.addRow(row);
        }
        Tabla.updateUI();
    }

 
    
}
