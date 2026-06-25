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

public class GestionCatalogo extends JFrame implements ActionListener {   

    JButton muestraCatalogo, buscaTitulo, muestraSeries, estadisticas;
    JLabel etiquetaBusqueda;
    JTextField campoBusqueda;
    JTextArea areaResultado;
    static ArrayList<Contenido> contenidos;

    public GestionCatalogo() { 
        super("Gestión del catálogo de CeliaFlix"); 
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
        areaResultado.setBounds(50, 60, 400, 400);
        getContentPane().add(areaResultado);

        //Coloco el botón que muestra todo el catálogo
        muestraCatalogo = new JButton("Muestra Catálogo");
        muestraCatalogo.setBounds(50, 475, 150, 20);
        muestraCatalogo.setActionCommand("muestraCatalogo");
        muestraCatalogo.addActionListener(this);
        getContentPane().add(muestraCatalogo);

        //Coloco el botón que muestra todas las series
        muestraSeries = new JButton("Muestra Series");
        muestraSeries.setBounds(300, 475, 150, 20);
        muestraSeries.setActionCommand("muestraSeries");
        muestraSeries.addActionListener(this);
        getContentPane().add(muestraSeries);

        //Coloco el botón que busca un contenido por título
        buscaTitulo = new JButton("Busca por título");
        buscaTitulo.setBounds(50, 515, 150, 20);
        buscaTitulo.setActionCommand("buscaTitulo");
        buscaTitulo.addActionListener(this);
        getContentPane().add(buscaTitulo);

        //Coloco el botón que muestra las estadísticas
        estadisticas = new JButton("Estadísticas");
        estadisticas.setBounds(300, 515, 150, 20);
        estadisticas.setActionCommand("estadisticas");
        estadisticas.addActionListener(this);
        getContentPane().add(estadisticas);
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("muestraCatalogo")) { //Ha pedido ver todo el catálogo
            areaResultado.setText(""); //Vacío el JTextArea

            //Recorro el array con el catálogo
            for (Contenido c:contenidos) {
                areaResultado.append(c.mostrarDatos()+"\n");
            }
        }

        if (e.getActionCommand().equals("muestraSeries")) { //Ha pedido ver todas las series
            areaResultado.setText(""); //Vacío el JTextArea
            areaResultado.append("===== SERIES ====="+"\n"+"\n");

            //Recorro el array con el catálogo
            for (Contenido c:contenidos) {
                if (c instanceof Serie) { //Es una serie
                    areaResultado.append(c.mostrarDatos()+"\n");
                }
            }
        }

        if (e.getActionCommand().equals("buscaTitulo")) { //Ha pedido buscar contenidos por titulo
            areaResultado.setText(""); //Vacío el JTextArea

            if (campoBusqueda.getText().equals("")) { //No ha escrito nada en el campo de búsqueda
                JOptionPane.showMessageDialog(this, "ERROR: Debes escribir algo en el campo de búsqueda");
            } else { //Hay algo escrito
                //Recorro el array con el catálogo
                for (Contenido c:contenidos) {
                    if (c.getTitulo().toLowerCase().contains(campoBusqueda.getText().toLowerCase())) {  //El título del contenido contiene lo del campo de búsqueda
                        areaResultado.append(c.mostrarDatos()+"\n");
                    }
                }
            }
        }

        if (e.getActionCommand().equals("estadisticas")) { //Ha pedido ver las estadisticas
            areaResultado.setText(""); //Vacío el JTextArea
            int total=0, totalSeries=0, totalDuracion=0;

            //Recorro el array con el catálogo
            for (Contenido c:contenidos) {
                total++;
                totalDuracion+=c.getDuracion();
                if (c instanceof Serie) { //Es una serie
                    totalSeries++;
                }
            }
            //Muestro los resultados
            areaResultado.append("Contenidos totales: "+total+"\n");
            areaResultado.append("Series totales: "+totalSeries+"\n");
            areaResultado.append("Duración media: "+(totalDuracion/total)+" minutos\n");
        }
    }


    public static void main(String[] args) {
        //Leemos el fichero con los datos
        FileReader archivo;
        BufferedReader buffer;
        String linea;
       
        contenidos = new ArrayList<>();

        //Leo el archivo de contenidos
        try {
            //Creo las estructuras para leer del archivo
            archivo = new FileReader("catalogo.txt");
            buffer = new BufferedReader(archivo);

            //Voy leyendo línea a línea del archivo
            while((linea = buffer.readLine()) != null) {
                String [] palabras = linea.split("#"); //Descompongo la línea

                //Compruebo si es una serie o no
                if (palabras[0].equals("Serie")) { //Es una serie
                    contenidos.add(new Serie(palabras[1], palabras[2], Integer.parseInt(palabras[3]), Integer.parseInt(palabras[4])));
                } else { //No es una serie
                    contenidos.add(new Contenido(palabras[1], palabras[2], Integer.parseInt(palabras[3])));
                }   
            }
            //Cierro las estructuras de lectura
            archivo.close();
            buffer.close();
            System.out.println("Catálogo leído correctamente");
        } catch (IOException e) {
            System.out.println("Error al abrir el fichero "+e.getMessage());
        }

        //Creo la ventana principal
        // 1. Crear el marco (la ventana principal)
        GestionCatalogo ventanaC = new GestionCatalogo();
        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        ventanaC.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana
        ventanaC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Creamos una nueva ventana con los elementos definidos más arriba
        ventanaC.VentanaActual();
        
        // 4. Hacer que la ventana sea visible
        ventanaC.setVisible(true);

    }
}