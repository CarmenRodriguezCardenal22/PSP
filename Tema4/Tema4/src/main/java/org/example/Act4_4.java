package org.example;

import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Act4_4 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // Solicitar datos del usuario
        System.out.print("Ingrese el servidor SMTP: ");
        String servidor = sc.nextLine();

        System.out.print("Ingrese el puerto: ");
        int puerto = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese su correo electrónico: ");
        String correo = sc.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contraseña = sc.nextLine();

        System.out.print("Ingrese el correo del remitente: ");
        String cR = sc.nextLine();

        System.out.print("Ingrese el correo del destinatario: ");
        String cD = sc.nextLine();

        System.out.print("Ingrese el asunto del mensaje: ");
        String texto = sc.nextLine();

        System.out.print("Ingrese el contenido del mensaje: ");
        String mensaje = sc.nextLine();

        AuthenticatingSMTPClient cliente = new AuthenticatingSMTPClient();

        try {
            // Configurar la conexión segura con TLS
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(null, null);
            KeyManager km = kmf.getKeyManagers()[0];

            // Conectar al servidor SMTP
            cliente.connect(servidor, puerto);
            System.out.println("Conectando al servidor... " + cliente.getReplyString());
            cliente.setKeyManager(km);

            if (!SMTPReply.isPositiveCompletion(cliente.getReplyCode())) {
                cliente.disconnect();
                System.err.println("Error: Conexión rechazada por el servidor.");
                System.exit(1);
            }

            // Enviar EHLO y verificar respuesta del servidor
            cliente.ehlo(servidor);
            System.out.println("Respuesta del servidor: " + cliente.getReplyString());

            // Intentar ejecutar TLS para conexión segura
            if (cliente.execTLS()) {
                System.out.println("Inicio de sesión TLS exitoso: " + cliente.getReplyString());

                // Autenticación con credenciales
                if (cliente.auth(AuthenticatingSMTPClient.AUTH_METHOD.PLAIN, correo, contraseña)) {
                    System.out.println("Autenticación exitosa: " + cliente.getReplyString());

                    // Crear encabezado del correo
                    SimpleSMTPHeader header = new SimpleSMTPHeader(cR, cD, texto);
                    cliente.setSender(cR);
                    cliente.addRecipient(cD);
                    System.out.println("Configurando destinatarios: " + cliente.getReplyString());

                    // Enviar mensaje
                    Writer writer = cliente.sendMessageData();
                    if (writer == null) {
                        System.out.println("Error: No se pudo enviar el mensaje.");
                        System.exit(1);
                    }
                    writer.write(header.toString());
                    writer.write(mensaje);
                    writer.close();
                    System.out.println("Enviando mensaje... " + cliente.getReplyString());

                    // Confirmar transacción
                    boolean exito = cliente.completePendingCommand();
                    System.out.println("Estado final del envío: " + cliente.getReplyString());

                    if (!exito) {
                        System.out.println("Error: No se pudo completar la transacción.");
                        System.exit(1);
                    } else {
                        System.out.println("Mensaje enviado correctamente.");
                    }
                } else {
                    System.out.println("Error: Autenticación fallida.");
                }
            } else {
                System.out.println("Error: No se pudo establecer una conexión segura con TLS.");
            }
        } catch (Exception e) {
            System.out.println("Error: No se pudo conectar al servidor.");
            e.printStackTrace();
        } finally {
            cliente.disconnect();
            System.out.println("Conexión cerrada.");
        }
    }
}

