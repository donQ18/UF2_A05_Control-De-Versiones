/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control_de_versiones;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablaPersonas extends JFrame{
     private JTable Tabla;
     public TablaPersonas(){
          int w;
    int h;
    int x;
    int y;
     this.setSize(1024, 600);
     this.setTitle("Tabla de Empleados");
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    
        w = this.getSize().width;
        h = this.getSize().height;
        x = (dim.width - w) / 2;
        y = (dim.height - h) / 2;
        this.setLocation(x, y);
        Controlador control = new Controlador();
        Tabla=control.getTabla();
        JPanel jp = new JPanel();
  
        JScrollPane JSP = new JScrollPane();
        JSP.setViewportView(Tabla);
        
        add(JSP);
        setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
     }
     
}
