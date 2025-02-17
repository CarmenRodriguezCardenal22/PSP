package org.example.Act2;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException {
        //Funciona todo menos lo que pone en el cliente
        int puerto = 49153;
        ServerSocket servidor = new ServerSocket(puerto);
        Profesor[] profesores = new Profesor[5];
        //Inicialización del array de profesores
        profesores[0] = new Profesor(1, "Carmen", new Asignatura[]{
                new Asignatura(1, "Inglés"),
                new Asignatura(2, "Francés"),
                new Asignatura(3, "Alemán")}, new Especialidad(1, "Idiomas"));
        profesores[1] = new Profesor(2, "Sergio", new Asignatura[]{
                new Asignatura(4, "Física"),
                new Asignatura(5, "Química"),
                new Asignatura(6, "Matemáticas")}, new Especialidad(2, "Ciencias"));
        profesores[2] = new Profesor(3, "Sofía", new Asignatura[]{
                new Asignatura(7, "Biología"),
                new Asignatura(8, "Enfermería"),
                new Asignatura(9, "Farmacia")}, new Especialidad(3, "Sanidad"));
        profesores[3] = new Profesor(4, "Javier", new Asignatura[]{
                new Asignatura(10, "Base de Datos"),
                new Asignatura(11, "Programación"),
                new Asignatura(12, "Lenguaje de Marcas")}, new Especialidad(4, "Informática"));
        profesores[4] = new Profesor(5, "Jose Antonio", new Asignatura[]{
                new Asignatura(1, "Fútbol"),
                new Asignatura(2, "Baloncesto"),
                new Asignatura(3, "Atletismo")}, new Especialidad(5, "Deportes"));
        int idClientes = 1;
        //Bucle infinito
        while(true){
            //Conectando con el cliente
            System.out.println("Servidor iniciado...");
            Socket cliente = servidor.accept();

            //Inicializando objetos de escritura
            OutputStream salida = cliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            //Mandandole al cliente su identificador
            flujoSalida.writeUTF("Tu identificados es: " + idClientes);
            idClientes++;

            //Inicializando objetos de lecturas
            InputStream entrada = cliente.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);

            //Obteniendo del cliente el id del profesor que hay que mostrar
            int id = Integer.parseInt(flujoEntrada.readUTF());
            System.out.println("Consultando id: " + id + ", solicitado por el cliente: " + idClientes);

            //Busqueda y envio de los datos del profesor con el id soliciatado
            for(int i = 0; i<profesores.length; i++){
                if(id==profesores[i].getIdProfesor()){
                    flujoSalida.writeUTF(String.valueOf(profesores[i]));
                }
                else {
                    flujoSalida.writeUTF("El id introducido no corresponde a ningún profesor");
                }
            }


            entrada.close();
            flujoEntrada.close();
            salida.close();
            flujoSalida.close();
            cliente.close();
            servidor.close();
        }
    }
}
