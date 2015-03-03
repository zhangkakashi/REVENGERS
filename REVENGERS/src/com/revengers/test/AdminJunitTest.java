package com.revengers.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revengers.beans.Admin;
import com.revengers.beans.Gender;
import com.revengers.dao.IAdminDAO;
import com.revengers.dao.IAdminDAO.AdminException;
import com.revengers.md5.MD5;

public class AdminJunitTest {

	MD5 md5 = new MD5();
	private static IAdminDAO AdminDAO;
	
	@BeforeClass
	public static void setUoBeforeClass() throws Exception {
		try{
			@SuppressWarnings("resource")
			ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
			AdminDAO = (IAdminDAO) act.getBean("adminDAO");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void AdminDAOSave(){
		for(int i=1;i<10;i++){
			Admin c = new Admin();
			c.setUsername("admin3 NO." + i);
			c.setPassword(MD5.encode("admin3 NO." + i));
			c.setGender(Gender.MALE);
			c.setAddress("admin3 Address NO." + i);
			c.setPhone("123 NO." + i);
			c.setEmail("admin3@123.com");
			c.setName("admin3");
			try {
				AdminDAO.save(c);
			} catch (AdminException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Test
	public void AdminDAOList(){
		try {
			List<Admin> list = AdminDAO.list();
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i).getPassword());
			}
		} catch (AdminException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void AdminDAODelete(){
		try {
			Admin c = AdminDAO.find(1);
			AdminDAO.delete(c);
			List<Admin> list = AdminDAO.list();
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i).getPassword());
			}
		} catch (AdminException e) {
			e.printStackTrace();
		}
		
		//AdminDAO
		
	}
	
	@Test
	public void AdminDAOUpdate(){
		try {
			Admin a = AdminDAO.find(2);
			a.setPhone("1000");
			a.setAddress("admin2 adress");
			AdminDAO.update(a);
		}catch (AdminException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void AdminDAOgetAdminByUsername(){
		try {
			Admin c = AdminDAO.getAdminByUsername("admin2");
			System.out.println(c.getPassword());
		} catch (AdminException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void AdminDAOgetAdminByUsernameAndPassword(){
		try {
			Admin c = AdminDAO.getAdminByUsernameAndPassword("admin2", MD5.encode("admin2"));
			System.out.println(c.getPassword());
		} catch (AdminException e) {
			System.out.println("no such user");
		}
	}
}
