package ejyoo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import ejyoo.dto.MemberVO;

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
	public List<MemberVO> selectMemberList(SqlMapClient smc, MemberVO memberDto) throws SQLException {
		try {
			List<MemberVO> memberList = smc.queryForList("member.selectMemberList", memberDto);
			return memberList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public MemberVO selectMember(SqlMapClient smc, String userId) throws SQLException {
		try {
			MemberVO member = (MemberVO) smc.queryForObject("member.selectMember", userId);
			return member;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int insertMember(SqlMapClient smc, MemberVO memberDto) throws SQLException {
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
	public int updateMember(SqlMapClient smc, MemberVO memberDto) throws SQLException {
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
	public int deleteMember(SqlMapClient smc, String userId) throws SQLException {
		int cnt = 0;
		try{
			cnt = smc.delete("member.deleteMember", userId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return cnt;
	}
}
