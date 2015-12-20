package com.hybrid.service;

import com.hybrid.dao.MemberDao;
import com.hybrid.exception.LoginFailException;
import com.hybrid.model.Member;

public class LoginService {

	MemberDao memberDao;
	
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}


	public Member login(String email, String password) {
		Member member = memberDao.selectByEmailAndPassword(email, password);
		if (member == null)
			throw new LoginFailException("이메일 페스워드가 일치하지 않습니다.");
		
		return member;
	}
}
