package arreglos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ventana extends JFrame {
    private JTextField nombreField, edadField, salarioField;
    private JTextArea listadoArea;
    private ArrayList<Persona> personas;

    public ventana() {
        setTitle("Captura de Personas");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        personas = new ArrayList<>();

        add(new JLabel("Nombre:"));
        nombreField = new JTextField(20);
        add(nombreField);

        add(new JLabel("Edad:"));
        edadField = new JTextField(5);
        add(edadField);

        add(new JLabel("Salario:"));
        salarioField = new JTextField(10);
        add(salarioField);

        JButton agregarBtn = new JButton("Agregar");
        add(agregarBtn);

        JButton mostrarBtn = new JButton("Mostrar Listado");
        add(mostrarBtn);

        listadoArea = new JTextArea(10, 30);
        listadoArea.setEditable(false);
        add(new JScrollPane(listadoArea));

        agregarBtn.addActionListener(e -> agregarPersona());
        mostrarBtn.addActionListener(e -> mostrarListado());
    }

    private void agregarPersona() {
        String nombre = nombreField.getText();
        int edad;
        double salario;
        try {
            edad = Integer.parseInt(edadField.getText());
            salario = Double.parseDouble(salarioField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Edad o salario inválido.");
            return;
        }
        personas.add(new Persona(nombre, edad, salario));
        nombreField.setText("");
        edadField.setText("");
        salarioField.setText("");
    }

    private void mostrarListado() {
        StringBuilder sb = new StringBuilder();
        for (Persona p : personas) {
            sb.append("Nombre: ").append(p.nombre)
              .append(", Edad: ").append(p.edad)
              .append(", Salario: ").append(p.salario)
              .append("\n");
        }
        listadoArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ventana().setVisible(true));
    }
}

class Persona {
    String nombre;
    int edad;
    double salario;

    public Persona(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }
}
