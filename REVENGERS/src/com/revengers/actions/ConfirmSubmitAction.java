package com.revengers.actions;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.revengers.beans.Customer;
import com.revengers.beans.Transaction;
import com.revengers.beans.Video;
import com.revengers.service.ITransactionService;
import com.revengers.service.IVideoService;
import com.revengers.service.impl.TransactionService;
import com.revengers.service.impl.VideoService;

public class ConfirmSubmitAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ITransactionService ts;
	private IVideoService vs;
	private List<Video> chosenVideos=null;
	private Customer c;
	private List<Transaction> trans;
	private Map<String, Object> session;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String execute(){
		ts=new TransactionService();
		vs=new VideoService();
		trans=new ArrayList<Transaction>();
		chosenVideos=(ArrayList<Video>)session.get("chosenVideos");
		c=(Customer)session.get("customer");
		
		if(chosenVideos !=null){
			Transaction t;
			Video v;
			for(int i=0;i<chosenVideos.size();i++){
				t=new Transaction();
				t.setCustomer(c);
				t.setVideo(chosenVideos.get(i));
				
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				cal.add(Calendar.DATE, 4);
				t.setDue_date(cal.getTime());
				
				
				ts.save(t);
				trans.add(t);
				
				v=chosenVideos.get(i);
				v.setStock(v.getStock()-1);
				vs.update(v);
			}
			
			session.put("transactions", trans);
			
			ActionContext ac = ActionContext.getContext();
			Map session = ac.getSession();
			session.remove("chosenVideos");
		}
		
		
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

}
