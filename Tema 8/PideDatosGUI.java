import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.toedter.calendar.JDateChooser;

public class PideDatosGUI extends JFrame implements ActionListener, ChangeListener{
    JRadioButton hombre, mujer;
    JCheckBox cine, baile, videojuegos; 
    ButtonGroup grupoBotones; 
    JLabel descripción, nombre, sexo, aficiones, titulo, edad, edadValor, fecha, hora;
    JTextField nombreCampo;
    JButton botonEjecutar;
    JSlider barraEdad;
    JDateChooser campoFecha;
    SpinnerDateModel modeloHora;
    JSpinner spinner;
    JSpinner.DateEditor editor;

    public PideDatosGUI() { 
        super("Mi Ventana"); 
        setSize(400,550);
        setLocationRelativeTo(null);
    } 

    public void creaVentana(){ //Vista
        getContentPane().setLayout(null); 

        //Colocamos el título principal
        titulo = new JLabel("Ventana de petición de datos");
        titulo.setBounds(100, 10, 200, 20);

        //Colocamos la petición de nombre
        nombre = new JLabel("Nombre: "); //Etiqueta para la caja del nombre
        nombre.setBounds(10, 45, 100, 10);
        nombreCampo = new JTextField(); //Caja del nombre
        nombreCampo.setBounds(100, 40, 250, 20);

        // Crear el selector de fecha
        fecha = new JLabel("Fecha de nacimiento: "); //Etiqueta para el selector de fecha
        fecha.setBounds(10, 80, 150, 10);
        campoFecha = new JDateChooser();
        campoFecha.setDateFormatString("dd/MM/yyyy HH:mm"); //Indicamos el formato de la fecha que saldrá en el selector 
        campoFecha.setBounds(180, 75, 200, 20);

        // Crear el selector de hora
        hora = new JLabel("Hora de nacimiento: "); //Etiqueta para el selector de hora
        hora.setBounds(10,120, 150, 10);
        modeloHora = new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE);
        spinner = new JSpinner(modeloHora);
        editor = new JSpinner.DateEditor(spinner, "HH:mm");
        spinner.setEditor(editor);
        spinner.setBounds(180, 115, 150, 20);


        // Creamos los radio buttons 
        sexo = new JLabel("Sexo: "); //Etiqueta para los Radio Button de Sexo
        sexo.setBounds(10, 150, 100, 10);
        mujer = new JRadioButton("Mujer");  //Radio Button para elegir Mujer
        hombre = new JRadioButton("Hombre"); //Radio Button para elgir Hombre
        hombre.setBounds(50, 180, 100, 20);
        mujer.setBounds(50, 210, 100, 20);
        // Creamos el grupo y asignamos los dos radio buttons a él 
        grupoBotones = new ButtonGroup(); 
        grupoBotones.add(mujer); 
        grupoBotones.add(hombre); 

        aficiones = new JLabel("Aficiones: ");//Etiqueta para los CheckBox de aficiones
        aficiones.setBounds(10, 250, 100, 10);
        //Creamos los checkBox
        videojuegos = new JCheckBox("Videojuegos"); //CheckBox de Videojuegos
        videojuegos.setBounds(50, 270, 100, 20);
        baile = new JCheckBox("Baile"); //CheckBox de Baile
        baile.setBounds(50, 300, 100, 20);
        cine = new JCheckBox("Cine"); //CheckBox de Cine
        cine.setBounds(50, 330, 100, 20);

        //Metemos la barra para la edad
        edad = new JLabel("Edad: "); //Etiqueta para la barra de edad
        edad.setBounds(10, 385, 100, 10);
        barraEdad=new JSlider(JSlider.HORIZONTAL,0,100,0); //Barra para elgir la edad
        barraEdad.setPaintLabels(true); 
        barraEdad.setPaintTicks(true); 
        barraEdad.setMajorTickSpacing(25); 
        barraEdad.setMinorTickSpacing(5); 
        barraEdad.addChangeListener(this); 
        barraEdad.setBounds(70, 365, 300, 50);
        edadValor = new JLabel("0"); //Etiqueta donde se va a ir escribiendo la edad elegida en ese instante
        edadValor.setBounds(370, 370, 25, 10);

        //Metemos el botón
        botonEjecutar= new JButton("Analiza datos"); 
        botonEjecutar.setBounds(120, 440, 150, 20);
        botonEjecutar.setActionCommand("botonEjecutar"); //Le pongo un nombre al evento
        botonEjecutar.addActionListener(this); //Añado el escuchador de eventos para eñ botón

        // Agregamos los elementos al panel y lo mostramos todo 
        getContentPane().add(titulo); 
        getContentPane().add(nombre);
        getContentPane().add(nombreCampo);
        getContentPane().add(fecha);
        getContentPane().add(campoFecha);
        getContentPane().add(hora);
        getContentPane().add(spinner);
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
        ventana.creaVentana();
        
        // 4. Hacer que la ventana sea visible
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) { //Controlador
        if (e.getActionCommand().equals("botonEjecutar")) {
            //Creamos la cadena que vamos a mostrar en la Dialog Box
            String salida = "";

            salida = "Hola " + nombreCampo.getText()+"\n"; //Añadimos el nombre

            //Añadimos la fecha de nacimiento y la hora que viene de JCalendar
            Date fechaNac = campoFecha.getDate();
            LocalDate fechaSeleccionada = fechaNac.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalTime horaDeFecha = fechaNac.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
            salida = salida + "Fecha: " + fechaSeleccionada.getDayOfMonth() + "/" + fechaSeleccionada.getMonthValue() + "/" + fechaSeleccionada.getYear() + " "+ horaDeFecha.getHour()+":"+horaDeFecha.getMinute() +"\n";

            //Añadimos la hora de nacimiento puesta en el Spinner
            Date horaNac = (Date) spinner.getValue();
            LocalTime horaLT = horaNac.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
            salida = salida + "Hora de nacimiento: " + horaLT.getHour()+":"+horaLT.getMinute()+"\n";


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