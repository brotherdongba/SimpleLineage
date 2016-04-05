package com.dongba.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPMessageTransporter extends MessageTransporter {
	
	public UDPMessageTransporter() {
	}

	@Override
	public void send(Object message) throws IOException {
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			oos.writeObject(message);
			DatagramSocket ds = new DatagramSocket(0);
			DatagramPacket p = new DatagramPacket(bos.toByteArray(), bos.size());
			ds.send(p);
		} 
	}

	@Override
	public Object receive() throws IOException, ClassNotFoundException {
		return null;
	}

}
