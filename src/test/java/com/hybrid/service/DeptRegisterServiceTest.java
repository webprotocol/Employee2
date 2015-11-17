package com.hybrid.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.model.Dept;

public class DeptRegisterServiceTest {

	static Log log = LogFactory.getLog(DeptRegisterServiceTest.class);
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=null;
		ctx = new GenericXmlApplicationContext("spring/beans_oracle.xml");
		
		DeptRegisterService service = ctx.getBean(DeptRegisterService.class);
		
		service.regist(null);
		
	}

}
