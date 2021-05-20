package ejyoo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import ejyoo.dto.MemberVO;

public interface IMemberSystemDao {
	List<MemberVO> selectMemberList(SqlMapClient smc, MemberVO memberDto) throws SQLException;
	
	MemberVO selectMember(SqlMapClient smc, String userId) throws SQLException;
	
	int insertMember(SqlMapClient smc, MemberVO memberDto) throws SQLException;
	
	int updateMember(SqlMapClient smc, MemberVO memberDto) throws SQLException;
	
	int deleteMember(SqlMapClient smc, String userId) throws SQLException;
}
