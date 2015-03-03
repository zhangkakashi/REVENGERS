package com.revengers.test;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;


import com.revengers.beans.Transaction;
import com.revengers.service.ICustomerService;
import com.revengers.service.ITransactionService;
import com.revengers.service.IVideoService;
import com.revengers.service.impl.CustomerService;
import com.revengers.service.impl.TransactionService;
import com.revengers.service.impl.VideoService;

public class TransactionServiceTest {

	private static ITransactionService ts;
	private static IVideoService vs;
	private static ICustomerService cs;
	@BeforeClass
	public static void setUoBeforeClass() throws Exception {
		ts = new TransactionService();
		vs = new VideoService();
		cs = new CustomerService();
	}
	
	@Test
	public void save(){
		Transaction t = new Transaction();
		t.setVideo(vs.find(7));
		t.setCustomer(cs.find(1));
		ts.save(t);
	}
	
	@Test
	public void delete(){
		ts.delete(1);
	}
	
	@Test
	public void setReturnDate(){
		Transaction t = ts.find(2);
		//ts.setReturnDate(t, 3);
		ts.setReturnDate(t , new Date());
	}
	
	@Test
	public void setDueDate(){
		Transaction t = ts.find(2);
		ts.setDueDate(t, 100);
	}
	
	@Test
	public void setAdmin(){
		Transaction t = ts.find(1);
		ts.setAdmin(t, 3);
	}
}
