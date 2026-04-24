import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class GeneraTexto extends JFrame implements ActionListener{
    JTextArea texto;
    JLabel titulo, privacidad;
    JRadioButton privado, publico;
    ButtonGroup grupoBotones; 
    JButton botonEjecutar;
    

    public GeneraTexto() { 
        super("Generador de textos"); 
        setSize(400,450);
        setLocationRelativeTo(null);
    } 

    public void VentanaCasillaAct(){ //Vista
        getContentPane().setLayout(null); 

        //Colocamos el título principal
        titulo = new JLabel("Introduce el texto que has creado");
        titulo.setBounds(100, 10, 200, 10);
        getContentPane().add(titulo); 

        //Ponemos el área de texto
        texto = new JTextArea();
        texto.setBounds(10, 35, 380, 250);
        getContentPane().add(texto); 

        //Colocamos la petición del tipo de privacidad
        privacidad = new JLabel("Privacidad: "); //Etiqueta para elegir la privacidad
        privacidad.setBounds(10, 300, 70, 20);
        getContentPane().add(privacidad);
        
        // Creamos los radio buttons 
        privado = new JRadioButton("Privado");  //Radio Button para elegir privado
        publico = new JRadioButton("Público"); //Radio Button para elgir público
        privado.setBounds(50, 330, 100, 20);
        publico.setBounds(250, 330, 100, 20);
        // Creamos el grupo y asignamos los dos radio buttons a él 
        grupoBotones = new ButtonGroup(); 
        grupoBotones.add(publico); 
        grupoBotones.add(privado); 
        getContentPane().add(privado); 
        getContentPane().add(publico); 

        //Metemos el botón
        botonEjecutar= new JButton("Generar Resultado"); 
        botonEjecutar.setBounds(120, 370, 150, 20);
        botonEjecutar.setActionCommand("botonGenerar"); //Le pongo un nombre al evento
        botonEjecutar.addActionListener(this); //Añado el escuchador de eventos para eñ botón
        getContentPane().add(botonEjecutar);

        setVisible(true);  
    } 

    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        GeneraTexto ventana = new GeneraTexto();
        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        ventana.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Creamos una nueva ventana con los elementos definidos más arriba
        ventana.VentanaCasillaAct();
        
        // 4. Hacer que la ventana sea visible
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) { //Controlador
        if (e.getActionCommand().equals("botonGenerar")) {
            //Compruebo si ha elegido público o privado
            if (publico.isSelected()) { //Ha elegido público
                JOptionPane.showMessageDialog(this, texto.getText());
            } else if (privado.isSelected()) { //Ha elegido privado
                //Escribo el fichero
                try {
                        //Creo el escritor del fichero
                        FileWriter escritor = new FileWriter("privado.txt");

                        escritor.write(texto.getText());

                        //Cierro el fichero
                        escritor.close();                       
                        JOptionPane.showMessageDialog(this, "Archivo privado.txt generado correctamente");
                    } catch (IOException error) {
                        System.out.println("Error al abrir el fichero "+error.getMessage());
                    }

            } else { //No hay nada elegido
                JOptionPane.showMessageDialog(this, "ERROR: Debes elegir si quieres que el texto sea público o privado");
            }
        }
    }
}