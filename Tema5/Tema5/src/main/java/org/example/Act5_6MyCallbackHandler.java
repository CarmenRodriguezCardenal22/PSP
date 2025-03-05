package org.example;

import javax.security.auth.callback.*;
import java.io.IOException;

public class Act5_6MyCallbackHandler  implements CallbackHandler {
    private String usuario, clave;

    //Constructor recibe parametros usuario y clave
    public Act5_6MyCallbackHandler(String usu, String clave) {
        this.usuario = usu;
        this.clave = clave;
    }

    //Metodo handle sera invocado por el LoginModule
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            Callback callback = callbacks[i];
            if (callback instanceof NameCallback) {
                NameCallback nameCallback = (NameCallback) callback;

                //se asigna al NameCallBack el nombre de usuario
                nameCallback.setName(usuario);
            } else if (callback instanceof PasswordCallback) {
                PasswordCallback passwordCallback = (PasswordCallback) callback;

                //Se asigna al PasswordCallBack la clave
                passwordCallback.setPassword(clave.toCharArray());
            }
        }
    }
}
