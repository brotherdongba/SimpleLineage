package com.dongba.client;

import java.io.IOException;

import com.dongba.dto.Account;

public class SessionManager {
	
	public SessionManager(MessageTransporter mt) throws IOException {
		Account account = new Account(mt.getAccountId());
		mt.send(account);
	}

}
