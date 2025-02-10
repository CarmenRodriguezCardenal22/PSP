package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

public class Act5_1A {
    public static void main(String[] args) {
        MessageDigest md;
        try {
            // Inicializamos el MessageDigest con el algoritmo MD5
            md = MessageDigest.getInstance("MD5");

            // Definimos el texto a cifrar
            String texto = "Esto es un texto plano";

            // Convertimos el texto a un arreglo de bytes
            byte dataByte[] = texto.getBytes();

            // Actualizamos el MessageDigest con los datos
            md.update(dataByte);

            // Obtenemos el mensaje resumen (hash)
            byte resumen[] = md.digest();

            // Imprimimos el mensaje original
            System.out.println("Mensaje original: " + texto);
            // Imprimimos el número de bytes del resumen
            System.out.println("Número de bytes: " + md.getDigestLength());

            // Imprimimos el algoritmo usado (MD5)
            System.out.println("Algoritmo: " + md.getAlgorithm());
            // Imprimimos el mensaje resumen (en bytes, pero no es legible)
            System.out.println("Mensaje resumen: " + new String(resumen));

            // Imprimimos el mensaje resumen en formato hexadecimal
            System.out.println("Mensaje en Hexadecimal: " + Hexadecimal(resumen));

            // Obtenemos y mostramos el proveedor del algoritmo
            Provider proveedor = md.getProvider();
            System.out.println("Proveedor: " + proveedor);
        }
        catch (NoSuchAlgorithmException e) {
            // Si no se encuentra el algoritmo MD5, mostramos un error
            e.printStackTrace();
        }
    }

    // Convertir el resumen (hash) en formato hexadecimal
    static String Hexadecimal(byte[] resumen) {
        String hex = "";
        // Recorremos el arreglo de bytes del resumen
        for (int i = 0; i < resumen.length; i++) {
            // Convertimos cada byte a su representación hexadecimal
            String h = Integer.toHexString(resumen[i] & 0xFF);
            // Si el valor hexadecimal tiene un solo dígito, lo completamos con un 0
            if (h.length() == 1) hex += "0";
            // Añadimos el valor hexadecimal al resultado
            hex += h;
        }
        // Devolvemos el resultado en mayúsculas
        return hex.toUpperCase();
    }
}
