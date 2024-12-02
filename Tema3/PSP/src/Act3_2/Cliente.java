package Act3_2;

import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 49153;

        Socket cliente = new Socket(host, puerto);
        System.out.println("Puerto local: " + cliente.getLocalPort());
        System.out.println("Puerto remoto: " + cliente.getPort());
        System.out.println("Dirección IP: " + cliente.getInetAddress());
        cliente.close();
    }
}
