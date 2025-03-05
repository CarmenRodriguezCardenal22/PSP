package org.example;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.security.PrivilegedAction;

public class Act5_6MainJaasAutentication {
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) {

        CallbackHandler handler = new Act5_6MyCallbackHandler("pedro", "abcd");
        LoginContext loginContext = null;
        try{
            loginContext = new LoginContext("EjemploLogin", handler);
            loginContext.login();
            System.out.println("Usuario autenticado.....");
        }catch (Exception e){
            System.err.println("ERROR=> No se puede autenticar el usuario");
            System.exit(-1);
        }
        //Una vez autenticado se obtiene el Subject
        Subject subject = loginContext.getSubject();

        //Se crea un objeto PrivilegedAction
        PrivilegedAction action = new Act5_6EjemploAccion();
        try{
            //El sujeto realiza la accion definida en la clase
            //EjemploAccion como usuario autenticado bajo las
            //restricciones de seguridad definidas,
            //se usa el metodo doAsPrivileged()
            System.out.println("Ejecutando acción como usuario autenticado...");
        }catch (SecurityException se){
            System.out.println("ACCESO DENEGADO => " + se.getMessage());
        }
        try{
            //Desconectamos el usuario
            loginContext.logout();
        }catch (LoginException le){
            System.out.println("Logout: " + le.getMessage());
            System.exit(-1);
        }

    }
}
//java -Djava.security.auth.login.config=file:/home/usuario/PSP/Tema5/Tema5/target/classes/jaas.config      -cp target/classes org.example.Act5_6MainJaasAutentication
// java -Djava.security.manager -Djava.security.policy=policy.config -Djava.security.auth.login.config=file:/home/usuario/PSP/Tema5/Tema5/target/classes/jaas.config -cp target/classes org.example.Act5_6MainJaasAutentication
