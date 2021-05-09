package ejyoo.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.util.SqlMapClientUtil;

import ejyoo.dao.IMemberSystemDao;
import ejyoo.dao.MemberSystemDaoImpl;
import ejyoo.vo.MemberDTO;

public class MemberSystemServiceImpl implements IMemberSystemService {
	private static IMemberSystemService mmssi = null;
	private static SqlMapClient smc = null;
	private static IMemberSystemDao mmsdi = null;
	
	private MemberSystemServiceImpl() {
		mmsdi = MemberSystemDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IMemberSystemService getInstance() {
		if(mmssi == null) {
			mmssi = new MemberSystemServiceImpl();
		}
		return mmssi;
	}
	
	@Override
	public List<MemberDTO> getMemberList(MemberDTO memberDto) throws SQLException {
		List<MemberDTO> resultMemberDto = null;
		try {
			resultMemberDto = mmsdi.selectMemberList(smc, memberDto);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return resultMemberDto;
	}

	@Override
	public int insertMember(MemberDTO memberDto) throws SQLException {
		int resultCnt = 0;
		try {
			resultCnt = mmsdi.insertMember(smc, memberDto);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return resultCnt;
	}

	@Override
	public int updateMember(MemberDTO memberDto) throws SQLException {
		int resultCnt = 0;
		try {
			resultCnt = mmsdi.updateMember(smc, memberDto);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return resultCnt;
	}

	@Override
	public int deleteMember(MemberDTO memberDto) throws SQLException {
		int resultCnt = 0;
		try {
			resultCnt = mmsdi.deleteMember(smc, memberDto);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return resultCnt;
	}
}
