import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 
public class VentanaListaCombinada extends JFrame implements ItemListener{ 

    String[] valores = {"perro","gato","vaca","oveja","cerdo","pollo","cabra","caballo","asno"};
    JComboBox <String> lista=new JComboBox<String>(valores); 
    JLabel etiqueta=new JLabel("Seleccionado: "); 
    JPanel p1=new JPanel(), p2=new JPanel(); 

    public VentanaListaCombinada() { 
        this.setLocation(100,100); 
        this.setSize(300,200); 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        p1.setLayout(new FlowLayout()); 
        p2.setLayout(new FlowLayout()); 
        lista.setMaximumRowCount(5); 
        lista.addItemListener(this); 
        p1.add(lista); 
        p2.add(etiqueta); 
        getContentPane().add(p1,BorderLayout.CENTER); 
        getContentPane().add(p2,BorderLayout.SOUTH); 
    } 
  
    public void itemStateChanged(ItemEvent e) { 
        etiqueta.setText("Seleccionado: "+ 
        (String)lista.getSelectedItem()); 
    } 
 
    public static void main(String[] args) {
        VentanaListaCombinada ventana1=new VentanaListaCombinada(); 

        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana1.setVisible(true); 
    }
} 
