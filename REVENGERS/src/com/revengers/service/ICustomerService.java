package com.revengers.service;

import java.util.List;
import java.util.Set;

import com.revengers.beans.Customer;
import com.revengers.beans.Transaction;
import com.revengers.beans.model.CustomerLogin;

public interface ICustomerService {

	public void save(Customer customer);
	public void delete(int id);
	public List<Customer> list();
	public Customer getCustomerById(int id);
	public Customer find(int id);
	public void update(Customer customer); 
	public Customer getCustomerByUsername(String username);
	public Customer getCustomerByUsernameAndPassword(String username, String password);
	public List<Customer> likeList(String name);
	public CustomerLogin loginStatus(String username, String password);
	public void changePassword(Customer customer, String password);
	public void changePassword(int customerId, String password);
	public void changePriority(Customer customer, int priority);
	public void changePriority(int customerId, int priority);
	public List<Transaction> getTransactionsList(Customer customer);
	public List<Transaction> getTransactionsList(int customerId);
	public Set<Transaction> getTransactionsSet(Customer customer);
	public Set<Transaction> getTransactionsSet(int customerId);
}
