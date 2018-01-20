package com.fustack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fustack.dao.EventsDao;
import com.fustack.po.Events;

@Service
public class EventsServiceImpl implements EventsService {

	@Autowired
	private EventsDao dao;
	
	public long addEvents(Events bean) {
		// TODO Auto-generated method stub
		return dao.addEvents(bean);
	}
	
	public void deleteEvents(Events bean) {
		dao.deleteEvents(bean);
	}
	
	public void updateEvents(Events bean) {
		dao.updateEvents(bean);
	}

	public Events getEvents(Events bean) {
		return dao.getEvents(bean);
	}
	
	public List getEventsList(Events bean) {
		return dao.getEventsList(bean);
	}
	
	public int getCount(Events bean) {
		return dao.getCount(bean);
	}
	
	public List getEventsListBypage(Events bean,int type,int startnumber) {
		return dao.getEventsListBypage(bean, type, startnumber);
	}

	
	public int getPages(int count,int perpage_count) {
		
		int mod = count % perpage_count;
		int pages = 0;
		if(mod > 0) {
			pages = count / perpage_count + 1;
		}else {
			pages = count / perpage_count;
		}
				
				
		return pages;
	}
}
