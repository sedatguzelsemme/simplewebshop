package com.guzelsemme.webshop.login;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Login {
	private String email;
	private String password;
	
		
	public Login() {
		super();
	}
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
	
	
}
