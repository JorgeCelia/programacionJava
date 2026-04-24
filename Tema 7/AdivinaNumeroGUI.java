import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AdivinaNumeroGUI {
    //Variable para contar el número intentos
    static int intentos = 0;

    public static void main(String[] args) {
        //Genero el número aleatorio que el usuario va a intentar adivinar
        final int objetivo=(int)(Math.random()*100+1);
        

        // 1. Crear el marco (la ventana principal)
        JFrame frame = new JFrame("Adivina un número");
        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        frame.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Creamos la etiqueta y la caja de texto para recoger la información
        JLabel label = new JLabel("Dime un número entre 1 y 100");
        JTextField numero = new JTextField(10);

        label.setBounds(110,10,200,30);
        numero.setBounds(175,40,50,30);


        // 3. Establecer el tamaño de la ventana (ancho, alto)
        frame.setSize(400, 200);
        frame.setResizable(false);
        
        // 5. Añadir la etiqueta a la ventana
        jp.add(label);
        jp.add(numero);

        //Añado los botones
        JButton botonAdivina = new JButton("Adivina"); 
        botonAdivina.setBounds(150, 100, 100, 20);

        jp.add(botonAdivina); 

        //Defino el evento cuando pulso el botón de OK
        JTextArea mensaje = new JTextArea("");
        botonAdivina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Esto es lo que ocurre cuando se pulsa el botón

                //Transformo a entero el valor que haya escrito en la caja de texto
                int valor = Integer.parseInt(numero.getText());

                //Incremento el contador
                intentos++;

                if (valor<objetivo) { //El usuario ha metido un número más pequeño
                    JOptionPane.showMessageDialog(frame, "El número que buscas es más grande");
                } else if (valor>objetivo) { //El usuario ha metido un número más grande
                    JOptionPane.showMessageDialog(frame, "El número que buscas es más pequeño");
                } else if (valor==objetivo) { //El usuario ha metido un número igual al buscado
                    JOptionPane.showMessageDialog(frame, "Has acertado\nNúmero de intentos: "+intentos);
                }

                
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