package com.servlet.service;

import java.sql.SQLException;

import com.servlet.dao.MemberDao;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIdException;
import com.servlet.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao;  // = MemberDAOImpl.getInstance();
	
	@Override
	public MemberVO login(String id, String pwd) 
					throws 	NotFoundIdException, 
							InvalidPasswordException, 
							SQLException {
		
		MemberVO member = null;
		
		try {
			member = memberDao.selectMemberById(id);
		} catch(SQLException e) {
			// Exception 에 대한 처리 구문 필요
			e.printStackTrace();
			throw e;
		}
		
		if(member!=null) {
			if(pwd.equals(member.getUserPw())) { // 로그인 성공
				return member;
			} else { // 패스워드 불일치
				throw new InvalidPasswordException();
			}
		} else {
			throw new NotFoundIdException();
		}
	}
}
