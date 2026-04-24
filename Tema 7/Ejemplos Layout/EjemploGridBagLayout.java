import javax.swing.*;
import java.awt.*;

public class EjemploGridBagLayout extends JFrame {

    public EjemploGridBagLayout() {
        // 1. Configuración de la ventana
        setTitle("Formulario Profesional");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. Establecer el GridBagLayout
        setLayout(new GridBagLayout());
        
        // 3. Crear el objeto de restricciones (las "reglas" para ubicar cosas)
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Definimos un margen general de 5 píxeles por cada lado para todos los elementos
        gbc.insets = new Insets(5, 5, 5, 5); 

        // --- FILA 0: Título que ocupa toda la parte superior ---
        JLabel titulo = new JLabel("Contáctanos");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;          // Columna 0
        gbc.gridy = 0;          // Fila 0
        gbc.gridwidth = 2;      // ¡Magia! Le decimos que ocupe 2 columnas de ancho
        gbc.anchor = GridBagConstraints.CENTER; // Que se centre en su espacio
        add(titulo, gbc);

        // --- Restablecemos el ancho a 1 para los siguientes componentes ---
        gbc.gridwidth = 1;

        // --- FILA 1: Etiqueta y Campo de Nombre ---
        JLabel lblNombre = new JLabel("Nombre completo:");
        gbc.gridx = 0;          // Columna 0
        gbc.gridy = 1;          // Fila 1
        gbc.anchor = GridBagConstraints.EAST;   // Alineado a la derecha (pegado al campo de texto)
        add(lblNombre, gbc);

        JTextField txtNombre = new JTextField(15);
        gbc.gridx = 1;          // Columna 1
        gbc.gridy = 1;          // Fila 1
        gbc.fill = GridBagConstraints.HORIZONTAL; // Le decimos que se estire a lo ancho
        gbc.weightx = 1.0;      // Le damos prioridad para que tome todo el espacio horizontal sobrante
        add(txtNombre, gbc);

        // --- FILA 2: Etiqueta y Campo de Correo ---
        JLabel lblCorreo = new JLabel("Correo electrónico:");
        gbc.gridx = 0;          // Columna 0
        gbc.gridy = 2;          // Fila 2
        gbc.fill = GridBagConstraints.NONE;     // Quitamos el estiramiento horizontal para la etiqueta
        gbc.weightx = 0.0;      // Le quitamos la prioridad de espacio
        gbc.anchor = GridBagConstraints.EAST;
        add(lblCorreo, gbc);

        JTextField txtCorreo = new JTextField(15);
        gbc.gridx = 1;          // Columna 1
        gbc.gridy = 2;          // Fila 2
        gbc.fill = GridBagConstraints.HORIZONTAL; // Se estira a lo ancho
        gbc.weightx = 1.0;
        add(txtCorreo, gbc);

        // --- FILA 3: Botón de Enviar ---
        JButton btnEnviar = new JButton("Enviar Mensaje");
        gbc.gridx = 0;          // Columna 0
        gbc.gridy = 3;          // Fila 3
        gbc.gridwidth = 2;      // Vuelve a ocupar 2 columnas
        gbc.fill = GridBagConstraints.NONE;     // No queremos que el botón ocupe toda la pantalla
        gbc.anchor = GridBagConstraints.CENTER; // Lo centramos
        add(btnEnviar, gbc);
    }

    public static void main(String[] args) {
        EjemploGridBagLayout ventana = new EjemploGridBagLayout();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}