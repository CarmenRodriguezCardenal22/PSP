package org.example.Tema4;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException {
        //buffer para recibir el mensaje en bytes
        byte[] buffer = new byte[1024];

        //creacion del Datagram Socket
        DatagramSocket socket = new DatagramSocket(49153, InetAddress.getByName("localhost"));
        System.out.println("Esperando al cliente...");

        //creacion del Datagram Packet
        DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
        //recibimos el mensaje
        socket.receive(recibo);
        //obtengo numero de bytes
        int bytesRec = recibo.getLength();
        //obtengo el String
        String paquete = new String(recibo.getData());

        System.out.println("Recibiendo mensaje: " + paquete.trim());
        //Una vez recibidos los 5 latidos, deja de latir y muere
        System.out.println("Corazón muerto");
        socket.close();
    }
}
