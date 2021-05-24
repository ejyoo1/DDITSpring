package ejyoo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ejyoo.dto.MemberVO;
import ejyoo.servlet.util.OracleMyBatisSqlSessionFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMemberDAOImpl {
	private SqlSession session;
	private IMemberDAO memberDAO;
	
	@Before
	public void init() {
		session = new OracleMyBatisSqlSessionFactory().openSession(false);
		memberDAO = new MemberDAOImpl();
	}
	
//	@Test
	public void Test1_selectMemberList() throws Exception {
		List<MemberVO> memberList = memberDAO.selectMemberList(session);
		Assert.assertEquals(2, memberList.size());
	}
	
//	@Test
	public void Test2_selectMemberListByInfo() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setUserId("test1");
		List<MemberVO> memberList = memberDAO.selectMemberListByInfo(session,memberVO);
		Assert.assertEquals(1, memberList.size());
	}
	
//	@Test
	public void Test3_selectMemberByInfo() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setUserId("test1");
		MemberVO resultMemberVO = memberDAO.selectMemberByInfo(session,memberVO);
		Assert.assertEquals("test1", resultMemberVO.getUserId());
	}
	
//	@Test
	public void Test4_selectMemberById() throws Exception {
		String userId = "test1";
		MemberVO resultMemberVO = memberDAO.selectMemberById(session,userId);
		Assert.assertEquals("test1", resultMemberVO.getUserId());
	}
	
//	@Test
	public void Test5_insertMemberByInfo() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setUserId("test3");
		memberVO.setUserPw("1234");
		memberVO.setUserPhone("010-0000-0000");
		memberVO.setUserEmail("test3@test.com");
		int cnt = memberDAO.insertMemberByInfo(session,memberVO);
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void Test6_updateMemberByInfo() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setUserPw("1234");
		memberVO.setUserPhone("010-0000-0000");
		memberVO.setUserEmail("test@test.com");
		memberVO.setUserId("test1");
		int cnt = memberDAO.updateMemberByInfo(session, memberVO);
		Assert.assertEquals(1, cnt);
	}
	
//	@Test
	public void Test7_deleteMemberById() throws Exception {
		String userId="test3";
		int cnt = memberDAO.deleteMemberById(session,userId);
		Assert.assertEquals(1, cnt);
	}
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
}
