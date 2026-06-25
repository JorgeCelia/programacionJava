import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;

public class GestionNuevaReparacion extends JFrame implements ActionListener{

    JPanel jp;
    ReparacionesDAO gestor; //Objeto para acceder a la BD

    JTextField campoDNI, campoNombre, campoPrecio, campoHoras;
    JLabel etiquetaDNI, etiquetaNombre, etiquetaPrecio, etiquetaFecha, etiquetaHoras, etiquetaTipo;
    JButton botonInsertar;
    JDateChooser campoFecha;

    ButtonGroup grupoBotones; 
    JRadioButton movil, ordenador;
    String[] valoresMovil = {"Pantalla","Batería","Conectividad"};
    String[] valoresOrdenador = {"Sin Limpieza Interna","Con Limpieza Interna"};
    JComboBox <String> listaMovil=new JComboBox<String>(valoresMovil); 
    JComboBox <String> listaOrdenador=new JComboBox<String>(valoresOrdenador);
    
    public GestionNuevaReparacion() { 
        super("Inserción de una nueva reparación"); 
        setSize(400,400);

        jp=new JPanel(false); 
        jp.setLayout(null);

        this.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana (Si es llamada desde fuera, libera recursos pero no cierra el programa)
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        // 3. Creo el objeto DAO que permitirá el acceso a la BD
        gestor = new ReparacionesDAO();

        // 4. Creamos la ventana
        this.creaVentana();
    } 

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("botonInsertar")) { //Ha pedido insertar un nuevo contrato
             boolean exito=false;
            if (campoDNI.getText().equals("") || campoNombre.getText().equals("") || campoPrecio.getText().equals("") || campoFecha.getDate() == null || campoHoras.getText().equals("")) { 
                //No ha escrito nada en alguno de los campos
                JOptionPane.showMessageDialog(this, "ERROR: Debes rellenar todos los campos");
            } else if(!movil.isSelected() && !ordenador.isSelected()) { //No ha elegido ni reparación de móvil ni de ordenador
                JOptionPane.showMessageDialog(this, "ERROR: Debes elegir un tipo de reparación");
            } else { //Tenemos todos los datos para insertar una nueva reserva

                if (movil.isSelected()) { //Ha elegido reparación móvil
                    exito = gestor.insertaReparacionMovil(campoDNI.getText(), campoNombre.getText(), Double.parseDouble(campoPrecio.getText()), campoFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), Integer.parseInt(campoHoras.getText()), (String)listaMovil.getSelectedItem());
                } else { //Ha elegido reparación de ordenador
                    exito = gestor.insertaReparacionOrdenador(campoDNI.getText(), campoNombre.getText(), Double.parseDouble(campoPrecio.getText()), campoFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), Integer.parseInt(campoHoras.getText()), (String)listaOrdenador.getSelectedItem());
                }

                if (!exito) { //Ha habido algún problema
                    JOptionPane.showMessageDialog(this, "ERROR: Ha habido un error al insertar los datos");
                } else {
                    JOptionPane.showMessageDialog(this, "ÉXITO: Reparación insertada correctamente");
                }
            }
        }
    }


    public void creaVentana(){ //Creamos la vista
        //Creamos los elementos gráficos de la aplicación que estamos creando
        getContentPane().setLayout(null); 

        //DNI
        etiquetaDNI = new JLabel("DNI: ");
        etiquetaDNI.setBounds(20, 30, 100, 20);

        getContentPane().add(etiquetaDNI);

        campoDNI = new JTextField();
        campoDNI.setBounds(140, 30, 75, 20);

        getContentPane().add(campoDNI);

        //Nombre
        etiquetaNombre = new JLabel("Nombre: ");
        etiquetaNombre.setBounds(20, 60, 100, 20);

        getContentPane().add(etiquetaNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(140, 60, 220, 20);

        getContentPane().add(campoNombre);

        //Precio por noche
        etiquetaPrecio = new JLabel("Precio base: ");
        etiquetaPrecio.setBounds(20, 90, 120, 20);

        getContentPane().add(etiquetaPrecio);

        campoPrecio = new JTextField();
        campoPrecio.setBounds(140, 90, 75, 20);

        getContentPane().add(campoPrecio);

        //Fecha de inicio
        etiquetaFecha = new JLabel("Fecha de entrada: ");
        etiquetaFecha.setBounds(20, 120, 110, 20);

        getContentPane().add(etiquetaFecha);

        campoFecha = new JDateChooser();
        campoFecha.setDateFormatString("dd/MM/yyyy"); //Indicamos el formato de la fecha que saldrá en el selector 
        campoFecha.setBounds(140, 120, 200, 20);

        getContentPane().add(campoFecha);

        //Número de noches
        etiquetaHoras = new JLabel("Horas de trabajo: ");
        etiquetaHoras.setBounds(20, 150, 120, 20);

        getContentPane().add(etiquetaHoras);

        campoHoras = new JTextField();
        campoHoras.setBounds(140, 150, 75, 20);

        getContentPane().add(campoHoras);

        // Creamos los radio buttons 
        etiquetaTipo = new JLabel("Tipo de reparación: "); //Etiqueta para los Radio Button del tipo de reparación
        etiquetaTipo.setBounds(20, 190, 150, 20);
        movil = new JRadioButton("Móvil");  //Radio Button para elegir reparación de móvil
        ordenador = new JRadioButton("Ordenador"); //Radio Button para elegir reparación de ordenador
        movil.setBounds(30, 220, 100, 20);
        ordenador.setBounds(30, 250, 100, 20);
        // Creamos el grupo y asignamos los dos radio buttons a él 
        grupoBotones = new ButtonGroup(); 
        grupoBotones.add(movil); 
        grupoBotones.add(ordenador); 

        getContentPane().add(etiquetaTipo);
        getContentPane().add(movil);
        getContentPane().add(ordenador);

        //Lista para la selección del tipo de reparación móvil
        listaMovil.setBounds(150, 220, 130, 20);
        getContentPane().add(listaMovil);

        //Lista para la selección del tipo de reparación de ordenador
        listaOrdenador.setBounds(150, 250, 130, 20);
        getContentPane().add(listaOrdenador);

        //Creo el botón para que me inserte una nueva reparación en la BD
        botonInsertar = new JButton("Insertar nueva reparación");
        botonInsertar.setBounds(100, 310, 200, 20);
        botonInsertar.setActionCommand("botonInsertar");
        botonInsertar.addActionListener(this);

        getContentPane().add(botonInsertar);    

        setVisible(true); 
    } 
}