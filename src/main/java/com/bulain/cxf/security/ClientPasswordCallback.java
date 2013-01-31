package com.bulain.cxf.security;

import java.io.IOException;
import java.util.List;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class ClientPasswordCallback implements CallbackHandler {

    private List<String> privateAlais;
    private String password;

    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback cb : callbacks) {
            if (cb instanceof WSPasswordCallback) {
                WSPasswordCallback pc = (WSPasswordCallback) cb;

                String identifier = pc.getIdentifier();
                if (privateAlais != null && privateAlais.contains(identifier)) {
                    continue;
                }

                pc.setPassword(password);
            }
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrivateAlais(List<String> privateAlais) {
        this.privateAlais = privateAlais;
    }

}
