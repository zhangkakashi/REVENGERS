package com.revengers.actions;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.revengers.beans.Transaction;
import com.revengers.service.ICustomerService;
import com.revengers.service.ITransactionService;
import com.revengers.service.IVideoService;
import com.revengers.service.impl.CustomerService;
import com.revengers.service.impl.TransactionService;
import com.revengers.service.impl.VideoService;

public class AdminTransactionsAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ITransactionService ts;
	private ICustomerService cs;
	private IVideoService vs;
	private List<Transaction> transactions;

	private String id;
	private Date rent_date;
	private Date due_date;
	private Date return_date;
	private String customer_id;
	private String video_id;
	private String admin_id;
	

	
	public InputStream getInputStream() throws Exception{
		ts=new TransactionService();
		cs=new CustomerService();
		vs=new VideoService();
		transactions=ts.list();
		
		if(id !=null){
			Transaction t=ts.find(Integer.parseInt(id));

			t.setRent_date(rent_date);
			t.setDue_date(due_date);
			t.setReturn_date(return_date);
			t.setAdmin_id(Integer.parseInt(admin_id));
			t.setCustomer(cs.getCustomerById(Integer.parseInt(customer_id)));
			t.setVideo(vs.getVideoById(Integer.parseInt(video_id)));
			
			ts.update(t);
		}
		
		return null;
	}
	
	
	public String execute(){
		ts=new TransactionService();
		transactions=ts.list();
		
		return SUCCESS;
	}


	public List<Transaction> getTransactions() {
		return transactions;
	}


	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getRent_date() {
		return rent_date;
	}


	public void setRent_date(Date rent_date) {
		this.rent_date = rent_date;
	}


	public Date getDue_date() {
		return due_date;
	}


	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}


	public Date getReturn_date() {
		return return_date;
	}


	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}


	public String getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}


	public String getVideo_id() {
		return video_id;
	}


	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}


	public String getAdmin_id() {
		return admin_id;
	}


	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	
}
