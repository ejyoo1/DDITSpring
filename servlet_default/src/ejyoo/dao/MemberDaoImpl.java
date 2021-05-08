package ejyoo.dao;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao{
	
	private static IMemberDao memDao;
	
	private MemberDaoImpl () {}
	
	public static IMemberDao getInstance() {
		if(memDao == null) {
			memDao = new MemberDaoImpl();
		}
		return memDao;
	}
	
	private static final Logger RESULT_LOGGER = Logger.getLogger(MemberDaoImpl.class);

	@Override
	public boolean memberSearchId(SqlMapClient smc, MemberVO mv) throws SQLException {
		boolean chk = false;
		
		int cnt = (int) smc.queryForObject("member.memberSearchId", mv);
		
		if(cnt > 0) {
			chk = true;
		}
		return chk;
	}

	@Override
	public boolean memberSearchPw(SqlMapClient smc, MemberVO mv) throws SQLException {
		boolean chk = false;
		
		int cnt = (int) smc.queryForObject("member.memberSearchPw", mv);
		
		if(cnt > 0) {
			chk = true;
		}
		return chk;
	}

	@Override
	public MemberVO memberSearch(SqlMapClient smc, MemberVO mv) throws SQLException {
		MemberVO mv1 = (MemberVO) smc.queryForObject("member.memberSearch", mv);
		
		return mv1;
	}

}
