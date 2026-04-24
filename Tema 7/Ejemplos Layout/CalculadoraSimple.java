import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraSimple extends JFrame implements ActionListener {
    
    private JTextField pantalla;
    private double numero1 = 0, numero2 = 0, resultado = 0;
    private char operacion;

    public CalculadoraSimple() {
        // 1. Configuración de la ventana
        setTitle("Calculadora Paso a Paso");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 2. Configuración de la pantalla
        pantalla = new JTextField();
        pantalla.setEditable(false);
        pantalla.setFont(new Font("Arial", Font.BOLD, 28));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        add(pantalla, BorderLayout.NORTH);

        // 3. Configuración del panel de botones (Cuadrícula 4x4)
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 4, 5, 5));

        // --- CREACIÓN EXPLÍCITA DE CADA BOTÓN ---
        // Fila 1
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btnDiv = new JButton("/");
        
        // Fila 2
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btnMult = new JButton("*");
        
        // Fila 3
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btnResta = new JButton("-");
        
        // Fila 4
        JButton btnC = new JButton("C");
        JButton btn0 = new JButton("0");
        JButton btnIgual = new JButton("=");
        JButton btnSuma = new JButton("+");

        // --- ASIGNAR EL ESCUCHADOR DE EVENTOS A CADA BOTÓN ---
        // Esto le dice a Java: "Avísame cuando hagan clic aquí"
        btn7.addActionListener(this); btn8.addActionListener(this); btn9.addActionListener(this); btnDiv.addActionListener(this);
        btn4.addActionListener(this); btn5.addActionListener(this); btn6.addActionListener(this); btnMult.addActionListener(this);
        btn1.addActionListener(this); btn2.addActionListener(this); btn3.addActionListener(this); btnResta.addActionListener(this);
        btnC.addActionListener(this); btn0.addActionListener(this); btnIgual.addActionListener(this); btnSuma.addActionListener(this);

        // --- AÑADIR LOS BOTONES AL PANEL ---
        // ¡El orden en que los añades es exactamente el orden en que aparecen de izquierda a derecha!
        panelBotones.add(btn7); panelBotones.add(btn8); panelBotones.add(btn9); panelBotones.add(btnDiv);
        panelBotones.add(btn4); panelBotones.add(btn5); panelBotones.add(btn6); panelBotones.add(btnMult);
        panelBotones.add(btn1); panelBotones.add(btn2); panelBotones.add(btn3); panelBotones.add(btnResta);
        panelBotones.add(btnC); panelBotones.add(btn0); panelBotones.add(btnIgual); panelBotones.add(btnSuma);

        // Añadimos el panel completo al centro de la ventana
        add(panelBotones, BorderLayout.CENTER);
    }

    // 4. Lógica matemática (Se mantiene igual)
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand(); // Lee el texto del botón presionado

        if (comando.charAt(0) >= '0' && comando.charAt(0) <= '9') {
            pantalla.setText(pantalla.getText() + comando);
        } else if (comando.equals("C")) {
            pantalla.setText("");
            numero1 = numero2 = resultado = 0;
        } else if (comando.equals("=")) {
            if (!pantalla.getText().isEmpty()) {
                numero2 = Double.parseDouble(pantalla.getText());
                switch (operacion) {
                    case '+': resultado = numero1 + numero2; break;
                    case '-': resultado = numero1 - numero2; break;
                    case '*': resultado = numero1 * numero2; break;
                    case '/': 
                        if(numero2 != 0) resultado = numero1 / numero2; 
                        else { pantalla.setText("Error"); return; }
                        break;
                }
                
                if (resultado == (long) resultado) {
                    pantalla.setText(String.format("%d", (long) resultado));
                } else {
                    pantalla.setText(String.valueOf(resultado));
                }
                numero1 = resultado; 
            }
        } else {
            if (!pantalla.getText().isEmpty()) {
                numero1 = Double.parseDouble(pantalla.getText());
                operacion = comando.charAt(0);
                pantalla.setText(""); 
            }
        }
    }

    public static void main(String[] args) {
        CalculadoraSimple calc = new CalculadoraSimple();
        calc.setLocationRelativeTo(null);
        calc.setVisible(true);
    }
}