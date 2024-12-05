package Act3_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        String host = "localhost";
        int puerto = 49153;

        Socket cliente = new Socket(host, puerto);

        DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
        System.out.println("Introduce un número");
        int n=sc.nextInt();
        flujoSalida.writeUTF(String.valueOf(n));

        DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
        int nCuadrado = Integer.parseInt(flujoEntrada.readUTF());
        System.out.println("Recibiendo mensaje del servidor: " + nCuadrado);

        flujoEntrada.close();
        flujoSalida.close();
        cliente.close();
    }
}
