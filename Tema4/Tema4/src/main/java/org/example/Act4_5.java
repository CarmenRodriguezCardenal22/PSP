package org.example;

import org.apache.commons.net.pop3.POP3MessageInfo;
import org.apache.commons.net.pop3.POP3SClient;

import java.io.IOException;

public class Act4_5 {

    public static void main(String[] args) {
        // Datos del servidor, usuario y contraseña
        String servidor = "pop.gmail.com", usuario = "carmen.rodriguez.cardenal22@gmail.com", contrasena = "xjab twzu jzsz vqiz";
        int puerto = 995;

        // Instanciamos el cliente POP3 seguro
        POP3SClient clientePop3 = new POP3SClient(true);
        try {
            // Conectamos al servidor
            clientePop3.connect(servidor, puerto);
            System.out.println("Conexión realizada con el servidor");

            // Intentamos hacer login con el usuario y la contraseña
            if (!clientePop3.login(usuario, contrasena)) {
                System.out.println("Error al hacer login");
            } else {
                // Listamos los mensajes en el servidor
                POP3MessageInfo[] mensajes = clientePop3.listMessages();

                if (mensajes == null)
                    System.out.println("No se puede listar los mensajes");
                else {
                    // Mostramos el número de mensajes
                    System.out.println("Número de mensajes: " + mensajes.length);
                    recuperarMensajes(mensajes, clientePop3); // Recuperamos los mensajes
                }
                // Cerramos la sesión de correo
                clientePop3.logout();
            }
            // Desconectamos del servidor
            clientePop3.disconnect();
        } catch (IOException e) {
            // Capturamos excepciones de entrada/salida
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
        // Finalizamos el programa
        System.exit(0);
    }

    private static void recuperarMensajes(POP3MessageInfo[] mensajes, POP3SClient clientePop3) throws IOException {
        // Iteramos sobre los mensajes recibidos
        for (int i = 0; i < mensajes.length; i++) {
            System.out.println("\nMensaje " + (i + 1));
            POP3MessageInfo mensajeInfo = mensajes[i];

            // Mostramos información básica del mensaje
            System.out.println("ID: " + mensajeInfo.identifier);
            System.out.println("Número: " + mensajeInfo.number);
            System.out.println("Tamaño: " + mensajeInfo.size + " bytes");

            // Obtenemos y mostramos el identificador único del mensaje
            POP3MessageInfo pmi = clientePop3.listUniqueIdentifier(i + 1);
            if (pmi != null) {
                System.out.println("Identificador único: " + pmi.identifier);
            } else {
                System.out.println("No se pudo obtener el identificador único.");
            }
        }
    }
}
