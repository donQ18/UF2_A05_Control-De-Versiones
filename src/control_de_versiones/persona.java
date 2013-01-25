/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control_de_versiones;

/**
 *
 * @author Jukniz
 */
public class persona {
     private String DNI="NULL";
    private String Nombre="NULL";
    private String Primer_Apellido="NULL";
    private String Segundo_Apellido="NULL";
    private int Edad=0;
    private String Sexo="NULL";
   

    public persona(String DNI, String Nombre, String Primer_Apellido, String Segundo_Apellido, int Edad, String Sexo) {
        this.Nombre = Nombre;
        this.Primer_Apellido = Primer_Apellido;
        this.Segundo_Apellido = Segundo_Apellido;
        this.Edad = Edad;
        this.Sexo = Sexo;
        this.DNI = DNI;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPrimer_Apellido() {
        return Primer_Apellido;
    }

    public void setPrimer_Apellido(String Primer_Apellido) {
        this.Primer_Apellido = Primer_Apellido;
    }

    public String getSegundo_Apellido() {
        return Segundo_Apellido;
    }

    public void setSegundo_Apellido(String Segundo_Apellido) {
        this.Segundo_Apellido = Segundo_Apellido;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }
}
