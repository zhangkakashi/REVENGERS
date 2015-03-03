package com.revengers.test;

import com.revengers.beans.Video;
import com.revengers.service.impl.VideoService;

public class Test {

	/**
	 * @param args
	 */
	
	//private static ICustomerDAO customerDAO;
	//private static IVideoDAO videoDAO;
	//private static ITransactionDAO transactionDAO;
	
	public static void main(String[] args) {
		//MD5 md5 = new MD5();
		
		/*IVideoDAO videoDAO = null;
		
		
		try{
			@SuppressWarnings("resource")
			ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
			videoDAO = (IVideoDAO) act.getBean("videoDAO");
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			Video v = videoDAO.getVideoById(5);
			System.out.println(v.getTitle() + " " + v.getActor());
		} catch (VideoException e) {
			e.printStackTrace();
		}
		*/
		
		
		/*try {
			@SuppressWarnings("resource")
			ApplicationContext act = new ClassPathXmlApplicationContext(
					"beans.xml");
			transactionDAO = (ITransactionDAO) act.getBean("transactionDAO");
			
			Customer c = customerDAO.find(5);
			Video v = videoDAO.find(4);
			Transaction t = new Transaction();
			t.setCustomer(c);
			t.setVideo(v);
			t.setDue_date(new Date());
			t.setRent_date(new Date());
			transactionDAO.save(t);
			
			Transaction t = transactionDAO.find(1);
			System.out.println(t.getAdmin_id() +  " " + t.getCustomer().getId() + " " + 
			t.getRent_date() + " " + t.getDue_date() + " " + t.getReturn_date());
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*ICustomerDAO customerDAO = null;
		
		
			try{
				@SuppressWarnings("resource")
				ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
				customerDAO = (ICustomerDAO) act.getBean("customerDAO");
			}catch(Exception e){
				e.printStackTrace();
			}
			
		
		
		
			Customer c = new Customer();
			c.setUsername("123");
			System.out.println(md5.encode("123"));
			c.setPassword(md5.encode("123"));
			c.setGender(Gender.MALE);
			c.setAddress("123");
			c.setAge(1);
			c.setCredit_card("123");
			c.setPhone("123");
			c.setEmail("123@123.com");
			c.setName("123");
			try {
				customerDAO.save(c);
			} catch (CustomerException e) {
				e.printStackTrace();
			}*/
		
		
		/*Customer c = new Customer();
		c.setUsername("Tony");
		System.out.println(md5.encode("Stark"));
		c.setPassword(md5.encode("123"));
		c.setGender(Gender.MALE);
		c.setAddress("123");
		c.setAge(1);
		c.setCredit_card("123");
		c.setPhone("123");
		c.setEmail("123@123.com");
		c.setName("123");

		CustomerService cs = new CustomerService();
		cs.save(c);*/
		//CustomerService cs = new CustomerService();
		VideoService vs = new VideoService();
		//cs.delete(5);
		//System.out.println(cs.list().get(0).getUsername());
		//CustomerLogin cl = cs.loginStatus("hello1", "1231");
		//System.out.println(cl.isLogin());
		
		Video v = new Video();
		v.setTitle("Lord of the Rings");
		v.setActor("Olando");
		v.setDirector("Peter Jackson");
		v.setLanguage("English");
		v.setAddress("/user");
		vs.save(v);
	}

}
