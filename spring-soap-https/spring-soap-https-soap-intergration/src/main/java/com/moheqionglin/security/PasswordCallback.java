package com.moheqionglin.security;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

@Component
public class PasswordCallback implements CallbackHandler {

	@Value("${cxf.user}")
	private String user;
	@Value("${cxf.pwd}")
	private String pwd;
	
	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		if (pc.getIdentifier().equals(user)) {
			pc.setPassword(pwd);
		}
	}

}
