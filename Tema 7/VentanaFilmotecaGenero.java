import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaFilmotecaGenero extends JFrame implements ActionListener {
    JLabel descripción, labelGenero;
    JTextField campoGenero;
    static ArrayList<Pelicula> peliculas = new ArrayList<>();
    JButton botonBuscarD;

    public VentanaFilmotecaGenero() {
        super("Búsqueda por género"); 

        setSize(400,500);

        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        this.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana (Si es llamada desde fuera, libera recursos pero no cierra el programa)
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        // 3. Creamos la ventana
        this.creaVentana();      
    } 

    public void datosFilmoteca (ArrayList<Pelicula> datos) {
        //Hago que el array List de esta clase apunte al que le pasan como parámetro
        peliculas = datos;
    }

    public void creaVentana(){ //Creamos la vista
        //Creamos los elementos gráficos de la aplicación que estamos creando
        getContentPane().setLayout(null); 

        //Coloco la etiqueta y el campo para la búsqueda por director
        labelGenero = new JLabel();
        labelGenero.setBounds(30, 50, 150, 20);
        labelGenero.setText("Introduce un género: ");
        this.add(labelGenero);

        campoGenero = new JTextField();
        campoGenero.setBounds(190, 50, 200, 20);
        this.add(campoGenero);

        //Creo el botón para elegir el archivo
        botonBuscarD = new JButton("Buscar por género");
        botonBuscarD.setBounds(100, 170, 200, 20);
        botonBuscarD.setActionCommand("botonBuscarG");
        botonBuscarD.addActionListener(this);

        getContentPane().add(botonBuscarD);

        setVisible(true); 
    } 

    public void actionPerformed(ActionEvent e){ 
        if (e.getActionCommand().equals("botonBuscarG")) { 
            String resultado="";
            for(Pelicula p:peliculas) {
                if(p.getGenero().compareTo(campoGenero.getText())==0) { //Encuentra una pelicula del género
                    resultado=resultado+p.getTitulo()+"\n";
                }
            }
            JOptionPane.showMessageDialog(this, resultado);
        }
    } 

    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        VentanaFilmotecaGenero ventanaG = new VentanaFilmotecaGenero();

        //Al ser llamada en el main y ser la ventana principal, ponemos que cuando se cierre la ventana se acabe el programa
        ventanaG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 4. Hacer que la ventana sea visible
        ventanaG.setVisible(true);
    }


}