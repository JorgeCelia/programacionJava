import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilmotecaBorraPelicula extends JFrame implements ActionListener{

    JPanel jp;
    FilmotecaDAO gestor; //Objeto para acceder a la BD

    JTextField campoTitulo;
    JLabel etiquetaTitulo;
    JButton botonBusqueda;

    public FilmotecaBorraPelicula() { 
        super("Borrado de película"); 
        setSize(400,200);

        jp=new JPanel(false); 
        jp.setLayout(null);

        this.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana (Si es llamada desde fuera, libera recursos pero no cierra el programa)
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        // 3. Rellenamos el ArrayList de esta ventana
        gestor = new FilmotecaDAO();

        // 4. Creamos la ventana
        this.creaVentana();
    } 

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("botonBorrar")) { //Ha pedido borrar la película
            boolean exito = false;
            if (campoTitulo.getText().equals("")) { //No ha escrito nada
                JOptionPane.showMessageDialog(this, "ERROR: Debes escribir el título de la película que deseas borrar");
            } else {

                exito=gestor.borraPelicula(campoTitulo.getText());
                if (!exito) { //Ha habido algún problema
                    JOptionPane.showMessageDialog(this, "ERROR: Ha habido un error al borrar la película");
                } else {
                    JOptionPane.showMessageDialog(this, "ÉXITO: Película borrada correctamente");
                }

            }
        }

    }


    public void creaVentana(){ //Creamos la vista
        //Creamos los elementos gráficos de la aplicación que estamos creando
        getContentPane().setLayout(null); 

        etiquetaTitulo = new JLabel("Título: ");
        etiquetaTitulo.setBounds(30, 50, 200, 20);

        getContentPane().add(etiquetaTitulo);

        campoTitulo = new JTextField();
        campoTitulo.setBounds(100, 50, 250, 20);

        getContentPane().add(campoTitulo);


        //Creo el botón para que borre la película con ese título
        botonBusqueda = new JButton("Borrar Película");
        botonBusqueda.setBounds(100, 100, 200, 20);
        botonBusqueda.setActionCommand("botonBorrar");
        botonBusqueda.addActionListener(this);

        getContentPane().add(botonBusqueda);
        setVisible(true); 
    } 
}