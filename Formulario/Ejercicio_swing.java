package Formulario;
import javax.swing.JFrame;

public class Ejercicio_swing extends JFrame {
    public Ejercicio_swing() {
        setTitle("Formulario de Ejemplo"); // Título descriptivo
        setSize(400, 300); // Tamaño de la ventana
        setLocation(10, 10); // Ubicación en la pantalla
        setLayout(null); // Sin layout 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    public static void main(String[] args) {
        Ejercicio_swing ventana = new Ejercicio_swing();
        ventana.setVisible(true); // Hacer visible
    }
}