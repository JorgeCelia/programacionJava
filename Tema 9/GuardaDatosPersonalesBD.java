import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuardaDatosPersonalesBD extends JFrame implements ActionListener{
    JLabel titulo, nombre, apellidos, edad, direccion;
    JTextField nombreCampo, apellidosCampo, edadCampo, direccionCampo;
    JButton botonGuardar;

    public GuardaDatosPersonalesBD() { 
        super("Mis datos"); 
        setSize(400,250);
        setLocationRelativeTo(null);
    } 

    public void CreaVentana(){ //Vista
        getContentPane().setLayout(null); 

        //Colocamos el título principal
        titulo = new JLabel("Introduce tus datos personales");
        titulo.setBounds(100, 10, 200, 20);

        //Colocamos la petición de nombre
        nombre = new JLabel("Nombre: "); //Etiqueta para la caja del nombre
        nombre.setBounds(10, 55, 100, 20);
        nombreCampo = new JTextField(); //Caja del nombre
        nombreCampo.setBounds(100, 50, 150, 20);
        
        //Colocamos la petición de apellidos
        apellidos = new JLabel("Apellidos: "); //Etiqueta para la caja de los apellidos
        apellidos.setBounds(10, 85, 100, 20);
        apellidosCampo = new JTextField(); //Caja de los apellidos
        apellidosCampo.setBounds(100, 80, 250, 20);

        //Colocamos la petición de edad
        edad = new JLabel("Edad: "); //Etiqueta para la caja de la edad
        edad.setBounds(10, 115, 100, 20);
        edadCampo = new JTextField(); //Caja de la edad
        edadCampo.setBounds(100, 110, 50, 20);

        //Colocamos la petición de la dirección
        direccion = new JLabel("Dirección: "); //Etiqueta para la caja de la dirección
        direccion.setBounds(10, 145, 100, 20);
        direccionCampo = new JTextField(); //Caja de la dirección
        direccionCampo.setBounds(100, 140, 250, 20);

        //Metemos el botón
        botonGuardar= new JButton("Guardar datos"); 
        botonGuardar.setBounds(120, 180, 150, 20);
        botonGuardar.setActionCommand("botonGuardar"); //Le pongo un nombre al evento
        botonGuardar.addActionListener(this); //Añado el escuchador de eventos para el botón

        // Agregamos los elementos al panel y lo mostramos todo 
        getContentPane().add(titulo); 
        getContentPane().add(nombre);
        getContentPane().add(nombreCampo);
        getContentPane().add(apellidos);
        getContentPane().add(apellidosCampo);
        getContentPane().add(edad);
        getContentPane().add(edadCampo);
        getContentPane().add(direccion);
        getContentPane().add(direccionCampo);

        getContentPane().add(botonGuardar);

        setVisible(true);  
    } 

    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        GuardaDatosPersonalesBD ventana = new GuardaDatosPersonalesBD();
        JPanel jp=new JPanel(false); 
        jp.setLayout(null);

        ventana.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Creamos una nueva ventana con los elementos definidos más arriba
        ventana.CreaVentana();
        
        // 4. Hacer que la ventana sea visible
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) { //Controlador
        if (evento.getActionCommand().equals("botonGuardar")) {
            GuardaDatosPersonalesDAO gestor = new GuardaDatosPersonalesDAO();

            boolean exito;

            if (nombreCampo.getText().equals("") || apellidosCampo.getText().equals("") || edadCampo.getText().equals("") || direccionCampo.getText().equals("")) { //Hay algún campo vacío
                    JOptionPane.showMessageDialog(this, "ERROR: Debes rellenar todos los campos");
            } else {
                exito = gestor.insertaUsuario(nombreCampo.getText(), apellidosCampo.getText(), Integer.parseInt(edadCampo.getText()), direccionCampo.getText());

                if (exito) {
                    JOptionPane.showMessageDialog(this, "ÉXITO: El usuario se ha insertado correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "ERROR: Ha habido un error al insertar el usuario");
                }
            }
        }
    }
}