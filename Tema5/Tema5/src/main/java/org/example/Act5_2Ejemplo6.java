package org.example;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.MessageDigest;

public class Act5_2Ejemplo6 {
    public static void main(String[] args) {
        try{
            FileInputStream fileout = new FileInputStream("DATOS.DAT");
            ObjectInputStream dataOS = new ObjectInputStream(fileout);
            Object o = dataOS.readObject();

            //Primera lectura, se obtiene el String
            String datos = (String) o;
            System.out.println("Datos: " + datos);

            //Segunda lectura, se obtiene el resumen
            o = dataOS.readObject();
            byte resumenOriginal[] = (byte[]) o;

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            //Se calcula el resumen del String leido del fichero
            md.update(datos.getBytes());
            byte resumenActual[] = md.digest();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
