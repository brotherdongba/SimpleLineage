package com.dongba.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPMessageTransporter extends MessageTransporter {
	
	private Socket s;

	public TCPMessageTransporter(Socket s) {
		this.s = s;
	}

	@Override
	public void send(Object message) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
		out.writeObject(message);
		out.flush();
	}

	@Override
	public Object receive() throws IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(s.getInputStream());
		return in.readObject();
	}

}
