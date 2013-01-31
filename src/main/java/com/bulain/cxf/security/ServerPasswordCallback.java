package com.bulain.cxf.security;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;
import org.springframework.core.io.Resource;

public class ServerPasswordCallback implements CallbackHandler {

    private List<String> privateAlais;
    private Properties properties;
    private Resource location;

    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback cb : callbacks) {
            if (cb instanceof WSPasswordCallback) {
                WSPasswordCallback pc = (WSPasswordCallback) cb;

                String identifier = pc.getIdentifier();
                if (privateAlais != null && privateAlais.contains(identifier)) {
                    continue;
                }

                if (properties == null && location != null) {
                    properties = new Properties();
                    properties.load(location.getInputStream());
                }

                if (properties != null) {
                    pc.setPassword(properties.getProperty(identifier));
                }
            }
        }
    }

    public void setLocation(Resource location) {
        this.location = location;
    }

    public void setPrivateAlais(List<String> privateAlais) {
        this.privateAlais = privateAlais;
    }

}
