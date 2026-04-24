import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaInformacion extends JFrame { 

   JLabel etiqueta=new JLabel("Editor de Textos v0.9 "); 
   JPanel p1=new JPanel(); 

   public VentanaInformacion(int numPalabras) { 
      p1.setLayout(null);

      etiqueta.setVerticalAlignment(SwingConstants.CENTER);
      etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
      
      etiqueta.setText("En el documento hay "+numPalabras+" palabras");

      getContentPane().add(etiqueta); 
      
      setTitle("Información del documento");
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
      setSize(350,200);
      setLocationRelativeTo(null);
      setVisible(true);
   }
}