package com.revengers.dao;

import java.util.List;

import com.revengers.beans.Transaction;

public interface ITransactionDAO {

	public static class TransactionException extends Exception{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public TransactionException(String msg){
			super(msg);
		}
		
	}
	public void save(Transaction transaction) throws TransactionException ;
	public Transaction find(int id) throws TransactionException;
	public void update(Transaction transaction) throws TransactionException;
	public void delete(Transaction transaction) throws TransactionException;
	public void deleteByVideoId(int videoId);
	public void deleteByCustomerId(int customerId);
	public List<Transaction> list();
	public void setAdmin(Transaction transaction, int AdminId) throws TransactionException;
	public void setReturnDate(Transaction transaction) throws TransactionException;
}
