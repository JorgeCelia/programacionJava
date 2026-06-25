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

public class GestionNuevaReserva extends JFrame implements ActionListener{

    JPanel jp;
    ReservasDAO gestor; //Objeto para acceder a la BD

    JTextField campoDNI, campoNombre, campoPrecio, campoNumNoches;
    JLabel etiquetaDNI, etiquetaNombre, etiquetaPrecio, etiquetaFecha, etiquetaNumNoches, etiquetaTipo;
    JButton botonInsertar;
    JDateChooser campoFecha;

    ButtonGroup grupoBotones; 
    JRadioButton estandar, pension;
    String[] valoresEstandar = {"Individual","Doble","Suite"};
    String[] valoresPension = {"Media Pensión","Pensión Completa"};
    JComboBox <String> listaEstandar=new JComboBox<String>(valoresEstandar); 
    JComboBox <String> listaPension=new JComboBox<String>(valoresPension);
    
    public GestionNuevaReserva() { 
        super("Inserción de una nueva reserva"); 
        setSize(400,400);

        jp=new JPanel(false); 
        jp.setLayout(null);

        this.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana (Si es llamada desde fuera, libera recursos pero no cierra el programa)
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        // 3. Creo el objeto DAO que permitirá el acceso a la BD
        gestor = new ReservasDAO();

        // 4. Creamos la ventana
        this.creaVentana();
    } 

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("botonInsertar")) { //Ha pedido insertar un nuevo contrato
            boolean exito=false;
            if (campoDNI.getText().equals("") || campoNombre.getText().equals("") || campoPrecio.getText().equals("") || campoFecha.getDate() == null || campoNumNoches.getText().equals("")) { 
                //No ha escrito nada en alguno de los campos
                JOptionPane.showMessageDialog(this, "ERROR: Debes rellenar todos los campos");
            } else if(!estandar.isSelected() && !pension.isSelected()) { //No ha elegido ni estandar ni con pensión
                JOptionPane.showMessageDialog(this, "ERROR: Debes elegir un tipo de reserva");
            } else { //Tenemos todos los datos para insertar una nueva reserva

                if (estandar.isSelected()) { //Ha elegido reserva estándar
                    exito = gestor.insertaReservaEstandar(campoDNI.getText(), campoNombre.getText(), Double.parseDouble(campoPrecio.getText()), campoFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), Integer.parseInt(campoNumNoches.getText()), (String)listaEstandar.getSelectedItem());
                } else { //Ha elegido reserva con pensión
                    exito = gestor.insertaReservaPension(campoDNI.getText(), campoNombre.getText(), Double.parseDouble(campoPrecio.getText()), campoFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), Integer.parseInt(campoNumNoches.getText()), (String)listaPension.getSelectedItem());
                }

                if (!exito) { //Ha habido algún problema
                    JOptionPane.showMessageDialog(this, "ERROR: Ha habido un error al insertar los datos");
                } else {
                    JOptionPane.showMessageDialog(this, "ÉXITO: Reserva insertada correctamente");
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
        etiquetaPrecio = new JLabel("Precio por noche: ");
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
        etiquetaNumNoches = new JLabel("Número de noches: ");
        etiquetaNumNoches.setBounds(20, 150, 120, 20);

        getContentPane().add(etiquetaNumNoches);

        campoNumNoches = new JTextField();
        campoNumNoches.setBounds(140, 150, 75, 20);

        getContentPane().add(campoNumNoches);

        // Creamos los radio buttons 
        etiquetaTipo = new JLabel("Tipo de reserva: "); //Etiqueta para los Radio Button del tipo de reserva
        etiquetaTipo.setBounds(20, 190, 100, 10);
        estandar = new JRadioButton("Estándar");  //Radio Button para elegir reserva estandar
        pension = new JRadioButton("Con Pensión"); //Radio Button para elegir con pensión
        estandar.setBounds(30, 210, 100, 20);
        pension.setBounds(30, 240, 100, 20);
        // Creamos el grupo y asignamos los dos radio buttons a él 
        grupoBotones = new ButtonGroup(); 
        grupoBotones.add(estandar); 
        grupoBotones.add(pension); 

        getContentPane().add(etiquetaTipo);
        getContentPane().add(estandar);
        getContentPane().add(pension);

        //Lista para la selección del tipo de reserva estándar
        listaEstandar.setBounds(150, 210, 130, 20);
        getContentPane().add(listaEstandar);

        //Lista para la selección del tipo de reserva con pensión
        listaPension.setBounds(150, 240, 130, 20);
        getContentPane().add(listaPension);

        //Creo el botón para que me inserte una nueva reserva en la BD
        botonInsertar = new JButton("Insertar nueva reserva");
        botonInsertar.setBounds(100, 300, 200, 20);
        botonInsertar.setActionCommand("botonInsertar");
        botonInsertar.addActionListener(this);

        getContentPane().add(botonInsertar);    

        setVisible(true); 
    } 
}