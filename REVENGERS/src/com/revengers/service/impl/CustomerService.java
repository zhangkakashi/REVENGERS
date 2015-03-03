package com.revengers.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revengers.beans.Customer;
import com.revengers.beans.Transaction;
import com.revengers.beans.model.CustomerLogin;
import com.revengers.dao.ICustomerDAO;
import com.revengers.dao.ICustomerDAO.CustomerException;
import com.revengers.dao.ITransactionDAO;
import com.revengers.md5.MD5;
import com.revengers.service.ICustomerService;

public class CustomerService implements ICustomerService{

	private static ICustomerDAO customerDAO;
	private static ITransactionDAO transactionDAO;
	
	static{
		@SuppressWarnings("resource")
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		customerDAO = (ICustomerDAO) act.getBean("customerDAO");
		transactionDAO = (ITransactionDAO)act.getBean("transactionDAO");
	}
	
	@Override
	public void save(Customer customer) {
		Customer c = customer;
		c.setPassword(MD5.encode(customer.getPassword()));
		try {
			customerDAO.save(c);
		} catch (CustomerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			Customer customer = customerDAO.find(id);
			transactionDAO.deleteByCustomerId(id);
			customerDAO.delete(customer);
		} catch (CustomerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> list() {
		List<Customer> list = null;
		try {
			list = customerDAO.list();
		} catch (CustomerException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer c = new Customer();
		try {
			c = customerDAO.getCustomerById(id);
		} catch (CustomerException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Customer find(int id) {
		Customer c = new Customer();
		try {
			c = customerDAO.find(id);
		} catch (CustomerException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void update(Customer customer) {
		try {
			customerDAO.update(customer);
		} catch (CustomerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		Customer c = new Customer();
		try {
			c = customerDAO.getCustomerByUsername(username);
		} catch (CustomerException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Customer getCustomerByUsernameAndPassword(String username,
			String password) {
		Customer c = new Customer();
		try {
			customerDAO.getCustomerByUsernameAndPassword(username, password);
		} catch (CustomerException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Customer> likeList(String name) {
		List<Customer> list = null;
		try {
			if(name!=null&&!name.trim().equals("")){
				list = customerDAO.likeList(name);
			}
		} catch (CustomerException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public CustomerLogin loginStatus(String username, String password) {
		CustomerLogin cl = new CustomerLogin();
		try {
			cl.setCustomer(customerDAO.getCustomerByUsernameAndPassword(username, MD5.encode(password)));
			cl.setLogin(true);
		} catch (CustomerException e) {
			System.out.println(e.toString());
			cl.setCustomer(null);
			cl.setLogin(false);
		}
		return cl;
	}

	@Override
	public void changePassword(Customer customer, String password) {
		try {
			customer.setPassword(password);
			customerDAO.update(customer);
		} catch (CustomerException e) {
			System.out.println(e.toString() + ", password Customer changing fails");
		}
		
	}

	@Override
	public void changePassword(int id, String password) {
		try {
			Customer c = customerDAO.find(id);
			c.setPassword(password);
			customerDAO.update(c);
		} catch (CustomerException e) {
			System.out.println(e.toString() + ", password Customer changing fails");
		}
	}

	@Override
	public void changePriority(Customer customer, int priority) {
		try {
			customer.setPriority(priority);
			customerDAO.update(customer);
		} catch (CustomerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void changePriority(int customerId, int priority) {
		try {
			Customer c = customerDAO.find(customerId);
			c.setPriority(priority);
			customerDAO.update(c);
		} catch (CustomerException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public List<Transaction> getTransactionsList(Customer customer) {
		Set<Transaction> transactionSet = customer.getTransactions();
		List<Transaction> transactionList = new ArrayList<Transaction>();
		for(Transaction t: transactionSet){
			transactionList.add(t);
		}
		return transactionList;
	}

	@Override
	public List<Transaction> getTransactionsList(int customerId) {
		Customer customer = new Customer();
		try {
			customer = customerDAO.find(customerId);
		} catch (CustomerException e) {
			e.printStackTrace();
		}
		Set<Transaction> transactionSet = customer.getTransactions();
		List<Transaction> transactionList = new ArrayList<Transaction>();
		for(Transaction t: transactionSet){
			transactionList.add(t);
		}
		return transactionList;
	}

	@Override
	public Set<Transaction> getTransactionsSet(Customer customer) {
		return customer.getTransactions();
	}

	@Override
	public Set<Transaction> getTransactionsSet(int customerId) {
		Customer customer = new Customer();
		try {
			customer = customerDAO.find(customerId);
		} catch (CustomerException e) {
			e.printStackTrace();
		}
		return customer.getTransactions();
	}

}
