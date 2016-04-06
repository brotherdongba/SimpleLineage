package com.dongba.dto;

import java.io.Serializable;

public class AccountSession implements Serializable {

	private static final long serialVersionUID = -7866591713611930217L;
	
	private boolean loginFlag;

	private boolean checkInFlag;
	
	public AccountSession() {
		loginFlag = false;
		checkInFlag = false;
	}

	public void setLoginFlag(boolean loginFlag) {
		this.loginFlag = loginFlag;
	}
	
	public void setCheckInFlag(boolean checkInFlag) {
		this.checkInFlag = checkInFlag;
	}

	public boolean getLoginFlag() {
		return loginFlag;
	}

	public boolean isCheckInFlag() {
		return checkInFlag;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
