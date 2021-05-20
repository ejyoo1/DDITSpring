package kr.or.ddit.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ejyoo.dto.MemberVO;
import ejyoo.servlet.util.OracleMyBatisSqlSessionFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestOracleMyBatisMemberQuery {
	private SqlSessionFactory factory = new OracleMyBatisSqlSessionFactory();
	
	private SqlSession session;
	
	@Before
	public void openSession() {
		session = factory.openSession();
	}
	
	@Test
	public void Test1_selectMemberListSQL() {
		MemberVO paramTypeMemberVo = new MemberVO();
		paramTypeMemberVo.setUserNo(118);
		paramTypeMemberVo.setUserId("test1");
		paramTypeMemberVo.setUserPw("test");
		paramTypeMemberVo.setUserPhone("010-0000-0000");
		paramTypeMemberVo.setUserEmail("o3k1@test.com");
		List<MemberVO> memberVoList = session.selectList("Member-Mapper.selectMemberList",paramTypeMemberVo);
		Assert.assertTrue(memberVoList.size()>0);
	}
	
	@Test
	public void Test2_selectMemberByInfoSQL() {
		MemberVO paramTypeMemberVo = new MemberVO();
		paramTypeMemberVo.setUserNo(118);
		paramTypeMemberVo.setUserId("test1");
		paramTypeMemberVo.setUserPw("test");
		paramTypeMemberVo.setUserPhone("010-0000-0000");
		paramTypeMemberVo.setUserEmail("o3k1@test.com");
		MemberVO memberVo = session.selectOne("Member-Mapper.selectMemberById",paramTypeMemberVo);
		Assert.assertEquals("test1", memberVo.getUserId());
	}
	
	@Test
	public void Test3_selectMemberByIdSQL() {
		String userId = "test1";
		MemberVO memberVo = session.selectOne("Member-Mapper.selectMemberById",userId);
		Assert.assertEquals("test1", memberVo.getUserId());
	}
	
	@Test
	public void Test4_insertMemberByInfoSQL() {
		MemberVO paramTypeMemberVo = new MemberVO();
		paramTypeMemberVo.setUserId("test3");
		paramTypeMemberVo.setUserPw("yej33585");
		paramTypeMemberVo.setUserPhone("010-0000-0000");
		paramTypeMemberVo.setUserEmail("test@test.com");
		int cnt = session.insert("Member-Mapper.insertMemberByInfo", paramTypeMemberVo);
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void Test5_updateMemberByInfoSQL() {
		MemberVO paramTypeMemberVo = new MemberVO();
		paramTypeMemberVo.setUserNo(135);
		paramTypeMemberVo.setUserId("test4");
		paramTypeMemberVo.setUserPw("yej3585");
		paramTypeMemberVo.setUserPhone("010-1111-1111");
		paramTypeMemberVo.setUserEmail("test@test.com");
		int cnt = session.update("Member-Mapper.updateMemberByInfo", paramTypeMemberVo);
		Assert.assertTrue(cnt == 1);
	}
	
	@Test
	public void Test6_deleteMemberByIdSQL() {
		String userId = "test4";
		int cnt = session.update("Member-Mapper.deleteMemberById", userId);
		Assert.assertTrue(cnt == 1);
	}
	
	@After
	public void closeSession() {
		session.close();
	}
}
