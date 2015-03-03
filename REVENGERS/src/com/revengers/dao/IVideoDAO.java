package com.revengers.dao;

import java.util.List;

import com.revengers.beans.Video;

public interface IVideoDAO {

	public static class VideoException extends Exception{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public VideoException(String msg){
			super(msg);
		}
		
	}
	public void save(Video video) throws VideoException;
	public void delete(Video video) throws VideoException;
	public void update(Video video) throws VideoException;
	public Video find(int id) throws VideoException;
	public Video getVideoById(int id) throws VideoException;
	public List<Video> list();
	public List<Video> titleLikeList(String title);
	public List<Video> actorLikeList(String actor);
	public List<Video> formatList(String format);
	public List<Video> availableList();
	public List<Video> priorityList(int priority);
}
