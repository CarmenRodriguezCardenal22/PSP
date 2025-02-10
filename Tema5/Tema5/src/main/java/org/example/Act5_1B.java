package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Act5_1B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer las tres cadenas
        System.out.print("Introduce la primera cadena: ");
        String cadena1 = scanner.nextLine();

        System.out.print("Introduce la segunda cadena: ");
        String cadena2 = scanner.nextLine();

        System.out.print("Introduce la clave: ");
        String clave = scanner.nextLine();

        // Llamamos al metodo para calcular el resumen cifrado
        try {
            byte[] resumen1 = calcularResumen(cadena1, clave);
            byte[] resumen2 = calcularResumen(cadena2, clave);

            // Imprimir los resúmenes
            System.out.println("Resumen 1 (cadena 1 + clave) en Hexadecimal: " + Hexadecimal(resumen1));
            System.out.println("Resumen 2 (cadena 2 + clave) en Hexadecimal: " + Hexadecimal(resumen2));

            // Comparar los resúmenes
            if (MessageDigest.isEqual(resumen1, resumen2)) {
                System.out.println("Los resúmenes son iguales.");
            } else {
                System.out.println("Los resúmenes no son iguales.");
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Calcular el resumen (hash) usando la clave
    static byte[] calcularResumen(String mensaje, String clave) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Concatenamos el mensaje con la clave
        String mensajeConClave = mensaje + clave;

        // Actualizamos el mensaje con la concatenación
        md.update(mensajeConClave.getBytes());

        // Generamos el resumen (digest)
        return md.digest();
    }

    // Convertir el resumen a formato hexadecimal
    static String Hexadecimal(byte[] resumen) {
        StringBuilder hex = new StringBuilder();
        for (byte b : resumen) {
            String h = Integer.toHexString(b & 0xFF);
            if (h.length() == 1) hex.append("0");
            hex.append(h);
        }
        return hex.toString().toUpperCase();
    }
}
