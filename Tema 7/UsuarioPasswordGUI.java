import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UsuarioPasswordGUI {

    public void actionPerformed(ActionEvent e){ 
        if (e.getActionCommand().equals("pulsaOk")==true){ 
            System.out.println("Se pulsó Aceptar"); 
        }
    }

    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        JFrame frame = new JFrame("Mi Primera Ventana");
        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        frame.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Creamos la etiqueta para usuario        
        JLabel labelUsuario = new JLabel("Usuario: ");
        JTextField usuario = new JTextField(10);

        labelUsuario.setBounds(10,10,100,30);
        usuario.setBounds(110,10,100,30);

        //Creamos la etiqueta para la clave
        JLabel labelPassword = new JLabel("Clave: ");
        JPasswordField clave = new JPasswordField(10);
        labelPassword.setBounds(10,50,100,30);
        clave.setBounds(110,50,100,30);

        // 3. Establecer el tamaño de la ventana (ancho, alto)
        frame.setSize(400, 400);
        frame.setResizable(false);

        
        // 5. Añadir la etiqueta a la ventana
        jp.add(labelUsuario);
        jp.add(usuario);
        jp.add(labelPassword);
        jp.add(clave);

        //Añado los botones
        JButton botonOk = new JButton("Aceptar"); 
        JButton botonCancel = new JButton("Cancelar"); 
        botonOk.setBounds(50, 150, 100, 20);
        botonCancel.setBounds(250, 150, 100, 20);

        //Defino el evento cuando pulso el botón de OK
        JLabel mensaje = new JLabel("");
        botonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Esto es lo que ocurre cuando se pulsa el botón
                mensaje.setText("¡El botón ha sido pulsado con éxito!");
                
                //JOptionPane.showMessageDialog(frame, "¡Has pulsado el botón!");
            }
        });
        botonOk.setActionCommand("pulsaOk"); 


        jp.add(botonOk); 
        jp.add(botonCancel);

        mensaje.setBounds(100,300,200,50);
        jp.add(mensaje);


        // 6. Centrar la ventana en la pantalla del ordenador
        frame.setLocationRelativeTo(null);

        // 7. Hacer que la ventana sea visible
        frame.setVisible(true);
    }


}