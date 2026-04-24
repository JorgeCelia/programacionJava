import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HolaMundoGUI {

    public static void main(String[] args) {
        // 1. Crear el marco (la ventana principal)
        JFrame frame = new JFrame("Mi Primera Ventana");
        
        // 2. Configurar el comportamiento al cerrar la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 3. Establecer el tamaño de la ventana (ancho, alto)
        frame.setSize(400, 250);
        frame.setResizable(false);

        // 4. Crear una etiqueta (texto) con el mensaje y centrarlo
        JLabel label = new JLabel("¡Hola Mundo!", SwingConstants.CENTER);
        
        // 5. Añadir la etiqueta a la ventana
        frame.add(label);

        // 6. Centrar la ventana en la pantalla del ordenador
        frame.setLocationRelativeTo(null);

        // 7. Hacer que la ventana sea visible
        frame.setVisible(true);
    }


}