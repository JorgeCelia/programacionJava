import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TablaMultiplicarGUI {
    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        JFrame frame = new JFrame("Tablas de multiplicar");
        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        frame.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Creamos la etiqueta y la caja de texto para recoger la información
        JLabel label = new JLabel("Introduce un número: ");
        JTextField numero = new JTextField(10);

        label.setBounds(10,10,200,30);
        numero.setBounds(210,10,100,30);


        // 3. Establecer el tamaño de la ventana (ancho, alto)
        frame.setSize(400, 600);
        frame.setResizable(false);
        
        // 5. Añadir la etiqueta a la ventana
        jp.add(label);
        jp.add(numero);

        //Añado los botones
        JButton botonOk = new JButton("Aceptar"); 
        botonOk.setBounds(150, 100, 100, 20);

        jp.add(botonOk); 

        //Defino el evento cuando pulso el botón de OK
        JTextArea mensaje = new JTextArea("");
        botonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Esto es lo que ocurre cuando se pulsa el botón

                //Transformo a entero el valor que haya escrito en la caja de texto
                int valor = Integer.parseInt(numero.getText());

                //Construyo en un String su tabla de multiplicar
                String tabla = "";

                for (int i=1; i<=10; i++) {
                    tabla = tabla + valor+"x"+i+"="+(valor*i)+"\n";
                }

                mensaje.setText(tabla);
                
                //JOptionPane.showMessageDialog(frame, "¡Has pulsado el botón!");
            }
        });

        mensaje.setBounds(100,300,200,250);
        jp.add(mensaje);


        // 6. Centrar la ventana en la pantalla del ordenador
        frame.setLocationRelativeTo(null);

        // 7. Hacer que la ventana sea visible
        frame.setVisible(true);
    }


}