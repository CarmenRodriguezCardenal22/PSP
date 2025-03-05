package org.example;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.security.PrivilegedAction;

public class Act5_6MainJaasAutentication {
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) {
        System.out.println("Iniciando programa...");

        CallbackHandler handler = new Act5_5MyCallbackHandler("pedro", "abcd");
        System.out.println("CallbackHandler creado.");

        try {
            LoginContext loginContext = new LoginContext("EjemploLogin", handler);
            System.out.println("LoginContext creado.");

            loginContext.login();
            System.out.println("✅ Usuario autenticado correctamente.");
        } catch (LoginException e) {
            System.err.println("ERROR: No se puede autenticar el usuario.");
            e.printStackTrace();  // Esto mostrará el error completo
            System.exit(-1);
        }
    }
}
