package com.dongba.client;

import java.io.IOException;

public class ServerMessageReciever extends Thread {
	
	private MessageTransporter mt;

	public ServerMessageReciever(MessageTransporter mt) throws IOException {
		this.mt = mt;
	}
	
	public void run() {
		try {
			while (true) {
				Object msg = mt.receive();
				System.out.println("received message : " + msg.toString());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
