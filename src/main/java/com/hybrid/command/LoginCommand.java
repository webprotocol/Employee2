package com.hybrid.command;

import java.util.HashMap;
import java.util.Map;

public class LoginCommand {
	String email;
	String password;
	Boolean remember;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getRemember() {
		return remember;
	}
	public void setRemember(Boolean remember) {
		this.remember = remember;
	}
	
}
