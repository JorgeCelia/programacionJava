import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VentanaCargaImagen extends JFrame implements ActionListener {
    JLabel descripción; 
    JMenuBar barraMenu;
    JMenu menuArchivo;
    JButton botonAbrir;
    JMenuItem menuItemAbrir;

    public VentanaCargaImagen() { 
        super("Cargar una imagen"); 
        setSize(400,500);

        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        this.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana (Si es llamada desde fuera, libera recursos pero no cierra el programa)
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        // 3. Creamos la ventana
        this.creaVentana();      
    } 

    public void creaVentana(){ //Creamos la vista
        //Creamos los elementos gráficos de la aplicación que estamos creando
        getContentPane().setLayout(null); 

        //Creamos la barra del menú
        barraMenu = new JMenuBar();

        //Añadimos las opciones principales a la barra del menú
        menuArchivo = new JMenu("Archivo");    // Creamos un menú con el nombre Archivo (primera forma de hacerlo)
        menuArchivo.setMnemonic(KeyEvent.VK_A); // Atajo: tecla Alt+A para el menú Archivo
        barraMenu.add(menuArchivo);   // Añadimos el primer menú a la barra

        //Añadimos las opciones a cada uno de los menús
        //Opción Abrir en Archivo
        menuItemAbrir = new JMenuItem();    //Creamos el Item del menú 
        menuItemAbrir.setText("Abrir");     
        menuArchivo.add(menuItemAbrir);     //Lo añadimos al menú Abrir
        menuItemAbrir.setActionCommand("menuItemAbrir");    //Creo el evento para cuando se elija esta opción
        menuItemAbrir.addActionListener(this);        

        this.setJMenuBar(barraMenu);    //Indicamos que la barra de menú corresponde a esta ventana

        //Coloco la zona donde irá la imagen
        descripción = new JLabel();
        descripción.setBounds(100, 50, 200, 300);
        this.add(descripción);

        //Creo el botón para elegir el archivo
        botonAbrir = new JButton("Buscar Imagen");
        botonAbrir.setBounds(100, 370, 200, 20);
        botonAbrir.setActionCommand("botonAbrir");
        botonAbrir.addActionListener(this);

        getContentPane().add(botonAbrir);

        setVisible(true); 
    } 

    public void actionPerformed(ActionEvent e){ 
        if (e.getActionCommand().equals("menuItemAbrir") || e.getActionCommand().equals("botonAbrir")) { 
            //Ha elegido buscar la imagen por el botón o por el menú
            JFileChooser selector = new JFileChooser(); 

            int returnVal = selector.showOpenDialog(null); 
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                descripción.setIcon(new ImageIcon(selector.getSelectedFile().getAbsolutePath()));
                descripción.repaint();
            }
        }
    } 

    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        VentanaCargaImagen ventanaM = new VentanaCargaImagen();

        //Al ser llamada en el main y ser la ventana principal, ponemos que cuando se cierre la ventana se acabe el programa
        ventanaM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 4. Hacer que la ventana sea visible
        ventanaM.setVisible(true);
    }


}