package org.example;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Act4_1 {
    public static void main(String[] args) {
        FTPClient cliente = new FTPClient();
        String servFTP = "ftp.rediris.es";
        System.out.println("Nos conectamos a: " + servFTP);
        String usuario = "anonymous";
        String clave = "anonymous";
        try{
            cliente.connect(servFTP);
            cliente.enterLocalPassiveMode();

            boolean login = cliente.login(usuario, clave);
            if(login){
                System.out.println("Login correcto...");
            }
            else{
                System.out.println("Login incorrecto...");
                cliente.disconnect();
                System.exit(1);
            }
            System.out.println("Directorio actual: " + cliente.printWorkingDirectory());
            FTPFile[] files = cliente.listFiles();
            System.out.println("Ficheros en el directorio actual: " + files.length);
            String tipos[] = {"Fichero", "Directorio", "Enlace simb."};

            for(int i=0; i<files.length; i++){
                System.out.println("\t" + files[i].getName() + " => " + tipos[files[i].getType()]);
            }

            //cambiar a /mirror/MySQL/Downloads/
            String directorio = "/mirror/MySQL/Downloads/";
            if(cliente.changeWorkingDirectory(directorio)) {
                System.out.println("Dir Actual: " + cliente.printWorkingDirectory());

            }
            else{
                System.out.println("NO EXISTE EL DIRECTORIO: " + directorio);
            }
            FTPFile[] files1 = cliente.listFiles();
            for(int j=0; j<files1.length; j++){
                System.out.println("\t" + files1[j].getName() + " => " + tipos[files1[j].getType()]);
            }
            //cambiar a /debian
            String directorio2 = "/debian";
            if(cliente.changeWorkingDirectory(directorio2)) {
                System.out.println("Dir Actual: " + cliente.printWorkingDirectory());
            }
            else{
                System.out.println("NO EXISTE EL DIRECTORIO: " + directorio2);
            }
            FTPFile[] files2 = cliente.listFiles();
            for(int i=0; i<files2.length; i++){
                System.out.println("\t" + files2[i].getName() + " => " + tipos[files2[i].getType()]);
            }
            boolean logout = cliente.logout();
            if(logout){
                System.out.println("Logout del servidor FTP...");
            }
            else{
                System.out.println("Error al hacer Logout...");
            }
            cliente.disconnect();
            System.out.println("Desconectado...\n\n\n");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        FTPClient cliente2 = new FTPClient();
        String servFTP2 = "localhost";
        System.out.println("Nos conectamos a: " + servFTP2);
        String usuario2 = "carmen";
        String clave2 = "carmen";
        String tipos2[] = {"Fichero", "Directorio", "Enlace simb."};
        try {
            cliente2.connect(servFTP2);
            cliente2.enterLocalPassiveMode();

           /* boolean login = cliente2.login(usuario2, clave2);
            if (login) {
                System.out.println("Login correcto...");
            } else {
                System.out.println("Login incorrecto...");
                cliente2.disconnect();
                System.exit(1);
            }*/
            FTPFile[] files3 = cliente2.listFiles();
            System.out.println("Ficheros en el directorio actual: " + files3.length);
            for (int i = 0; i < files3.length; i++) {
                System.out.println("\t" + files3[i].getName() + " => " + tipos2[files3[i].getType()]);
                System.out.println("hola");
            }
            boolean logout = cliente2.logout();
            if (logout) {
                System.out.println("Logout del servidor FTP...");
            } else {
                System.out.println("Error al hacer Logout...");
            }
            cliente2.disconnect();
            System.out.println("Desconectado...");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
