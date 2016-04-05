package com.dongba.client;

import java.io.IOException;

abstract public class MessageTransporter {
	
	abstract public void send(Object message) throws IOException;
	
	abstract public Object receive() throws IOException, ClassNotFoundException;
	
}
