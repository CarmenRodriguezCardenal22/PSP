package org.example;

import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import java.io.IOException;
import java.io.Writer;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;

public class Act4_4 {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, InvalidKeyException, InvalidKeySpecException {

        // Cliente SMTP seguro
        AuthenticatingSMTPClient client = new AuthenticatingSMTPClient();

        // Datos del usuario y del servidor SMTP
        String server = "smtp.gmail.com";
        String username = "carmen.rodriguezcardenal@iesvalleinclan.es";
        String password = "Valleinclan_123";
        int puerto = 587;
        String remitente = "carmen.rodriguezcardenal@iesvalleinclan.es";

        try {
            int respuesta;

            // Creación de la clave para el canal seguro
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(null, null);
            KeyManager km = kmf.getKeyManagers()[0];

            // Nos conectamos al servidor SMTP
            client.connect(server, puerto);
            System.out.println("1 - " + client.getReplyString());

            // Se establece la clave para la comunicación segura
            client.setKeyManager(km);

            respuesta = client.getReplyCode();
            if (!SMTPReply.isPositiveCompletion(respuesta)) {
                client.disconnect();
                System.err.println("CONEXIÓN RECHAZADA");
                System.exit(1);
            }

            // Se envía el comando EHLO
            client.ehlo(server);
            System.out.println("2 - " + client.getReplyString());

            // Se inicia la negociación TLS
            if (!client.execTLS()) {
                System.err.println("FALLO AL EJECUTAR STARTTLS");
                client.disconnect();
                System.exit(1);
            }

            System.out.println("3 - " + client.getReplyString());

            // Intentamos autenticarnos con AUTH LOGIN en lugar de AUTH PLAIN
            if (client.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, username, password)) {
                System.out.println("4 - " + client.getReplyString());

                String destino1 = "carmen.rodriguez.cadenal22@gmail.com";
                String asunto = "Prueba de SMTPClient con GMAIL";
                String mensaje = "Hola.\nEnviando saludos.\nUsando GMAIL.\nChao.";

                // Se crea la cabecera del correo
                SimpleSMTPHeader cabecera = new SimpleSMTPHeader(remitente, destino1, asunto);
                client.setSender(remitente);
                client.addRecipient(destino1);
                System.out.println("5 - " + client.getReplyString());

                // Enviar el mensaje
                Writer writer = client.sendMessageData();
                if (writer == null) {
                    System.err.println("FALLO AL ENVIAR DATA");
                    System.exit(1);
                }

                writer.write(cabecera.toString()); // Cabecera
                writer.write(mensaje); // Cuerpo del mensaje
                writer.close();
                System.out.println("6 - " + client.getReplyString());

                boolean exito = client.completePendingCommand();
                System.out.println("7 - " + client.getReplyString());

                if (!exito) {
                    System.err.println("FALLO AL FINALIZAR TRANSACCIÓN");
                    System.exit(1);
                } else {
                    System.out.println("MENSAJE ENVIADO CON ÉXITO");
                }
            } else {
                System.err.println("USUARIO NO AUTENTICADO - VERIFICA USUARIO Y CONTRASEÑA");
            }

        } catch (IOException e) {
            System.err.println("No se pudo conectar al servidor");
            e.printStackTrace();
            System.exit(1);
        } finally {
            try {
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Fin de envío");
        }
    }
}

