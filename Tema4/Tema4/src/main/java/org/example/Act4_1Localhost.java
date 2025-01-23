package org.example;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;

public class Act4_1Localhost {
    public static void main(String[] args) throws IOException {
        FTPClient cliente = new FTPClient();
        String servFTP = "localhost";
        cliente.connect(servFTP);

        System.out.println("Conexion: " + servFTP);

        String user = "carmen";
        String passwd = "";

        try {
            cliente.connect(servFTP);
            cliente.enterLocalPassiveMode();

            /*boolean login = cliente.login(user, passwd);
            if (login)
                System.out.println("Login exitoso..");
            else {
                System.out.println("Login incorrecto...");
                cliente.disconnect();
                System.exit(1);
            }*/
            String directorio = "/carmen";
            if(cliente.changeWorkingDirectory(directorio)) {
                System.out.println("Dir Actual: " + cliente.printWorkingDirectory());
            }
            System.out.println("Dirección actual: " + cliente.printWorkingDirectory() );
            FTPFile[] files = cliente.listFiles();
            // Listar directorios en el directorio raíz
            System.out.println("Archivos en el directorio actual:" + files.length);
            String tipos[] = {"Ficheros", "Directorio", "Enlace simb."};

            for (int i = 0; i < files.length; i++){
                System.out.println("\t" + files[i].getName() + " => " + tipos[files[i].getType()]);
            }

            boolean logout = cliente.logout();
            if (logout) {
                System.out.println("Logout del servidor FTP...");
            } else {
                System.out.println("Error al hacer Logout...");
            }
            cliente.disconnect();
            System.out.println("Desconexion exitosa");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
