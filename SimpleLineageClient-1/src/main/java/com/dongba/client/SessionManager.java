package com.dongba.client;

import java.io.IOException;

import com.dongba.dto.Account;

public class SessionManager {
	
	private final MessageTransporter mt;

	public SessionManager(MessageTransporter mt) throws IOException {
		this.mt = mt;
	}

	public void login(Account account) throws IOException {
		new ServerMessageReciever(mt).start();
		mt.send(account);
	}

	public void checkIn(Account account) throws IOException {
		new ChattingClient(mt, account).start();
		new MotionClient(account).start();
		mt.send(account);
	}

	public MessageTransporter getMessageTransporter() {
		return mt;
	}

}
