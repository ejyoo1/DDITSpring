package ejyoo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import ejyoo.vo.MemberDTO;

public interface IMemberSystemDao {
	List<MemberDTO> selectMemberList(SqlMapClient smc, MemberDTO memberDto) throws SQLException;
	
	int insertMember(SqlMapClient smc, MemberDTO memberDto) throws SQLException;
	
	int updateMember(SqlMapClient smc, MemberDTO memberDto) throws SQLException;
	
	int deleteMember(SqlMapClient smc, MemberDTO memberDto) throws SQLException;
}
