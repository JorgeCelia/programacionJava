import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaGridBagLayout extends JFrame implements ActionListener {
    JButton ejCheckBox, ejRadioButton, ejScrollBar, ejSlider, ejList, ejListaCombinada, ejColor, ejFile, ejMenu, ejMenuContextual;

    public VentanaGridBagLayout() { 
        super("Ejemplo de Grid Bag Layout"); 
        setSize(600,500);
        setLocationRelativeTo(null);
    } 

    public void VentanaActual(){ 
        GridBagConstraints restricciones=new GridBagConstraints(); 

        //Creo el botón para acceder a la ventana de CheckBox
        ejCheckBox = new JButton("Ejemplo Checkbox");
        ejCheckBox.setBounds(40, 20, 200, 20);
        ejCheckBox.setActionCommand("ejCheckBox");    
        ejCheckBox.addActionListener(this);

        restricciones.fill=GridBagConstraints.BOTH; 
        restricciones.weightx=1.0; 
        restricciones.weighty=1.0; 
        restricciones.gridwidth=4; 

        getContentPane().add(ejCheckBox, restricciones);

        //Creo el botón para acceder a la ventana de Radio Button
        ejRadioButton = new JButton("Ejemplo Radio Button");
        ejRadioButton.setBounds(300, 20, 200, 20);
        ejRadioButton.setActionCommand("ejRadioButton");
        ejRadioButton.addActionListener(this);

        restricciones.gridwidth=1; 
        getContentPane().add(ejRadioButton, restricciones);

        //Creo el botón para acceder a la ventana de Scroll Bar
        ejScrollBar = new JButton("Ejemplo Scroll Bar");
        ejScrollBar.setBounds(40, 60, 200, 20);
        ejScrollBar.setActionCommand("ejScrollBar");
        ejScrollBar.addActionListener(this);

        restricciones.gridheight=2;
        getContentPane().add(ejScrollBar, restricciones);


        //Creo el botón para acceder a la ventana del Slider
        ejSlider = new JButton("Ejemplo Slider");
        ejSlider.setBounds(300, 60, 200, 20);
        ejSlider.setActionCommand("ejSlider");
        ejSlider.addActionListener(this);

        restricciones.gridx=1;
        restricciones.gridy=1;
        getContentPane().add(ejSlider, restricciones);

        //Creo el botón para acceder a la ventana del JList
        ejList = new JButton("Ejemplo JList");
        ejList.setBounds(40, 100, 200, 20);
        ejList.setActionCommand("ejList");
        ejList.addActionListener(this);

        restricciones.gridx=2;
        restricciones.gridy=1;
        getContentPane().add(ejList, restricciones);

        //Creo el botón para acceder a la ventana de Lista Combinada
        ejListaCombinada = new JButton("Ejemplo Lista Combinada");
        ejListaCombinada.setBounds(300, 100, 200, 20);
        ejListaCombinada.setActionCommand("ejListaCombinada");
        ejListaCombinada.addActionListener(this);

        restricciones.gridx=6;
        restricciones.gridy=2;
        getContentPane().add(ejListaCombinada, restricciones);

        //Creo el botón para acceder a la ventana de color chooser
        ejColor = new JButton("Ejemplo Color Chooser");
        ejColor.setBounds(40, 140, 200, 20);
        ejColor.setActionCommand("ejColor");
        ejColor.addActionListener(this);

        restricciones.gridx=6;
        restricciones.gridy=1;
        getContentPane().add(ejColor, restricciones);

        //Creo el botón para acceder a la ventana de Lista Combinada
        ejFile = new JButton("Ejemplo File Chooser");
        ejFile.setBounds(300, 140, 200, 20);
        ejFile.setActionCommand("ejFile");
        ejFile.addActionListener(this);

        restricciones.gridx=3;
        restricciones.gridy=2;
        getContentPane().add(ejFile, restricciones);

        //Creo el botón para acceder a la ventana con un menú
        ejMenu = new JButton("Ejemplo de menú");
        ejMenu.setBounds(40, 180, 200, 20);
        ejMenu.setActionCommand("ejMenu");
        ejMenu.addActionListener(this);

        restricciones.gridx=4;
        restricciones.gridy=2;
        getContentPane().add(ejMenu, restricciones);

        //Creo el botón para acceder a la ventana con un menú contextual
        ejMenuContextual = new JButton("Ejemplo de menú contextual");
        ejMenuContextual.setBounds(300, 180, 200, 20);
        ejMenuContextual.setActionCommand("ejMenuContextual");
        ejMenuContextual.addActionListener(this);

        restricciones.gridx=5;
        restricciones.gridy=2;
        getContentPane().add(ejMenuContextual, restricciones);

} 

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ejCheckBox")) { //Ha pedido ver la ventana con el ejemplo de CheckBox
                EjemploCheckBox ventanaCB = new EjemploCheckBox();

                ventanaCB.setVisible(true);
        }

        if (e.getActionCommand().equals("ejRadioButton")) { //Ha pedido ver la ventana con el ejemplo de Radio Button
                EjemploRadioButton ventanaRB = new EjemploRadioButton();

                ventanaRB.setVisible(true);
        }

        if (e.getActionCommand().equals("ejScrollBar")) { //Ha pedido ver la ventana con el ejemplo de Scroll Bar
                VentanaScrollBar ventanaSB = new VentanaScrollBar();

                ventanaSB.setVisible(true);
        }

        if (e.getActionCommand().equals("ejSlider")) { //Ha pedido ver la ventana con el ejemplo de Slider
                VentanaSlider ventanaSL = new VentanaSlider();

                ventanaSL.setVisible(true);
        }

        if (e.getActionCommand().equals("ejList")) { //Ha pedido ver la ventana con el ejemplo de JList
                VentanaLista ventanaList = new VentanaLista();

                ventanaList.setVisible(true);
        }

        if (e.getActionCommand().equals("ejListaCombinada")) { //Ha pedido ver la ventana con el ejemplo de Lista Combinada
                VentanaListaCombinada ventanaLC = new VentanaListaCombinada();

                ventanaLC.setVisible(true);
        }

        if (e.getActionCommand().equals("ejColor")) { //Ha pedido ver la ventana con el ejemplo de Color Chooser
                // Parámetros: Componente padre, Título, Color inicial
                Color colorSeleccionado = JColorChooser.showDialog(null, "Elige un color para el fondo", Color.LIGHT_GRAY);

                        // Si el usuario no cancela, aplicamos el color
                        if (colorSeleccionado != null) {
                                getContentPane().setBackground(colorSeleccionado);
                        }
        }

        if (e.getActionCommand().equals("ejFile")) { //Ha pedido ver la ventana con el ejemplo de File Chooser
                JFileChooser selector = new JFileChooser(); 

                int returnVal = selector.showOpenDialog(null); 

                if(returnVal == JFileChooser.APPROVE_OPTION) { 
                        System.out.println("Se eligió el archivo " + selector.getSelectedFile().getName()); 
                }
        }

        if (e.getActionCommand().equals("ejMenu")) { //Ha pedido ver la ventana con el menú
                VentanaMenu ventanaM = new VentanaMenu();

                ventanaM.setVisible(true);
        }

        if (e.getActionCommand().equals("ejMenuContextual")) { //Ha pedido ver la ventana con el menú contextual
                VentanaMenuContextual ventanaMC = new VentanaMenuContextual();

                ventanaMC.setVisible(true);
        }

    }

    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        VentanaGridBagLayout ventanaGB = new VentanaGridBagLayout();
        JPanel jp=new JPanel(false); 
        jp.setLayout(new GridBagLayout());

        ventanaGB.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana
        ventanaGB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Creamos una nueva ventana con los elementos definidos más arriba
        ventanaGB.VentanaActual();
        
        // 4. Hacer que la ventana sea visible
        ventanaGB.setVisible(true);
    }
}