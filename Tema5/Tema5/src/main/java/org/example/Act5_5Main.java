package org.example;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Act5_5Main {
    public static void main(String[] args) {
        CallbackHandler handler = new MyCallbackHandler("pedro", "abcd");

        try {
            LoginContext loginContext = new LoginContext("Act5_5", handler);
            loginContext.login();
            System.out.println("Usuario autenticado...");
        } catch (LoginException e) {
            System.err.println("ERROR => No se puede autenticar el usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }
    //ejecutar en terminal:
    //java -Djava.security.auth.login.config=/home/usuario/PSP/Tema5/Tema5/target/classes/jaas.config -cp target/classes org.example.Act5_5Main
}
