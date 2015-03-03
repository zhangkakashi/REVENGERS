package com.revengers.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revengers.beans.Transaction;
import com.revengers.beans.Video;
import com.revengers.dao.ITransactionDAO;
import com.revengers.dao.IVideoDAO;
import com.revengers.dao.IVideoDAO.VideoException;
import com.revengers.service.IVideoService;

public class VideoService implements IVideoService {

	private static IVideoDAO videoDAO;
	private static ITransactionDAO transactionDAO;

	static {
		@SuppressWarnings("resource")
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		videoDAO = (IVideoDAO) act.getBean("videoDAO");
		transactionDAO = (ITransactionDAO) act.getBean("transactionDAO");
	}

	@Override
	public void save(Video video) {
		Video v = video;
		try {
			videoDAO.save(v);
		} catch (VideoException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Video video) {
		try {
			Video v = videoDAO.getVideoById(video.getId());
			transactionDAO.deleteByVideoId(video.getId());
			videoDAO.delete(v);
		} catch (VideoException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int videoId) {
		try {
			Video v = videoDAO.getVideoById(videoId);
			transactionDAO.deleteByVideoId(videoId);
			videoDAO.delete(v);
		} catch (VideoException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Video video) {
		try {
			videoDAO.update(video);
		} catch (VideoException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Video find(int id) {
		Video v = new Video();
		try {
			v = videoDAO.find(id);
		} catch (VideoException e) {
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public Video getVideoById(int id) {
		Video v = new Video();
		try {
			v = videoDAO.find(id);
		} catch (VideoException e) {
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public List<Video> list() {
		List<Video> list = null;
		list = videoDAO.list();
		return list;
	}

	@Override
	public List<Video> titleLikeList(String title) {
		List<Video> list = null;
		if (title != null && !title.trim().equals("")) {
			list = videoDAO.titleLikeList(title);
		}
		return list;
	}

	@Override
	public List<Video> actorLikeList(String actor) {
		List<Video> list = null;
		if (actor != null && !actor.trim().equals("")) {
			list = videoDAO.actorLikeList(actor);
		}
		return list;
	}

	@Override
	public List<Video> formatList(String format) {
		List<Video> list = null;
		if (format != null && !format.trim().equals("")) {
			list = videoDAO.formatList(format);
		}
		return list;
	}

	@Override
	public List<Video> availableList(){
		List<Video> list=null;
		list=videoDAO.availableList();
		return list;
	}
	
	@Override
	public void changePriority(Video video, int priority) {
		try {
			video.setPriority(priority);
			videoDAO.update(video);
		} catch (VideoException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void changePriority(int videoId, int priority) {
		try {
			Video v = videoDAO.find(videoId);
			v.setPriority(priority);
			videoDAO.update(v);
		} catch (VideoException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Transaction> getTransactionsList(Video video) {
		Set<Transaction> transactionSet = video.getTransactions();
		List<Transaction> transactionList = new ArrayList<Transaction>();
		for (Transaction t : transactionSet) {
			transactionList.add(t);
		}
		return transactionList;
	}

	@Override
	public List<Transaction> getTransactionsList(int videoId) {
		Video video = new Video();
		try {
			video = videoDAO.find(videoId);
		} catch (VideoException e) {
			e.printStackTrace();
		}
		Set<Transaction> transactionSet = video.getTransactions();
		List<Transaction> transactionList = new ArrayList<Transaction>();
		for (Transaction t : transactionSet) {
			transactionList.add(t);
		}
		return transactionList;
	}

	@Override
	public Set<Transaction> getTransactionsSet(Video video) {
		return video.getTransactions();
	}

	@Override
	public Set<Transaction> getTransactionsSet(int videoId) {
		Video video = new Video();
		try {
			video = videoDAO.find(videoId);
		} catch (VideoException e) {
			e.printStackTrace();
		}
		return video.getTransactions();
	}

	@Override
	public List<Video> priorityList(int priority) {
		List<Video> list = null;
		list = videoDAO.priorityList(priority);
		return list;
	}

}
