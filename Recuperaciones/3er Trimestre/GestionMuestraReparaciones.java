import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.util.ArrayList;

public class GestionMuestraReparaciones extends JFrame {

    JPanel jp;
    DefaultTableModel modelo;
    JTable tabla;
    ArrayList<Reparacion> reparaciones = new ArrayList<>();
    ReparacionesDAO gestor; //Objeto para acceder a la BD

    public GestionMuestraReparaciones() { 
        super("Listado de reparaciones"); 
        setSize(800,700);

        jp=new JPanel(false); 
        jp.setLayout(null);

        this.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana (Si es llamada desde fuera, libera recursos pero no cierra el programa)
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        // 3. Rellenamos el ArrayList de esta ventana
        gestor = new ReparacionesDAO();
        reparaciones=gestor.cargaDatosReparaciones();

        // 4. Creamos la ventana
        this.creaVentana();
    } 

    public void creaVentana(){ //Creamos la vista
        //Creamos los elementos gráficos de la aplicación que estamos creando
        getContentPane().setLayout(null); 

        //Creo la tabla donde insertaré los resultados
        // 1. Definir los nombres de las columnas
        String[] columnas = {"Tipo Reparación", "Nombre", "DNI", "Precio Base", "Fecha entrada", "Horas Trabajo", "Tipo", "Precio Total"};

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
         for(Reparacion r:reparaciones) {
            if (r instanceof ReparacionMovil) { //Es una reparación móvil
                if (r.getTipoAveria()=='P') { //Es una reparación de pantalla
                    modelo.addRow(new Object[]{"Móvil", r.getNombreCliente(), r.getDni(), r.getPrecioBase()+"€", r.getFechaEntrada(), r.getHorasTrabajo(), "Pantalla", r.getPrecioTotal()+"€"});
                } else if (r.getTipoAveria()=='B') { //Es una reparación de batería
                    modelo.addRow(new Object[]{"Móvil", r.getNombreCliente(), r.getDni(), r.getPrecioBase()+"€", r.getFechaEntrada(), r.getHorasTrabajo(), "Batería", r.getPrecioTotal()+"€"});
                } else { //Es una reparación de conectividad
                    modelo.addRow(new Object[]{"Móvil", r.getNombreCliente(), r.getDni(), r.getPrecioBase()+"€", r.getFechaEntrada(), r.getHorasTrabajo(), "Conectividad", r.getPrecioTotal()+"€"});
                }
            } else { //Es una reparación de ordenador
                if (r.getLimpiezaInterna()=='S') { //Hay que limpiar el ordenador por dentro
                    modelo.addRow(new Object[]{"Ordenador", r.getNombreCliente(), r.getDni(), r.getPrecioBase()+"€", r.getFechaEntrada(), r.getHorasTrabajo(), "Con Limpieza", r.getPrecioTotal()+"€"});
                } else { //Es pensión completa
                    modelo.addRow(new Object[]{"Ordenador", r.getNombreCliente(), r.getDni(), r.getPrecioBase()+"€", r.getFechaEntrada(), r.getHorasTrabajo(), "Sin Limpieza", r.getPrecioTotal()+"€"});
                }
            }
        }

        setVisible(true); 
    } 
}