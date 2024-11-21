import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Act2_12 extends JFrame implements Runnable, ActionListener {
    private int x = 1; // Posición inicial en x
    private int y = 100; // Posición inicial en y
    private int dx = 2; // Incremento para la dirección horizontal
    private boolean corriendo = true; // Indica si el hilo está activo
    private Thread hilo; // Hilo para animación
    private JButton boton; // Botón para pausar/reanudar

    public Act2_12() {
        // Configuración del JFrame
        setTitle("Letra Rebotando");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear el botón
        boton = new JButton("Finalizar Hilo");
        boton.addActionListener(this); // Agregar listener al botón
        add(boton, BorderLayout.SOUTH);

        // Iniciar el hilo
        hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        while (true) {
            if (corriendo) { // Solo mover la letra si el hilo está activo
                x += dx; // Actualizar la posición horizontal

                // Comprobar si la letra debe rebotar
                if (x > getWidth() - 20) { // Rebote a la izquierda
                    dx = -dx;
                }
                if (x < 1) { // Rebote a la derecha
                    dx = -dx;
                }

                repaint(); // Actualizar la pantalla
            }

            // Pausa para controlar la velocidad
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Llamar al método paint de JFrame
        g.setFont(new Font("Arial", Font.BOLD, 20)); // Fuente de la letra
        g.drawString("A", x, y); // Dibujar la letra en la posición actual
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Alternar entre pausar y reanudar el movimiento
        corriendo = !corriendo;
        boton.setText(corriendo ? "Finalizar Hilo" : "Reanudar Hilo");
    }

    public static void main(String[] args) {
        // Crear y mostrar el JFrame
        SwingUtilities.invokeLater(() -> {
            Act2_12 frame = new Act2_12();
            frame.setVisible(true);
        });
    }
}
