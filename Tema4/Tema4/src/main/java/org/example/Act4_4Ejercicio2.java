package org.example;

import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

import javax.swing.*;
import java.awt.*;

public class Act4_4Ejercicio2 extends JFrame {
    private JTextField servidor, puerto, usuario, contrasena, remitente, destinatario, asunto;
    private JTextArea mensaje;
    private JRadioButton sinTLS, conTLS;
    private JButton conectar, enviar;
    private AuthenticatingSMTPClient cliente;

    public Act4_4Ejercicio2() {
        setTitle("Cliente SMTP");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(11, 2));

        // Campos de entrada
        add(new JLabel("Servidor SMTP:"));
        servidor = new JTextField("");
        add(servidor);

        add(new JLabel("Puerto:"));
        puerto = new JTextField("");
        add(puerto);

        add(new JLabel("Usuario:"));
        usuario = new JTextField();
        add(usuario);

        add(new JLabel("Contraseña:"));
        contrasena = new JPasswordField();
        add(contrasena);

        add(new JLabel("Correo remitente:"));
        remitente = new JTextField();
        add(remitente);

        add(new JLabel("Correo destinatario:"));
        destinatario = new JTextField();
        add(destinatario);

        add(new JLabel("Asunto:"));
        asunto = new JTextField();
        add(asunto);

        add(new JLabel("Mensaje:"));
        mensaje = new JTextArea(5, 20);
        add(new JScrollPane(mensaje));

        // Opciones de conexión con TLS
        sinTLS = new JRadioButton("Sin TLS", true);
        conTLS = new JRadioButton("Con TLS");
        ButtonGroup grupoTLS = new ButtonGroup();
        grupoTLS.add(sinTLS);
        grupoTLS.add(conTLS);
        add(sinTLS);
        add(conTLS);

        // Botones de conexión y envío
        conectar = new JButton("Conectar");
        enviar = new JButton("Enviar");
        enviar.setEnabled(false);
        add(conectar);
        add(enviar);

        // Asignar eventos a los botones
        conectar.addActionListener(e -> conectarSMTP());
        enviar.addActionListener(e -> enviarCorreo());

        setVisible(true);
    }

    // Metodo para conectar con el servidor SMTP
    private void conectarSMTP() {
        try {
            cliente = new AuthenticatingSMTPClient();
            cliente.connect(servidor.getText(), Integer.parseInt(puerto.getText()));

            if (!SMTPReply.isPositiveCompletion(cliente.getReplyCode())) {
                JOptionPane.showMessageDialog(this, "Conexión rechazada", "Error", JOptionPane.ERROR_MESSAGE);
                cliente.disconnect();
                return;
            }

            cliente.ehlo(servidor.getText());
            if (conTLS.isSelected()) {
                cliente.execTLS();
            }

            JOptionPane.showMessageDialog(this, "Conectado al servidor SMTP", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            enviar.setEnabled(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metodo para enviar un correo electrónico
    private void enviarCorreo() {
        try {
            SimpleSMTPHeader cabecera = new SimpleSMTPHeader(remitente.getText(), destinatario.getText(), asunto.getText());
            cliente.setSender(remitente.getText());
            cliente.addRecipient(destinatario.getText());

            cliente.sendShortMessageData(mensaje.getText());
            JOptionPane.showMessageDialog(this, "Correo enviado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            cliente.logout();
            cliente.disconnect();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al enviar correo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Act4_4Ejercicio2();
    }
}
