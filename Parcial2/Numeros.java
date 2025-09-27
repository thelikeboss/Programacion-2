
package Parcial2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Numeros {
    public static void main(String[] args) {
        // Solicitar la cantidad de números a ingresar
        String input = JOptionPane.showInputDialog("Ingrese la cantidad de números a capturar:");
        int cantidadNumeros = Integer.parseInt(input);

        // Crear un ArrayList para almacenar los números
        ArrayList<Integer> numeros = new ArrayList<>();

        // Capturar los números ingresados por el usuario
        for (int i = 0; i < cantidadNumeros; i++) {
            boolean valido = false;
            while (!valido) {
                String numeroInput = JOptionPane.showInputDialog("Ingrese el número " + (i + 1) + ":");
                try {
                    int numero = Integer.parseInt(numeroInput);
                    numeros.add(numero);
                    valido = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Solo se permiten números enteros. Intente de nuevo.");
                }
            }
        }

        // Calcular la suma y el promedio de los números capturados
        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        double promedio = (double) suma / cantidadNumeros;

        // Menú de opciones para el usuario
        boolean continuar = true;
        while (continuar) {
            String[] opciones = {
                    "Ver suma",
                    "Ver promedio",
                    "Ver todos los números",
                    "Ver cantidad de números que superan el promedio",
                    "Salir"
            };
            int eleccion = JOptionPane.showOptionDialog(
                    null,
                    "¿Qué desea hacer?",
                    "Opciones                                Christopher Aaron Landaverry Argueta 9960-23-1691",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (eleccion) {
                case 0: // Ver suma
                    JOptionPane.showMessageDialog(null, "La suma de los números es: " + suma);
                    break;
                case 1: // Ver promedio
                    JOptionPane.showMessageDialog(null, "El promedio de los números es: " + promedio);
                    break;
                case 2: // Ver todos los números
                    StringBuilder sb = new StringBuilder("Números ingresados:\n");
                    for (int num : numeros) {
                        sb.append(num).append(", ");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                    break;
                case 3: // Ver cantidad de números que superan el promedio
                    int contador = 0;
                    for (int num : numeros) {
                        if (num > promedio) {
                            contador++;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Cantidad de números que superan el promedio: " + contador);
                    break;

                default: // Salir o cerrar ventana
                    continuar = false;
                    break;
            }
        }
    }
}