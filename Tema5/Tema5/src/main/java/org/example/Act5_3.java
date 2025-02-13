package org.example;

import java.io.FileOutputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Act5_3 {
    public static void main(String[] args) {
        try{
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
            //Se inicializa el generador nde claves
            SecureRandom numero = SecureRandom.getInstance("SHA1PRNG");
            keyGen.initialize(2048, numero);

            //Se crea el par de claves privada y publica
            KeyPair par = keyGen.generateKeyPair();
            PrivateKey clavepriv = par.getPrivate();
            PublicKey clavepub = par.getPublic();

            PKCS8EncodedKeySpec pk8Dpec = new PKCS8EncodedKeySpec(clavepriv.getEncoded());
            //Escribir a fichero binario la clave privada
            FileOutputStream outpriv = new FileOutputStream("Clave.privada");
            outpriv.write(pk8Dpec.getEncoded());
            outpriv.close();

            X509EncodedKeySpec pkX509 = new X509EncodedKeySpec(clavepub.getEncoded());
            //Escribir a fichero binario la clave publica
            FileOutputStream outpub = new FileOutputStream("Clave.publica");
            outpub.write(pk8Dpec.getEncoded());
            outpub.close();

//            //Firma con clave privada el mensaje
//            //Al objeto Signature se le suministran los datos a firmar
//            Signature dsa = Signature.getInstance("SHA256withDSA");
//            dsa.initSign(clavepriv);
//            String mensaje = "Este mensaje va a ser firmado";
//            dsa.update(mensaje.getBytes());
//
//            byte[] firma = dsa.sign(); //Mensaje firmado
//
//            //El receptor del mensaje verifica con la clave publica el mensaje firmado
//            //Al objeto Signature se le suministran los datos a verificar
//            Signature verificadsa = Signature.getInstance("SHA256withDSA");
//            verificadsa.initVerify(clavepub);
//            verificadsa.update(mensaje.getBytes());
//            boolean check = verificadsa.verify(firma);
//
//            if (check) {
//                System.out.println("Firma verificada con clave pública");
//            }
//            else{
//                System.out.println("Firma no verificada");
//            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
