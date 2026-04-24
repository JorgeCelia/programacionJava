import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EditorTexto extends JFrame implements ActionListener{
    JTextArea texto;
    JMenuBar barraMenu;
    JMenu menuArchivo, menuAyuda;
    JMenuItem menuItemAbrir, menuItemNuevo, menuItemGuardar, menuItemSalir, menuItemInformacion, menuItemAcercaDe;
    JLabel etiquetaArchivo;
    JTextField campoArchivo;
   

    public EditorTexto() { 
        super("Editor de texto"); 
        setSize(500,600);
        setLocationRelativeTo(null);
    } 

    public void creaVentana(){ //Vista
        getContentPane().setLayout(null); 

        //Creamos la barra del menú
        barraMenu = new JMenuBar();
        this.setJMenuBar(barraMenu);    //Indicamos que la barra de menú corresponde a esta ventana

        //Añadimos las opciones principales a la barra del menú
        menuArchivo = new JMenu("Archivo");    // Creamos un menú con el nombre Archivo (primera forma de hacerlo)
        menuAyuda = new JMenu();    // Creamos otro menú
        menuAyuda.setText("Ayuda"); //Ponemos el texto a este menú (segunda forma de hacerlo)
        barraMenu.add(menuArchivo);   // Añadimos el primer menú a la barra
        barraMenu.add(menuAyuda);   // Añadimos el otro menú a la barra

        //Añadimos las opciones a cada uno de los menús
        //Opción Nuevo en Archivo
        menuItemNuevo = new JMenuItem();    //Creamos el Item del menú 
        menuItemNuevo.setText("Nuevo");     
        menuArchivo.add(menuItemNuevo);     //Lo añadimos al menú Archivo
        menuItemNuevo.setActionCommand("menuItemNuevo");    //Creo el evento para cuando se elija esta opción
        menuItemNuevo.addActionListener(this);  

        //Opción Abrir en Archivo
        menuItemAbrir = new JMenuItem();    //Creamos el Item del menú 
        menuItemAbrir.setText("Abrir");     
        menuArchivo.add(menuItemAbrir);     //Lo añadimos al menú Archivo
        menuItemAbrir.setActionCommand("menuItemAbrir");    //Creo el evento para cuando se elija esta opción
        menuItemAbrir.addActionListener(this);  

        //Opción Guardar en Archivo
        menuItemGuardar = new JMenuItem();    //Creamos el Item del menú 
        menuItemGuardar.setText("Guardar");     
        menuArchivo.add(menuItemGuardar);     //Lo añadimos al menú Archivo
        menuItemGuardar.setActionCommand("menuItemGuardar");    //Creo el evento para cuando se elija esta opción
        menuItemGuardar.addActionListener(this);  

        //Opción Salir en Archivo
        menuItemSalir = new JMenuItem("Salir");    //Creamos el Item del menú 
        menuArchivo.add(menuItemSalir);     //Lo añadimos al menú Archivo
        menuItemSalir.setActionCommand("menuItemSalir");    //Creo el evento para cuando se elija esta opción
        menuItemSalir.addActionListener(this); 

        //Opción Información en Ayuda
        menuItemInformacion = new JMenuItem("Información");    //Creamos el Item del menú 
        menuAyuda.add(menuItemInformacion);     //Lo añadimos al menú Ayuda
        menuItemInformacion.setActionCommand("menuItemInformacion");    //Creo el evento para cuando se elija esta opción
        menuItemInformacion.addActionListener(this);  

        //Opción Acerca De en Ayuda
        menuItemAcercaDe = new JMenuItem("Acerca De...");    //Creamos el Item del menú 
        menuAyuda.add(menuItemAcercaDe);     //Lo añadimos al menú Ayuda
        menuItemAcercaDe.setActionCommand("menuItemAcercaDe");    //Creo el evento para cuando se elija esta opción
        menuItemAcercaDe.addActionListener(this);  

        //Ponemos el área de texto
        texto = new JTextArea();
        texto.setBounds(10, 15, 480, 450);
        getContentPane().add(texto); 


        //Ponemos la etiqueta y el campo para el nombre del archivo
        etiquetaArchivo = new JLabel("Nombre del archivo:");
        etiquetaArchivo.setBounds(20, 500, 150, 20);
        getContentPane().add(etiquetaArchivo); 

        campoArchivo = new JTextField();
        campoArchivo.setBounds(175, 500, 300, 20);
        getContentPane().add(campoArchivo); 

        setVisible(true);  
    } 

    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        EditorTexto ventana = new EditorTexto();
        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        ventana.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Creamos una nueva ventana con los elementos definidos más arriba
        ventana.creaVentana();
        
        // 4. Hacer que la ventana sea visible
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) { //Controlador
        if (e.getActionCommand().equals("menuItemNuevo")) { //Ha pulsado la opción Nuevo del menú Archivo
            texto.setText("");
            this.setTitle("Editor de texto");
        }

        if (e.getActionCommand().equals("menuItemAbrir")) { //Ha pulsado la opción Abrir del menú Archivo
            String linea;
            JFileChooser selector = new JFileChooser(); 

            int returnVal = selector.showOpenDialog(null); 
            if(returnVal == JFileChooser.APPROVE_OPTION) { 
                //Leo el fichero elegido y lo escribo en el textArea
                try {
                    //Creo el escritor del fichero
                    FileReader lector = new FileReader(selector.getSelectedFile().getName());
                    BufferedReader buffer = new BufferedReader(lector);

                    texto.setText("");

                    //Recorremos el fichero leyendo línea a línea
                    while((linea = buffer.readLine()) != null) {
                        texto.append(linea+"\n");
                    }
                        
                    //Cerramos las estructuras de lectura
                    lector.close();
                    buffer.close();

                    //Cambiamos el titulo de la ventana
                    this.setTitle("Editor de texto - "+selector.getSelectedFile().getName());
                } catch (IOException error) {
                    System.out.println("Error al abrir el fichero "+error.getMessage());
                }

            }
        }

        if (e.getActionCommand().equals("menuItemGuardar")) { //Ha pulsado la opción Guardar del menú Archivo
            //Compruebo si hay algún nombre de fichero en el campo correspondiente
            if (campoArchivo.getText().equals("")) { //No hay nada escrito
                JOptionPane.showMessageDialog(this, "ERROR: Debes poner un nombre de archivo");
            } else { //Hay un nombre de archivo puesto
                try {
                    //Creo el escritor del fichero
                    FileWriter escritor = new FileWriter(campoArchivo.getText());

                    escritor.write(texto.getText());

                    //Cierro el fichero
                    escritor.close();                       
                    JOptionPane.showMessageDialog(this, "Archivo "+campoArchivo.getText()+" generado correctamente");
                } catch (IOException error) {
                    System.out.println("Error al abrir el fichero "+error.getMessage());
                }
            }            
        }

        if (e.getActionCommand().equals("menuItemSalir")) { //Ha pulsado la opción Salir del menú Archivo
            this.dispose();
        }


        if (e.getActionCommand().equals("menuItemInformacion")) {  //Ha pulsado la opción Información del menú Ayuda
            //Cuento las palabras que hay el textArea
            int numPalabras = cuentaPalabras(texto.getText());
            
            //Creo la ventana de información con el número de palabras del textArea
            VentanaInformacion info = new VentanaInformacion(numPalabras);

            info.setVisible(true);
        }

        if (e.getActionCommand().equals("menuItemAcercaDe")) {  //Ha pulsado la opción Acerca De del menú Ayuda
            VentanaAcercaDe acerca = new VentanaAcercaDe();

            acerca.setVisible(true);
        }
    }

    public int cuentaPalabras(String linea) {
        int contador = 0;
        //Cuento los espacios y añado 1
        for (int i=0; i<linea.length(); i++) {
            if (linea.charAt(i) == ' ' || linea.charAt(i) == '\n') {
                contador++;
            }
        }
        return contador+1;
    }
}