package com.revengers.beans.model;

import com.revengers.beans.Admin;

public class AdminLogin {

	private boolean login;
	private Admin admin;
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}
