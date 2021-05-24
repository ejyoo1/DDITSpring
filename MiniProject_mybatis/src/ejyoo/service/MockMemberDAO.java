package ejyoo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ejyoo.dao.IMemberDAO;
import ejyoo.dto.MemberVO;

public class MockMemberDAO implements IMemberDAO {

	@Override
	public List<MemberVO> selectMemberList(SqlSession session) throws SQLException {
		List<MemberVO> memberList = null;
		
		if(session.getConnection()==null) throw new SQLException();
		
		MemberVO member = new MemberVO();
		member.setUserId("test1");
		
		memberList = new ArrayList<MemberVO>();
		memberList.add(member);
		
		return memberList;
	}

	@Override
	public List<MemberVO> selectMemberListByInfo(SqlSession session, MemberVO memberVo) throws SQLException {
		List<MemberVO> memberList = null;
		
		if(session.getConnection()==null) throw new SQLException();
		
		MemberVO member = new MemberVO();
		member.setUserId("test1");
		
		memberList = new ArrayList<MemberVO>();
		memberList.add(member);
		
		return memberList;
	}

	@Override
	public MemberVO selectMemberByInfo(SqlSession session, MemberVO memberVo) throws SQLException {
		MemberVO member = null;
		
		if(session.getConnection()==null) throw new SQLException();
		
		member = new MemberVO();
		member.setUserId("test1");
		
		return member;
	}

	@Override
	public MemberVO selectMemberById(SqlSession session, String userId) throws SQLException {
		MemberVO member = null;
		
		if(session.getConnection()==null) throw new SQLException();
		
		member = new MemberVO();
		member.setUserId("test1");
		
		return member;
	}

	@Override
	public int insertMemberByInfo(SqlSession session, MemberVO memberVo) throws SQLException {
		int cnt = 0;
		
		if(session.getConnection()==null) throw new SQLException();
		
		cnt = 1;
		
		return cnt;
	}

	@Override
	public int updateMemberByInfo(SqlSession session, MemberVO memberVo) throws SQLException {
		int cnt = 0;
		
		if(session.getConnection()==null) throw new SQLException();
		
		cnt = 1;
		
		return cnt;
	}

	@Override
	public int deleteMemberById(SqlSession session, String userId) throws SQLException {
		int cnt = 0;
		
		if(session.getConnection()==null) throw new SQLException();
		
		cnt = 1;
		
		return cnt;
	}
}
