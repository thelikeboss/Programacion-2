package Calculo_del_precio_de_un_producto;
/*
Objetivo: Desarrollar un programa en Java que permita calcular el precio total de venta de un producto aplicando el IVA, a partir de ingresar el precio unitario y cantidad de unidades.
Contenidos: Variables, entrada/salida de datos, operaciones matemáticas, impresión por pantalla. 
*/

import java.util.Scanner;// Importar la clase Scanner para la entrada de datos 

// Clase principal del programa
public class CálculoDelPrecioDeVentaDeUnProductoIncluyendoIVA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        do {
            // Solicitar el precio unitario del producto
            System.out.print("Ingrese el precio unitario del producto: ");
            double precioUnitario = scanner.nextDouble();

            // Solicitar la cantidad de unidades
            System.out.print("Ingrese la cantidad de unidades: ");
            int cantidadUnidades = scanner.nextInt();

            // Calcular el subtotal
            double subtotal = precioUnitario * cantidadUnidades;

            // Definir el IVA (21% en este caso)
            double iva = 0.21;

            // Calcular el total incluyendo IVA
            double totalConIVA = subtotal * (1 + iva);

            // Mostrar el resultado
            System.out.printf("El precio total de venta del producto, incluyendo IVA, es: %.2f%n", totalConIVA);

            // preguntar al usuario si desea realizar otro cálculo
            System.out.print("¿Desea realizar otro cálculo? (s/n): ");
            scanner.nextLine(); // Limpiar el buffer
            continuar = scanner.nextLine().toLowerCase();
        } while (continuar.equals("s") || continuar.equals("si"));
        
        // Cerrar el scanner
        scanner.close();
    }
}
// Fin del programa2