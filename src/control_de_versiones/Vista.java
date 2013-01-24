package control_de_versiones;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author donQ
 */
public class Vista extends JFrame implements ActionListener {

    JTextField Nombre = new JTextField();
    JTextField PrimerApellido = new JTextField();
    JTextField SegundoApellido = new JTextField();
    JTextField Edad = new JTextField();
    JTextField Sexo = new JTextField();
    JTextField DNI = new JTextField();
    JLabel Int_Nombre = new JLabel("Introduce Nombre");
    JLabel Int_PrimerApellido = new JLabel("Introduce primer Apellido");
    JLabel Int_SegundoApellido = new JLabel("Introduce segundo Apellido");
    JLabel Int_Edad = new JLabel("Introduce Edad");
    JLabel Int_Sexo = new JLabel("Introduce Sexo");
    JLabel Int_DNI = new JLabel("Introduce DNI");
    JLabel Titulo = new JLabel("Añadir Usuario", JLabel.CENTER);
    JButton buttonInsert = new JButton("Añadir");
    JPanel contenedor = new JPanel();

    Vista() {
        this.setSize(1024, 130);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        contenedor = new JPanel(new GridLayout(2, 6));

        contenedor.add(Int_Nombre);
        contenedor.add(Int_PrimerApellido);
        contenedor.add(Int_SegundoApellido);
        contenedor.add(Int_Edad);
        contenedor.add(Int_Sexo);
        contenedor.add(Int_DNI);

        contenedor.add(Nombre);
        contenedor.add(PrimerApellido);
        contenedor.add(SegundoApellido);
        contenedor.add(Edad);
        contenedor.add(Sexo);
        contenedor.add(DNI);

        add(contenedor, "Center");
        buttonInsert.addActionListener(this);
        add(buttonInsert, "South");
        add(Titulo, "North");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean ok=false;
        
        try{
        persona Persona = new persona(Nombre.getText(), PrimerApellido.getText(), SegundoApellido.getText(), Integer.parseInt(Edad.getText()), Sexo.getText(), DNI.getText());

        Controlador controlador = new Controlador();
        ok=controlador.Insertar(Persona);
        if(ok==true){
            Titulo.setText("Se ha insertado correctamente");
        }else{
            Titulo.setText("No se ha insertado correctamente");
        }
         }catch (Exception t){
             Titulo.setText("Faltan Campos para llenar");
        }
        
    }
}
