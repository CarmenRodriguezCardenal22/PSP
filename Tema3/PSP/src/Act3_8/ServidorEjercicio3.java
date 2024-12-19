package Act3_8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServidorEjercicio3 {
    public static void main(String[] args) throws SocketException {
        int puerto = 49153;

        Alumno alumnos[] = new Alumno[5];
        Curso curso1 = new Curso("1", "matematicas");
        Curso curso2 = new Curso("2", "lengua");
        Curso curso3 = new Curso("3", "ingles");
        alumnos[0] = new Alumno("1", "Carmen", curso3, 7);
        alumnos[1] = new Alumno("2", "Sofía", curso1, 4);
        alumnos[2] = new Alumno("3", "Sergio", curso2, 5);
        alumnos[3] = new Alumno("4", "Javier", curso1, 8);
        alumnos[4] = new Alumno("5", "Jose Antonio", curso3, 10);

        try {
            DatagramSocket servidor = new DatagramSocket(puerto);
            System.out.println("Esperando cliente...");

            while (true) {
                // Recibir paquete del cliente
                byte[] recibidos = new byte[1024];
                DatagramPacket paqueteRecibido = new DatagramPacket(recibidos, recibidos.length);
                servidor.receive(paqueteRecibido);

                // Decodificación del ID recibido
                ByteArrayInputStream bais = new ByteArrayInputStream(paqueteRecibido.getData());
                ObjectInputStream in = new ObjectInputStream(bais);
                String idAlumno = (String) in.readObject();
                System.out.println("Alumno con ID: " + idAlumno);

                // Buscar alumno en la lista
                Alumno alumnoEncontrado = null;
                for (Alumno alumno : alumnos) {
                    if (alumno.getIdAlumno().equals(idAlumno)) {
                        alumnoEncontrado = alumno;
                        break;
                    }
                }

                // Si no se encuentra, se crea un alumno "no existe"
                if (alumnoEncontrado == null) {
                    alumnoEncontrado = new Alumno(idAlumno);
                }

                // Codificación del objeto Alumno
                ByteArrayOutputStream bs = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(bs);
                out.writeObject(alumnoEncontrado);
                byte[] bytes = bs.toByteArray();

                // Enviar respuesta al cliente
                InetAddress ip = paqueteRecibido.getAddress();
                int puertoCliente = paqueteRecibido.getPort();
                DatagramPacket paqueteEnviado = new DatagramPacket(bytes, bytes.length, ip, puertoCliente);
                servidor.send(paqueteEnviado);

                System.out.println("Respuesta enviada: " + alumnoEncontrado.getNombre() + ", "  + alumnoEncontrado.getCurso().getDescripcion() + ", " + alumnoEncontrado.getNota());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
