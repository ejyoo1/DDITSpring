package ejyoo.service;

import java.sql.SQLException;
import java.util.List;

import ejyoo.vo.MemberDTO;

public interface IMemberSystemService {
	List<MemberDTO> getMemberList(MemberDTO memberDto) throws SQLException;
	
	MemberDTO getMember(String userId) throws SQLException;
	
	int insertMember(MemberDTO memberDto) throws SQLException;
	
	int updateMember(MemberDTO memberDto) throws SQLException;
	
	int deleteMember(String userId) throws SQLException;
}
