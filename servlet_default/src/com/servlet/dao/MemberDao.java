package com.servlet.dao;

import java.sql.SQLException;

import com.servlet.vo.MemberVO;

public interface MemberDao {
	
	MemberVO selectMemberById(String id) throws SQLException;
}
