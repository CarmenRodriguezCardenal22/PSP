package Act3_5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorN {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int puerto = 49153;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Dime el número de clientes que quieres aceptar");
        int n = sc.nextInt();
        int clientesConectados = 1;
        while(clientesConectados<n+1){
            System.out.println("Esperando cliente...");
            Socket cliente = servidor.accept();

            OutputStream salida = cliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            flujoSalida.writeUTF("Eres el cliente número " + clientesConectados);

            clientesConectados++;
            salida.close();
            flujoSalida.close();
            cliente.close();
        }

        servidor.close();
    }
}
