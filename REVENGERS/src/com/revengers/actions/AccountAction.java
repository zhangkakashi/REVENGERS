package com.revengers.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.revengers.beans.Admin;
import com.revengers.beans.Customer;
import com.revengers.beans.Video;
import com.revengers.beans.model.AdminLogin;
import com.revengers.beans.model.CustomerLogin;
import com.revengers.service.IAdminService;
import com.revengers.service.ICustomerService;
import com.revengers.service.IVideoService;
import com.revengers.service.impl.AdminService;
import com.revengers.service.impl.CustomerService;
import com.revengers.service.impl.VideoService;

public class AccountAction extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1136441468897197406L;
	private String account;
	private String username;
	private String password;
	
	private IAdminService as;
	private ICustomerService cs;
	private IVideoService vs;
	Admin admin=null;
	Customer customer=null;
	List<Video> list = null;
	
	private Map<String,Object> session;
	
	public String execute(){
		System.out.println(account);
		
		if(account==null){
			return "error";
		}

		 if(account.equals("admin")){
			as=new AdminService();
			AdminLogin al = as.loginStatus(username, password);
			System.out.println(al.isLogin());
			if(al.isLogin()){
				System.out.println("al.isLogin()");
				session.put("admin", al.getAdmin());
				return "admin";
				}
			else{
				return "error";
			}
		}
		else if(account.equals("customer")){
			System.out.println(username);
			System.out.println(password);
			cs=new CustomerService();
			CustomerLogin cl=cs.loginStatus(username, password);
			System.out.println(cl.isLogin());
			if(cl.isLogin()){
				System.out.println("cl.isLogin()");
				vs = new VideoService();
				session.put("customer", cl.getCustomer());
				System.out.println(cl.getCustomer().getPriority());
				list = vs.priorityList(cl.getCustomer().getPriority());
				System.out.println(list.size());
				session.put("videos", list);
				return "customer";
			}
			else {
				return "error";
			}
		}
		else return "error";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

/*	public String getPassword() {
		return password;
	}*/

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

}
