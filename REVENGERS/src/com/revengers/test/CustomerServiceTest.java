package com.revengers.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revengers.beans.Customer;
import com.revengers.beans.Gender;
import com.revengers.beans.Transaction;
import com.revengers.beans.model.CustomerLogin;
import com.revengers.service.ICustomerService;
import com.revengers.service.impl.CustomerService;

public class CustomerServiceTest {

	private static ICustomerService cs;
	@BeforeClass
	public static void setUoBeforeClass() throws Exception {
		cs = new CustomerService();
		
	}
	
	@Test
	public void save(){
		Customer c = new Customer();
		c.setUsername("1");
		c.setPassword("123");
		c.setGender(Gender.MALE);
		cs.save(c);
	}
	
	
	@Test
	public void islogin(){
		CustomerLogin c = cs.loginStatus("1", "123");
		System.out.println(c.isLogin());
	}
	
	@Test
	public void tranaction(){
		Customer customer = cs.find(6);
		List<Transaction> list = cs.getTransactionsList(customer);
		for(Transaction t:list){
			System.out.println(t.getCustomer().getId() + " " + t.getDue_date() + " " + t.getRent_date() + " " + t.getVideo().getId());
		}
	}
}
