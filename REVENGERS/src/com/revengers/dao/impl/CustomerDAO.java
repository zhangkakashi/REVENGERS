package com.revengers.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revengers.beans.Customer;
import com.revengers.dao.ICustomerDAO;

@Service
@Transactional
public class CustomerDAO implements ICustomerDAO {

	@Resource//(name="sessionFactory")
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public void save(Customer customer) throws CustomerException {
		//Customer c = getCustomerByUsername(customer.getUsername());
		List<Customer> list = sessionFactory.getCurrentSession().createQuery("from Customer where username='"+customer.getUsername()+"'").list();
		if(list.size()==0){
		sessionFactory.getCurrentSession().save(customer);
		}else{
			throw new CustomerException("Customer already exist with username=" + customer.getUsername());
		}

	}

	@Override
	public void delete(Customer customer) throws CustomerException {
		try{
			sessionFactory.getCurrentSession().delete(customer);
		}catch(Exception e){
			throw new CustomerException(e.toString());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> list() throws CustomerException {
		return sessionFactory.getCurrentSession().createQuery("from Customer").list();

	}

	@Override
	public Customer getCustomerById(int id) throws CustomerException {
		try{
			Customer c = (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
			if(c != null){
				return c;
			}else{
				throw new CustomerException("no such customer");
			}
		}catch(Exception e){
			throw new CustomerException("no such customer");
		}
	}
	
	@Override
	public Customer find(int id) throws CustomerException {
		try{
			Customer c = (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
			if(c != null){
				return c;
			}else{
				throw new CustomerException("no such customer");
			}
		}catch(Exception e){
			throw new CustomerException("no such customer");
		}
	}

	@Override
	public void update(Customer customer) throws CustomerException {
		try{
			sessionFactory.getCurrentSession().merge(customer);
		}catch(Exception e){
			throw new CustomerException("no such customer");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Customer getCustomerByUsername(String username) throws CustomerException {
		List<Customer> list = sessionFactory.getCurrentSession().createQuery("from Customer where username='"+username+"'").list();
		if(list.size()<1){
			throw new CustomerException("Customer not found: username=" + username); 
		}
		else if(list.size()>1){
			throw new CustomerException("duplicate username"); 
		}
		else{
			return list.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Customer getCustomerByUsernameAndPassword(String username, String password) throws CustomerException {
		List<Customer> list = sessionFactory.getCurrentSession().createQuery("from Customer where username='"+username+"' and password='" + password  + "'").list();
		if(list.size()<1){
			throw new CustomerException("Customer not found: username=" + username + "  password=" + password); 
		}
		else if(list.size()>1){
			throw new CustomerException("duplicate username"); 
		}
		else{
			return list.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> likeList(String name) throws CustomerException {
		List<Customer> list = sessionFactory.getCurrentSession().createQuery("from Customer where name like '%" + name + "%'").list();
	    return  list;
	}

	

}
