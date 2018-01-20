package com.fustack.service;

import java.util.List;

import com.fustack.po.Events;

public interface EventsService {
	
	public long addEvents(Events bean);
	
	public void deleteEvents(Events bean);
	
	public void updateEvents(Events bean);
	
	public Events getEvents(Events bean);
	
	public List getEventsList(Events bean);
	
	public int getCount(Events bean);
	
	public int getPages(int count,int perpage_count);
	
	public List getEventsListBypage(Events bean,int type,int startnumber);
	
}
