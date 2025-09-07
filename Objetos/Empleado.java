package Objetos;

public class Empleado {

    private String nombre;

    private String cedula;

    public Empleado(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public void setNombre(String pNombre)

    {
        nombre = pNombre;
    }

    public String getNombre()

    {
        return nombre;
    }

    public void setCedula(String pCedula)

    {
        cedula = pCedula;
    }

    public String getCedula()

    {
        return cedula;
    }

    public String toString()

    {
        return "Empleado : " + nombre + ", Cedula :" + cedula + "\n";
    }

    public static void main(String[] args) {
        Empleado empleado = new Empleado("Juan Perez", "1234567890");

        System.out.println(empleado.toString());
    }
}