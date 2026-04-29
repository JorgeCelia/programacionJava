import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.util.ArrayList;

public class ContratosMuestraIndefinidos extends JFrame {

    JPanel jp;
    DefaultTableModel modelo;
    JTable tabla;
    ArrayList<ContratoIndefinido> contratos = new ArrayList<>();
    ContratoDAO gestor; //Objeto para acceder a la BD

    public ContratosMuestraIndefinidos() { 
        super("Listado de contratos indefinidos"); 
        setSize(600,700);

        jp=new JPanel(false); 
        jp.setLayout(null);

        this.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana (Si es llamada desde fuera, libera recursos pero no cierra el programa)
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        // 3. Rellenamos el ArrayList de esta ventana
        gestor = new ContratoDAO();
        gestor.cargaContratosIndefinidos(contratos);

        // 4. Creamos la ventana
        this.creaVentana();
    } 

    public void creaVentana(){ //Creamos la vista
        //Creamos los elementos gráficos de la aplicación que estamos creando
        getContentPane().setLayout(null); 

        //Creo la tabla donde insertaré los resultados
        // 1. Definir los nombres de las columnas
        String[] columnas = {"Nombre", "DNI", "Salario", "Fecha Inicio", "Días trabajados"};

        // 2. Creamos el modelo de la tabla vacío inicialmente
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);

        // --- CONFIGURACIÓN DE ANCHOS ---
        
        // A. Desactivar el auto-ajuste para que respete nuestros píxeles exactos
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // B. Obtener el modelo de columnas para manipularlas una por una
        TableColumnModel columnModel = tabla.getColumnModel();

        // Columna Nombre
        columnModel.getColumn(0).setPreferredWidth(225);
        
        // Columna DNI
        columnModel.getColumn(1).setPreferredWidth(75);      

        // Columna Salario
        columnModel.getColumn(2).setPreferredWidth(75);      

        // Columna Fecha Inicio
        columnModel.getColumn(3).setPreferredWidth(75);

        // Columna Tiempo Trabajado
        columnModel.getColumn(4).setPreferredWidth(100);
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


        // !Importante! Envolver la tabla en un JScrollPane 
        // Esto permite ver los encabezados y hacer scroll si hay muchos datos
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(30, 30, 550, 600);
        getContentPane().add(scrollPane);

        //Relleno la tabla
        for(ContratoIndefinido c:contratos) {
            modelo.addRow(new Object[]{c.getEmpleado(), c.getDni(), c.getSalario(), c.getFechaInicio(), c.tiempoTrabajado()});
        }        

        setVisible(true); 
    } 
}