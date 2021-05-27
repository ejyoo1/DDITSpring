package ejyoo.service;

import java.sql.SQLException;
import java.util.List;

import ejyoo.dto.MemberVO;

public interface MemberService {
	List<MemberVO> getMemberList() throws SQLException;
	
	List<MemberVO> getMemberListByInfo(MemberVO member) throws SQLException;
	
	MemberVO getMemberByInfo(MemberVO member) throws SQLException;
	
	MemberVO getMemberById(String id) throws SQLException;
	
	int insertMemberByInfo(MemberVO member) throws SQLException;
	
	int updateMemberByInfo(MemberVO member) throws SQLException;
	
	int deleteMemberById(String id) throws SQLException;
}
