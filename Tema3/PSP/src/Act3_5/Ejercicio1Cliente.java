package Act3_5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Ejercicio1Cliente {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        String host = "localhost";
        int puerto = 49153;

        Socket cliente = new Socket(host, puerto);

        DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
        System.out.println("Introduce una cadena");
        String cadena=sc.nextLine();
        flujoSalida.writeUTF(cadena);

        DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

        while(cadena.equals("*")==false){
            int n = Integer.parseInt(flujoEntrada.readUTF());
            System.out.println("Recibiendo mensaje del servidor: " + n + " caracteres");

            System.out.println("Introduce una cadena");
            cadena=sc.nextLine();
            flujoSalida.writeUTF(cadena);
        }
        flujoEntrada.close();
        flujoSalida.close();
        cliente.close();
    }
}
