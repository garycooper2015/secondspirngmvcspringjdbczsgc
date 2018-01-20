package com.fustack.po;

import java.util.Date;

public class Events {
    private Long event_id;

    private String title;
    private Date event_date;
	public Long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(Long event_id) {
		this.event_id = event_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getEvent_date() {
		return event_date;
	}
	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}


}
