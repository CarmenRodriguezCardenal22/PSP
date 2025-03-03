package org.example;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.Socket;

public class Act5_4Cliente {
    public static void main(String[] args) throws IOException {
        String host = "localhost"; // Dirección del servidor
        int puerto = 49153; // Puerto en el que el servidor escucha

        // Crea un socket seguro para conectarse al servidor en el host y puerto especificados
        SSLSocketFactory sfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket cliente = (SSLSocket) sfact.createSocket(host, puerto);

        // Imprime el puerto local que está utilizando el cliente para esta conexión
        System.out.println("Puerto local: " + cliente.getLocalPort());

        // Imprime el puerto remoto del servidor con el que está conectado el cliente
        System.out.println("Puerto remoto: " + cliente.getPort());

        // Muestra la dirección IP del servidor al que se conecta el cliente
        System.out.println("Dirección IP: " + cliente.getInetAddress());

        // Cierra el socket después de haber obtenido la información
        cliente.close();
    }
}
