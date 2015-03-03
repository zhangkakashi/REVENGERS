package com.revengers.service;

import java.util.Date;
import java.util.List;

import com.revengers.beans.Transaction;

public interface ITransactionService {

	public void save(Transaction transaction);
	public void save(Transaction transaction, int videoId, int customerId);
	public Transaction find(int id);
	public void update(Transaction transaction);
	public void delete(Transaction transaction);
	public void delete(int transactionId);
	public List<Transaction> list();
	public void setAdmin(Transaction transaction, int AdminId);
	public void setReturnDate(Transaction transaction);
	public void setReturnDate(Transaction transaction, Date date);
	public void setReturnDate(Transaction transaction, int date);
	public void setDueDate(Transaction transaction);
	public void setDueDate(Transaction transaction, Date date);
	public void setDueDate(Transaction transaction, int date);
}
