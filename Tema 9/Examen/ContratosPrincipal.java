import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ContratosPrincipal extends JFrame implements ActionListener {
    JButton nuevoIndefinido, nuevoTemporal, buscarContrato, mostrarTemporales, mostrarIndefinidos;

    public ContratosPrincipal() { 
        super("Gestión de contratos"); 
        setSize(300,260);
        setLocationRelativeTo(null);
    } 

    public void VentanaActual(){ 
        getContentPane().setLayout(null); 

        //Creo el botón para acceder a la ventana de inserción de un nuevo contrato indefinido
        nuevoIndefinido = new JButton("Insertar un nuevo contrato indefinido");
        nuevoIndefinido.setBounds(25, 20, 250, 20);
        nuevoIndefinido.setActionCommand("nuevoIndefinido");
        nuevoIndefinido.addActionListener(this);

        getContentPane().add(nuevoIndefinido);

        //Creo el botón para acceder a la ventana de inserción de un nuevo contrato temporal
        nuevoTemporal = new JButton("Insertar un nuevo contrato temporal");
        nuevoTemporal.setBounds(25, 60, 250, 20);
        nuevoTemporal.setActionCommand("nuevoTemporal");
        nuevoTemporal.addActionListener(this);

        getContentPane().add(nuevoTemporal);

        //Creo el botón para acceder a la ventana que muestra todos los contratos temporales
        mostrarTemporales = new JButton("Mostrar los contratos temporales");
        mostrarTemporales.setBounds(25, 100, 250, 20);
        mostrarTemporales.setActionCommand("mostrarTemporales");
        mostrarTemporales.addActionListener(this);

        getContentPane().add(mostrarTemporales);

        //Creo el botón para acceder a la ventana que muestra todos los contratos indefinidos
        mostrarIndefinidos = new JButton("Mostrar los contratos indefinidos");
        mostrarIndefinidos.setBounds(25, 140, 250, 20);
        mostrarIndefinidos.setActionCommand("mostrarIndefinidos");
        mostrarIndefinidos.addActionListener(this);

        getContentPane().add(mostrarIndefinidos);

        //Creo el botón para acceder a la ventana de búsqueda de los datos de un contrato
        buscarContrato = new JButton("Buscar un contrato por DNI");
        buscarContrato.setBounds(25, 180, 250, 20);
        buscarContrato.setActionCommand("buscarContrato");
        buscarContrato.addActionListener(this);

        getContentPane().add(buscarContrato);
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("nuevoIndefinido")) { //Ha pedido ver la ventana de inserción de nuevo contrato indefinido
                ContratosNuevoIndefinido ventanaNI = new ContratosNuevoIndefinido();

                ventanaNI.setVisible(true);
        }

        if (e.getActionCommand().equals("nuevoTemporal")) { //Ha pedido ver la ventana de inserción de nuevo contrato temporal
                ContratosNuevoTemporal ventanaNT = new ContratosNuevoTemporal();

                ventanaNT.setVisible(true);
        }

        if (e.getActionCommand().equals("mostrarTemporales")) { //Ha pedido ver la ventana que muestra los contratos temporales
                ContratosMuestraTemporales ventanaMT = new ContratosMuestraTemporales();

                ventanaMT.setVisible(true);
        }

        if (e.getActionCommand().equals("mostrarIndefinidos")) { //Ha pedido ver la ventana que muestra los contratos Indefinidos
                ContratosMuestraIndefinidos ventanaMI = new ContratosMuestraIndefinidos();

                ventanaMI.setVisible(true);
        }

        if (e.getActionCommand().equals("buscarContrato")) { //Ha pedido ver la ventana de búsqueda de contrato por DNI
                ContratosBuscaDNI ventanaCB = new ContratosBuscaDNI();

                ventanaCB.setVisible(true);
        }
    }

    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        ContratosPrincipal ventanaF = new ContratosPrincipal();
        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        ventanaF.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana
        ventanaF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Creamos una nueva ventana con los elementos definidos más arriba
        ventanaF.VentanaActual();
        
        // 4. Hacer que la ventana sea visible
        ventanaF.setVisible(true);
    }
}