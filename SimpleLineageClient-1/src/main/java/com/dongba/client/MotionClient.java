package com.dongba.client;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.dongba.dto.Account;
import com.dongba.dto.CharacterMotion;

public class MotionClient extends Thread {
	
	private JFrame frame;
	
	private MessageTransporter mt;
	
	private Account account;

	public MotionClient(Account account) {
		this.frame = new JFrame("input motion");
		this.mt = new UDPMessageTransporter();
		this.account = account;
	}
	
	public void run() {
		try {
			while (true) {
				String motion = JOptionPane.showInputDialog(frame, "input character motion.");
				CharacterMotion cm = parseMotion(motion);
				if (cm == null) {
					System.out.println("wrong motion");
					continue;
				}
				mt.send(cm);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private CharacterMotion parseMotion(String motion) {
		String[] split = motion.split(" ");
		if (split.length != 2) {
			return null;
		}
		return new CharacterMotion(account.getCurrCharacterName(), split[0], Integer.parseInt(split[1]));
	}

}
