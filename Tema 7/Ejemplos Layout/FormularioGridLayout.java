import javax.swing.*;
import java.awt.*;

public class FormularioGridLayout extends JFrame {

    public FormularioGridLayout() {
        // 1. Configuración de la ventana
        setTitle("Registro de Usuario");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. Aplicar el GridLayout directamente a la ventana
        // 4 filas, 2 columnas, y 10px de margen (gap) horizontal y vertical
        setLayout(new GridLayout(4, 2, 10, 10));

        // 3. Añadir los componentes
        // El GridLayout los acomodará automáticamente: primero izquierda, luego derecha.

        // --- Fila 1 ---
        add(new JLabel(" Usuario:")); // Etiqueta (Izquierda)
        add(new JTextField());        // Campo de texto (Derecha)

        // --- Fila 2 ---
        add(new JLabel(" Contraseña:"));   // Etiqueta (Izquierda)
        add(new JPasswordField());         // Campo de contraseña (Derecha)

        // --- Fila 3 ---
        add(new JLabel(" Email:"));   // Etiqueta (Izquierda)
        add(new JTextField());        // Campo de texto (Derecha)

        // --- Fila 4 ---
        add(new JButton("Cancelar"));    // Botón (Izquierda)
        add(new JButton("Registrarse")); // Botón (Derecha)
    }

    public static void main(String[] args) {
        FormularioGridLayout formulario = new FormularioGridLayout();
        formulario.setLocationRelativeTo(null); // Centrar en pantalla
        formulario.setVisible(true);
    }
}