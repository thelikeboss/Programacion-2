package Objetos;

import java.util.Scanner;

public class Computadora {

    private String serie;
    private String marca;
    private Empleado responsable = null;

    public Computadora(String pserie, String pmarca) {
        setSerie(pserie);
        setMarca(pmarca);
    }

    public void setSerie(String pSerie) {
        serie = pSerie;
    }

    public String getSerie() {
        return serie;
    }

    public void setMarca(String pMarca) {
        marca = pMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setResponsable(Empleado pResponsable) {
        responsable = pResponsable;
    }

    public Empleado getResponsable() {
        return responsable;
    }

    public String toString() {
        return "Computadora : " + marca + ", Serie : " + serie + "\n" +
               "\tResponsable : " + (responsable != null ? responsable.toString() : "Ninguno");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Datos de la computadora
        System.out.print("Ingrese la serie de la computadora: ");
        String serie = sc.nextLine();
        System.out.print("Ingrese la marca de la computadora: ");
        String marca = sc.nextLine();
        Computadora comp1 = new Computadora(serie, marca);

        // Datos del empleado
        System.out.print("Ingrese el nombre del responsable: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la cedula del responsable: ");
        String cedula = sc.nextLine();
        Empleado emp1 = new Empleado(nombre, cedula);

        comp1.setResponsable(emp1);

        System.out.println("\n" + comp1.toString());

        sc.close();
    }
}