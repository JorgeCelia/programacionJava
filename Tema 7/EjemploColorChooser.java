import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EjemploColorChooser extends JFrame implements ActionListener{

    private JButton boton;
    private JPanel panel;

    public EjemploColorChooser() {
        // Configuración básica de la ventana
        setTitle("Probando JColorChooser");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        boton = new JButton("Seleccionar Color");
        boton.addActionListener(this);

        panel.add(boton);
        add(panel);
    }
   public static void main(String[] args) {
        new EjemploColorChooser().setVisible(true);
    }
   
   @Override
   public void actionPerformed(ActionEvent e) {
       // Parámetros: Componente padre, Título, Color inicial
       Color colorSeleccionado = JColorChooser.showDialog(null, "Elige un color para el fondo", Color.LIGHT_GRAY);

        // Si el usuario no cancela, aplicamos el color
        if (colorSeleccionado != null) {
            panel.setBackground(colorSeleccionado);
        }
   }
}
