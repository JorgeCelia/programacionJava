import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GestionReservas extends JFrame implements ActionListener {
    JButton nuevaReserva, muestraReservas;

    public GestionReservas() { 
        super("Gestión de las reservas"); 
        setSize(300,130);
        setLocationRelativeTo(null);
    } 

    public void VentanaActual(){ 
        getContentPane().setLayout(null); 

        //Creo el botón para insertar una nueva reserva
        nuevaReserva = new JButton("Insertar nueva reserva");
        nuevaReserva.setBounds(50, 20, 200, 20);
        nuevaReserva.setActionCommand("nuevaReserva");
        nuevaReserva.addActionListener(this);
        getContentPane().add(nuevaReserva);

        //Creo el botón para mostrar las reservas
        muestraReservas = new JButton("Muestra las reservas");
        muestraReservas.setBounds(50, 60, 200, 20);
        muestraReservas.setActionCommand("muestraReservas");
        muestraReservas.addActionListener(this);
        getContentPane().add(muestraReservas);
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("nuevaReserva")) { //Ha pedido ver la ventana de los datos en bruto
                GestionNuevaReserva ventanaNR = new GestionNuevaReserva();

                ventanaNR.setVisible(true);
        }

        if (e.getActionCommand().equals("muestraReservas")) { //Ha pedido ver la ventana con todas las reservas
                GestionMuestraReservas ventanaMR = new GestionMuestraReservas();

                ventanaMR.setVisible(true);
        }
     }

    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        GestionReservas ventanaGR = new GestionReservas();
        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        ventanaGR.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana
        ventanaGR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Creamos una nueva ventana con los elementos definidos más arriba
        ventanaGR.VentanaActual();
        
        // 4. Hacer que la ventana sea visible
        ventanaGR.setVisible(true);
    }
}