package com.revengers.service;

import java.util.List;
import java.util.Set;

import com.revengers.beans.Transaction;
import com.revengers.beans.Video;

public interface IVideoService {

	public void save(Video video);
	public void delete(Video video);
	public void delete(int videoId);
	public void update(Video video);
	public Video find(int id);
	public Video getVideoById(int id);
	public List<Video> list();
	public List<Video> titleLikeList(String title);
	public List<Video> actorLikeList(String actor);
	public List<Video> formatList(String format);
	public List<Video> availableList();
	public List<Video> priorityList(int priority);
	public void changePriority(Video video, int priority);
	public void changePriority(int videoId, int priority);
	public List<Transaction> getTransactionsList(Video video);
	public List<Transaction> getTransactionsList(int videoId);
	public Set<Transaction> getTransactionsSet(Video video);
	public Set<Transaction> getTransactionsSet(int videoId);
}
