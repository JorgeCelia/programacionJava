import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

public class VentanaScrollBar extends JFrame implements AdjustmentListener 
{ 
    JLabel etiqueta; 
    JScrollBar barra; 

    //constructor 
    public VentanaScrollBar() { 
        this.setLocation(100,100); 
        this.setSize(300,200); 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        barra=new JScrollBar(JScrollBar.HORIZONTAL,0, 30,0, 300); 
        etiqueta=new JLabel("Valor: 0"); 
        etiqueta.setHorizontalAlignment(JLabel.CENTER); 
        getContentPane().add(barra,BorderLayout.NORTH); 
        getContentPane().add(etiqueta,BorderLayout.SOUTH); 
        barra.addAdjustmentListener(this); 
    } 

    public void adjustmentValueChanged(AdjustmentEvent e) { 
        etiqueta.setText("Valor: "+e.getValue()); 
    } 
    public static void main(String[] args) {
        VentanaScrollBar ventana1=new VentanaScrollBar(); 
        //Al ser llamada en el main y ser la ventana principal, ponemos que cuando se cierre la ventana se acabe el programa
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana1.setVisible(true); 
   }
}
