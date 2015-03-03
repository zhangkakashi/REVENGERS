package com.revengers.actions;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.revengers.beans.Video;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.revengers.service.IVideoService;
import com.revengers.service.impl.VideoService;

public class SingleVideoBrowseAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	private IVideoService vs;
	private int focusVideo;
	private List<Video> chosenVideos=null;
	
	public String execute(){
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String add(){
		vs=new VideoService();
		if(session.get("chosenVideos")==null){
			chosenVideos=new ArrayList<Video>();
			chosenVideos.add(vs.getVideoById(focusVideo));
			session.put("chosenVideos", chosenVideos);
		}else{
			chosenVideos=(ArrayList<Video>)session.get("chosenVideos");
			boolean exist=false;
			for(int i=0;i<chosenVideos.size();i++){
				if(chosenVideos.get(i).getId()==focusVideo)
					exist=true;
			}
			if(!exist){
				chosenVideos.add(vs.getVideoById(focusVideo));
				session.put("chosenVideos", chosenVideos);
			}
		}
		
		return SUCCESS;
	}
	

	public int getFocusVideo() {
		return focusVideo;
	}

	public void setFocusVideo(int focusVideo) {
		this.focusVideo = focusVideo;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	
	
	
}
