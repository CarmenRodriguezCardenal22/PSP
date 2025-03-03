package org.example;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Act5_4Servidor {
    public static void main(String[] args) throws IOException {
        int puerto = 49153;
        SSLServerSocketFactory sfact = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket servidor = (SSLServerSocket) sfact.createServerSocket(puerto);
        int clientesConectados = 0;
        while(clientesConectados<2){
            System.out.println("Esperando cliente...");
            Socket cliente = servidor.accept();
            System.out.println("Puerto local: " + cliente.getLocalPort());
            System.out.println("Puerto remoto: " + cliente.getPort());
            clientesConectados++;
        }
        servidor.close();
    }
}
