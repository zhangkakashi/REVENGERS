package com.revengers.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.revengers.beans.Video;
import com.revengers.service.IVideoService;
import com.revengers.service.impl.VideoService;

public class VideoBrowserAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IVideoService vs;
	private List<Video> videos=new ArrayList<Video>();
	private Map<String, Object> session;
	
	public String execute(){
		vs=new VideoService();
		videos=vs.availableList();
		
		session.put("videos", videos);
		
		return SUCCESS;
	}
	

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
	

}
