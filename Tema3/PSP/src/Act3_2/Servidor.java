package Act3_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        int puerto = 49153;
        ServerSocket servidor = new ServerSocket(puerto);
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
