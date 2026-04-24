import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EjemploCheckBox extends JFrame implements ItemListener {
    JCheckBox deportes, cultura; 
    JLabel descripción; 
    private String sdeportes="",scultura=""; 

    public EjemploCheckBox() { 
        super("Ventana con CheckBox"); 
        setSize(400,200);

        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        this.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana (Si es llamada desde fuera, libera recursos pero no cierra el programa)
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 3. Creamos la ventana
        this.VentanaCasillaAct();      
    } 

    public void VentanaCasillaAct(){ //Creamos la vista
        //Creamos los elementos gráficos de la aplicación que estamos creando
        getContentPane().setLayout(new FlowLayout()); 
        deportes = new JCheckBox("Deportes"); 
        cultura = new JCheckBox("Cultura"); 
        descripción = new JLabel("Tiene elegido: "); 
        deportes.addItemListener(this); 
        cultura.addItemListener(this); 
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
        EjemploCheckBox ventanaCB = new EjemploCheckBox();

        //Al ser llamada en el main y ser la ventana principal, ponemos que cuando se cierre la ventana se acabe el programa
        ventanaCB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 4. Hacer que la ventana sea visible
        ventanaCB.setVisible(true);
    }


}