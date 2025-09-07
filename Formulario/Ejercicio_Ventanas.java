package Formulario;

import javax.swing.*; //
import java.awt.event.*;

public class Ejercicio_Ventanas extends JFrame {
    private JTextField nitField, nombreField, apellidoField, direccionField, telefonoField;
    private JLabel mensajeLabel;

    public Ejercicio_Ventanas() {
        setTitle("Formulario de Datos Personales");
        setSize(400, 300);
        setLocation(10, 10);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Nit
        JLabel nitLabel = new JLabel("Nit:");
        nitLabel.setBounds(20, 20, 80, 25);
        add(nitLabel);

        nitField = new JTextField();
        nitField.setBounds(120, 20, 200, 25);
        add(nitField);

        // Nombre
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(20, 50, 80, 25);
        add(nombreLabel);

        nombreField = new JTextField();
        nombreField.setBounds(120, 50, 200, 25);
        add(nombreField);

        // Apellido
        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoLabel.setBounds(20, 80, 80, 25);
        add(apellidoLabel);

        apellidoField = new JTextField();
        apellidoField.setBounds(120, 80, 200, 25);
        add(apellidoField);

        // Dirección
        JLabel direccionLabel = new JLabel("Dirección:");
        direccionLabel.setBounds(20, 110, 80, 25);
        add(direccionLabel);

        direccionField = new JTextField();
        direccionField.setBounds(120, 110, 200, 25);
        add(direccionField);

        // Teléfono
        JLabel telefonoLabel = new JLabel("Teléfono:");
        telefonoLabel.setBounds(20, 140, 80, 25);
        add(telefonoLabel);

        telefonoField = new JTextField();
        telefonoField.setBounds(120, 140, 200, 25);
        add(telefonoField);

        // Botón Aceptar
        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.setBounds(120, 180, 100, 30);
        add(aceptarButton);

        // Mensaje
        mensajeLabel = new JLabel("");
        mensajeLabel.setBounds(120, 220, 200, 25);
        add(mensajeLabel);

        // Acción del botón
        aceptarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nit = nitField.getText();
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                String direccion = direccionField.getText();
                String telefono = telefonoField.getText();

                System.out.println("Nit: " + nit);
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("Dirección: " + direccion);
                System.out.println("Teléfono: " + telefono);

                mensajeLabel.setText("Grabado");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejercicio_Ventanas();
    }
}