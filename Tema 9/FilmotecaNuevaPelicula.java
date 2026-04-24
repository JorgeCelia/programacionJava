import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilmotecaNuevaPelicula extends JFrame implements ActionListener{

    JPanel jp;
    FilmotecaDAO gestor; //Objeto para acceder a la BD

    JTextField campoTitulo, campoDirector, campoGenero, campoDuracion, campoPais, campoYear;
    JLabel etiquetaTitulo, etiquetaDirector, etiquetaGenero, etiquetaDuracion, etiquetaPais, etiquetaYear;
    JButton botonInsertar;

    public FilmotecaNuevaPelicula() { 
        super("Inserción de nueva película"); 
        setSize(400,300);

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
        if (e.getActionCommand().equals("botonInsertar")) { //Ha pedido insertar una nueva película
            boolean exito=false;
            if (campoTitulo.getText().equals("") || campoDirector.getText().equals("") || campoGenero.getText().equals("") || campoDuracion.getText().equals("") || campoPais.getText().equals("") || campoYear.getText().equals("")) { 
                //No ha escrito nada en alguno de los campos
                JOptionPane.showMessageDialog(this, "ERROR: Debes rellenar todos los campos");
            } else {
                exito = gestor.insertaPelicula(campoTitulo.getText(), campoDirector.getText(), campoGenero.getText(), Integer.parseInt(campoDuracion.getText()), campoPais.getText(), Integer.parseInt(campoYear.getText()));

                if (!exito) { //Ha habido algún problema
                    JOptionPane.showMessageDialog(this, "ERROR: Ha habido un error al insertar los datos");
                } else {
                    JOptionPane.showMessageDialog(this, "ÉXITO: Película insertada correctamente");
                }
            }
        }

    }


    public void creaVentana(){ //Creamos la vista
        //Creamos los elementos gráficos de la aplicación que estamos creando
        getContentPane().setLayout(null); 

        //Título
        etiquetaTitulo = new JLabel("Título: ");
        etiquetaTitulo.setBounds(20, 30, 100, 20);

        getContentPane().add(etiquetaTitulo);

        campoTitulo = new JTextField();
        campoTitulo.setBounds(120, 30, 250, 20);

        getContentPane().add(campoTitulo);

        //Director
        etiquetaDirector = new JLabel("Director: ");
        etiquetaDirector.setBounds(20, 60, 100, 20);

        getContentPane().add(etiquetaDirector);

        campoDirector = new JTextField();
        campoDirector.setBounds(120, 60, 250, 20);

        getContentPane().add(campoDirector);

        //Género
        etiquetaGenero = new JLabel("Género: ");
        etiquetaGenero.setBounds(20, 90, 100, 20);

        getContentPane().add(etiquetaGenero);

        campoGenero = new JTextField();
        campoGenero.setBounds(120, 90, 250, 20);

        getContentPane().add(campoGenero);

        //Duración
        etiquetaDuracion = new JLabel("Duración (min): ");
        etiquetaDuracion.setBounds(20, 120, 100, 20);

        getContentPane().add(etiquetaDuracion);

        campoDuracion = new JTextField();
        campoDuracion.setBounds(120, 120, 50, 20);

        getContentPane().add(campoDuracion);

        //Nacionalidad
        etiquetaPais = new JLabel("Nacionalidad: ");
        etiquetaPais.setBounds(20, 150, 100, 20);

        getContentPane().add(etiquetaPais);

        campoPais = new JTextField();
        campoPais.setBounds(120, 150, 150, 20);

        getContentPane().add(campoPais);

        //Año
        etiquetaYear = new JLabel("Año: ");
        etiquetaYear.setBounds(20, 180, 100, 20);

        getContentPane().add(etiquetaYear);

        campoYear = new JTextField();
        campoYear.setBounds(120, 180, 50, 20);

        getContentPane().add(campoYear);


        //Creo el botón para que me inserte la película en BD
        botonInsertar = new JButton("Insertar película");
        botonInsertar.setBounds(100, 220, 200, 20);
        botonInsertar.setActionCommand("botonInsertar");
        botonInsertar.addActionListener(this);

        getContentPane().add(botonInsertar);    

        setVisible(true); 
    } 
}