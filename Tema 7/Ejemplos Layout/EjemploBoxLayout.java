import javax.swing.*;
import java.awt.*;

public class EjemploBoxLayout extends JFrame {

    public EjemploBoxLayout() {
        // 1. Configuración básica de la ventana
        setTitle("Ejemplo de BoxLayout");
        setSize(250, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. Crear el panel principal y asignarle el BoxLayout
        JPanel panelMenu = new JPanel();
        // BoxLayout necesita saber a qué contenedor se aplica y en qué dirección (Y_AXIS = Vertical)
        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));
        
        // Le ponemos un borde vacío para que los botones no queden pegados a los bordes de la ventana
        panelMenu.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 3. Crear los componentes (una etiqueta y tres botones)
        JLabel etiquetaTitulo = new JLabel("Menú Principal");
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        
        JButton btnPerfil = new JButton("Mi Perfil");
        JButton btnAjustes = new JButton("Configuración");
        JButton btnSalir = new JButton("Cerrar Sesión");

        // 4. Añadir los componentes al panel, apilándolos de arriba hacia abajo
        panelMenu.add(etiquetaTitulo);
        
        // ¡Truco! Añadimos un "área rígida" (un espacio vacío) de 20 píxeles de alto
        panelMenu.add(Box.createRigidArea(new Dimension(0, 20))); 
        
        panelMenu.add(btnPerfil);
        panelMenu.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio de 10 píxeles
        
        panelMenu.add(btnAjustes);
        panelMenu.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio de 10 píxeles
        
        panelMenu.add(btnSalir);

        // 5. Añadir el panel a la ventana
        add(panelMenu);
    }

    public static void main(String[] args) {
        EjemploBoxLayout ventana = new EjemploBoxLayout();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}