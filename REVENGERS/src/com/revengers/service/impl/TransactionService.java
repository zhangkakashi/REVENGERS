package com.revengers.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import com.revengers.service.ITransactionService;

public class TransactionService implements ITransactionService {

	private static ICustomerDAO customerDAO;
	private static IVideoDAO videoDAO;
	private static ITransactionDAO transactionDAO;
	
	static{
		@SuppressWarnings("resource")
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		customerDAO = (ICustomerDAO) act.getBean("customerDAO");
		videoDAO = (IVideoDAO) act.getBean("videoDAO");
		transactionDAO = (ITransactionDAO)act.getBean("transactionDAO");
	}
	
	@Override
	public void save(Transaction transaction) {
		try {
			transaction.setRent_date(new Date());
			transactionDAO.save(transaction);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save(Transaction transaction, int videoId, int customerId) {
		try {
			Video v = videoDAO.find(videoId);
			Customer c = customerDAO.find(customerId);
			transaction.setCustomer(c);
			transaction.setVideo(v);
			transactionDAO.save(transaction);
		} catch (VideoException e) {
			e.printStackTrace();
		} catch (CustomerException e) {
			e.printStackTrace();
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Transaction find(int id) {
		Transaction t = new Transaction();
		try {
			t = transactionDAO.find(id);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public void update(Transaction transaction) {
		try {
			transactionDAO.update(transaction);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Transaction transaction) {
		try {
			transactionDAO.delete(transaction);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(int transactionId) {
		try {
			Transaction t = transactionDAO.find(transactionId);
			transactionDAO.delete(t);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Transaction> list() {
		List<Transaction> list = null;
		list = transactionDAO.list();
		return list;
	}

	@Override
	public void setAdmin(Transaction transaction, int AdminId) {
		try {
			transactionDAO.setAdmin(transaction, AdminId);
		}  catch (TransactionException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void setReturnDate(Transaction transaction) {
		try {
			transactionDAO.setReturnDate(transaction);
		} catch (TransactionException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void setReturnDate(Transaction transaction, Date date) {
		try {
			transaction.setReturn_date(date);
			transactionDAO.update(transaction);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setReturnDate(Transaction transaction, int date) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(transaction.getRent_date());
			cal.add(Calendar.DATE, date);
			transaction.setReturn_date(cal.getTime());
			transactionDAO.update(transaction);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setDueDate(Transaction transaction) {
		try {
			transaction.setDue_date(new Date());
			transactionDAO.update(transaction);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setDueDate(Transaction transaction, Date date) {
		try {
			transaction.setDue_date(date);
			transactionDAO.update(transaction);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setDueDate(Transaction transaction, int date) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(transaction.getRent_date());
			cal.add(Calendar.DATE, date);
			transaction.setDue_date(cal.getTime());
			transactionDAO.update(transaction);
		} catch (TransactionException e) {
			e.printStackTrace();
		}
	}


}
