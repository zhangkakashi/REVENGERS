package com.revengers.beans.model;

import com.revengers.beans.Customer;

public class CustomerLogin {

	private boolean login;
	private Customer customer;
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
