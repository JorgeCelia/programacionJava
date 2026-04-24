import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.util.ArrayList;

public class FilmotecaBruto extends JFrame {

    JPanel jp;
    DefaultTableModel modelo;
    JTable tabla;
    ArrayList<Pelicula> peliculas = new ArrayList<>();
    FilmotecaDAO gestor; //Objeto para acceder a la BD

    public FilmotecaBruto() { 
        super("Contenido de la filmoteca"); 
        setSize(800,700);

        jp=new JPanel(false); 
        jp.setLayout(null);

        this.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana (Si es llamada desde fuera, libera recursos pero no cierra el programa)
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        // 3. Rellenamos el ArrayList de esta ventana
        gestor = new FilmotecaDAO();
        gestor.cargaDatosBruto(peliculas);

        // 4. Creamos la ventana
        this.creaVentana();
    } 

    public void creaVentana(){ //Creamos la vista
        //Creamos los elementos gráficos de la aplicación que estamos creando
        getContentPane().setLayout(null); 

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
        scrollPane.setBounds(50, 30, 725, 600);
        getContentPane().add(scrollPane);

        //Relleno la tabla
        for(Pelicula p:peliculas) {
            modelo.addRow(new Object[]{p.getTitulo(), p.getDirector(), p.getGenero(), p.getDuracion(), p.getNacionalidad(), p.getYear()});
        }        

        setVisible(true); 
    } 
}