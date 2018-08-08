package com.fustack.action;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fustack.po.Events;
import com.fustack.service.EventsService;
import com.fustack.util.Constant;
import com.fustack.vo.EventsVO;
import com.mysql.jdbc.StringUtils;

@Controller
public class EventsCotroller {

	@Autowired
	private EventsService service;
	
	@RequestMapping("/")
	public String Index(Model model) {
		return "index";
	}

	@RequestMapping("/index")
	public String Index1(Model model) {
		return "index";
	}	
	
	@RequestMapping("/addevents")
	public String addEvents(Model model) {

		return "addevents";
	}
	
	@RequestMapping("/doaddevents")
	public String doaddEvents(@ModelAttribute("events") EventsVO events, Model model) {
		Events bean = new Events();
		
		
		//bean.setTitle(events.getTitle());
		
		BeanUtils.copyProperties(events,bean);
		
		long event_id = service.addEvents(bean);
		
		events.setEvent_id(String.valueOf(event_id));
		
		model.addAttribute("event",events);
		
//		model.addAttribute("title",events.getTitle());
//		model.addAttribute("event_id",event_id);
		
		return "addeventsresult";
	}
	
	
	@RequestMapping("/dodeleteevents")
	public String deleteEvents(@ModelAttribute("events") EventsVO events, Model model) {
		Events bean = new Events();
		bean.setEvent_id(new Long(events.getEvent_id()).longValue());
		
		
		service.deleteEvents(bean);
		
		model.addAttribute("event_id", events.getEvent_id());
		
		return "deleteeventsresult";
	}
	
	@RequestMapping("/updateevents")
	public String updateEvents(@ModelAttribute("events") EventsVO vo, Model model) {
		Events bean = new Events();
		
		bean.setEvent_id(new Long(vo.getEvent_id()).longValue());
		
		Events events = service.getEvents(bean);
		
		model.addAttribute("item", events);
		
		return "updateevents";
	}	
	
	@RequestMapping("/doupdate")
	public String doupdateEvents(@ModelAttribute("events") EventsVO vo,Model model) {
		Events bean = new Events();

		bean.setEvent_id(new Long(vo.getEvent_id()).longValue());
		bean.setTitle(vo.getTitle());
		
		
		model.addAttribute("title",vo.getTitle());
		model.addAttribute("event_id",vo.getEvent_id());

		
		service.updateEvents(bean);
		
		
		return "doupdateresult";
	}
	
	@RequestMapping("/searchevents")
	public String searchEvents(@ModelAttribute("events") EventsVO vo, Model model) {
		Events bean = new Events();
		
		bean.setTitle(vo.getTitle());
		
		List<Events> list = service.getEventsList(bean);
		
		model.addAttribute("list", list);
		
		return "searchevents";
	}	
	
	
	@RequestMapping("/searchresult")
	public String getSearchResult(@ModelAttribute("events") EventsVO vo,Model model) {
		
		
		Events bean = new Events();
		bean.setTitle(vo.getTitle());
		
		List<Events> list = service.getEventsList(bean);
		
		model.addAttribute("list", list);
		
		return "geteventslist";
	}	
	
	@RequestMapping("/geteventslist")
	public String getEventsList(@ModelAttribute("events") EventsVO vo,Model model) {
		
		
		Events bean = new Events();
		bean.setTitle(vo.getTitle());
		
		List<Events> list = service.getEventsList(bean);
		
		model.addAttribute("list", list);
		
		return "geteventslist";
	}

	@RequestMapping("/geteventslistdel")
	public String getEventsListdel(@ModelAttribute("events") EventsVO vo,Model model) {
		
		
		Events bean = new Events();
		bean.setTitle(vo.getTitle());
		
		List<Events> list = service.getEventsList(bean);
		
		model.addAttribute("list", list);
		
		return "geteventslistdel";
	}
	
	@RequestMapping("/geteventslistupdate")
	public String getEventsListupdate(@ModelAttribute("events") EventsVO vo,Model model) {
		
		
		Events bean = new Events();
		bean.setTitle(vo.getTitle());
		
		List<Events> list = service.getEventsList(bean);
		
		model.addAttribute("list", list);
		
		return "geteventslistupdate";
	}	
	
	
	/**
	 * 分页列表
	 * @param vo
	 * @param model
	 * @return
	 */
	@RequestMapping("geteventlistbypage")
	public String getA(@ModelAttribute("events") EventsVO vo,Model model) {
		
		Events bean = new Events();
		
		//得到总数
		int count = service.getCount(bean);
		
		//得到页数
		int pages = service.getPages(count, Constant.PERPAGE_COUNT);
		
		//开始页，默认为第一页
		String spage = vo.getPage();

		if(StringUtils.isNullOrEmpty(spage)) {
			spage = "1";
		}
		
		int startpage = Integer.parseInt(spage);
		if(startpage <= 0) startpage = 1;
		
		//开始的位置
		int startnumber = (startpage - 1) * Constant.PERPAGE_COUNT;
		
		//参数1代表分页显示
		List<Events> list = service.getEventsListBypage(bean, 1, startnumber);
		
		
		model.addAttribute("count",count);
		model.addAttribute("pages",pages);
		model.addAttribute("list",list);
		//System.out.println("spage = " + spage);
		model.addAttribute("spage",spage);

		
		
		return "geteventlistbypage";
	}
	
	
}
