package ejyoo.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import ejyoo.dao.IMemberSystemDao;
import ejyoo.dao.MemberSystemDaoImpl;
import ejyoo.dto.MemberVO;
import ejyoo.servlet.util.SqlMapClientUtil;

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
	public List<MemberVO> getMemberList(MemberVO memberDto) throws SQLException {
		List<MemberVO> resultMemberDtoList = null;
		try {
			resultMemberDtoList = mmsdi.selectMemberList(smc, memberDto);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return resultMemberDtoList;
	}
	
	public MemberVO getMember(String userId) throws SQLException {
		MemberVO resultMemberDto = null;
		try {
			resultMemberDto = mmsdi.selectMember(smc, userId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return resultMemberDto;
	}

	@Override
	public int insertMember(MemberVO memberDto) throws SQLException {
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
	public int updateMember(MemberVO memberDto) throws SQLException {
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
	public int deleteMember(String userId) throws SQLException {
		int resultCnt = 0;
		try {
			resultCnt = mmsdi.deleteMember(smc, userId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return resultCnt;
	}
}
