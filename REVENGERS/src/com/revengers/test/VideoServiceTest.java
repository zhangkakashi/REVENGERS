package com.revengers.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revengers.beans.Video;
import com.revengers.service.IVideoService;
import com.revengers.service.impl.VideoService;

public class VideoServiceTest {

	private static IVideoService vs;
	@BeforeClass
	public static void setUoBeforeClass() throws Exception {
		vs = new VideoService();
		
	}
	
	@Test
	public void save(){
		Video v = new Video();
		v.setTitle("Lord of the Rings");
		v.setActor("Olando");
		v.setDirector("Peter Jackson");
		v.setLanguage("English");
		v.setAddress("in the folder");
		vs.save(v);
	}
	
	@Test
	public void saveMany(){
		for(int i=1;i<20;i++){
				Video v = new Video();
				v.setActor("actor NO." + i);
				v.setAddress("address NO." + i);
				v.setCategory("category NO." + i);
				v.setDescription("description NO." + i);
				v.setDirector("director NO." + i);
				v.setFormat("format" + i);
				v.setLanguage("language NO." + i);
				v.setLength("length NO." + i);
				v.setStock(10);
				v.setTitle("title NO." + i);
				v.setYear(2000);
				//v.setAddress("address " + i);
				vs.save(v);
			
		}
	}
	
	@Test
	public void list(){
		List<Video> list = vs.list();
		for(Video v:list){
			System.out.println(v.getTitle());
		}
	}
	
	/**
	 * 
	 */
	@Test
	public void priorityList(){
		List<Video> list = vs.priorityList(1);
		for(Video v:list){
			System.out.println(v.getTitle());
		}
	}
	
	@Test
	public void delete(){
		vs.delete(vs.find(7));
	}
	
	@Test 
	public void update(){
		Video v = vs.find(1);
		v.setDescription("The Lord of the Rings is a film series consisting of three epic fantasy adventure films directed by Peter Jackson. They are based on the novel The Lord of the Rings by J. R. R. Tolkien. The films are subtitled The Fellowship of the Ring (2001), The Two Towers (2002) and The Return of the King (2003). They were distributed by New Line Cinema."
				+ "</br>" + "Considered to be one of the biggest and most ambitious film projects ever undertaken, with an overall budget of $280 million, the entire project took eight years, with the filming for all three films done simultaneously and entirely in New Zealand, Jackson's native country.[2] Each film in the series also had special extended editions released on DVD a year after their respective theatrical releases. While the films follow the book's general storyline, they do omit some of the novel's plot elements and include some additions to and deviations from the source material."
				+ "</br>" + "Set in the fictional world of Middle-earth, the films follow the hobbit Frodo Baggins (Elijah Wood) as he and a Fellowship embark on a quest to destroy the One Ring, and thus ensure the destruction of its maker, the Dark Lord Sauron. The Fellowship becomes divided and Frodo continues the quest together with his loyal companion Sam (Sean Astin) and the treacherous Gollum (Andy Serkis). Meanwhile, Aragorn (Viggo Mortensen), heir in exile to the throne of Gondor, and the wizard Gandalf (Ian McKellen) unite and rally the Free Peoples of Middle-earth in the War of the Ring.");
		vs.update(v);
	}
}
