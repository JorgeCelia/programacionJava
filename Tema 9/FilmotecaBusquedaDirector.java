import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FilmotecaBusquedaDirector extends JFrame implements ActionListener{

    JPanel jp;
    DefaultTableModel modelo;
    JTable tabla;
    ArrayList<Pelicula> peliculas;
    FilmotecaDAO gestor; //Objeto para acceder a la BD

    JTextField campoTitulo;
    JLabel etiquetaTitulo;
    JButton botonBusqueda;

    public FilmotecaBusquedaDirector() { 
        super("Búsqueda de películas por director"); 
        setSize(800,700);

        jp=new JPanel(false); 
        jp.setLayout(null);

        this.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana (Si es llamada desde fuera, libera recursos pero no cierra el programa)
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        // 3. Rellenamos el ArrayList de esta ventana
        gestor = new FilmotecaDAO();

        // 4. Creamos la ventana
        this.creaVentana();
    } 

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("botonBusqueda")) { //Ha pedido buscar por director
            if (campoTitulo.getText().equals("")) { //No ha escrito nada
                JOptionPane.showMessageDialog(this, "ERROR: Debes escribir un director para buscar");
            } else {
                peliculas = new ArrayList<>(); //reinicio el ArrayList cada vez que hago una búsqueda para borrar lo que hubiera antes
                int filas = gestor.cargaDatosBusquedaDirector(peliculas, campoTitulo.getText());

                if (filas>0) { //Hay algún resultado
                    //Borro lo que hubiese en la tabla
                    while(modelo.getRowCount()>0) {
                        modelo.removeRow(0);
                    }
                    
                    //Relleno la tabla
                    for(Pelicula p:peliculas) {
                        modelo.addRow(new Object[]{p.getTitulo(), p.getDirector(), p.getGenero(), p.getDuracion(), p.getNacionalidad(), p.getYear()});
                    }        
                } else { //No ha devuelto ningún resultado
                    JOptionPane.showMessageDialog(this, "No hay ninguna película del director "+campoTitulo.getText());
                }

            }
        }

    }


    public void creaVentana(){ //Creamos la vista
        //Creamos los elementos gráficos de la aplicación que estamos creando
        getContentPane().setLayout(null); 

        etiquetaTitulo = new JLabel("Director: ");
        etiquetaTitulo.setBounds(200, 50, 200, 20);

        getContentPane().add(etiquetaTitulo);

        campoTitulo = new JTextField();
        campoTitulo.setBounds(300, 50, 200, 20);

        getContentPane().add(campoTitulo);


        //Creo el botón para que me busque los datos por director
        botonBusqueda = new JButton("Buscar por director");
        botonBusqueda.setBounds(300, 100, 200, 20);
        botonBusqueda.setActionCommand("botonBusqueda");
        botonBusqueda.addActionListener(this);

        getContentPane().add(botonBusqueda);

     
     
        //Creo la tabla donde insertaré los resultados
        // 1. Definir los nombres de las columnas
        String[] columnas = {"Título", "Director", "Género", "Duración", "Nacionalidad", "Año"};

        // 2. Creamos el modelo de la tabla vacío inicialmente
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);

        // --- CONFIGURACIÓN DE ANCHOS ---
        
        // A. Desactivar el auto-ajuste para que respete nuestros píxeles exactos
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // B. Obtener el modelo de columnas para manipularlas una por una
        TableColumnModel columnModel = tabla.getColumnModel();

        // Columna Título
        columnModel.getColumn(0).setPreferredWidth(250);
        
        // Columna Director
        columnModel.getColumn(1).setPreferredWidth(150);      

        // Columna Género
        columnModel.getColumn(2).setPreferredWidth(75);      

        // Columna Duración
        columnModel.getColumn(3).setPreferredWidth(75);

        // Columna Nacionalidad
        columnModel.getColumn(4).setPreferredWidth(100);

        // Columna Año
        columnModel.getColumn(5).setPreferredWidth(50);
        // -------------------------------

        //Alineo las columnas
        // Ejemplo para centrar la primera columna
        DefaultTableCellRenderer rendererCentrado = new DefaultTableCellRenderer();
        rendererCentrado.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(rendererCentrado);
        tabla.getColumnModel().getColumn(1).setCellRenderer(rendererCentrado);
        tabla.getColumnModel().getColumn(2).setCellRenderer(rendererCentrado);
        tabla.getColumnModel().getColumn(3).setCellRenderer(rendererCentrado);
        tabla.getColumnModel().getColumn(4).setCellRenderer(rendererCentrado);
        tabla.getColumnModel().getColumn(5).setCellRenderer(rendererCentrado);


        // !Importante! Envolver la tabla en un JScrollPane 
        // Esto permite ver los encabezados y hacer scroll si hay muchos datos
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(50, 150, 725, 400);
        getContentPane().add(scrollPane);

        setVisible(true); 
    } 
}