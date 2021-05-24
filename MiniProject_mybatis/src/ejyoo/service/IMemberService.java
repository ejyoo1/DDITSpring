package ejyoo.service;

import java.sql.SQLException;
import java.util.List;

import ejyoo.dto.MemberVO;

public interface IMemberService {
	List<MemberVO> getMemberList() throws SQLException;
	
	List<MemberVO> getMemberListByInfo(MemberVO memberVo) throws SQLException;
	
	MemberVO getMemberByInfo(MemberVO memberVo) throws SQLException;
	
	MemberVO getMemberById(String userId) throws SQLException;
	
	int insertMemberByInfo(MemberVO memberVo) throws SQLException;
	
	int updateMemberByInfo(MemberVO memberVo) throws SQLException;
	
	int deleteMemberById(String userId) throws SQLException;
}
