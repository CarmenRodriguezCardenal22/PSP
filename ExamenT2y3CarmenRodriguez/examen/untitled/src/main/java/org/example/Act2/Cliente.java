package org.example.Act2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        //Funciona todo menos a la hora de comprobar el * en el bucle
        Scanner sc = new Scanner(System.in);
        String host = "localhost"; // Dirección del servidor
        int puerto = 49153; // Puerto en el que el servidor escucha

        // Crea un socket para conectarse al servidor en el host y puerto especificados
        Socket cliente = new Socket(host, puerto);

        //Inicializando objeto de lectura
        DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
        //Leyendo id del cliente
        System.out.println("Soy el cliente: " + flujoEntrada.readUTF());
        //Inicializando objeto de escritura
        DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
        //Solicitando por teclado el id del profesor
        System.out.println("Introduce el id del cliente que quieres solicitar");
        String id=sc.nextLine();
        //Mandado el id del profesor a consultar
        flujoSalida.writeUTF(id);

        //Bucle de repetición hasta que se introduzca *
        while(id.equals("*")==false){
            //Lectura de los datos del profesor con el id solicitado
            System.out.println(flujoEntrada.readUTF());
            //Solicitando por teclado el id del profesor
            System.out.println("Introduce el id del cliente que quieres solicitar");
            id=sc.nextLine();
            //Mandado el id del profesor a consultar
            flujoSalida.writeUTF(id);
        }
        flujoEntrada.close();
        flujoSalida.close();
        cliente.close();
    }
}
