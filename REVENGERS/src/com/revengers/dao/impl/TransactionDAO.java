package com.revengers.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revengers.beans.Admin;
import com.revengers.beans.Transaction;
import com.revengers.dao.ITransactionDAO;

@Service
@Transactional
public class TransactionDAO implements ITransactionDAO {

	@Resource
	// (name="sessionFactory")
	SessionFactory sessionFactory;

	@Override
	public void save(Transaction transaction)  throws TransactionException {
		try{
			sessionFactory.getCurrentSession().save(transaction);
		}catch(Exception e){
		    throw new TransactionException("save transaction fails");	
		}
	}

	// @Transactional
	@Override
	public Transaction find(int id) throws TransactionException {
		try {
			Transaction t = (Transaction) sessionFactory.getCurrentSession()
					.get(Transaction.class, id);
			if (t != null) {
				return t;
			} else {
				throw new TransactionException("no such Transaction");
			}
		} catch (Exception e) {
			throw new TransactionException("no such Transaction");
		}
	}

	// @Transactional
	@Override
	public void update(Transaction transaction) throws TransactionException {
		try {
			sessionFactory.getCurrentSession().merge(transaction);
		} catch (Exception e) {
			throw new TransactionException("no such Transaction");
		}
	}

	@Override
	public void delete(Transaction transaction) throws TransactionException {
		try {
			sessionFactory.getCurrentSession().createQuery("delete from Transaction where id= :id ").setParameter("id", transaction.getId()).executeUpdate();
		} catch (Exception e) {
			throw new TransactionException("no such Transaction");
		}
	}

	// @Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> list() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Transaction").list();
	}

	@Override
	public void setAdmin(Transaction transaction, int AdminId)
			throws TransactionException {

		Admin a = (Admin) sessionFactory.getCurrentSession().get(Admin.class,
				AdminId);
		Transaction t = find(transaction.getId());
		if (a != null && t != null) {
			t.setAdmin_id(AdminId);
			sessionFactory.getCurrentSession().merge(t);
		} else {
			throw new TransactionException("no such transaction or admin");
		}
	}

	@Override
	public void setReturnDate(Transaction transaction)
			throws TransactionException {
		try {
			Transaction t = find(transaction.getId());
			if (t != null) {
				t.setReturn_date(new Date());
				sessionFactory.getCurrentSession().merge(t);
			} else {
				throw new TransactionException("no such transaction");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteByVideoId(int videoId) {
		sessionFactory.getCurrentSession().createQuery("delete from Transaction where video_id= :video_id ").setParameter("video_id", videoId).executeUpdate();
	}

	@Override
	public void deleteByCustomerId(int customerId) {
		sessionFactory.getCurrentSession().createQuery("delete from Transaction where customer_id= :customer_id ").setParameter("customer_id", customerId).executeUpdate();
	}

}
