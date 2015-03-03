package com.revengers.dao;

import java.util.List;

import com.revengers.beans.Customer;

public interface ICustomerDAO {
	public static class CustomerException extends Exception{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public CustomerException(String msg){
			super(msg);
		}
		
	}
	public void save(Customer customer) throws CustomerException;
	public void delete(Customer customer) throws CustomerException;
	public List<Customer> list() throws CustomerException;
	public Customer getCustomerById(int id) throws CustomerException;
	public Customer find(int id) throws CustomerException;
	public void update(Customer customer) throws CustomerException; 
	public Customer getCustomerByUsername(String username) throws CustomerException;
	public Customer getCustomerByUsernameAndPassword(String username, String password)
			throws CustomerException;
	public List<Customer> likeList(String name) throws CustomerException;
	
}
