package com.dongba.dto;

import java.io.Serializable;

public class Account implements Serializable {
	
	private static final long serialVersionUID = 7859294584922295548L;
	
	private String id;
	
	private String currCharacterName;

	public Account(String id) {
		this.id = id;
		this.currCharacterName = "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCurrCharacterName() {
		return currCharacterName;
	}

	public void setCurrCharacterName(String currCharacterName) {
		this.currCharacterName = currCharacterName;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", currCharacterName=" + currCharacterName
				+ "]";
	}
	
}
