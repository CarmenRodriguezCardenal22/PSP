package org.example.Tema4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        //creacion del Datagram Socket
        DatagramSocket socket = new DatagramSocket(49153, InetAddress.getByName("localhost"));

        //mensaje a enviar en bytes
        byte[] mensaje = new byte[1024];
        String latido = "Latido";
        mensaje = latido.getBytes();

        //creacion del Datagram Packet
        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, InetAddress.getByName("localhost"), 49153);

        for(int i=0; i<5; i++) {
            //enviamos el mensaje
            socket.send(envio);
            //tiempo de espera: 20 seg
            socket.setSoTimeout(20000);
        }
    }
}
