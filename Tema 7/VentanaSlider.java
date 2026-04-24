import java.awt.*; 
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class VentanaSlider extends JFrame implements ChangeListener{ 

    JLabel etiqueta; 
    JSlider barra; 

    public VentanaSlider() { 
        this.setLocation(100,100); 
        this.setSize(300,200); 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        barra=new JSlider(JSlider.HORIZONTAL,0,100,0); 
        etiqueta=new JLabel("Valor: 0"); 
        etiqueta.setHorizontalAlignment(JLabel.CENTER); 
        barra.addChangeListener(this); 

        //apariencia del slider 
        barra.putClientProperty("JSlider.isFilled", Boolean.TRUE); 
        barra.setPaintLabels(true); 
        barra.setPaintTicks(true); 
        barra.setMajorTickSpacing(25); 
        barra.setMinorTickSpacing(5); 
        getContentPane().add(barra,BorderLayout.NORTH); 
        getContentPane().add(etiqueta,BorderLayout.SOUTH); 
    }
  
    public void stateChanged(ChangeEvent e) { 
      etiqueta.setText("Valor: "+((JSlider)e.getSource()).getValue()); 
    }

    public static void main(String[] args) {
        VentanaSlider ventana1=new VentanaSlider(); 

        //Al ser llamada en el main y ser la ventana principal, ponemos que cuando se cierre la ventana se acabe el programa
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana1.setVisible(true); 
    }
} 
