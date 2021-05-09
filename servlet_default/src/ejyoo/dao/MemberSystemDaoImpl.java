package ejyoo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import ejyoo.vo.MemberDTO;

public class MemberSystemDaoImpl implements IMemberSystemDao{
	private static IMemberSystemDao mmsdi;
	
	private MemberSystemDaoImpl() {}
	
	public static IMemberSystemDao getInstance() {
		if(mmsdi == null) {
			mmsdi = new MemberSystemDaoImpl();
		}
		return mmsdi;
	}

	@Override
	public List<MemberDTO> selectMemberList(SqlMapClient smc, MemberDTO memberDto) throws SQLException {
		try {
			List<MemberDTO> memberList = smc.queryForList("member.selectMemberList", memberDto);
			return memberList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int insertMember(SqlMapClient smc, MemberDTO memberDto) throws SQLException {
		int cnt = 0;
		try{
			Object obj = smc.insert("member.insertMember", memberDto);
		
			if(obj==null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return cnt;
	}

	@Override
	public int updateMember(SqlMapClient smc, MemberDTO memberDto) throws SQLException {
		int cnt = 0;
		try{
			cnt = smc.update("member.updateMember", memberDto);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return cnt;
	}

	@Override
	public int deleteMember(SqlMapClient smc, MemberDTO memberDto) throws SQLException {
		int cnt = 0;
		try{
			cnt = smc.delete("member.deleteMember", memberDto);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return cnt;
	}
}
