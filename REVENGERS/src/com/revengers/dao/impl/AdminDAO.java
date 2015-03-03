package com.revengers.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revengers.beans.Admin;
import com.revengers.dao.IAdminDAO;

@Service
@Transactional
public class AdminDAO implements IAdminDAO {

	@Resource//(name="sessionFactory")
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public void save(Admin admin) throws AdminException {
		//Admin c = getAdminByUsername(Admin.getUsername());
		List<Admin> list = sessionFactory.getCurrentSession().createQuery("from Admin where username='"+admin.getUsername()+"'").list();
		if(list.size()==0){
		sessionFactory.getCurrentSession().save(admin);
		}else{
			throw new AdminException("Admin already exist with username=" + admin.getUsername());
		}

	}

	@Override
	public void delete(Admin admin) throws AdminException {
		try{
			sessionFactory.getCurrentSession().delete(admin);
		}catch(Exception e){
			throw new AdminException("no such admin");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> list() throws AdminException {
		return sessionFactory.getCurrentSession().createQuery("from Admin").list();

	}

	@Override
	public Admin getAdminById(int id) throws AdminException {
		try{
			Admin a = (Admin) sessionFactory.getCurrentSession().get(Admin.class, id);
			if(a!=null){
				return a;
			}else{
				throw new AdminException("no such Admin");
			} 
		}catch(Exception e){
			throw new AdminException("no such Admin");
		}
	}
	
	@Override
	public Admin find(int id) throws AdminException {
		try{
			Admin a = (Admin) sessionFactory.getCurrentSession().get(Admin.class, id);
			if(a!=null){
				return a;
			}else{
				throw new AdminException("no such Admin");
			}
		}catch(Exception e){
			throw new AdminException("no such Admin");
		}
	}

	@Override
	public void update(Admin admin) throws AdminException {
		try{
			sessionFactory.getCurrentSession().merge(admin);
		}catch(Exception e){
			throw new AdminException("no such Admin");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Admin getAdminByUsername(String username) throws AdminException {
		List<Admin> list = sessionFactory.getCurrentSession().createQuery("from Admin where username='"+username+"'").list();
		if(list.size()<1){
			throw new AdminException("Admin not found: username=" + username); 
		}
		else if(list.size()>1){
			throw new AdminException("duplicate username"); 
		}
		else{
			return list.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Admin getAdminByUsernameAndPassword(String username, String password) throws AdminException {
		List<Admin> list = sessionFactory.getCurrentSession().createQuery("from Admin where username='"+username+"' and password='" + password  + "'").list();
		if(list.size()<1){
			throw new AdminException("Admin not found: username=" + username + "  password=" + password); 
		}
		else if(list.size()>1){
			throw new AdminException("duplicate username"); 
		}
		else{
			return list.get(0);
		}
	}

}
