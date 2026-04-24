import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame implements ActionListener {
    JButton ejCheckBox, ejRadioButton, ejScrollBar, ejSlider, ejList, ejListaCombinada, ejColor, ejFile, ejMenu, ejMenuContextual;

    public VentanaPrincipal() { 
        super("Ejemplo de Swing/AWT"); 
        setSize(600,500);
        setLocationRelativeTo(null);
    } 

    public void VentanaActual(){ 
        getContentPane().setLayout(null); 

        //Creo el botón para acceder a la ventana de CheckBox
        ejCheckBox = new JButton("Ejemplo Checkbox");
        ejCheckBox.setBounds(40, 20, 200, 20);
        ejCheckBox.setActionCommand("ejCheckBox");
        ejCheckBox.addActionListener(this);

        getContentPane().add(ejCheckBox);

        //Creo el botón para acceder a la ventana de Radio Button
        ejRadioButton = new JButton("Ejemplo Radio Button");
        ejRadioButton.setBounds(300, 20, 200, 20);
        ejRadioButton.setActionCommand("ejRadioButton");
        ejRadioButton.addActionListener(this);

        getContentPane().add(ejRadioButton);

        //Creo el botón para acceder a la ventana de Scroll Bar
        ejScrollBar = new JButton("Ejemplo Scroll Bar");
        ejScrollBar.setBounds(40, 60, 200, 20);
        ejScrollBar.setActionCommand("ejScrollBar");
        ejScrollBar.addActionListener(this);

        getContentPane().add(ejScrollBar);

        //Creo el botón para acceder a la ventana del Slider
        ejSlider = new JButton("Ejemplo Slider");
        ejSlider.setBounds(300, 60, 200, 20);
        ejSlider.setActionCommand("ejSlider");
        ejSlider.addActionListener(this);

        getContentPane().add(ejSlider);

        //Creo el botón para acceder a la ventana del JList
        ejList = new JButton("Ejemplo JList");
        ejList.setBounds(40, 100, 200, 20);
        ejList.setActionCommand("ejList");
        ejList.addActionListener(this);

        getContentPane().add(ejList);

        //Creo el botón para acceder a la ventana de Lista Combinada
        ejListaCombinada = new JButton("Ejemplo Lista Combinada");
        ejListaCombinada.setBounds(300, 100, 200, 20);
        ejListaCombinada.setActionCommand("ejListaCombinada");
        ejListaCombinada.addActionListener(this);

        getContentPane().add(ejListaCombinada);

        //Creo el botón para acceder a la ventana de color chooser
        ejColor = new JButton("Ejemplo Color Chooser");
        ejColor.setBounds(40, 140, 200, 20);
        ejColor.setActionCommand("ejColor");
        ejColor.addActionListener(this);

        getContentPane().add(ejColor);

        //Creo el botón para acceder a la ventana de Lista Combinada
        ejFile = new JButton("Ejemplo File Chooser");
        ejFile.setBounds(300, 140, 200, 20);
        ejFile.setActionCommand("ejFile");
        ejFile.addActionListener(this);

        getContentPane().add(ejFile);

        //Creo el botón para acceder a la ventana con un menú
        ejMenu = new JButton("Ejemplo de menú");
        ejMenu.setBounds(40, 180, 200, 20);
        ejMenu.setActionCommand("ejMenu");
        ejMenu.addActionListener(this);

        getContentPane().add(ejMenu);

        //Creo el botón para acceder a la ventana con un menú contextual
        ejMenuContextual = new JButton("Ejemplo de menú contextual");
        ejMenuContextual.setBounds(300, 180, 200, 20);
        ejMenuContextual.setActionCommand("ejMenuContextual");
        ejMenuContextual.addActionListener(this);

        getContentPane().add(ejMenuContextual);

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
        VentanaPrincipal ventanaPR = new VentanaPrincipal();
        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        ventanaPR.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana
        ventanaPR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Creamos una nueva ventana con los elementos definidos más arriba
        ventanaPR.VentanaActual();
        
        // 4. Hacer que la ventana sea visible
        ventanaPR.setVisible(true);
    }
}