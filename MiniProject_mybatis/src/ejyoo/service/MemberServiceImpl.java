package ejyoo.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ejyoo.dao.IMemberDAO;
import ejyoo.dao.MemberDAOImpl;
import ejyoo.dto.MemberVO;
import ejyoo.servlet.util.OracleMyBatisSqlSessionFactory;

public class MemberServiceImpl implements IMemberService {

	private IMemberDAO memberDao = new MemberDAOImpl();
	public void setMemberDao(IMemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	private SqlSessionFactory sqlSessionFactory = new OracleMyBatisSqlSessionFactory();
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		List<MemberVO> memberList = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		memberList = memberDao.selectMemberList(session);
		session.close();
		
		return memberList;
	}
	@Override
	public List<MemberVO> getMemberListByInfo(MemberVO memberVo) throws SQLException {
		List<MemberVO> memberList = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		memberList = memberDao.selectMemberListByInfo(session, memberVo);
		session.close();
		
		return memberList;
	}
	@Override
	public MemberVO getMemberByInfo(MemberVO memberVo) throws SQLException {
		MemberVO member = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		member = memberDao.selectMemberByInfo(session, memberVo);
		session.close();
		
		return member;
	}
	@Override
	public MemberVO getMemberById(String userId) throws SQLException {
		MemberVO member = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		member = memberDao.selectMemberById(session, userId);
		session.close();
		
		return member;
	}
	@Override
	public int insertMemberByInfo(MemberVO memberVo) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		cnt = memberDao.insertMemberByInfo(session, memberVo);
		session.close();
		
		return cnt;
	}
	@Override
	public int updateMemberByInfo(MemberVO memberVo) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		cnt = memberDao.updateMemberByInfo(session, memberVo);
		session.close();
		
		return cnt;
	}
	@Override
	public int deleteMemberById(String userId) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		cnt = memberDao.deleteMemberById(session, userId);
		session.close();
		
		return cnt;
	}
	
	
}
