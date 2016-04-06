package com.dongba.client;

import java.io.IOException;

import javax.naming.AuthenticationException;

import com.dongba.dto.Account;
import com.dongba.dto.AccountSession;

public class SessionManager {
	
	public boolean login(MessageTransporter mt, Account account) {
		try {
			mt.send(account);
			isSuccessLogin(mt);
		} catch (IOException e) {
			System.exit(0);
		} catch (AuthenticationException e) {
			return false;
		} catch (ClassNotFoundException e) {
		}
		return true;
	}

	public void checkInCharacter(MessageTransporter mt, Account account) throws IOException {
		mt.send(account);
	}
	
	private void isSuccessLogin(MessageTransporter mt) throws ClassNotFoundException, IOException, AuthenticationException {
		AccountSession as = (AccountSession)mt.receive();
		if (as.getLoginFlag() == false){
			throw new AuthenticationException(as.getMessage());
		}
	}

}
