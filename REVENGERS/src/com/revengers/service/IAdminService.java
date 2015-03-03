package com.revengers.service;

import java.util.List;

import com.revengers.beans.Admin;
import com.revengers.beans.model.AdminLogin;

public interface IAdminService {

	public void save(Admin admin);
	public void delete(int id);
	public List<Admin> list();
	public Admin getAdminById(int id);
	public Admin find(int id);
	public void update(Admin admin); 
	public Admin getAdminByUsername(String username);
	public Admin getAdminByUsernameAndPassword(String username, String password);
	public AdminLogin loginStatus(String username, String password);
	public void changePassword(Admin admin, String password);
	public void changePassword(int adminId, String password);
}
