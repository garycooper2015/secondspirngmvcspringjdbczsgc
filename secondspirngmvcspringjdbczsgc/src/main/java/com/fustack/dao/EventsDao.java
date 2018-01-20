package com.fustack.dao;

import java.util.List;

import com.fustack.po.Events;

public interface EventsDao {
	
	public long addEvents(Events bean);
	
	public void deleteEvents(Events bean);
	
	public void updateEvents(Events bean);
	
	public Events getEvents(Events bean);
	
	public List getEventsList(Events bean);
	
	public List getEventsListBypage(Events bean,int type,int startnumber);
	
	public int getCount(Events bean);

}
