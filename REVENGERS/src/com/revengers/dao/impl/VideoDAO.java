package com.revengers.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revengers.beans.Video;
import com.revengers.dao.IVideoDAO;


@Service
@Transactional
public class VideoDAO implements IVideoDAO {

	@Resource//(name="sessionFactory")
	SessionFactory sessionFactory;
	
	@Override
	public void save(Video video) throws VideoException {
		try{	
			sessionFactory.getCurrentSession().save(video);
		}catch(Exception e){
			throw new VideoException("can not save video ");
		}
	}

	@Override
	public void delete(Video video) throws VideoException {
		try{
			sessionFactory.getCurrentSession().delete(video);
		}catch(Exception e){
			throw new VideoException("no such video");
		}
	}

	@Override
	public void update(Video video) throws VideoException {
		try{
			sessionFactory.getCurrentSession().merge(video);
		}catch(Exception e){
			throw new VideoException("no such video");
		}
	}

	@Override
	public Video find(int id) throws VideoException {
		try{
			Video v = (Video) sessionFactory.getCurrentSession().get(Video.class, id);
			if(v!=null){
				return v;
			}else{
				throw new VideoException("no such video");
			}
		}catch(Exception e){
			throw new VideoException("no such video");
		}
	}
	
	@Override
	public Video getVideoById(int id) throws VideoException {
		try{
			Video v = (Video) sessionFactory.getCurrentSession().get(Video.class, id);
			if(v!=null){
				return v;
			}else{
				throw new VideoException("no such video");
			}
		}catch(Exception e){
			throw new VideoException("no such video");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> list() {
		return sessionFactory.getCurrentSession().createQuery("from Video").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> titleLikeList(String title) {
		return sessionFactory.getCurrentSession().createQuery("from Video where title like '%" + title + "%'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> actorLikeList(String actor) {
		return sessionFactory.getCurrentSession().createQuery("from Video where actor like '%" + actor + "%'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> formatList(String format) {
		return sessionFactory.getCurrentSession().createQuery("from Video where format='" + format + "'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> availableList(){
		return sessionFactory.getCurrentSession().createQuery("from Video where stock>0").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> priorityList(int priority) {
		return sessionFactory.getCurrentSession().createQuery("from Video where priority<" + (priority+1)).list();
	}
}
