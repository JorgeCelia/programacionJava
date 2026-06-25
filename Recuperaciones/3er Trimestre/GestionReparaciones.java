import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GestionReparaciones extends JFrame implements ActionListener {
    JButton nuevaReparacion, muestraReparaciones;

    public GestionReparaciones() { 
        super("Gestión de las reparaciones"); 
        setSize(300,130);
        setLocationRelativeTo(null);
    } 

    public void VentanaActual(){ 
        getContentPane().setLayout(null); 

        //Creo el botón para insertar una nueva reserva
        nuevaReparacion = new JButton("Insertar nueva reparación");
        nuevaReparacion.setBounds(50, 20, 200, 20);
        nuevaReparacion.setActionCommand("nuevaReparacion");
        nuevaReparacion.addActionListener(this);
        getContentPane().add(nuevaReparacion);

        //Creo el botón para mostrar las reservas
        muestraReparaciones = new JButton("Muestra las reparaciones");
        muestraReparaciones.setBounds(50, 60, 200, 20);
        muestraReparaciones.setActionCommand("muestraReparaciones");
        muestraReparaciones.addActionListener(this);
        getContentPane().add(muestraReparaciones);
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getActionCommand().equals("nuevaReparacion")) { //Ha pedido ver la ventana para insertar una nueva reparacion
            GestionNuevaReparacion ventanaNR = new GestionNuevaReparacion();
            ventanaNR.setVisible(true);
        }

        if (e.getActionCommand().equals("muestraReparaciones")) { //Ha pedido ver la ventana con todas las reparaciones
                GestionMuestraReparaciones ventanaMR = new GestionMuestraReparaciones();

                ventanaMR.setVisible(true);
        }
     }

    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        GestionReparaciones ventanaGR = new GestionReparaciones();
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