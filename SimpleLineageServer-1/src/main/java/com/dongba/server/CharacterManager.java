package com.dongba.server;

import java.io.IOException;

import com.dongba.dto.Account;
import com.dongba.dto.CharacterDto;

public class CharacterManager {
	
	private CharacterDAO charDAO;

	private Account account;

	public CharacterManager(Account account) {
		this.account = account;
		charDAO = new CharacterDAO();
	}

	public CharacterDto loadCurrCharacter() throws IOException {
		return charDAO.load(account);
	}

	public void saveCurrCharacter() throws IOException {
		charDAO.save(account);
	}

}
