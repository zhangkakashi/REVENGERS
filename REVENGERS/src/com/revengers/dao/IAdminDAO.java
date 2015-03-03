package com.revengers.dao;

import java.util.List;

import com.revengers.beans.Admin;

public interface IAdminDAO {

	public static class AdminException extends Exception{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public AdminException(String msg){
			super(msg);
		}
		
	}
	public void save(Admin admin) throws AdminException;
	public void delete(Admin admin) throws AdminException;
	public List<Admin> list() throws AdminException;
	public Admin getAdminById(int id) throws AdminException;
	public Admin find(int id) throws AdminException;
	public void update(Admin admin) throws AdminException; 
	public Admin getAdminByUsername(String username) throws AdminException;
	public Admin getAdminByUsernameAndPassword(String username, String password)
			throws AdminException;
	

}
