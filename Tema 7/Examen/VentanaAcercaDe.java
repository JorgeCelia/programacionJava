import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaAcercaDe extends JFrame { 

   JLabel etiqueta=new JLabel("Editor de Textos v0.9 "); 
   JPanel p1=new JPanel(); 

   public VentanaAcercaDe() { 
      p1.setLayout(null);

      etiqueta.setVerticalAlignment(SwingConstants.CENTER);
      etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
      
      getContentPane().add(etiqueta); 
      
      setTitle("Acerca De...");
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
      setSize(300,200);
      setLocationRelativeTo(null);
      setVisible(true);
   }
}