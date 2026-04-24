import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PideDatosGUI extends JFrame implements ActionListener, ChangeListener{
    JRadioButton hombre, mujer;
    JCheckBox cine, baile, videojuegos; 
    ButtonGroup grupoBotones; 
    JLabel descripción, nombre, sexo, aficiones, titulo, edad, edadValor;
    JTextField nombreCampo;
    JButton botonEjecutar;
    JSlider barraEdad; 

    public PideDatosGUI() { 
        super("Mi Ventana"); 
        setSize(400,450);
        setLocationRelativeTo(null);
    } 

    public void VentanaCasillaAct(){ //Vista
        getContentPane().setLayout(null); 

        //Colocamos el título principal
        titulo = new JLabel("Ventana de petición de datos");
        titulo.setBounds(100, 10, 200, 10);

        //Colocamos la petición de nombre
        nombre = new JLabel("Nombre: "); //Etiqueta para la caja del nombre
        nombre.setBounds(10, 55, 100, 10);
        nombreCampo = new JTextField(); //Caja del nombre
        nombreCampo.setBounds(100, 50, 200, 20);
        
        // Creamos los radio buttons 
        sexo = new JLabel("Sexo: "); //Etiqueta para los Radio Button de Sexo
        sexo.setBounds(10, 100, 100, 10);
        mujer = new JRadioButton("Mujer");  //Radio Button para elegir Mujer
        hombre = new JRadioButton("Hombre"); //Radio Button para elgir Hombre
        hombre.setBounds(50, 130, 100, 20);
        mujer.setBounds(50, 160, 100, 20);
        // Creamos el grupo y asignamos los dos radio buttons a él 
        grupoBotones = new ButtonGroup(); 
        grupoBotones.add(mujer); 
        grupoBotones.add(hombre); 

        aficiones = new JLabel("Aficiones: ");//Etiqueta para los CheckBox de aficiones
        aficiones.setBounds(10, 200, 100, 10);
        //Creamos los checkBox
        videojuegos = new JCheckBox("Videojuegos"); //CheckBox de Videojuegos
        videojuegos.setBounds(50, 220, 100, 20);
        baile = new JCheckBox("Baile"); //CheckBox de Baile
        baile.setBounds(50, 250, 100, 20);
        cine = new JCheckBox("Cine"); //CheckBox de Cine
        cine.setBounds(50, 280, 100, 20);

        //Metemos la barra para la edad
        edad = new JLabel("Edad: "); //Etiqueta para la barra de edad
        edad.setBounds(10, 335, 100, 10);
        barraEdad=new JSlider(JSlider.HORIZONTAL,0,100,0); //Barra para elgir la edad
        barraEdad.setPaintLabels(true); 
        barraEdad.setPaintTicks(true); 
        barraEdad.setMajorTickSpacing(25); 
        barraEdad.setMinorTickSpacing(5); 
        barraEdad.addChangeListener(this); 
        barraEdad.setBounds(70, 315, 300, 50);
        edadValor = new JLabel("0"); //Etiqueta donde se va a ir escribiendo la edad elegida en ese instante
        edadValor.setBounds(370, 320, 25, 10);

        //Metemos el botón
        botonEjecutar= new JButton("Analiza datos"); 
        botonEjecutar.setBounds(120, 370, 150, 20);
        botonEjecutar.setActionCommand("botonEjecutar"); //Le pongo un nombre al evento
        botonEjecutar.addActionListener(this); //Añado el escuchador de eventos para eñ botón

        // Agregamos los elementos al panel y lo mostramos todo 
        getContentPane().add(titulo); 
        getContentPane().add(nombre);
        getContentPane().add(nombreCampo);
        getContentPane().add(sexo);
        getContentPane().add(hombre); 
        getContentPane().add(mujer); 

        getContentPane().add(aficiones); 
        getContentPane().add(videojuegos); 
        getContentPane().add(baile); 
        getContentPane().add(cine);

        getContentPane().add(edad);
        getContentPane().add(barraEdad);
        getContentPane().add(edadValor);

        getContentPane().add(botonEjecutar);

        setVisible(true);  
    } 

    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        PideDatosGUI ventana = new PideDatosGUI();
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
        if (e.getActionCommand().equals("botonEjecutar")) {
            //Creamos la cadena que vamos a mostrar en la Dialog Box
            String salida = "";

            salida = "Hola " + nombreCampo.getText()+"\n"; //Añadimos el nombre
            //Añadimos el sexo
            if (hombre.isSelected()) {
                salida = salida + "Eres un hombre\n";
            } else {
                salida = salida + "Eres una mujer\n";
            }
            //Añadimos las aficiones
            salida = salida + "Tus aficiones son: ";
            if (cine.isSelected()) { 
                salida = salida + "cine ";
            }
            if (baile.isSelected()) { 
                salida = salida + "baile ";
            }
            if (videojuegos.isSelected()) { 
                salida = salida + "videojuegos ";
            }

            salida = salida + "\n";
            //Añadimos la edad
            salida = salida + "Tienes "+barraEdad.getValue()+" años";

            JOptionPane.showMessageDialog(this, salida);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        edadValor.setText(""+((JSlider)e.getSource()).getValue()+""); 
    }
}