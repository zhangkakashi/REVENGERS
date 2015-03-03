package com.revengers.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revengers.beans.Admin;
import com.revengers.beans.model.AdminLogin;
import com.revengers.dao.IAdminDAO;
import com.revengers.dao.IAdminDAO.AdminException;
import com.revengers.md5.MD5;
import com.revengers.service.IAdminService;

public class AdminService implements IAdminService {

	private static IAdminDAO adminDAO;
	
	static{
		@SuppressWarnings("resource")
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		adminDAO = (IAdminDAO) act.getBean("adminDAO");
	}
	
	@Override
	public void save(Admin admin) {
		Admin c = admin;
		c.setPassword(MD5.encode(admin.getPassword()));
		try {
			adminDAO.save(c);
		} catch (AdminException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			Admin admin = adminDAO.find(id);
			adminDAO.delete(admin);
		} catch (AdminException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Admin> list() {
		List<Admin> list = null;
		try {
			list = adminDAO.list();
		} catch (AdminException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Admin getAdminById(int id) {
		Admin c = new Admin();
		try {
			c = adminDAO.getAdminById(id);
		} catch (AdminException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Admin find(int id) {
		Admin c = new Admin();
		try {
			c = adminDAO.find(id);
		} catch (AdminException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void update(Admin admin) {
		try {
			adminDAO.update(admin);
		} catch (AdminException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Admin getAdminByUsername(String username) {
		Admin c = new Admin();
		try {
			c = adminDAO.getAdminByUsername(username);
		} catch (AdminException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Admin getAdminByUsernameAndPassword(String username,
			String password) {
		Admin c = new Admin();
		try {
			adminDAO.getAdminByUsernameAndPassword(username, password);
		} catch (AdminException e) {
			e.printStackTrace();
		}
		return c;
	}


	@Override
	public AdminLogin loginStatus(String username, String password) {
		AdminLogin cl = new AdminLogin();
		try {
			cl.setAdmin(adminDAO.getAdminByUsernameAndPassword(username, MD5.encode(password)));
			cl.setLogin(true);
		} catch (AdminException e) {
			System.out.println(e.toString());
			cl.setAdmin(null);
			cl.setLogin(false);
		}
		return cl;
	}

	@Override
	public void changePassword(Admin admin, String password) {
		try {
			admin.setPassword(password);
			adminDAO.update(admin);
		} catch (AdminException e) {
			System.out.println(e.toString() + ", change Admin password failed");
		}
	}

	@Override
	public void changePassword(int id, String password) {
		try {
			Admin a = adminDAO.find(id);
			a.setPassword(MD5.encode(password));
			adminDAO.update(a);
		} catch (AdminException e) {
			System.out.println(e.toString() + ", change Admin password failed");
		}
	}

}
