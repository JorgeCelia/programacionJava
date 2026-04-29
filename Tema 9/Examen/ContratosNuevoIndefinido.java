import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;

public class ContratosNuevoIndefinido extends JFrame implements ActionListener{

    JPanel jp;
    ContratoDAO gestor; //Objeto para acceder a la BD

    JTextField campoDNI, campoNombre, campoSalario;
    JLabel etiquetaDNI, etiquetaNombre, etiquetaSalario, etiquetaFecha;
    JButton botonInsertar;
    JDateChooser campoFecha;

    public ContratosNuevoIndefinido() { 
        super("Inserción un nuevo contrato indefinido"); 
        setSize(400,250);

        jp=new JPanel(false); 
        jp.setLayout(null);

        this.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana (Si es llamada desde fuera, libera recursos pero no cierra el programa)
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        // 3. Creo el objeto DAO que me permitirá acceder a la BD
        gestor = new ContratoDAO();

        // 4. Creamos la ventana
        this.creaVentana();
    } 

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("botonInsertar")) { //Ha pedido insertar un nuevo contrato
            boolean exito=false;
            if (campoDNI.getText().equals("") || campoNombre.getText().equals("") || campoSalario.getText().equals("") || campoFecha.getDate() == null) { 
                //No ha escrito nada en alguno de los campos
                JOptionPane.showMessageDialog(this, "ERROR: Debes rellenar todos los campos");
            } else {
                exito = gestor.insertaContratoIndefinido(campoDNI.getText(), campoNombre.getText(), Double.parseDouble(campoSalario.getText()), campoFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

                if (!exito) { //Ha habido algún problema
                    JOptionPane.showMessageDialog(this, "ERROR: Ha habido un error al insertar los datos");
                } else {
                    JOptionPane.showMessageDialog(this, "ÉXITO: Contrato insertado correctamente");
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

        //Salario
        etiquetaSalario = new JLabel("Salario (bruto/mes): ");
        etiquetaSalario.setBounds(20, 90, 120, 20);

        getContentPane().add(etiquetaSalario);

        campoSalario = new JTextField();
        campoSalario.setBounds(140, 90, 100, 20);

        getContentPane().add(campoSalario);

        //Fecha de inicio
        etiquetaFecha = new JLabel("Fecha de inicio: ");
        etiquetaFecha.setBounds(20, 120, 100, 20);

        getContentPane().add(etiquetaFecha);

        campoFecha = new JDateChooser();
        campoFecha.setDateFormatString("dd/MM/yyyy"); //Indicamos el formato de la fecha que saldrá en el selector 
        campoFecha.setBounds(140, 120, 200, 20);

        getContentPane().add(campoFecha);

        //Creo el botón para que me inserte el contrato indefinido en la BD
        botonInsertar = new JButton("Insertar contrato indefinido");
        botonInsertar.setBounds(100, 170, 200, 20);
        botonInsertar.setActionCommand("botonInsertar");
        botonInsertar.addActionListener(this);

        getContentPane().add(botonInsertar);    

        setVisible(true); 
    } 
}