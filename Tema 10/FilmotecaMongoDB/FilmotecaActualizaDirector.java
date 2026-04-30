import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilmotecaActualizaDirector extends JFrame implements ActionListener{

    JPanel jp;
    FilmotecaDAO gestor; //Objeto para acceder a la BD

    JTextField campoTitulo, campoDirector;
    JLabel etiquetaTitulo, etiquetaDirector;
    JButton botonBusqueda;

    public FilmotecaActualizaDirector() { 
        super("Actualización del director de una película"); 
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
        if (e.getActionCommand().equals("botonActualizar")) { //Ha pedido actualizar el director de la pelicula
            boolean exito = false;
            if (campoTitulo.getText().equals("") || campoDirector.getText().equals("")) { //No ha escrito nada
                JOptionPane.showMessageDialog(this, "ERROR: Debes rellenar los campos");
            } else {

                exito=gestor.actualizaDirectorPelicula(campoTitulo.getText(), campoDirector.getText());
                if (!exito) { //Ha habido algún problema
                    JOptionPane.showMessageDialog(this, "ERROR: Ha habido un error al actualizar los datos de la película");
                } else {
                    JOptionPane.showMessageDialog(this, "ÉXITO: Director actualizado correctamente");
                }

            }
        }

    }


    public void creaVentana(){ //Creamos la vista
        //Creamos los elementos gráficos de la aplicación que estamos creando
        getContentPane().setLayout(null); 

        etiquetaTitulo = new JLabel("Título: ");
        etiquetaTitulo.setBounds(30, 30, 200, 20);

        getContentPane().add(etiquetaTitulo);

        campoTitulo = new JTextField();
        campoTitulo.setBounds(100, 30, 250, 20);

        getContentPane().add(campoTitulo);

        etiquetaDirector = new JLabel("Director: ");
        etiquetaDirector.setBounds(30, 70, 200, 20);

        getContentPane().add(etiquetaDirector);

        campoDirector = new JTextField();
        campoDirector.setBounds(100, 70, 250, 20);

        getContentPane().add(campoDirector);


        //Creo el botón para que actualice el director de la película con ese título
        botonBusqueda = new JButton("Actualiza Director");
        botonBusqueda.setBounds(100, 120, 200, 20);
        botonBusqueda.setActionCommand("botonActualizar");
        botonBusqueda.addActionListener(this);

        getContentPane().add(botonBusqueda);
        setVisible(true); 
    } 
}