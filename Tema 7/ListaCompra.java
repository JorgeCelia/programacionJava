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

public class ListaCompra extends JFrame implements ActionListener {
    JLabel descripción, productoLabel, cantidadLabel, precioLabel, preciofinal;
    JTextField producto, cantidad, precio;
    JButton botonAñadir;
    JPanel jp;
    DefaultTableModel modelo;
    JTable tabla;

    public ListaCompra() { 
        super("Lista de la compra"); 
        setSize(500,700);

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
        descripción.setBounds(200, 20, 200, 30);
        descripción.setText("Lista de la compra");
        this.add(descripción);

        //Campo de etiquetas y recogida de datos para el producto
        productoLabel = new JLabel("Producto");
        productoLabel.setBounds(20, 70, 60, 20);
        getContentPane().add(productoLabel);

        producto = new JTextField();
        producto.setBounds(100, 70, 300, 20);
        getContentPane().add(producto);

        //Campo de etiquetas y recogida de datos para el producto
        precioLabel = new JLabel("Precio");
        precioLabel.setBounds(20, 100, 60, 20);
        getContentPane().add(precioLabel);

        precio = new JTextField();
        precio.setBounds(100, 100, 50, 20);
        getContentPane().add(precio);

        //Campo de etiquetas y recogida de datos para la cantidad de productos
        cantidadLabel = new JLabel("Cantidad");
        cantidadLabel.setBounds(20, 130, 60, 20);
        getContentPane().add(cantidadLabel);

        cantidad = new JTextField();
        cantidad.setBounds(100, 130, 50, 20);
        getContentPane().add(cantidad);

        //Creo el botón para añadir productos a la lista
        botonAñadir = new JButton("Añadir producto");
        botonAñadir.setBounds(150, 180, 200, 20);
        botonAñadir.setActionCommand("botonAñadir");
        botonAñadir.addActionListener(this);
        getContentPane().add(botonAñadir);

        //Creo la tabla donde insertaré las búsquedas
        // 1. Definir los nombres de las columnas
        String[] columnas = {"Producto", "Precio", "Cantidad"};

        // 2. Creamos el modelo de la tabla vacío inicialmente
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);

        // --- CONFIGURACIÓN DE ANCHOS ---
        
        // A. Desactivar el auto-ajuste para que respete nuestros píxeles exactos
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // B. Obtener el modelo de columnas para manipularlas una por una
        TableColumnModel columnModel = tabla.getColumnModel();

        // Columna Precio
        columnModel.getColumn(0).setPreferredWidth(250);
        
        // Columna Precio
        columnModel.getColumn(1).setPreferredWidth(75);      

        // Columna Cantidad
        columnModel.getColumn(2).setPreferredWidth(65);      
        // -------------------------------

        //Alineo las columnas
        // Ejemplo para centrar la primera columna
        DefaultTableCellRenderer rendererCentrado = new DefaultTableCellRenderer();
        rendererCentrado.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(rendererCentrado);
        tabla.getColumnModel().getColumn(1).setCellRenderer(rendererCentrado);


        // 3. ¡Importante! Envolver la tabla en un JScrollPane 
        // Esto permite ver los encabezados y hacer scroll si hay muchos datos
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(50, 230, 400, 350);
        getContentPane().add(scrollPane);

        //Campo para el precio final
        preciofinal = new JLabel("Precio Final: 0€");
        preciofinal.setBounds(200, 610, 150, 20);
        getContentPane().add(preciofinal);


        setVisible(true); 
    } 

    //Método de control de las acciones
    public void actionPerformed(ActionEvent e){ 
        if (e.getActionCommand().equals("botonAñadir")) { 
            //Compruebo que las cajas tienen algo escrito
            if (!producto.getText().equals("") && !cantidad.getText().equals("") && !precio.getText().equals("")){
                //Añado el producto, el precio y la cantidad que haya en las cajas
                modelo.addRow(new Object[]{producto.getText(), precio.getText(), cantidad.getText()});

                //Recorro la tabla y voy calculando el precio final
                double total = 0;
                for (int i = 0; i < tabla.getRowCount(); i++) {
                    //Cada elemento de la tabla es de tipo Object. Lo paso a String y eso lo transformo a Double
                    total = total + (Double.parseDouble(tabla.getValueAt(i, 1).toString())*Double.parseDouble(tabla.getValueAt(i, 2).toString()));
                }
                preciofinal.setText("Precio Final: "+total+"€");
            }
            else {
                JOptionPane.showMessageDialog(this, "ERROR: Los campos deben estar rellenos");

            }
            
        }
    } 

    public static void main(String[] args) {      
        // 1. Crear el marco (la ventana principal)
        ListaCompra ventanaLC = new ListaCompra();

        //Al ser llamada en el main y ser la ventana principal, ponemos que cuando se cierre la ventana se acabe el programa
        ventanaLC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 4. Hacer que la ventana sea visible
        ventanaLC.setVisible(true);
    } //Cierro el main
}