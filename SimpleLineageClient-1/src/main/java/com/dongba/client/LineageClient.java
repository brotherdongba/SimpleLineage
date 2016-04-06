package com.dongba.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.dongba.dto.Account;

public class LineageClient {
	
	
	private Account account;

	private SessionManager sm;
	
	private MessageTransporter mt;
	
	public LineageClient(String host, int port) throws IOException {
		mt = new TCPMessageTransporter(new Socket(host, port));
		sm = new SessionManager();
	}

	public boolean login(String accountId) throws IOException {
		account = new Account(accountId);
		return sm.login(mt, account);
	}
	
	public void checkInCharacter(String cName) {
		try {
			account.setCurrCharacterName(cName);
			sm.checkInCharacter(mt, account);
		} catch (IOException e) {
			System.out.println("failed to check in character by name " + cName);
		}
	}
	
	public void init() throws IOException {
		new ServerMessageReciever(mt).start();
		new ChattingClient(mt, account).start();
		new MotionClient(account).start();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		String host = "localhost";
		int port = 1500;
		String accountId = "dongba";
		String cName = "dongba";
		LineageClient lineageClient = new LineageClient(host, port);
		while(true) {
			if (lineageClient.login(accountId)) {
				break;
			}
		}
		lineageClient.checkInCharacter(cName);
		lineageClient.init();
		System.out.println("play game!");
	}

}
