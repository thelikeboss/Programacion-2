package proyecto1;

import java.util.List;
import java.util.Scanner;

public class inv {
    public static void main(String[] args) {
        SistemaInventario inventario = new SistemaInventario();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Agregar algunos productos de ejemplo
        inventario.agregarProducto("Laptop HP", "Laptop 15 pulgadas, 8GB RAM", 899.99, 10, "Tecnologia");
        inventario.agregarProducto("Mouse Inalámbrico", "Mouse óptico inalámbrico", 25.50, 50, "Tecnologia");
        inventario.agregarProducto("Silla Oficina", "Silla ergonómica para oficina", 199.99, 3, "Muebles");
        inventario.agregarProducto("Monitor 24\"", "Monitor LED 24 pulgadas", 299.99, 0, "Tecnoloiía");

        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarProducto(inventario, scanner);
                    break;
                case 2:
                    eliminarProducto(inventario, scanner);
                    break;
                case 3:
                    modificarProducto(inventario, scanner);
                    break;
                case 4:
                    consultarDisponibilidad(inventario, scanner);
                    break;
                case 5:
                    listarProductos(inventario);
                    break;
                case 6:
                    actualizarStock(inventario, scanner);
                    break;
                case 7:
                    inventario.generarReportes();
                    break;
                case 8:
                    buscarPorCategoria(inventario, scanner);
                    break;
                case 9:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
            System.out.println("\nPresione Enter para continuar...");
            scanner.nextLine();
        } while (opcion != 9);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE INVENTARIO ===");
        System.out.println("1. Agregar producto");
        System.out.println("2. Eliminar producto");
        System.out.println("3. Modificar producto");
        System.out.println("4. Consultar disponibilidad");
        System.out.println("5. Listar todos los productos");
        System.out.println("6. Actualizar stock");
        System.out.println("7. Generar reportes estadísticos");
        System.out.println("8. Buscar por categoría");
        System.out.println("9. Salir");
    }

    private static void agregarProducto(SistemaInventario inventario, Scanner scanner) {
        System.out.println("\n--- AGREGAR PRODUCTO ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Stock inicial: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Categoría: ");
        String categoria = scanner.nextLine();

        inventario.agregarProducto(nombre, descripcion, precio, stock, categoria);
    }

    private static void eliminarProducto(SistemaInventario inventario, Scanner scanner) {
        System.out.println("\n--- ELIMINAR PRODUCTO ---");
        System.out.print("ID del producto a eliminar: ");
        int id = scanner.nextInt();
        inventario.eliminarProducto(id);
    }

    private static void modificarProducto(SistemaInventario inventario, Scanner scanner) {
        System.out.println("\n--- MODIFICAR PRODUCTO ---");
        System.out.print("ID del producto a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nueva descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Nuevo precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Nuevo stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Nueva categoría: ");
        String categoria = scanner.nextLine();

        inventario.modificarProducto(id, nombre, descripcion, precio, stock, categoria);
    }

    private static void consultarDisponibilidad(SistemaInventario inventario, Scanner scanner) {
        System.out.println("\n--- CONSULTAR DISPONIBILIDAD ---");
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        inventario.consultarDisponibilidad(nombre);
    }

    private static void listarProductos(SistemaInventario inventario) {
        inventario.listarProductos();
    }

    private static void actualizarStock(SistemaInventario inventario, Scanner scanner) {
        System.out.println("\n--- ACTUALIZAR STOCK ---");
        System.out.print("ID del producto: ");
        int id = scanner.nextInt();
        System.out.print("Cantidad a agregar/restar (use negativo para restar): ");
        int cantidad = scanner.nextInt();
        inventario.actualizarStock(id, cantidad);
    }

    private static void buscarPorCategoria(SistemaInventario inventario, Scanner scanner) {
        System.out.println("\n--- BUSCAR POR CATEGORiA ---");
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();
        
        List<Producto> productos = inventario.buscarProductosPorCategoria(categoria);
        if (productos.isEmpty()) {
            System.out.println("No se encontraron productos en la categoria: " + categoria);
        } else {
            System.out.println("Productos en la categoria '" + categoria + "':");
            productos.forEach(System.out::println);
        }
    }
}