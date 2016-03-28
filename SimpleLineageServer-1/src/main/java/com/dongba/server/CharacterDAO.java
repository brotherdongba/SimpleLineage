package com.dongba.server;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.dongba.dto.Account;
import com.dongba.dto.CharacterDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CharacterDAO {
	
	private static final String CHARACTER_MANAGER = "characterManager";

	private final String projectRoot = System.getProperty("user.dir");
	
	private Gson gson;
	
	public CharacterDAO() {
		GsonBuilder builder = new GsonBuilder();
		gson = builder.create();
		
	}

	/**
	 * getting selected character by account
	 * return null if not exists character for the account
	 * @param account
	 * @return CharacterDto
	 * @throws IOException
	 */
	public CharacterDto load(Account account) throws IOException {
		Path currAccountPath = Paths.get(projectRoot, CHARACTER_MANAGER, account.getId());
		if (Files.exists(currAccountPath) == false) {
			Files.createDirectories(currAccountPath);
			return null;
		}
		String currCharacterName = account.getCurrCharacterName();
		if (StringUtils.isBlank(currCharacterName)) {
			return null;
		}
		File characterFile = new File(currAccountPath.toFile().getPath(), currCharacterName + ".json");
		String currCharacterString = FileUtils.readFileToString(characterFile);
		return gson.fromJson(currCharacterString, CharacterDto.class);
	}

	public void save(Account account) throws IOException {
		Path currAccountPath = Paths.get(projectRoot, CHARACTER_MANAGER, account.getId());
		if (Files.exists(currAccountPath) == false) {
			Files.createDirectories(currAccountPath);
		}
		String currCharacterName = account.getCurrCharacterName();
		String currCharacterString = gson.toJson(account);
		File currCharacterFile = new File(currAccountPath.toFile().getPath(), currCharacterName + ".json");
		FileUtils.writeStringToFile(currCharacterFile, currCharacterString, false);
	}

}
