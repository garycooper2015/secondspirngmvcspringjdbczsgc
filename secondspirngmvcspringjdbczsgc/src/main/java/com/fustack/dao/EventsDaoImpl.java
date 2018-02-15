package com.fustack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.fustack.po.Events;
import com.fustack.util.Constant;
import com.mysql.jdbc.StringUtils;


@Repository
public class EventsDaoImpl implements EventsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 添加并返id
	 */
	public long addEvents(Events bean) {
		// TODO Auto-generated method stub
		// this.jdbTemplate.update("",bean.getTitle());

		final String sql = "insert into events(event_date,title) values(now(),?)";
		final String s1 = bean.getTitle();

		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
				ps.setString(1,s1);
				return ps;
			}
		}, keyHolder);
		

		//System.out.println("ID = " + keyHolder.getKey().longValue());
		
		return keyHolder.getKey().longValue();

	}

	public void deleteEvents(Events bean) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("delete from events where event_id = ?",bean.getEvent_id());
		
	}

	public void updateEvents(Events bean) {
		// TODO Auto-generated method stub
		
		this.jdbcTemplate.update("update events set title = ? where event_id = ?",bean.getTitle(),bean.getEvent_id());
		
	}

	public Events getEvents(Events bean) {
		// TODO Auto-generated method stub
		
		Events events = this.jdbcTemplate.queryForObject("select * from events where event_id = ? ", new Object[] {bean.getEvent_id()},new EventsMapper());
		
		return events;
	}

	/**
	 * 列表
	 */
	public List getEventsList(Events bean) {
		// TODO Auto-generated method stub
		
		String sql = "select * from events where 1=1 " + this.getwhere(bean);
		
		return this.jdbcTemplate.query(sql,new EventsMapper());
	}
	
	/**
	 * int type 0 是不需要分页  1 是需要分页
	 */
	public List getEventsListBypage(Events bean,int type,int startnumber) {
		
		String sql = "select * from events where 1=1 " + this.getwhere(bean);
		
		if(type == 1) {
			sql += " limit " + startnumber + "," + Constant.PERPAGE_COUNT;
		}
		
		//System.out.println("sql = " + sql);
		
		
		return this.jdbcTemplate.query(sql,new EventsMapper());

	}
	
	/**
	 * 得到结果集的内部类
	 * @author garycooper
	 *
	 */
	private static final class EventsMapper implements RowMapper<Events> {
		public Events mapRow(ResultSet rs, int rowNum) throws SQLException {
			Events bean = new Events();
			bean.setEvent_id(rs.getLong("event_id"));
			bean.setTitle(rs.getString("title"));
			bean.setEvent_date(rs.getTimestamp("event_date"));
			return bean;
		}
	}
	
	
	/**
	 * 处理where条件语句
	 * @param bean
	 * @return
	 */
	private static String getwhere(Events bean) {
		String s = "";
		
		String title = bean.getTitle();
		if(!StringUtils.isNullOrEmpty(title)) {
			s = " and title like '%" + title.trim() + "%' ";
		}
		
		return s;
	}
	
	public int getCount(Events bean) {
		
		String sql = "select count(*) from events  where 1=1 " + this.getwhere(bean);
		
		return this.jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
