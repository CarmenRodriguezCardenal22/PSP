package org.example;

import javax.security.auth.callback.*;
import java.io.IOException;

public class Act5_5MyCallbackHandler implements CallbackHandler {
    private String usuario, clave;
    //Constructor recibe parámetros usuario y clave
    public Act5_5MyCallbackHandler(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    //Metodo handler sera invocado por el LoginModule
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for(int i = 0; i < callbacks.length; i++ ) {
            Callback callback = callbacks[i];
            if(callback instanceof NameCallback){
                NameCallback nameCallback = (NameCallback) callback;
                //se asigna al NameCallback el nombre de usuario
                nameCallback.setName(usuario);
            }
            else if(callback instanceof PasswordCallback) {
                PasswordCallback passwordCallback = (PasswordCallback) callback;
                //se asigna al PasswordCallback la clave
                passwordCallback.setPassword(clave.toCharArray());
            }
        }
    }
}
