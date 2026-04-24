import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class VentanaMenuContextual extends JFrame implements ActionListener {
    JLabel descripción; 
    JPopupMenu menuEmergente;
    JMenuItem menuItemAbrir, menuItemSalir, menuItemColor;
    JPanel jp;

    public VentanaMenuContextual() { 
        super("Ventana con Menu Contextual"); 
        setSize(400,200);

        jp=new JPanel(false); 
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
        menuEmergente = new JPopupMenu("Menú emergente");

        //Añadimos las opciones al menú emergente
        //Opción Abrir
        menuItemAbrir = new JMenuItem();    //Creamos el Item del menú 
        menuItemAbrir.setText("Abrir");     
        menuEmergente.add(menuItemAbrir);     //Lo añadimos al menú contextual
        menuItemAbrir.setActionCommand("menuItemAbrir");    //Creo el evento para cuando se elija esta opción
        menuItemAbrir.addActionListener(this);  
        //Opción Elegir Color en Edición
        menuItemColor = new JMenuItem("Elegir Color");    //Creamos el Item del menú 
        menuEmergente.add(menuItemColor);     //Lo añadimos al menú contextual
        menuItemColor.setActionCommand("menuItemColor");    //Creo el evento para cuando se elija esta opción
        menuItemColor.addActionListener(this);  
        //Opción Salir
        menuItemSalir = new JMenuItem("Salir");    //Creamos el Item del menú 
        menuEmergente.add(menuItemSalir);     //Lo añadimos al menú contextual
        menuItemSalir.setActionCommand("menuItemSalir");    //Creo el evento para cuando se elija esta opción
        menuItemSalir.addActionListener(this);  

        jp.setComponentPopupMenu(menuEmergente); //El Menú contextual debe añadirse al panel. 
        // Como no es accesible desde este método hay que declararlo como atributo de la clase 

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
        VentanaMenuContextual ventanaMC = new VentanaMenuContextual();

        //Al ser llamada en el main y ser la ventana principal, ponemos que cuando se cierre la ventana se acabe el programa
        ventanaMC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 4. Hacer que la ventana sea visible
        ventanaMC.setVisible(true);
    }


}