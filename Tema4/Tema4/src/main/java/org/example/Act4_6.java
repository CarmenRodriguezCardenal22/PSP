package org.example;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Act4_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String usuario, contrasena;

        // Bucle principal para la autenticación de usuario
        while (true) {
            System.out.print("Introduce el nombre de usuario (* para salir): ");
            usuario = sc.nextLine();

            // Salir del bucle si se introduce "*"
            if (usuario.equals("*")) {
                System.out.println("Saliendo del sistema...");
                break;
            }

            System.out.print("Introduce la contraseña: ");
            contrasena = sc.nextLine();

            // Verificar credenciales en el servidor FTP
            if (verificarAutenticacionFTP(usuario, contrasena)) {
                System.out.println("Autenticación exitosa.");
                registrarConexionUsuario(usuario, contrasena);
            } else {
                System.out.println("Credenciales incorrectas. Se enviará una alerta al administrador.");
                enviarAlertaDeFallo(usuario);
            }
        }

        sc.close();
    }

    // Función para verificar las credenciales del usuario en el servidor FTP
    private static boolean verificarAutenticacionFTP(String usuario, String contraseña) {
        FTPClient clienteFTP = new FTPClient();
        try {
            clienteFTP.connect("localhost");
            boolean autenticado = clienteFTP.login(usuario, contraseña);
            clienteFTP.logout();
            clienteFTP.disconnect();
            return autenticado;
        } catch (IOException e) {
            System.err.println("Error al autenticar en el servidor FTP: " + e.getMessage());
            return false;
        }
    }

    // Función para registrar la conexión del usuario en el servidor FTP
    private static void registrarConexionUsuario(String usuario, String contraseña) {
        FTPClient clienteFTP = new FTPClient();

        try {
            // Conectar al servidor FTP
            clienteFTP.connect("localhost");
            if (clienteFTP.login(usuario, contraseña)) {
                clienteFTP.enterLocalPassiveMode();
                clienteFTP.setFileType(FTP.BINARY_FILE_TYPE);

                // Crear la carpeta LOG si no existe
                String rutaCarpetaLog = "/" + usuario + "/LOG";
                if (!clienteFTP.changeWorkingDirectory(rutaCarpetaLog)) {
                    clienteFTP.makeDirectory(rutaCarpetaLog);
                    clienteFTP.changeWorkingDirectory(rutaCarpetaLog);
                }

                // Preparar contenido para el archivo de registro
                String nombreArchivoLog = "LOG.TXT";
                String marcaTiempo = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH).format(new Date());
                String contenidoLog = "Conexión registrada para el usuario:\nHora de conexión: " + marcaTiempo + "\n\n";

                // Subir/actualizar el archivo LOG.TXT
                InputStream flujoEntrada = new ByteArrayInputStream(contenidoLog.getBytes());
                clienteFTP.storeFile(nombreArchivoLog, flujoEntrada);
                flujoEntrada.close();

                System.out.println("Conexión registrada en " + rutaCarpetaLog + "/" + nombreArchivoLog);
            } else {
                System.out.println("No se pudo autenticar en el servidor FTP.");
            }

            clienteFTP.logout();
        } catch (IOException e) {
            System.err.println("Error al registrar la conexión: " + e.getMessage());
        } finally {
            try {
                clienteFTP.disconnect();
            } catch (IOException ex) {
                System.err.println("Error al desconectar del servidor FTP: " + ex.getMessage());
            }
        }
    }

    // Función simulada para enviar una alerta por correo electrónico al administrador
    private static void enviarAlertaDeFallo(String usuario) {
        System.out.println("[SIMULACIÓN] Correo de alerta enviado al administrador: \"Usuario " + usuario + " intentó iniciar sesión con credenciales incorrectas.\"");
    }
}
