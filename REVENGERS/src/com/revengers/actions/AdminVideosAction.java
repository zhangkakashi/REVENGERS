package com.revengers.actions;

import java.io.InputStream;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.revengers.beans.Video;
import com.revengers.service.IVideoService;
import com.revengers.service.impl.VideoService;

public class AdminVideosAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IVideoService vs;
	private List<Video> videos;

	private String id;
	private String title;
	private String director;
	private String actor;
	private String year;
	private String stock;
	private String address;
	private String length;
	private String description;
	private String language;
	private String priority;
	private String category;
	private String format;
	

	
	public InputStream getInputStream() throws Exception{
		vs=new VideoService();
		//videos=vs.list();
		
		if(id !=null){
			Video v=vs.getVideoById(Integer.parseInt(id));
			v.setTitle(title);
			v.setDirector(director);
			v.setActor(actor);
			v.setYear(Integer.parseInt(year));
			v.setStock(Integer.parseInt(stock));
			v.setAddress(address);
			v.setLength(length);
			v.setDescription(description);
			v.setLanguage(language);
			v.setPriority(Integer.parseInt(priority));
			v.setCategory(category);
			v.setFormat(format);
			
			vs.update(v);
		}
		
		
		return null;
	}
	
	public String addVideo(){
		vs=new VideoService();
		Video v = new Video();
			v.setTitle(title);
			v.setDirector(director);
			v.setActor(actor);
			v.setYear(Integer.parseInt(year));
			v.setStock(Integer.parseInt(stock));
			v.setAddress(address);
			v.setLength(length);
			v.setDescription(description);
			v.setLanguage(language);
			v.setPriority(Integer.parseInt(priority));
			v.setCategory(category);
			v.setFormat(format);
			
			vs.save(v);
		
		return SUCCESS;
	}
	
	
	public String execute(){
		vs=new VideoService();
		videos=vs.list();
		
		return SUCCESS;
	}


	public List<Video> getVideos() {
		return videos;
	}


	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getActor() {
		return actor;
	}


	public void setActor(String actor) {
		this.actor = actor;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getStock() {
		return stock;
	}


	public void setStock(String stock) {
		this.stock = stock;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getLength() {
		return length;
	}


	public void setLength(String length) {
		this.length = length;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getFormat() {
		return format;
	}


	public void setFormat(String format) {
		this.format = format;
	}

	
	
}
