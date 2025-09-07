package Objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Factura {
    private String numero;
    private String cliente;
    private Fecha fecha;
    private ArrayList<Producto> productos;

    public Factura(String numero, String cliente, Fecha fecha) {
        this.numero = numero;
        this.cliente = cliente;
        this.fecha = fecha;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getTotal();
        }
        return total;
    }

    public void mostrarFactura() {
        System.out.println("Factura N°: " + numero);
        System.out.println("Cliente: " + cliente);
        System.out.println("Fecha: " + fecha);
        System.out.println("--------------------------------------------------");
        System.out.println("Cod\tDescripcion\tCant\tPrecio\tTotal");
        for (Producto p : productos) {
            System.out.println(p);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Total: " + calcularTotal());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numero, cliente;
        int dia, mes, anio;
        // Registrar datos de la factura 
        System.out.print("Ingrese el número de factura: ");
        numero = sc.nextLine();
        System.out.print("Ingrese el nombre del cliente: ");
        cliente = sc.nextLine();
        System.out.print("Ingrese el día: ");
        dia = sc.nextInt();
        System.out.print("Ingrese el mes: ");
        mes = sc.nextInt();
        System.out.print("Ingrese el año: ");
        anio = sc.nextInt();
        sc.nextLine(); 

        Fecha fecha = new Fecha(dia, mes, anio);
        Factura factura = new Factura(numero, cliente, fecha);

        String continuar;
        do {
            String codigo, descripcion;
            int cantidad;
            double precio;
            System.out.print("Ingrese código del producto: ");
            codigo = sc.nextLine();
            System.out.print("Ingrese descripción: ");
            descripcion = sc.nextLine();
            System.out.print("Ingrese cantidad: ");
            cantidad = sc.nextInt();
            System.out.print("Ingrese precio: ");
            precio = sc.nextDouble();
            sc.nextLine(); 

            Producto producto = new Producto(codigo, descripcion, cantidad, precio);
            factura.agregarProducto(producto);

            System.out.print("¿Desea agregar otro producto? (s/n): ");
           continuar = sc.nextLine().toLowerCase();
        } while (continuar.equalsIgnoreCase("s"));

        // Mostrar factura
        System.out.println("\n===== FACTURA =====");
        factura.mostrarFactura();

        sc.close();
    }
}
