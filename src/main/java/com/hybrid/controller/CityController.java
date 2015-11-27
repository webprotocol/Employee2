package com.hybrid.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.model.City;
import com.hybrid.model.CityList;
import com.hybrid.model.CityPage;
import com.hybrid.service.CityListService;
import com.hybrid.service.CityPageService;
import com.hybrid.util.Pagination;

//@Controller
@RequestMapping("/city")
public class CityController {
	static Log log = LogFactory.getLog(CityController.class);

	CityListService cityListService;
	
	CityPageService cityPageService;
	
	public void setCityListService(CityListService service) {
		this.cityListService = service;
	}
	public void setCityPageService(CityPageService service) {
		this.cityPageService = service;
	}
	
	
	@RequestMapping("/city.html")
	public String getView() {
		log.info("getView()...");
		
		return "city/city"; // /WEB-INF/view/city/city.jsp
	}
	
	@RequestMapping(value={"", "/"})
	@ResponseBody
	public CityList getCityAll() {

		CityList list = cityListService.getList();
		
		return list;
	}
	
//	@RequestMapping("/page/{pageNo:[\\-\\+]{0,1}[0-9]+}")
	@RequestMapping("/page/{pageNo:[0-9]+}")
	@ResponseBody
	public CityPage getCityPage(@PathVariable int pageNo) {
	
		log.info("pageNo = " + pageNo);
		
		CityPage page = cityPageService.getPage(pageNo);
		
		return page;
	}
	
	
	
	
	
	
}
