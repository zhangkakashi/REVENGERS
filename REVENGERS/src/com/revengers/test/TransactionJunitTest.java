package com.revengers.test;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revengers.beans.Customer;
import com.revengers.beans.Transaction;
import com.revengers.beans.Video;
import com.revengers.dao.ICustomerDAO;
import com.revengers.dao.ICustomerDAO.CustomerException;
import com.revengers.dao.ITransactionDAO;
import com.revengers.dao.ITransactionDAO.TransactionException;
import com.revengers.dao.IVideoDAO;
import com.revengers.dao.IVideoDAO.VideoException;

public class TransactionJunitTest {

	private static ICustomerDAO customerDAO;
	private static IVideoDAO videoDAO;
	private static ITransactionDAO transactionDAO;

	@BeforeClass
	public static void setUoBeforeClass() throws Exception {
		try {
			@SuppressWarnings("resource")
			ApplicationContext act = new ClassPathXmlApplicationContext(
					"beans.xml");
			transactionDAO = (ITransactionDAO) act.getBean("transactionDAO");
			videoDAO = (IVideoDAO) act.getBean("videoDAO");
			customerDAO = (ICustomerDAO) act.getBean("customerDAO");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void save() {
		try {
			Customer c = customerDAO.find(5);
			Video v = videoDAO.find(3);
			Transaction t = new Transaction();
			t.setCustomer(c);
			t.setVideo(v);
			t.setDue_date(new Date());
			t.setRent_date(new Date());
			transactionDAO.save(t);
		} catch (CustomerException  e) {
			e.printStackTrace();
		} catch (VideoException e) {
			e.printStackTrace();
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void find(){
		try {
			Transaction t = transactionDAO.find(1);
			System.out.println(t.getAdmin_id() +  " " + t.getCustomer() + " " + 
			t.getRent_date() + " " + t.getDue_date() + " " + t.getReturn_date());
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void list(){
		List<Transaction> list = transactionDAO.list();
		for(int i=0;i<list.size();i++){
			System.out.println(  " " + list.get(i).getCustomer() + " " + 
					list.get(i).getRent_date() + " " + list.get(i).getDue_date() + " " + list.get(i).getReturn_date());
		}
 	}
	
	@Test
	public void setAdmin(){
		try {
			Transaction t = transactionDAO.find(2);
			transactionDAO.setAdmin( t, 15);
		} catch (TransactionException e) {
			System.out.println("hehe");
			e.printStackTrace();
		}
	}
	
	@Test
	public void setReturn(){
		try {
			Transaction t = transactionDAO.find(2);
			transactionDAO.setReturnDate(t);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteVideo(){
		transactionDAO.deleteByVideoId(3);
	}
	
	@Test
	public void delete(){
		try {
			transactionDAO.delete(transactionDAO.find(1));
		} catch (TransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
