import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class SesionDJ extends JFrame implements ActionListener, ChangeListener{
    JLabel artista, tituloVentana, titulo, volumen, volumenValor, archivo;
    JTextField cajaTitulo, cajaArtista, cajaArchivo;
    JButton botonAñadir, botonGenerar;
    JSlider barraVolumen;
    DefaultTableModel modelo;
    JTable tabla;
    int contador;

    public SesionDJ() { 
        super("Mi sesión"); 
        setSize(500,650);
        setLocationRelativeTo(null);

        contador=0;
    } 

    public void VentanaCasillaAct(){ //Vista
        getContentPane().setLayout(null); 

        //Colocamos el título principal
        tituloVentana = new JLabel("Datos de la sesión");
        tituloVentana.setBounds(200, 10, 200, 10);
        getContentPane().add(tituloVentana); 

        //Colocamos la petición del título de la canción
        titulo = new JLabel("Título de la canción: "); //Etiqueta para la caja del título de la canción
        titulo.setBounds(10, 35, 150, 20);
        getContentPane().add(titulo);

        cajaTitulo = new JTextField(); //Caja del título
        cajaTitulo.setBounds(170, 35, 300, 20);
        getContentPane().add(cajaTitulo);

        //Colocamos la petición del artista
        artista = new JLabel("Artista: "); //Etiqueta para la caja del artista de la canción
        artista.setBounds(10, 65, 150, 20);
        getContentPane().add(artista);

        cajaArtista = new JTextField(); //Caja del artista
        cajaArtista.setBounds(170, 65, 300, 20);
        getContentPane().add(cajaArtista);

        //Metemos la barra para el volumen
        volumen = new JLabel("Volumen: "); //Etiqueta para la barra del volumen
        volumen.setBounds(10, 100, 100, 20);
        getContentPane().add(volumen);

        barraVolumen=new JSlider(JSlider.HORIZONTAL,0,100,0); //Barra para elegir el volumen
        barraVolumen.setPaintLabels(true); 
        barraVolumen.setPaintTicks(true); 
        barraVolumen.setMajorTickSpacing(25); 
        barraVolumen.setMinorTickSpacing(5); 
        barraVolumen.addChangeListener(this); 
        barraVolumen.setBounds(70, 100, 350, 50);
        getContentPane().add(barraVolumen);

        volumenValor = new JLabel("0"); //Etiqueta donde se va a ir escribiendo el volumen elegido en ese instante
        volumenValor.setBounds(425, 105, 40, 20);
        getContentPane().add(volumenValor);

        //Metemos el botón de añadir canción
        botonAñadir= new JButton("Añadir Canción"); 
        botonAñadir.setBounds(175, 170, 150, 20);
        botonAñadir.setActionCommand("botonAñadir"); //Le pongo un nombre al evento
        botonAñadir.addActionListener(this); //Añado el escuchador de eventos para eñ botón
        getContentPane().add(botonAñadir);

        //Creo la tabla donde insertaré las búsquedas
        // 1. Definir los nombres de las columnas
        String[] columnas = {"Nº", "Título", "Artista", "Vol"};

        // 2. Creamos el modelo de la tabla vacío inicialmente
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);

        // --- CONFIGURACIÓN DE ANCHOS ---
        
        // A. Desactivar el auto-ajuste para que respete nuestros píxeles exactos
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // B. Obtener el modelo de columnas para manipularlas una por una
        TableColumnModel columnModel = tabla.getColumnModel();

        // Columna Orden: Pequeña
        columnModel.getColumn(0).setPreferredWidth(50);
        
        // Columna Título
        columnModel.getColumn(1).setPreferredWidth(175);      

        // Columna Artista
        columnModel.getColumn(2).setPreferredWidth(175);      

        // Columna Volumen
        columnModel.getColumn(3).setPreferredWidth(38);      
        // -------------------------------

        // 3. ¡Importante! Envolver la tabla en un JScrollPane 
        // Esto permite ver los encabezados y hacer scroll si hay muchos datos
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(30, 210, 440, 300);

        getContentPane().add(scrollPane);

        //Colocamos la petición del archivo para la sesion
        archivo = new JLabel("Escribir en el archivo: "); //Etiqueta para la caja del archivo
        archivo.setBounds(10, 530, 150, 20);
        getContentPane().add(archivo);

        cajaArchivo = new JTextField(); //Caja del archivo
        cajaArchivo.setBounds(170, 530, 300, 20);
        getContentPane().add(cajaArchivo);

        //Metemos el botón de generar la sesión
        botonGenerar= new JButton("Generar fichero"); 
        botonGenerar.setBounds(175, 570, 150, 20);
        botonGenerar.setActionCommand("botonGenerar"); //Le pongo un nombre al evento
        botonGenerar.addActionListener(this); //Añado el escuchador de eventos para eñ botón
        getContentPane().add(botonGenerar);

        setVisible(true);  
    } 

    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        SesionDJ ventana = new SesionDJ();
        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        ventana.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Creamos una nueva ventana con los elementos definidos más arriba
        ventana.VentanaCasillaAct();
        
        // 4. Hacer que la ventana sea visible
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) { //Controlador
        if (e.getActionCommand().equals("botonAñadir")) { //Ha pulsado añadir canción
            //Compruebo que ha escrito todos los datos
            if(!cajaTitulo.getText().equals("") && !cajaArtista.getText().equals("")) {
                //Añado los campos a la tabla
                contador++; 
                modelo.addRow(new Object[]{contador,cajaTitulo.getText(), cajaArtista.getText(), volumenValor.getText()});
            } else { //Se ha dejado algún campo sin escribir
                JOptionPane.showMessageDialog(this, "ERROR: Debes rellenar todos los campos");
            }

        }

        if (e.getActionCommand().equals("botonGenerar")) { //Ha pulsado generar fichero
            //Compruebo que ha escrito el nombre del fichero
            if(!cajaArchivo.getText().equals("")) {
                //Escribo el fichero
                try {
                        //Creo el escritor del fichero
                        FileWriter escritor = new FileWriter(cajaArchivo.getText());

                        //Recorremos la tabla y voy escribiendo en el archivo con el formato adecuado
                        for (int i = 0; i < tabla.getRowCount(); i++) {
                            //Escribo los campos de cada fila en el archivo, separados por #
                            escritor.write(tabla.getValueAt(i, 0).toString()+"#"+tabla.getValueAt(i, 1).toString()+"#"+tabla.getValueAt(i, 2).toString()+"#"+tabla.getValueAt(i, 3).toString()+"\n");
                        }

                        //Cierro el fichero
                        escritor.close();
                        
                        //Muestro mensaje de éxito
                        JOptionPane.showMessageDialog(this, "Archivo "+ cajaArchivo.getText() +" escrito correctamente");

                    } catch (IOException error) {
                        System.out.println("Error al abrir el fichero "+error.getMessage());
                    }
            } else { //No ha escrito el nombre del fichero
                JOptionPane.showMessageDialog(this, "ERROR: Debes indicar un nombre de fichero");
            }

        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        volumenValor.setText(""+((JSlider)e.getSource()).getValue()); 
    }
}