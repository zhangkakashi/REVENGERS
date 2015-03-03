package com.revengers.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revengers.beans.Customer;
import com.revengers.beans.Gender;
import com.revengers.dao.ICustomerDAO;
import com.revengers.dao.ICustomerDAO.CustomerException;
import com.revengers.md5.MD5;


public class CustomerJunitTest {

	MD5 md5 = new MD5();
	private static ICustomerDAO customerDAO;
	
	@BeforeClass
	public static void setUoBeforeClass() throws Exception {
		try{
			@SuppressWarnings("resource")
			ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
			customerDAO = (ICustomerDAO) act.getBean("customerDAO");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void customerDAOSave(){
		for(int i=1;i<11;i++){
			Customer c = new Customer();
			c.setUsername("hello" + i);
			c.setPassword(MD5.encode("123" + i));
			c.setGender(Gender.FEMALE);
			c.setAddress("hehe Address " + i );
			c.setAge(1);
			c.setCredit_card("123123445");
			c.setPhone("123");
			c.setEmail("123@123.com");
			c.setName("abidas");
			try {
				customerDAO.save(c);
			} catch (CustomerException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Test
	public void customerDAOList(){
		try {
			List<Customer> list = customerDAO.list();
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i).getPassword() + "  " + list.get(i).getName() );
			}
		} catch (CustomerException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void customerDAODelete(){
		try {
			Customer c = customerDAO.find(1);
			customerDAO.delete(c);
			List<Customer> list = customerDAO.list();
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i).getPassword());
			}
		} catch (CustomerException e) {
			e.printStackTrace();
		}
		
		//customerDAO
		
	}
	
	@Test
	public void customerDAOUpdate(){
		try {
			Customer c = customerDAO.find(2);
			c.setAge(1000);
			customerDAO.update(c);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void customerDAOgetCustomerByUsername(){
		try {
			Customer c = customerDAO.getCustomerByUsername("hello");
			System.out.println(c.getPassword());
		} catch (CustomerException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void customerDAOgetCustomerByUsernameAndPassword(){
		try {
			Customer c = customerDAO.getCustomerByUsernameAndPassword("hello1", MD5.encode("12312"));
			System.out.println(c.getPassword());
		} catch (CustomerException e) {
			System.out.println("no such user");
		}
	}
	
	@Test 
	public void customerLikeList(){
		try {
			List<Customer> list = customerDAO.likeList("a");
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i).getName());
			}
		} catch (CustomerException e) {
			e.printStackTrace();
		}
	}
	
}
