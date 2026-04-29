import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContratosBuscaDNI extends JFrame implements ActionListener{

    JPanel jp;
    ContratoDAO gestor; //Objeto para acceder a la BD

    JTextField campoDNI;
    JLabel etiquetaDNI;
    JButton botonBusqueda;

    JLabel resultadoContrato, resultadoDNI, resultadoNombre, resultadoSalario, resultadoFechaInicio, resultadoFechaFin, resultadoDias;

    public ContratosBuscaDNI() { 
        super("Búsqueda de contratos por DNI"); 
        setSize(400,430);

        jp=new JPanel(false); 
        jp.setLayout(null);

        this.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana (Si es llamada desde fuera, libera recursos pero no cierra el programa)
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        // 3. Creo el objeto DAO que permitirá el acceso a la BD
        gestor = new ContratoDAO();

        // 4. Creamos la ventana
        this.creaVentana();
    } 

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("botonBusqueda")) { //Ha pedido buscar por DNI
            if (campoDNI.getText().equals("")) { //No ha escrito nada
                JOptionPane.showMessageDialog(this, "ERROR: Debes escribir un DNI para buscar");
            } else {
                char resultado;
                resultado = gestor.buscaTipoContratoDNI(campoDNI.getText());

                if (resultado == 'X') { //No ha encontrado ningún contrato con ese DNI
                    JOptionPane.showMessageDialog(this, "No hay ningún contrato con el DNI "+campoDNI.getText());
                } else if (resultado == 'I') { //El DNI es de un contrato indefinido
                    ContratoIndefinido contratoI;
                    contratoI = gestor.devuelveContratoIndefinido(campoDNI.getText());

                    //Muestro los datos por pantalla
                    resultadoContrato.setText("Tipo de contrato: Indefinido");
                    resultadoDNI.setText("DNI: "+contratoI.getDni());
                    resultadoNombre.setText("Nombre: "+contratoI.getEmpleado());
                    resultadoSalario.setText("Salario: "+contratoI.getSalario()+"€");
                    resultadoFechaInicio.setText("Fecha de Inicio: "+contratoI.getFechaInicio());
                    resultadoFechaFin.setText("Fecha de Fin: ");
                    resultadoDias.setText("Días trabajados: "+contratoI.tiempoTrabajado());
                } else { //El DNI es de un contrato temporal
                    ContratoTemporal contratoT;
                    contratoT = gestor.devuelveContratoTemporal(campoDNI.getText());

                    //Muestro los datos por pantalla
                    resultadoContrato.setText("Tipo de contrato: Temporal");
                    resultadoDNI.setText("DNI: "+contratoT.getDni());
                    resultadoNombre.setText("Nombre: "+contratoT.getEmpleado());
                    resultadoSalario.setText("Salario: "+contratoT.getSalario()+"€");
                    resultadoFechaInicio.setText("Fecha de Inicio: "+contratoT.getFechaInicio());
                    resultadoFechaFin.setText("Fecha de Fin: "+contratoT.getFechaFin());
                    resultadoDias.setText("Días trabajados: "+contratoT.calculaDuracion());
                }

            }
        }

    }


    public void creaVentana(){ //Creamos la vista
        //Creamos los elementos gráficos de la aplicación que estamos creando
        getContentPane().setLayout(null); 

        etiquetaDNI = new JLabel("DNI: ");
        etiquetaDNI.setBounds(50, 50, 200, 20);

        getContentPane().add(etiquetaDNI);

        campoDNI = new JTextField();
        campoDNI.setBounds(100, 50, 200, 20);

        getContentPane().add(campoDNI);

        //Creo el botón para que me busque los datos por DNI
        botonBusqueda = new JButton("Buscar por DNI");
        botonBusqueda.setBounds(100, 100, 200, 20);
        botonBusqueda.setActionCommand("botonBusqueda");
        botonBusqueda.addActionListener(this);

        getContentPane().add(botonBusqueda);

        //Pongo las etiquetas donde irán los resultados
        resultadoContrato = new JLabel("Tipo de contrato:");
        resultadoContrato.setBounds(50, 150, 200, 20);
        getContentPane().add(resultadoContrato);

        resultadoDNI = new JLabel("DNI:");
        resultadoDNI.setBounds(50, 180, 200, 20);
        getContentPane().add(resultadoDNI);

        resultadoNombre = new JLabel("Nombre:");
        resultadoNombre.setBounds(50, 210, 200, 20);
        getContentPane().add(resultadoNombre);

        resultadoSalario = new JLabel("Salario:");
        resultadoSalario.setBounds(50, 240, 200, 20);
        getContentPane().add(resultadoSalario);

        resultadoFechaInicio = new JLabel("Fecha de Inicio:");
        resultadoFechaInicio.setBounds(50, 270, 200, 20);
        getContentPane().add(resultadoFechaInicio);

        resultadoFechaFin = new JLabel("Fecha de Fin:");
        resultadoFechaFin.setBounds(50, 300, 200, 20);
        getContentPane().add(resultadoFechaFin);

        resultadoDias = new JLabel("Días trabajados:");
        resultadoDias.setBounds(50, 330, 200, 20);
        getContentPane().add(resultadoDias);

        setVisible(true); 
    } 
}