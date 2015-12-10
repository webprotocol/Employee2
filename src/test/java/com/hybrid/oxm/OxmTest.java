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

public class OxmTest {

	static Log log = LogFactory.getLog(OxmTest.class);
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx=null;
		ctx = new GenericXmlApplicationContext("spring/beans_dao.xml");
		
		Jaxb2Marshaller m = ctx.getBean(Jaxb2Marshaller.class);
		Map<String, Object> properties = new HashMap<>();
		properties.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		m.setMarshallerProperties(properties);
		
		CityList list = new CityList();
		List<City> citys = new ArrayList<>();
		list.setCitys(citys);
		
		City c = new City();
		c.setId(100);
		citys.add(c);
		
		m.marshal(list, new StreamResult(System.out));
		
		String xml = "<?xml version=\"1.0\"?>"
				+ "<Response>"
				+ "   <citys/>"
				+ "</Response>"; 
				
//		StreamSource source = new StreamSource(new StringReader(xml));
		StreamSource source = new StreamSource(new File("CityList.xml"));
		
		CityList list2 = (CityList) m.unmarshal(source);
		m.marshal(list2, new StreamResult(System.out));
		
		ctx.close();
	}

}
