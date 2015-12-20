package com.hybrid.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hybrid.command.LoginCommand;
import com.hybrid.dao.MemberDao;
import com.hybrid.exception.LoginFailException;
import com.hybrid.model.Member;
import com.hybrid.service.LoginService;
import com.hybrid.util.LoginCheck;

@Controller
@RequestMapping("/user")
public class LoginController {
	static Log log = LogFactory.getLog(LoginController.class);
	
	@Autowired
	LoginService loginService;

	/*
	 * login.html
	 */
	@RequestMapping(value="/login.html", method=RequestMethod.GET)
	public String getLoginView() {
		log.info("getLoginView()...");
		
		return "user/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public LoginCommand login(@RequestBody LoginCommand command, HttpSession session) {
		log.info("Email = " + command.getEmail());
		log.info("password = " + command.getPassword());
		log.info("remember = " + command.getRemember());
		
		Member member = loginService.login(command.getEmail(), command.getPassword());
		session.setAttribute("login", true);
		
		return command;
	}
	
	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public LoginFailException exception(LoginFailException e) {
		return e;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		log.info("logout...");
		
		session.invalidate();
		return "redirect:/user/login.html";
	}
	
	@RequestMapping(value="/logincheck", method=RequestMethod.GET)
	@ResponseBody
	public LoginCheck logincheck(HttpSession session) {

		LoginCheck check = new LoginCheck();
		
		Boolean login = (Boolean) session.getAttribute("login");
		if (login == null)
			check.setLogin(false);
		else
			check.setLogin(login);
		
		return check;
	}
}
