package com.dongba.client;

import java.io.IOException;
import java.util.Scanner;

import com.dongba.dto.Account;
import com.dongba.dto.ChatMessage;

public class ChattingClient extends Thread {

	private MessageTransporter mt;
	
	private Account account;

	public ChattingClient(MessageTransporter mt, Account account) {
		this.mt = mt;
		this.account = account;
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		try {
			while (true) {
				System.out.print("input message > ");
				String inputString = scanner.nextLine();
				if (inputString == null || inputString.isEmpty()) {
					continue;
				}
				ChatMessage chatMessage = new ChatMessage(account.getCurrCharacterName(), inputString);
				mt.send(chatMessage);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
