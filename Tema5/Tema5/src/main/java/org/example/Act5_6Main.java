package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.PrivilegedAction;

public class Act5_6Main implements PrivilegedAction {
    @Override
    public Object run() {
        File f = new File("fichero.txt");
        if (f.exists()) {
            System.out.println("EL FICHERO EXISTE...");
            //Si existe se muestra su contenido
            FileReader fic;
            try{
                fic=new FileReader(f);
                int i;
                System.out.println("Su contenido es:");
                while ((i= fic.read()) != -1){
                    System.out.print((char)i);
                }
                fic.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else{
            //Si no existe se crea y se insertan los datos
            System.out.println("EL FICHERO NO EXISTE, LO CREO...");
            try{
                FileWriter fic = new FileWriter(f);
                String cadena="Esto es una linea de texto";
                fic.append(cadena);
                fic.close();
                System.out.println("Fichero creado con datos...");
            }catch (IOException e){
                System.out.println("ERROR ==> " + e.getMessage());
            }
        }
        return null;
    }
}
