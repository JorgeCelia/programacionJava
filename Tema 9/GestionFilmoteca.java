import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GestionFilmoteca extends JFrame implements ActionListener {
    JButton filmotecaBruto, buscaDirector, nuevaPelicula, borrarPelicula, actualizaDirector, peliAleatoria;

    public GestionFilmoteca() { 
        super("Gestión de la filmoteca"); 
        setSize(300,300);
        setLocationRelativeTo(null);
    } 

    public void VentanaActual(){ 
        getContentPane().setLayout(null); 

        //Creo el botón para acceder a la ventana para ver los datos de la filmoteca en bruto
        filmotecaBruto = new JButton("Datos en bruto");
        filmotecaBruto.setBounds(50, 20, 200, 20);
        filmotecaBruto.setActionCommand("filmotecaBruto");
        filmotecaBruto.addActionListener(this);

        getContentPane().add(filmotecaBruto);

        //Creo el botón para acceder a la ventana de búsqueda por director
        buscaDirector = new JButton("Búsqueda por director");
        buscaDirector.setBounds(50, 60, 200, 20);
        buscaDirector.setActionCommand("buscaDirector");
        buscaDirector.addActionListener(this);

        getContentPane().add(buscaDirector);

        //Creo el botón para acceder a la ventana de inserción de nueva película
        nuevaPelicula = new JButton("Insertar película");
        nuevaPelicula.setBounds(50, 100, 200, 20);
        nuevaPelicula.setActionCommand("nuevaPelicula");
        nuevaPelicula.addActionListener(this);

        getContentPane().add(nuevaPelicula);

        //Creo el botón para acceder a la ventana de borrar una película
        borrarPelicula = new JButton("Borrar película");
        borrarPelicula.setBounds(50, 140, 200, 20);
        borrarPelicula.setActionCommand("borrarPelicula");
        borrarPelicula.addActionListener(this);

        getContentPane().add(borrarPelicula);

        //Creo el botón para acceder a la ventana de actualizar el director de una película
        actualizaDirector = new JButton("Actualizar Director");
        actualizaDirector.setBounds(50, 180, 200, 20);
        actualizaDirector.setActionCommand("actualizaDirector");
        actualizaDirector.addActionListener(this);

        getContentPane().add(actualizaDirector);

        //Creo el botón para acceder a la ventana de la película aleatoria del día
        peliAleatoria = new JButton("Sugiéreme una peli");
        peliAleatoria.setBounds(50, 220, 200, 20);
        peliAleatoria.setActionCommand("peliAleatoria");
        peliAleatoria.addActionListener(this);

        getContentPane().add(peliAleatoria);
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("filmotecaBruto")) { //Ha pedido ver la ventana de los datos en bruto
                FilmotecaBruto ventanaTB = new FilmotecaBruto();

                ventanaTB.setVisible(true);
        }

        if (e.getActionCommand().equals("buscaDirector")) { //Ha pedido ver la ventana con la búsqueda por director
                FilmotecaBusquedaDirector ventanaBD = new FilmotecaBusquedaDirector();

                ventanaBD.setVisible(true);
        }

        if (e.getActionCommand().equals("nuevaPelicula")) { //Ha pedido ver la ventana de inserción de nueva película
                FilmotecaNuevaPelicula ventanaNP = new FilmotecaNuevaPelicula();

                ventanaNP.setVisible(true);
        }

        if (e.getActionCommand().equals("borrarPelicula")) { //Ha pedido ver la ventana de borrado de una película
                FilmotecaBorraPelicula ventanaBP = new FilmotecaBorraPelicula();

                ventanaBP.setVisible(true);
        }

        if (e.getActionCommand().equals("actualizaDirector")) { //Ha pedido ver la ventana de actualización de director
                FilmotecaActualizaDirector ventanaAD = new FilmotecaActualizaDirector();

                ventanaAD.setVisible(true);
        }

        if (e.getActionCommand().equals("peliAleatoria")) { //Ha pedido ver la ventana de película aleatoria
                FilmotecaPeliAleatoria ventanaPA = new FilmotecaPeliAleatoria();

                ventanaPA.setVisible(true);
        }
    }

    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        GestionFilmoteca ventanaF = new GestionFilmoteca();
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