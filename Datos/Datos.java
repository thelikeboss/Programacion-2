package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;

public class Datos {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB = "gestion_tareas";
    private static final String USER = "root";
    private static final String PASS = "Mibenjamin1";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL + DB, USER, PASS);
             Statement stmt = conn.createStatement();
             Scanner scanner = new Scanner(System.in)) {

            // Crear tablas
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS usuarios (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "nombre VARCHAR(50) NOT NULL," +
                    "email VARCHAR(100) UNIQUE NOT NULL)");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS proyectos (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "nombre VARCHAR(100) NOT NULL)");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS tareas (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "descripcion VARCHAR(255) NOT NULL," +
                    "usuario_id INT," +
                    "proyecto_id INT," +
                    "FOREIGN KEY (usuario_id) REFERENCES usuarios(id)," +
                    "FOREIGN KEY (proyecto_id) REFERENCES proyectos(id))");

            // Menú con validaciones
            while (true) {
                System.out.println("\n1. Agregar usuario");
                System.out.println("2. Eliminar usuario");
                System.out.println("3. Mostrar usuarios");
                System.out.println("4. Salir");
                System.out.print("Elige una opción: ");
                String opcionStr = scanner.nextLine();
                int opcion;
                try {
                    opcion = Integer.parseInt(opcionStr);
                } catch (NumberFormatException e) {
                    System.out.println("Opción inválida. Debe ser un número.");
                    continue;
                }

                if (opcion == 1) {
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine().trim();
                    if (nombre.isEmpty()) {
                        System.out.println("El nombre no puede estar vacío.");
                        continue;
                    }
                    System.out.print("Email: ");
                    String email = scanner.nextLine().trim();
                    if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
                        System.out.println("Email inválido.");
                        continue;
                    }
                    // Validar email único
                    ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM usuarios WHERE email = '" + email + "'");
                    rs.next();
                    if (rs.getInt(1) > 0) {
                        System.out.println("El email ya está registrado.");
                        continue;
                    }
                    try {
                        stmt.executeUpdate("INSERT INTO usuarios (nombre, email) VALUES ('" + nombre + "', '" + email + "')");
                        System.out.println("Usuario agregado.");
                    } catch (SQLException e) {
                        System.out.println("Error al agregar usuario: " + e.getMessage());
                    }
                } else if (opcion == 2) {
                    System.out.print("ID del usuario a eliminar: ");
                    String idStr = scanner.nextLine();
                    int id;
                    try {
                        id = Integer.parseInt(idStr);
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido.");
                        continue;
                    }
                    // Validar existencia del usuario
                    ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM usuarios WHERE id = " + id);
                    rs.next();
                    if (rs.getInt(1) == 0) {
                        System.out.println("Usuario no encontrado.");
                        continue;
                    }
                    try {
                        int filas = stmt.executeUpdate("DELETE FROM usuarios WHERE id = " + id);
                        if (filas > 0) {
                            System.out.println("Usuario eliminado.");
                        } else {
                            System.out.println("No se pudo eliminar el usuario.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al eliminar usuario: " + e.getMessage());
                    }
                } else if (opcion == 3) {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");
                    System.out.println("Usuarios:");
                    boolean hayUsuarios = false;
                    while (rs.next()) {
                        hayUsuarios = true;
                        System.out.println(rs.getInt("id") + ": " + rs.getString("nombre") + " - " + rs.getString("email"));
                    }
                    if (!hayUsuarios) {
                        System.out.println("No hay usuarios registrados.");
                    }
                } else if (opcion == 4) {
                    break;
                } else {
                    System.out.println("Opción inválida.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

