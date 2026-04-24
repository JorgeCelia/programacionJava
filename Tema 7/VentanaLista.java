import java.awt.*; 
import javax.swing.*; 
import javax.swing.event.*; 

public class VentanaLista extends JFrame implements ListSelectionListener{ 
    String[] valores = {"perro","gato","vaca","oveja","cerdo","pollo","cabra","caballo","asno"};
    JList <String> lista=new JList<String>(valores); 
    JLabel etiqueta=new JLabel("Seleccionado: "); 
    JPanel p1=new JPanel(), p2=new JPanel(); 

    public VentanaLista() { 
        this.setLocation(100,100); 
        this.setSize(300,200); 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        JScrollPane sp=new JScrollPane(lista);
        p1.setLayout(new FlowLayout()); 
        p2.setLayout(new FlowLayout()); 
        lista.setVisibleRowCount(5); 
        lista.addListSelectionListener(this); 
        p1.add(sp); 
        p2.add(etiqueta);
        getContentPane().add(p1,BorderLayout.CENTER); 
        getContentPane().add(p2,BorderLayout.SOUTH); 
        setVisible(true);
    }

    public void valueChanged(ListSelectionEvent e) { 
        String texto="Seleccionado: "; 
        int i; 
        //Se añade el texto del siguiente elemento 
        //seleccionado hasta el último 
        for(i=0;i<lista.getSelectedValuesList().size();i++){ 
            texto+=(String) lista.getSelectedValuesList().get(i)+" "; 
        } 
        etiqueta.setText(texto); 
    }

    public static void main(String[] args) {
        VentanaLista ventana1=new VentanaLista(); 

        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana1.setVisible(true); 
    }
} 
