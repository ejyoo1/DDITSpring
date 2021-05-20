package ejyoo.service;

import java.sql.SQLException;
import java.util.List;

import ejyoo.dto.MemberVO;

public interface IMemberSystemService {
	List<MemberVO> getMemberList(MemberVO memberDto) throws SQLException;
	
	MemberVO getMember(String userId) throws SQLException;
	
	int insertMember(MemberVO memberDto) throws SQLException;
	
	int updateMember(MemberVO memberDto) throws SQLException;
	
	int deleteMember(String userId) throws SQLException;
}
