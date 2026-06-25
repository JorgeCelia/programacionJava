import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.util.ArrayList;

public class GestionMuestraReservas extends JFrame {

    JPanel jp;
    DefaultTableModel modelo;
    JTable tabla;
    ArrayList<Reserva> reservas = new ArrayList<>();
    ReservasDAO gestor; //Objeto para acceder a la BD

    public GestionMuestraReservas() { 
        super("Listado de reservas"); 
        setSize(800,700);

        jp=new JPanel(false); 
        jp.setLayout(null);

        this.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana (Si es llamada desde fuera, libera recursos pero no cierra el programa)
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        // 3. Rellenamos el ArrayList de esta ventana
        gestor = new ReservasDAO();
        reservas=gestor.cargaDatosReservas();

        // 4. Creamos la ventana
        this.creaVentana();
    } 

    public void creaVentana(){ //Creamos la vista
        //Creamos los elementos gráficos de la aplicación que estamos creando
        getContentPane().setLayout(null); 

        //Creo la tabla donde insertaré los resultados
        // 1. Definir los nombres de las columnas
        String[] columnas = {"Tipo Reserva", "Nombre", "DNI", "Precio/Noche", "Fecha entrada", "Número noches", "Tipo", "Precio Total"};

        // 2. Creamos el modelo de la tabla vacío inicialmente
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);

        // --- CONFIGURACIÓN DE ANCHOS ---
        
        // A. Desactivar el auto-ajuste para que respete nuestros píxeles exactos
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // B. Obtener el modelo de columnas para manipularlas una por una
        TableColumnModel columnModel = tabla.getColumnModel();

        // Columna Tipo Reserva
        columnModel.getColumn(0).setPreferredWidth(75);
        
        // Columna Nombre
        columnModel.getColumn(1).setPreferredWidth(150);      

        // Columna DNI
        columnModel.getColumn(2).setPreferredWidth(75);      

        // Columna Precio Por Noche
        columnModel.getColumn(3).setPreferredWidth(100);

        // Columna Fecha de entrada
        columnModel.getColumn(4).setPreferredWidth(100);

        // Columna Número de noches
        columnModel.getColumn(5).setPreferredWidth(100);

        // Columna tipo en cada reserva
        columnModel.getColumn(6).setPreferredWidth(50);

        // Columna Precio total
        columnModel.getColumn(7).setPreferredWidth(100);
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
        tabla.getColumnModel().getColumn(6).setCellRenderer(rendererCentrado);
        tabla.getColumnModel().getColumn(7).setCellRenderer(rendererCentrado);


        // !Importante! Envolver la tabla en un JScrollPane 
        // Esto permite ver los encabezados y hacer scroll si hay muchos datos
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(25, 30, 750, 600);
        getContentPane().add(scrollPane);

        //Relleno la tabla
        for(Reserva r:reservas) {
            if (r instanceof ReservaEstandar) { //Es una reserva estándar
                if (r.getTipoHabitacion()=='I') { //Es una habitación Individual
                    modelo.addRow(new Object[]{"Estandar", r.getNombreCliente(), r.getDni(), r.getPrecioNoche()+"€", r.getFechaEntrada(), r.getNumNoches(), "Indiv.", r.getPrecioTotal()+"€"});
                } else if (r.getTipoHabitacion()=='D') { //Es una habitación Doble
                    modelo.addRow(new Object[]{"Estandar", r.getNombreCliente(), r.getDni(), r.getPrecioNoche()+"€", r.getFechaEntrada(), r.getNumNoches(), "Doble", r.getPrecioTotal()+"€"});
                } else { //Es una Suite
                    modelo.addRow(new Object[]{"Estandar", r.getNombreCliente(), r.getDni(), r.getPrecioNoche()+"€", r.getFechaEntrada(), r.getNumNoches(), "Suite", r.getPrecioTotal()+"€"});
                }
            } else { //Es una reserva con pensión
                if (r.getPension().equals("MP")) { //Es media pension
                    modelo.addRow(new Object[]{"Pensión", r.getNombreCliente(), r.getDni(), r.getPrecioNoche()+"€", r.getFechaEntrada(), r.getNumNoches(), "Media P.", r.getPrecioTotal()+"€"});
                } else { //Es pensión completa
                    modelo.addRow(new Object[]{"Pensión", r.getNombreCliente(), r.getDni(), r.getPrecioNoche()+"€", r.getFechaEntrada(), r.getNumNoches(), "P. Com.", r.getPrecioTotal()+"€"});
                }
            }
        }        

        setVisible(true); 
    } 
}