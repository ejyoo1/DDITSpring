package com.servlet.service;

import java.sql.SQLException;

import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIdException;
import com.servlet.vo.MemberVO;

public interface MemberService {
	
	MemberVO login(String id, String pwd) 
			throws NotFoundIdException, InvalidPasswordException, SQLException;
}
