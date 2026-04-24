import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class EjemploRadioButton extends JFrame implements ItemListener {
    JRadioButton deportes, cultura; 
    ButtonGroup grupoBotones; 
    JLabel descripción; 
    private String sdeportes="",scultura=""; 

    public EjemploRadioButton() { 
        super("Mi Ventana"); 
        setSize(400,200);

        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        this.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana (Si es llamada desde fuera, libera recursos pero no cierra el programa)
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 3. Creamos una nueva ventana
        this.VentanaVista();

    } 

    public void VentanaVista(){ 
        //Método para crear la ventana y añadir los elementos que contiene (vista)
        getContentPane().setLayout(new FlowLayout()); 
        
        // Creamos los radio buttons 
        deportes = new JRadioButton("Deportes"); 
        cultura = new JRadioButton("Cultura"); 
        // Creamos el grupo y asignamos los dos radio buttons a él 
        grupoBotones = new ButtonGroup(); 
        grupoBotones.add(deportes); 
        grupoBotones.add(cultura); 
        // Creamos la etiqueta 
        descripción = new JLabel("Tiene elegido: "); 

        // Añadimos los escuchadores de eventos a los radio buttons 
        deportes.addItemListener(this); 
        cultura.addItemListener(this); 

        // Agregamos los radio buttons al panel y lo mostramos todo 
        getContentPane().add(deportes); 
        getContentPane().add(cultura); 
        getContentPane().add(descripción); 
        setVisible(true);  
    } 

    public void itemStateChanged(ItemEvent e){ 
        if (e.getItemSelectable()==deportes){ 
            if (e.getStateChange()==ItemEvent.SELECTED) 
                sdeportes=" deportes"; 
            else sdeportes=""; 
        } 
        else { //sólo puede haberlo provocado el evento "Cultura" 
            if (e.getStateChange()==ItemEvent.SELECTED) 
                scultura=" cultura"; 
            else scultura=""; 
        } 
        descripción.setText("Tiene elegido: "+sdeportes+" "+scultura); 
    } 

    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        EjemploRadioButton ventanaRB = new EjemploRadioButton();
        
        //Al ser llamada en el main y ser la ventana principal, ponemos que cuando se cierre la ventana se acabe el programa
        ventanaRB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 4. Hacer que la ventana sea visible
        ventanaRB.setVisible(true);
    }


}