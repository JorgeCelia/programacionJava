import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VentanaMenu extends JFrame implements ActionListener {
    JLabel descripción; 
    JMenuBar barraMenu;
    JMenu menuArchivo, menuEdicion;
    JMenuItem menuItemAbrir, menuItemSalir, menuItemColor;

    public VentanaMenu() { 
        super("Ventana con Menu"); 
        setSize(400,200);

        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        this.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana (Si es llamada desde fuera, libera recursos pero no cierra el programa)
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 3. Creamos la ventana
        this.creaVentana();      
    } 

    public void creaVentana(){ //Creamos la vista
        //Creamos los elementos gráficos de la aplicación que estamos creando
        getContentPane().setLayout(new FlowLayout()); 

        //Creamos la barra del menú
        barraMenu = new JMenuBar();

        //Añadimos las opciones principales a la barra del menú
        menuArchivo = new JMenu("Archivo");    // Creamos un menú con el nombre Archivo (primera forma de hacerlo)
        menuArchivo.setMnemonic(KeyEvent.VK_A); // Atajo: tecla Alt+A para el menú Archivo
        menuEdicion = new JMenu();    // Creamos otro menú
        menuEdicion.setText("Edición"); //Ponemos el texto a este menú (segunda forma de hacerlo)
        barraMenu.add(menuArchivo);   // Añadimos el primer menú a la barra
        barraMenu.add(menuEdicion);   // Añadimos el otro menú a la barra

        //Añadimos las opciones a cada uno de los menús
        //Opción Abrir en Archivo
        menuItemAbrir = new JMenuItem();    //Creamos el Item del menú 
        menuItemAbrir.setText("Abrir");     
        menuArchivo.add(menuItemAbrir);     //Lo añadimos al menú Abrir
        menuItemAbrir.setActionCommand("menuItemAbrir");    //Creo el evento para cuando se elija esta opción
        menuItemAbrir.addActionListener(this);  
        //Opción Salir en Archivo
        menuItemSalir = new JMenuItem("Salir");    //Creamos el Item del menú 
        menuArchivo.add(menuItemSalir);     //Lo añadimos al menú Archivo
        menuItemSalir.setActionCommand("menuItemSalir");    //Creo el evento para cuando se elija esta opción
        menuItemSalir.addActionListener(this);  
        //Opción Elegir Color en Edición
        menuItemColor = new JMenuItem("Elegir Color");    //Creamos el Item del menú 
        menuEdicion.add(menuItemColor);     //Lo añadimos al menú Edición
        menuItemColor.setActionCommand("menuItemColor");    //Creo el evento para cuando se elija esta opción
        menuItemColor.addActionListener(this);  


        this.setJMenuBar(barraMenu);    //Indicamos que la barra de menú corresponde a esta ventana

        setVisible(true); 
    } 

    public void actionPerformed(ActionEvent e){ 
        if (e.getActionCommand().equals("menuItemAbrir")) { //Ha pulsado la opción Abrir del menú Archivo
            JFileChooser selector = new JFileChooser(); 

            int returnVal = selector.showOpenDialog(null); 
            if(returnVal == JFileChooser.APPROVE_OPTION) { 
                System.out.println("Se eligió el archivo " + selector.getSelectedFile().getName()); 
            }
        }

        if (e.getActionCommand().equals("menuItemSalir")) { //Ha pulsado la opción Salir del menú Archivo
            super.dispose();
            //System.exit(0);
        }

        if (e.getActionCommand().equals("menuItemColor")) { //Ha pulsado la opción de elegir color en el menú Edición
            // Parámetros: Componente padre, Título, Color inicial
            Color colorSeleccionado = JColorChooser.showDialog(null, "Elige un color para el fondo", Color.LIGHT_GRAY);

            // Si el usuario no cancela, aplicamos el color
            if (colorSeleccionado != null) {
                getContentPane().setBackground(colorSeleccionado);
            }
        }
    } 

    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        VentanaMenu ventanaM = new VentanaMenu();

        //Al ser llamada en el main y ser la ventana principal, ponemos que cuando se cierre la ventana se acabe el programa
        ventanaM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 4. Hacer que la ventana sea visible
        ventanaM.setVisible(true);
    }


}