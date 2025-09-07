package proyecto1;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

public class SistemaInventario {
    private List<Producto> productos;
    private int nextId;

    public SistemaInventario() {
        this.productos = new ArrayList<>();
        this.nextId = 1;
    }

    // Agregar producto
    public boolean agregarProducto(String nombre, String descripcion, double precio,
            int stock, String categoria) {
        if (buscarProductoPorNombre(nombre) != null) {
            System.out.println("Error: Ya existe un producto con ese nombre.");
            return false;
        }

        Producto nuevoProducto = new Producto(nextId++, nombre, descripcion, precio, stock, categoria);
        productos.add(nuevoProducto);
        System.out.println("Producto agregado exitosamente: " + nombre);
        return true;
    }

    // Eliminar producto
    public boolean eliminarProducto(int id) {
        Producto producto = buscarProductoPorId(id);
        if (producto != null) {
            productos.remove(producto);
            System.out.println("Producto eliminado: " + producto.getNombre());
            return true;
        }
        System.out.println("Error: Producto no encontrado.");
        return false;
    }

    // Modificar producto
    public boolean modificarProducto(int id, String nuevoNombre, String nuevaDescripcion,
            double nuevoPrecio, int nuevoStock, String nuevaCategoria) {
        Producto producto = buscarProductoPorId(id);
        if (producto != null) {
            producto.setNombre(nuevoNombre);
            producto.setDescripcion(nuevaDescripcion);
            producto.setPrecio(nuevoPrecio);
            producto.setStock(nuevoStock);
            producto.setCategoria(nuevaCategoria);
            System.out.println("Producto modificado exitosamente.");
            return true;
        }
        System.out.println("Error: Producto no encontrado.");
        return false;
    }

    // Consultar disponibilidad
    public void consultarDisponibilidad(String nombre) {
        Producto producto = buscarProductoPorNombre(nombre);
        if (producto != null) {
            System.out.println("Disponibilidad de " + producto.getNombre() + ":");
            System.out.println("Stock actual: " + producto.getStock());
            System.out.println("Precio: $" + producto.getPrecio());
            if (producto.getStock() == 0) {
                System.out.println("PRODUCTO AGOTADO");
            } else if (producto.getStock() <= 5) {
                System.out.println("STOCK BAJO");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Generar reportes estadísticos
    public void generarReportes() {
        System.out.println("\n=== REPORTE ESTADÍSTICO DEL INVENTARIO ===");

        // Total de productos
        System.out.println("Total de productos: " + productos.size());

        // Valor total del inventario
        double valorTotal = productos.stream()
                .mapToDouble(p -> p.getPrecio() * p.getStock())
                .sum();
        System.out.println("Valor total del inventario: $" + String.format("%.2f", valorTotal));

        // Productos con stock bajo
        List<Producto> stockBajo = productos.stream()
                .filter(p -> p.getStock() < 5)
                .toList();
        System.out.println("Productos con stock bajo (" + stockBajo.size() + "):");
        stockBajo.forEach(p -> System.out.println("  - " + p.getNombre() + " (Stock: " + p.getStock() + ")"));

        // Productos agotados
        List<Producto> agotados = productos.stream()
                .filter(p -> p.getStock() == 0)
                .toList();
        System.out.println("Productos agotados (" + agotados.size() + "):");
        agotados.forEach(p -> System.out.println("  - " + p.getNombre()));

        // Productos por categoría
        Map<String, Long> productosPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.counting()));

        System.out.println("Productos por categoría:");
        productosPorCategoria.forEach(
                (categoria, cantidad) -> System.out.println("  - " + categoria + ": " + cantidad + " productos"));
    }

    // Listar todos los productos
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        }

        System.out.println("\n=== LISTA DE PRODUCTOS ===");
        productos.forEach(System.out::println);
    }

    // Buscar producto por ID
    public Producto buscarProductoPorId(int id) {
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Buscar producto por nombre
    public Producto buscarProductoPorNombre(String nombre) {
        return productos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    // Buscar productos por categoría
    public List<Producto> buscarProductosPorCategoria(String categoria) {
        return productos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }

    // Actualizar stock
    public boolean actualizarStock(int id, int cantidad) {
        Producto producto = buscarProductoPorId(id);
        if (producto != null) {
            int nuevoStock = producto.getStock() + cantidad;
            if (nuevoStock >= 0) {
                producto.setStock(nuevoStock);
                System.out.println("Stock actualizado: " + producto.getNombre() +
                        " - Nuevo stock: " + nuevoStock);
                return true;
            } else {
                System.out.println("Error: No se puede tener stock negativo.");
            }
        }
        return false;
    }
}