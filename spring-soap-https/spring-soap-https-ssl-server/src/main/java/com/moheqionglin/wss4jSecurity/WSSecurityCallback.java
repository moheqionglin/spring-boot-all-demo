package com.moheqionglin.wss4jSecurity;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

@Component
public class WSSecurityCallback implements CallbackHandler {
 
     
    private static final Logger log = LoggerFactory.getLogger(WSSecurityCallback.class);
    @Value("${ssl.soap.username}")
    private String userName;
    @Value("${ssl.soap:password}")
    private String password;
     
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
         
 
        WSPasswordCallback callback = (WSPasswordCallback) callbacks[0];
//        callback.setIdentifier(userName);

        // you won't be able to retrieve the password using callback.getPassword().
        // to authenticate a user, you'll need to set the password tied to the user.
        // user credentials are typically retrieved from DB or your own authentication source.
        // if the password set here is the same as the password passed by caller, authentication is successful.
        //可以查数据库
        callback.setPassword(password);

        log.info("Identifier: {}， PWD: {} " + callback.getIdentifier(), callback.getPassword());
                     
    }
}