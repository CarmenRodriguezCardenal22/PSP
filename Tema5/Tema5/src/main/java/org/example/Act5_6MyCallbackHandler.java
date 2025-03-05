package org.example;

import javax.security.auth.callback.*;
import java.io.IOException;

public class Act5_6MyCallbackHandler  implements CallbackHandler {
    private String usuario, clave;

    public Act5_6MyCallbackHandler(String usuario, String clave) {
        System.out.println("📌 CallbackHandler creado con usuario: " + usuario + ", clave: " + clave);
        this.usuario = usuario;
        this.clave = clave;
    }

    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            Callback callback = callbacks[i];
            if (callback instanceof NameCallback) {
                NameCallback nameCallback = (NameCallback) callback;
                nameCallback.setName(usuario);
                System.out.println("📌 NameCallback: Usuario asignado -> " + usuario);
            } else if (callback instanceof PasswordCallback) {
                PasswordCallback passwordCallback = (PasswordCallback) callback;
                passwordCallback.setPassword(clave.toCharArray());
                System.out.println("📌 PasswordCallback: Clave asignada -> " + clave);
            }
        }
    }
}
