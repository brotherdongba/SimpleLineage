package com.dongba.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.dongba.dto.Account;

public class LineageClient {
	
	
	private Account account;

	private SessionManager sm;
	
	public LineageClient(String host, int port) throws IOException {
		sm = new SessionManager(new TCPMessageTransporter(new Socket(host, port)));
	}

	public void login(String accountId) throws IOException {
		account = new Account(accountId);
		sm.login(account);
	}
	
	public void checkInCharacter(String cName) {
		try {
			account.setCurrCharacterName(cName);
			sm.checkIn(account);
		} catch (IOException e) {
			System.out.println("failed to check in character by name " + cName);
		}
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		String host = "localhost";
		int port = 1500;
		String accountId = "dongba";
		String cName = "dongba";
		LineageClient lineageClient = new LineageClient(host, port);
		lineageClient.login(accountId);
		lineageClient.checkInCharacter(cName);
	}

}
