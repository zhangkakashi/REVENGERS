package com.revengers.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revengers.beans.Admin;
import com.revengers.beans.model.AdminLogin;
import com.revengers.service.IAdminService;
import com.revengers.service.impl.AdminService;

public class AdminServiceTest {

	private static IAdminService as;
	@BeforeClass
	public static void setUoBeforeClass() throws Exception {
		as = new AdminService();
		
	}
	
	@Test
	public void save(){
		Admin a = new Admin();
		a.setUsername("1");
		a.setPassword("123");
		as.save(a);
	}
	
	@Test
	public void delete(){
		Admin a = as.find(10);
		as.delete(a.getId());
	}
	
	@Test
	public void update(){
		Admin a = as.find(11);
		a.setEmail("123@123.com");
		as.update(a);
	}
	
	@Test
	public void list(){
		List<Admin> list = as.list();
		for(Admin l:list){
			System.out.println(l.getUsername() + " " + l.getPassword() + " " + l.getEmail());
		}
	}
	
	@Test
	public void login(){
		AdminLogin al = as.loginStatus("nihao", "haha");
		System.out.println(al.getAdmin());
		System.out.println(al.isLogin());
	}
	
	@Test
	public void changePassword(){
		as.changePassword(12, "1234567890qwertyuiopasdfghjklzxcvbnm");
	}
}
