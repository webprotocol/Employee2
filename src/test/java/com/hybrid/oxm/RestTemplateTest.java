package com.hybrid.oxm;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;

import com.hybrid.model.City;
import com.hybrid.model.CityList;

public class RestTemplateTest {

	static Log log = LogFactory.getLog(RestTemplateTest.class);
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx=null;
		ctx = new GenericXmlApplicationContext("spring/beans_dao.xml");
		
		RestTemplate m = ctx.getBean(RestTemplate.class);
		
		String result = m.getForObject("https://api.flickr.com/services/feeds/photos_public.gne", String.class);
		
		System.out.println(result);
		
		ctx.close();
	}

}
