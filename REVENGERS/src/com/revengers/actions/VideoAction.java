package com.revengers.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.revengers.beans.Video;
import com.revengers.service.IVideoService;
import com.revengers.service.impl.VideoService;

public class VideoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int videoId;
	private Video video;
	
	

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	
	
	IVideoService vs;
	
	public String execute(){
		vs = new VideoService();
		video = vs.find(videoId);
		return SUCCESS;
	}
}
