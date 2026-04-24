import javax.swing.*;
import java.awt.*;

public class EjemploBoxLayoutHorizontal extends JFrame {

    public EjemploBoxLayoutHorizontal() {
        // 1. Configuración de la ventana
        setTitle("Reproductor de Música");
        setSize(400, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. Crear el panel y asignarle BoxLayout en el eje X (Horizontal)
        JPanel panelControles = new JPanel();
        panelControles.setLayout(new BoxLayout(panelControles, BoxLayout.X_AXIS));
        
        // Un pequeño margen para que no toque los bordes de la ventana
        panelControles.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 3. Crear los botones
        JButton btnAnterior = new JButton("⏮ Anterior");
        JButton btnPlay = new JButton("▶ Reproducir");
        JButton btnSiguiente = new JButton("⏭ Siguiente");

        // 4. Añadir los componentes al panel de izquierda a derecha
        
        // ¡Truco! Añadimos un "pegamento" al principio. 
        // Esto empujará todos los botones hacia la derecha (o hacia el centro si ponemos otro al final).
        panelControles.add(Box.createHorizontalGlue());
        
        // Añadimos el primer botón
        panelControles.add(btnAnterior);
        
        // Añadimos un espacio rígido, pero esta vez a lo ancho (15 píxeles de ancho, 0 de alto)
        panelControles.add(Box.createRigidArea(new Dimension(15, 0)));
        
        // Añadimos el segundo botón
        panelControles.add(btnPlay);
        panelControles.add(Box.createRigidArea(new Dimension(15, 0)));
        
        // Añadimos el tercer botón
        panelControles.add(btnSiguiente);
        
        // Añadimos otro "pegamento" al final. Al tener uno al inicio y otro al final, 
        // los botones quedan perfectamente centrados en la ventana.
        panelControles.add(Box.createHorizontalGlue());

        // 5. Añadir el panel a la ventana
        add(panelControles);
    }

    public static void main(String[] args) {
        EjemploBoxLayoutHorizontal ventana = new EjemploBoxLayoutHorizontal();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}