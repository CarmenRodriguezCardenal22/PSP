package org.example;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.util.Map;

public class Act5_5 implements LoginModule {
    private Subject subject;
    private CallbackHandler callbackHandler;

    public boolean commit() throws LoginException {
        return true;
    }
    public boolean logout() throws LoginException {
        return true;
    }
    public boolean abort() throws LoginException {
        return true;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler handler, Map state, Map options) {
        this.subject = subject;
        this.callbackHandler = handler;
    }
    //metodo login - se realiza la autenticacion
    public boolean login() throws LoginException {
        boolean autenticado = true;
        if(callbackHandler == null){
            throw new LoginException("Se necesita Callback");
        }
        //se crea el array de Callbacks
        Callback[] callbacks = new Callback[2];
        //constructor de NameCallback y PasswordCallback con prompt
        callbacks[0] = new NameCallback("Nombre de usuario: ");
        callbacks[1] = new PasswordCallback("Clave: ", false);

        try{
            //se invoca al metodo handle de CallbackHandler
            //para solicitar el usuario y la contraseña
            callbackHandler.handle(callbacks);
            String usuario = ((NameCallback) callbacks[0]).getName();
            char[] passw = ((PasswordCallback) callbacks[1]).getPassword();
            String clave = new String(passw);

            //la autenticacion se realiza aqui
            //el nombre de usuario: pedro, su clave: abcd
            autenticado = ("pedro".equalsIgnoreCase(usuario) & "abcd".equals(clave));
            System.out.println("......");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return autenticado;
    }
}
