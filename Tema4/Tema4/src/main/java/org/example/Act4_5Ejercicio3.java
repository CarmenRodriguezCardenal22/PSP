package org.example;

import org.apache.commons.net.pop3.POP3MessageInfo;
import org.apache.commons.net.pop3.POP3SClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Act4_5Ejercicio3 extends JFrame {
    private JTextField servidor, usuario, contraseña, puerto;
    private JButton conectar, recuperarMensajes;
    private JTextArea salida;
    private POP3SClient pop3;

    public Act4_5Ejercicio3() {
        // Configurar la ventana
        setTitle("Conexión POP3");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear componentes
        servidor = new JTextField("pop.gmail.com");
        usuario = new JTextField("carmen.rodriguez.cardenal22@gmail.com");
        contraseña = new JPasswordField("xjab twzu jzsz vqiz");
        puerto = new JTextField("995");  // Puerto por defecto
        conectar = new JButton("Conectar");
        recuperarMensajes = new JButton("Recuperar Mensajes");
        salida = new JTextArea();
        salida.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(salida);

        // Configurar el layout
        setLayout(new GridLayout(7, 1));
        add(new JLabel("Servidor:"));
        add(servidor);
        add(new JLabel("Usuario:"));
        add(usuario);
        add(new JLabel("Contraseña:"));
        add(contraseña);
        add(new JLabel("Puerto:"));
        add(puerto);
        add(conectar);
        add(recuperarMensajes);
        add(scrollPane);

        // Desactivar el botón de recuperación de mensajes hasta que se conecte
        recuperarMensajes.setEnabled(false);

        // Manejar evento de conexión
        conectar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conectarAlServidor();
            }
        });

        // Manejar evento de recuperación de mensajes
        recuperarMensajes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                recuperarMensajes();
            }
        });
    }

    private void conectarAlServidor() {
        String servidor = this.servidor.getText();
        String usuario = this.usuario.getText();
        String contraseña = this.contraseña.getText();
        int puerto = Integer.parseInt(this.puerto.getText());  // Convertir el texto del puerto a entero

        pop3 = new POP3SClient(true);
        try {
            pop3.connect(servidor, puerto);
            salida.append("Conexión realizada con el servidor\n");

            if (!pop3.login(usuario, contraseña)) {
                salida.append("Error al hacer login\n");
            } else {
                salida.append("Login exitoso\n");
                recuperarMensajes.setEnabled(true);
            }

        } catch (IOException e) {
            salida.append("Error de conexión: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    private void recuperarMensajes() {
        try {
            POP3MessageInfo[] mensajes = pop3.listMessages();

            if (mensajes == null) {
                salida.append("No se puede listar los mensajes\n");
            } else {
                salida.append("Número de mensajes: " + mensajes.length + "\n");
                mostrarMensajes(mensajes);
            }
            pop3.logout();
            pop3.disconnect();
        } catch (IOException e) {
            salida.append("Error al recuperar los mensajes: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    private void mostrarMensajes(POP3MessageInfo[] mensajes) throws IOException {
        for (int i = 0; i < mensajes.length; i++) {
            salida.append("\nMensaje " + (i + 1) + "\n");
            POP3MessageInfo msgInfo = mensajes[i];

            salida.append("ID: " + msgInfo.identifier + "\n");
            salida.append("Número: " + msgInfo.number + "\n");
            salida.append("Tamaño: " + msgInfo.size + " bytes\n");

            POP3MessageInfo pmi = pop3.listUniqueIdentifier(i + 1);
            if (pmi != null) {
                salida.append("Identificador único: " + pmi.identifier + "\n");
            } else {
                salida.append("No se pudo obtener el identificador único.\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Act4_5Ejercicio3().setVisible(true);
            }
        });
    }
}
