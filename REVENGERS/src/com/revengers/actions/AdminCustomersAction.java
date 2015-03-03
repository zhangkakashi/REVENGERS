package com.revengers.actions;

import java.io.InputStream;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.revengers.md5.MD5;
import com.revengers.service.ICustomerService;
import com.revengers.service.impl.CustomerService;
import com.revengers.beans.Customer;
import com.revengers.beans.Gender;

public class AdminCustomersAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ICustomerService cs;
	private List<Customer> customers;

	private String username;
	private String password;
	private String gender;
	private String name;
	private String age;
	private String address;
	private String phone;
	private String email;
	private String credit_card;
	private String priority;
	private String id;
	
	
	//private int[] indexes;
	

	
	public InputStream getInputStream() throws Exception{
		cs=new CustomerService();
		customers=cs.list();
		
		if(id !=null){
			Customer c=cs.getCustomerById(Integer.parseInt(id));
			c.setUsername(username);
			
			if(!password.equals("type new password here"))
				c.setPassword(MD5.encode(password));
			
			if(gender.equals("MALE"))
				c.setGender(Gender.MALE);
			else c.setGender(Gender.FEMALE);
			c.setName(name);
			c.setAge(Integer.parseInt(age));
			c.setAddress(address);
			c.setPhone(phone);
			c.setEmail(email);
			c.setCredit_card(credit_card);
			c.setPriority(Integer.parseInt(priority));
			
			
			cs.update(c);
		}
		
//		String result = "OK";
//		result = new String(result.getBytes("UTF-8"));
		return null;
	}
	
	
	public String execute(){
		cs=new CustomerService();
		customers=cs.list();
		
		/*if(index != null){
			String[] indexesString=index.split(",");
			indexes=new int[indexesString.length];
			
			if(indexesString[0].length()!=0){
				for(int i=0;i<indexesString.length;i++){
					indexes[i]=Integer.parseInt(indexesString[i]);
				}
			}
		}
		
		
		System.out.println(index);
		System.out.println(username);*/
		
		return SUCCESS;
	}


	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCredit_card() {
		return credit_card;
	}


	public void setCredit_card(String credit_card) {
		this.credit_card = credit_card;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}


	
	
}
