package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Act5_2Modifica {
    public static void main(String[] args) {
            try {
            // Leer el contenido original del archivo
            FileInputStream filein = new FileInputStream("DATOS.DAT");
            ObjectInputStream dataOS = new ObjectInputStream(filein);

            // Leer el String original
            String datosOriginal = (String) dataOS.readObject();

            // Leer el resumen original (hash)
            byte[] resumenOriginal = (byte[]) dataOS.readObject();

            dataOS.close();
            filein.close();

            // Modificar el contenido original (ejemplo: cambiar una letra)
            String datosModificados = datosOriginal.replace("Mancha", "mancha");

            // Escribir los datos modificados en el archivo sin cambiar el hash
            FileOutputStream fileout = new FileOutputStream("DATOS.DAT");
            ObjectOutputStream dataout = new ObjectOutputStream(fileout);

            dataout.writeObject(datosModificados); // Escribimos el texto modificado
            dataout.writeObject(resumenOriginal);  // Mantenemos el hash original

            dataout.close();
            fileout.close();

            System.out.println("Archivo modificado exitosamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
