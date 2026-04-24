import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OperacionesBasicasGUI {
    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        JFrame frame = new JFrame("Operaciones básicas");
        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        frame.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Creamos las etiqueta y cajas de texto para recoger la información
        JLabel label1 = new JLabel("Operando 1: ");
        JTextField numero1 = new JTextField(10);
        JLabel label2 = new JLabel("Operando 2: ");
        JTextField numero2 = new JTextField(10);

        label1.setBounds(10,10,90,30);
        numero1.setBounds(100,10,50,30);
        label2.setBounds(200,10,90,30);
        numero2.setBounds(290,10,50,30);


        // 3. Establecer el tamaño de la ventana (ancho, alto)
        frame.setSize(400, 400);
        frame.setResizable(false);
        
        // 5. Añadir la etiqueta a la ventana
        jp.add(label1);
        jp.add(numero1);
        jp.add(label2);
        jp.add(numero2);

        //Añado los botones
        JButton botonCalculo = new JButton("Calcula"); 
        botonCalculo.setBounds(150, 100, 100, 20);

        jp.add(botonCalculo); 

        //Defino el evento cuando pulso el botón de OK
        JLabel mensaje = new JLabel("");
        botonCalculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Esto es lo que ocurre cuando se pulsa el botón

                //Transformo a entero el valor que haya escrito en la caja de texto
                int valor1 = Integer.parseInt(numero1.getText());
                int valor2 = Integer.parseInt(numero2.getText());

                //Construyo en un String los resultados de las operaciones
                String tabla = "<html>";

                tabla += "Suma: "+(valor1+valor2)+"<br>"; 
                tabla += "Resta: "+(valor1-valor2)+"<br>"; 
                tabla += "Multiplicación: "+(valor1*valor2)+"<br>"; 
                tabla += "División: "+((double)valor1/valor2)+"<br>"; 
                
                tabla += "</html>";

                mensaje.setText(tabla);                
            }
        });

        mensaje.setBounds(100,150,200,250);
        jp.add(mensaje);


        // 6. Centrar la ventana en la pantalla del ordenador
        frame.setLocationRelativeTo(null);

        // 7. Hacer que la ventana sea visible
        frame.setVisible(true);
    }


}