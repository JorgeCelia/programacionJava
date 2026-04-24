import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EjemploFileChooser extends JFrame implements ActionListener{

    private JButton boton;
    private JPanel panel;

    public EjemploFileChooser() {
        // Configuración básica de la ventana
        setTitle("Probando JFileChooser");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        boton = new JButton("Seleccionar Archivo");
        boton.addActionListener(this);

        panel.add(boton);
        add(panel);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser selector = new JFileChooser(); 

        int returnVal = selector.showOpenDialog(null); 

        if(returnVal == JFileChooser.APPROVE_OPTION) { 
            System.out.println("Se eligió el archivo " + selector.getSelectedFile().getName()); 
        }
   }
   public static void main(String[] args) {
        new EjemploFileChooser().setVisible(true);
    }
   
}
