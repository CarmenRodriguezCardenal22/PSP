package org.example;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.util.Map;

public class Act5_6LoginModule implements LoginModule {
    private Subject subject;
    private CallbackHandler callbackHandler;
    String usuario, clave;

    //Se define el principal para es usuario
    private Act5_6EjemploPrincipal usuarioPrincipal;

    @Override
    public boolean abort() throws LoginException {
        return true;
    }
    //Se llama a este metodo si la autenticacion global de
    //Login Context ha sido satisfactoria
    @Override
    public boolean commit() throws LoginException {
        //Se crea el principal asociado al usuario autenticado
        usuarioPrincipal = new Act5_6EjemploPrincipal(usuario);

        //Se añade el principal (identidad unica) al sujeto
        if (!subject.getPrincipals().contains(usuarioPrincipal)) {
            subject.getPrincipals().add(usuarioPrincipal);
        }
        return true;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map sharedState, Map options) {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
    }

    //metodo login
    @Override
    public boolean login() throws LoginException {
        boolean autenticado = true;

        if (callbackHandler == null) {
            throw new LoginException("Se necesita CallbackHandler");
        }

        Callback[] callbacks = new Callback[2];
        callbacks[0] = new NameCallback("Nombre de usuario: ");
        callbacks[1] = new PasswordCallback("Clave: ", false);

        try {
            //Se invoca al CallbackHandler
            callbackHandler.handle(callbacks);

            usuario = ((NameCallback) callbacks[0]).getName();
            char[] passw = ((PasswordCallback) callbacks[1]).getPassword();
            clave = new String(passw);

            //La autenticacion se realiza aqui
            boolean autenticado1 = ("pedro".equalsIgnoreCase(usuario) && "abcd".equals(clave));
            boolean autenticado2 = ("maria".equalsIgnoreCase(usuario) && "1234".equals(clave));
            autenticado = autenticado1 || autenticado2;
        } catch (Exception e) {
            System.err.println("ERROR en login()");
            e.printStackTrace();
        }
        return autenticado;
    }
    //Finalizar la sesion del usuario
    //Este metodo elimina el principal que se añadio en commit
    @Override
    public boolean logout() throws LoginException {
        subject.getPrincipals().remove(usuarioPrincipal);
        usuarioPrincipal = null;
        usuario = null;
        clave = null;
        return true;
    }
}
