import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class VentanaFilmoteca extends JFrame implements ActionListener, WindowListener {
    JLabel descripción; 
    JButton botonBuscarDirector, botonBuscarGenero;
    JPanel jp;
    static ArrayList<Pelicula> peliculas = new ArrayList<>();
    DefaultTableModel modelo;
    JTable tabla;
    SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

    public VentanaFilmoteca() { 
        super("Gestión de filmoteca"); 
        setSize(400,500);

        jp=new JPanel(false); 
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


        //Coloco el título
        descripción = new JLabel();
        descripción.setBounds(130, 20, 200, 30);
        descripción.setText("Gestión de la filmoteca");
        this.add(descripción);

        //Creo el botón para buscar por director
        botonBuscarDirector = new JButton("Buscar por director");
        botonBuscarDirector.setBounds(100, 80, 200, 20);
        botonBuscarDirector.setActionCommand("botonBuscarDirector");
        botonBuscarDirector.addActionListener(this);

        //Creo el botón para buscar por director
        botonBuscarGenero = new JButton("Buscar por género");
        botonBuscarGenero.setBounds(100, 120, 200, 20);
        botonBuscarGenero.setActionCommand("botonBuscarGenero");
        botonBuscarGenero.addActionListener(this);

        //Creo la tabla donde insertaré las búsquedas
        // 1. Definir los nombres de las columnas
        String[] columnas = {"Búsqueda", "Hora"};

        // 2. Creamos el modelo de la tabla vacío inicialmente
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);

        // --- CONFIGURACIÓN DE ANCHOS ---
        
        // A. Desactivar el auto-ajuste para que respete nuestros píxeles exactos
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // B. Obtener el modelo de columnas para manipularlas una por una
        TableColumnModel columnModel = tabla.getColumnModel();

        // Columna Búsqueda: Más ancha
        columnModel.getColumn(0).setPreferredWidth(200);
        
        // Columna Hora: La mitad de ancha que la otra
        columnModel.getColumn(1).setPreferredWidth(100);      
        // -------------------------------

        // 3. ¡Importante! Envolver la tabla en un JScrollPane 
        // Esto permite ver los encabezados y hacer scroll si hay muchos datos
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(50, 170, 300, 250);

        getContentPane().add(botonBuscarDirector);
        getContentPane().add(botonBuscarGenero);
        getContentPane().add(scrollPane);

        setVisible(true); 
    } 

    //Método de control de las acciones
    public void actionPerformed(ActionEvent e){ 
        if (e.getActionCommand().equals("botonBuscarDirector")) { 
            //Creo la ventana de búsqueda por director
            VentanaFilmotecaDirector ventanaFD = new VentanaFilmotecaDirector();

            //Hago que el arryList de peliculas leido del fichero sea apuntado por el arrayList de VentanaFilmotecaDirector
            ventanaFD.datosFilmoteca(peliculas);

            ventanaFD.addWindowListener(this);

            ventanaFD.setVisible(true);

            //Añado la búsqueda que he hecho y la hora a la que le he hecho
            modelo.addRow(new Object[]{"Búsqueda por director", formatoHora.format(new Date())});

        }

        if (e.getActionCommand().equals("botonBuscarGenero")) { 
            //Creo la ventana de búsqueda por género
            VentanaFilmotecaGenero ventanaG = new VentanaFilmotecaGenero();

            //Hago que el arrayList de peliculas leido del fichero sea apuntado por el arrayList de VentanaFilmotecaGenero
            ventanaG.datosFilmoteca(peliculas);

            ventanaG.addWindowListener(this);

            ventanaG.setVisible(true);

            //Añado la búsqueda que he hecho y la hora a la que le he hecho
            modelo.addRow(new Object[]{"Búsqueda por género", formatoHora.format(new Date())});
        }
    } 

    //Métodos de control de ventana
    @Override
    public void windowClosed(WindowEvent e) {
        //Compruebo desde qué ventana estoy volviendo
        if (e.getSource() instanceof VentanaFilmotecaDirector) { 
            System.out.println("Volviendo de la ventana de la búsqueda por director...");
        }

        if (e.getSource() instanceof VentanaFilmotecaGenero) { 
            System.out.println("Volviendo de la ventana de la búsqueda por género...");
        }
    }

    // WindowListener te pide implementar estos también (se pueden dejar vacíos)
    @Override public void windowOpened(WindowEvent e) {}
    @Override public void windowClosing(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}

    public static void main(String[] args) {
        FileReader archivo;
        BufferedReader buffer;
        String linea;
       
        //Leo el archivo de películas
        try {
            //Creo las estructuras para leer del archivo
            archivo = new FileReader("filmoteca.txt");
            buffer = new BufferedReader(archivo);

            //Voy leyendo línea a línea del archivo
            while((linea = buffer.readLine()) != null) {
                peliculas.add(new Pelicula(linea)); //Con cada línea crea un objeto película
            }
 
            //Cierro las estructuras de lectura
            archivo.close();
            buffer.close();

        } catch (IOException e) {
            System.out.println("Error al abrir el fichero "+e.getMessage());
        }

        // 1. Crear el marco (la ventana principal)
        VentanaFilmoteca ventanaF = new VentanaFilmoteca();

        //Al ser llamada en el main y ser la ventana principal, ponemos que cuando se cierre la ventana se acabe el programa
        ventanaF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 4. Hacer que la ventana sea visible
        ventanaF.setVisible(true);
    } //Cierro el main
}