package com.revengers.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revengers.beans.Video;
import com.revengers.dao.IVideoDAO;
import com.revengers.dao.IVideoDAO.VideoException;
import com.revengers.md5.MD5;

public class VideoJunitTest {

	MD5 md5 = new MD5();
	private static IVideoDAO videoDAO;
	
	@BeforeClass
	public static void setUoBeforeClass() throws Exception {
		try{
			@SuppressWarnings("resource")
			ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
			videoDAO = (IVideoDAO) act.getBean("videoDAO");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void videoSave(){
		
		for(int i=1;i<20;i++){
			try {
				Video v = new Video();
				v.setActor("actor NO." + i);
				v.setAddress("address NO." + i);
				v.setCategory("category NO." + i);
				v.setDescription("description NO." + i);
				v.setDirector("director NO." + i);
				v.setFormat("format NO." + i);
				v.setLanguage("language NO." + i);
				v.setLength("length NO." + i);
				v.setStock(10);
				v.setTitle("title NO." + i);
				v.setYear(2000);
				videoDAO.save(v);
			} catch (VideoException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Test
	public void videoFind(){
		try {
			Video v = videoDAO.getVideoById(3);
			System.out.println(v.getTitle() + " " + v.getActor());
			//return v;
		} catch (VideoException e) {
			e.printStackTrace();
			//return null;
		}
	}
	
	@Test
	public void videoDelete(){
		
		try {
			Video v = videoDAO.getVideoById(2);
			v.setId(100);
			videoDAO.delete(v);
		} catch (VideoException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void videoList(){
		List<Video> list = videoDAO.list();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getId() + " " + list.get(i).getTitle());
		}
	}
	
	@Test
	public void videoTitle(){
		List<Video> list = videoDAO.titleLikeList("o");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getId() + " " + list.get(i).getTitle());
		}
	}
}
