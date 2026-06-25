import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionFarmacia extends JFrame implements ActionListener {   

    JButton muestraCatalogo, buscaProducto, muestraMedicamentos, estadisticas;
    JLabel etiquetaBusqueda;
    JTextField campoBusqueda;
    JTextArea areaResultado;
    static ArrayList<Producto> productos;

    public GestionFarmacia() { 
        super("Gestión de la farmacia CeliaSalud"); 
        setSize(500,600);
        setLocationRelativeTo(null);
    } 

    public void VentanaActual(){ 
        getContentPane().setLayout(null); 

        //Coloco la etiqueta de la búsqueda
        etiquetaBusqueda = new JLabel("Buscar contenido: ");
        etiquetaBusqueda.setBounds(50, 20, 200, 20);
        getContentPane().add(etiquetaBusqueda);

        //Coloco el campo de búsqueda
        campoBusqueda = new JTextField();
        campoBusqueda.setBounds(200, 20, 250, 20);
        getContentPane().add(campoBusqueda);

        //Coloco el area de resultados
        areaResultado = new JTextArea();
        areaResultado.setBounds(50, 140, 400, 400);
        getContentPane().add(areaResultado);

        //Coloco el botón que muestra todo el catálogo
        muestraCatalogo = new JButton("Mostrar Catálogo");
        muestraCatalogo.setBounds(50, 60, 150, 20);
        muestraCatalogo.setActionCommand("muestraCatalogo");
        muestraCatalogo.addActionListener(this);
        getContentPane().add(muestraCatalogo);

        //Coloco el botón que muestra todos los medicamentos
        muestraMedicamentos = new JButton("Muestra Medicamentos");
        muestraMedicamentos.setBounds(300, 60, 150, 20);
        muestraMedicamentos.setActionCommand("muestraMedicamentos");
        muestraMedicamentos.addActionListener(this);
        getContentPane().add(muestraMedicamentos);

        //Coloco el botón que busca un producto por el nombre
        buscaProducto = new JButton("Busca por nombre");
        buscaProducto.setBounds(50, 100, 150, 20);
        buscaProducto.setActionCommand("buscaProducto");
        buscaProducto.addActionListener(this);
        getContentPane().add(buscaProducto);

        //Coloco el botón que muestra las estadísticas
        estadisticas = new JButton("Estadísticas");
        estadisticas.setBounds(300, 100, 150, 20);
        estadisticas.setActionCommand("estadisticas");
        estadisticas.addActionListener(this);
        getContentPane().add(estadisticas);
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getActionCommand().equals("muestraCatalogo")) { //Ha pedido ver todo el catálogo
            areaResultado.setText(""); //Vacío el JTextArea

            //Recorro el array con el catálogo
            for (Producto p:productos) {
                areaResultado.append(p.mostrarDatos()+"\n");
            }
        }

        if (e.getActionCommand().equals("muestraMedicamentos")) { //Ha pedido ver todos los medicamentos
            areaResultado.setText(""); //Vacío el JTextArea
            areaResultado.append("===== MEDICAMENTOS ====="+"\n"+"\n");

            //Recorro el array con el catálogo
            for (Producto p:productos) {
                if (p instanceof Medicamento) { //Es un medicamento
                    areaResultado.append(p.mostrarDatos()+"\n");
                }
            }
        }

        if (e.getActionCommand().equals("buscaProducto")) { //Ha pedido buscar productos por nombre
            areaResultado.setText(""); //Vacío el JTextArea

            if (campoBusqueda.getText().equals("")) { //No ha escrito nada en el campo de búsqueda
                JOptionPane.showMessageDialog(this, "ERROR: Debes escribir algo en el campo de búsqueda");
            } else { //Hay algo escrito
                //Recorro el array con el catálogo
                for (Producto p:productos) {
                    if (p.getNombre().toLowerCase().contains(campoBusqueda.getText().toLowerCase())) {  //El nombre del producto contiene lo del campo de búsqueda
                        areaResultado.append(p.mostrarDatos()+"\n");
                    }
                }
            }
        }

        if (e.getActionCommand().equals("estadisticas")) { //Ha pedido ver las estadisticas
            areaResultado.setText(""); //Vacío el JTextArea
            int total=0, totalMedicamentos=0, totalReceta=0;
            double totalPrecio=0;

            //Recorro el array con el catálogo
            for (Producto p:productos) {
                total++;
                totalPrecio+=p.getPrecio();
                if (p instanceof Medicamento) { //Es un medicamento
                    totalMedicamentos++;
                    if (((Medicamento) p).getReceta()) { //Miro si tiene receta o no
                        totalReceta++;
                    }
                }
            }
            //Muestro los resultados
            areaResultado.append("Productos totales: "+total+"\n");
            areaResultado.append("Medicamentos totales: "+totalMedicamentos+"\n");
            //areaResultado.append("Precio medio: "+(totalPrecio/total)+"€\n");
            areaResultado.append(String.format("Precio medio: %.2f €\n", (totalPrecio / total)));            
            areaResultado.append("Medicamentos que requieren receta: "+totalReceta+"\n");
        }
    }


    public static void main(String[] args) {
        //Leemos el fichero con los datos
        FileReader archivo;
        BufferedReader buffer;
        String linea;
       
        productos = new ArrayList<>();

        //Leo el archivo de contenidos
        try {
            //Creo las estructuras para leer del archivo
            archivo = new FileReader("productos.txt");
            buffer = new BufferedReader(archivo);

            //Voy leyendo línea a línea del archivo
            while((linea = buffer.readLine()) != null) {
                String [] palabras = linea.split("#"); //Descompongo la línea

                //Compruebo si es una serie o no
                if (palabras[0].equals("Medicamento")) { //Es un medicamento
                    productos.add(new Medicamento(palabras[1], palabras[2], Double.parseDouble(palabras[3]), Boolean.parseBoolean(palabras[4])));
                } else { //No es una serie
                    productos.add(new Producto(palabras[1], palabras[2], Double.parseDouble(palabras[3])));
                }   
            }
            //Cierro las estructuras de lectura
            archivo.close();
            buffer.close();
            System.out.println("Catálogo de productos leídos correctamente");
        } catch (IOException e) {
            System.out.println("Error al abrir el fichero "+e.getMessage());
        }

        //Creo la ventana principal
        // 1. Crear el marco (la ventana principal)
        GestionFarmacia ventanaF = new GestionFarmacia();
        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        ventanaF.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana
        ventanaF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Creamos una nueva ventana con los elementos definidos más arriba
        ventanaF.VentanaActual();
        
        // 4. Hacer que la ventana sea visible
        ventanaF.setVisible(true);

    }
}