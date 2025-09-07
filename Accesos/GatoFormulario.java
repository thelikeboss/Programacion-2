package Accesos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GatoFormulario extends JFrame {
    private JTextField patasField;
    private JTextField ojosField;
    private JButton crearButton;
    private JButton clonarButton;
    private Gato miGato;

    public GatoFormulario() {
        setTitle("Formulario Gato");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 180);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.add(new JLabel("Número de patas:"));
        patasField = new JTextField();
        panel.add(patasField);

        panel.add(new JLabel("Número de ojos:"));
        ojosField = new JTextField();
        panel.add(ojosField);

        crearButton = new JButton("Crear Gato");
        clonarButton = new JButton("Clonar Gato");
        clonarButton.setEnabled(false); // Solo se habilita si hay un gato creado

        panel.add(crearButton);
        panel.add(clonarButton);

        add(panel);

        crearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int patas = Integer.parseInt(patasField.getText());
                    int ojos = Integer.parseInt(ojosField.getText());

                    if (patas <= 0 || ojos <= 0) {
                        throw new IllegalArgumentException("Debe ingresar números válidos mayores a cero.");
                    }

                    miGato = new Gato(patas, ojos);
                    String mensaje = miGato.habla() +
                            "\nPatas: " + miGato.getPatas() +
                            "\nOjos: " + miGato.getOjos();

                    JOptionPane.showMessageDialog(GatoFormulario.this, mensaje);
                    clonarButton.setEnabled(true);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(GatoFormulario.this, "Debe ingresar números válidos.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(GatoFormulario.this, ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clonarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (miGato != null) {
                        Gato clonGato = miGato.clone();
                        String mensaje = "Gato clonado:\n" +
                                clonGato.habla() +
                                "\nPatas: " + clonGato.getPatas() +
                                "\nOjos: " + clonGato.getOjos();
                        JOptionPane.showMessageDialog(GatoFormulario.this, mensaje);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(GatoFormulario.this, "Error al clonar el gato: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GatoFormulario().setVisible(true);
        });
    }
}