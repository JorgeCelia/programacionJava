import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CancionesGUI extends JFrame implements ActionListener, ChangeListener{
    JRadioButton sopNO, sopSI;
    ButtonGroup grupoBotones; 
    JLabel descripción, title, interprete, genero, sopFisico, aficiones, titulo, duracion, duracionValor;
    JTextField titleCampo, interpreteCampo;
    JButton botonEjecutar;
    JSlider barraDuracion; 
    String[] valores = {"Pop","Rock","Heavy","Techno","Reggaeton","K-Pop"};
    JComboBox <String> generos=new JComboBox<String>(valores); 

    public CancionesGUI() { 
        super("Mis Canciones"); 
        setSize(400,400);
        setLocationRelativeTo(null);
    } 

    public void CreaVentana(){ //Vista
        getContentPane().setLayout(null); 

        //Colocamos el título principal
        titulo = new JLabel("Ventana de petición de datos de canciones");
        titulo.setBounds(100, 10, 200, 10);

        //Colocamos la petición de título
        title = new JLabel("Título: "); //Etiqueta para la caja del título
        title.setBounds(10, 55, 100, 20);
        titleCampo = new JTextField(); //Caja del título
        titleCampo.setBounds(100, 50, 250, 20);
        
        //Colocamos la petición de intérprete
        interprete = new JLabel("Intérprete: "); //Etiqueta para la caja del intérprete
        interprete.setBounds(10, 85, 100, 20);
        interpreteCampo = new JTextField(); //Caja del intérprete
        interpreteCampo.setBounds(100, 80, 250, 20);

        //Metemos la barra para la duración
        duracion = new JLabel("Duración: "); //Etiqueta para la barra de duración
        duracion.setBounds(10, 115, 100, 20);
        barraDuracion=new JSlider(JSlider.HORIZONTAL,0,300,0); //Barra para elgir la duración
        barraDuracion.setPaintLabels(true); 
        barraDuracion.setPaintTicks(true); 
        barraDuracion.setMajorTickSpacing(60); 
        barraDuracion.setMinorTickSpacing(25); 
        barraDuracion.addChangeListener(this); 
        barraDuracion.setBounds(20, 140, 340, 50);
        duracionValor = new JLabel("0"); //Etiqueta donde se va a ir escribiendo la edad elegida en ese instante
        duracionValor.setBounds(360, 145, 35, 10);

        //Metemos la lista para elegir el género de las canciones
        genero = new JLabel("Género: "); //Etiqueta para elegir el género de la canción
        genero.setBounds(10, 200, 100, 25);
        generos.setMaximumRowCount(5); 
        generos.setBounds(110, 200, 100, 25);

        // Creamos los radio buttons 
        sopFisico = new JLabel("Soporte Físico: "); //Etiqueta para los Radio Button del sosporte físico
        sopFisico.setBounds(10, 240, 100, 20);
        sopSI = new JRadioButton("Sí");  //Radio Button para elegir Sí 
        sopNO = new JRadioButton("No"); //Radio Button para elegir No
        sopSI.setBounds(50, 270, 100, 20);
        sopNO.setBounds(50, 290, 100, 20);
        // Creamos el grupo y asignamos los dos radio buttons a él 
        grupoBotones = new ButtonGroup(); 
        grupoBotones.add(sopSI); 
        grupoBotones.add(sopNO); 

        //Metemos el botón
        botonEjecutar= new JButton("Muestra Canción"); 
        botonEjecutar.setBounds(120, 340, 150, 20);
        botonEjecutar.setActionCommand("botonEjecutar"); //Le pongo un nombre al evento
        botonEjecutar.addActionListener(this); //Añado el escuchador de eventos para eñ botón

        // Agregamos los elementos al panel y lo mostramos todo 
        getContentPane().add(titulo); 
        getContentPane().add(title);
        getContentPane().add(titleCampo);
        getContentPane().add(interprete);
        getContentPane().add(interpreteCampo);

        getContentPane().add(duracion);
        getContentPane().add(barraDuracion);
        getContentPane().add(duracionValor);

        getContentPane().add(genero);
        getContentPane().add(generos);

        getContentPane().add(sopFisico);
        getContentPane().add(sopSI); 
        getContentPane().add(sopNO); 

        getContentPane().add(botonEjecutar);

        setVisible(true);  
    } 

    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        CancionesGUI ventana = new CancionesGUI();
        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        ventana.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Creamos una nueva ventana con los elementos definidos más arriba
        ventana.CreaVentana();
        
        // 4. Hacer que la ventana sea visible
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) { //Controlador
        if (e.getActionCommand().equals("botonEjecutar")) {
            //Creamos la cadena que vamos a mostrar en la Dialog Box
            String salida = "";

            salida = salida + "Título: " + titleCampo.getText()+"\n"; //Añadimos el título
            salida = salida + "Intérprete: " + interpreteCampo.getText()+"\n"; //Añadimos el intérprete
            
            salida = salida + "Duración: " + duracionValor.getText()+"\n"; //Añadimos la duración

            //Añadimos el género
            salida = salida + "Género: "+ (String)generos.getSelectedItem()+"\n";

            if (sopNO.isSelected()) {
                salida = salida + "En formato electrónico\n";
            } else {
                salida = salida + "En formato físico\n";
            }

            JOptionPane.showMessageDialog(this, salida);
        }
    }

    //Método que transforma segundos a minutos:segundos
    public String segundosAMinSeg(int segundos) {
        String resultado;

        if ((segundos%60)<10) { //añadimos un 0 si hay mennos de 10 segundos
            resultado = (segundos/60)+":0"+(segundos%60);
        } else {
            resultado = (segundos/60)+":"+(segundos%60);
        }


        return resultado;
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        int segundos = ((JSlider)e.getSource()).getValue();
        duracionValor.setText(segundosAMinSeg(segundos)); 
    }
}