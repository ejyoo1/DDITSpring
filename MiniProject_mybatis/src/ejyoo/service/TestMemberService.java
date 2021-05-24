package ejyoo.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ejyoo.dto.MemberVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMemberService {
	private MemberServiceImpl service;
	
	@Before
	public void init() {
		service = new MemberServiceImpl();
		service.setMemberDao(new MockMemberDAO());
	}
	
	//@Test
	public void getMemberList() throws SQLException {
		List<MemberVO> memberList = service.getMemberList();
		
		Assert.assertEquals(1, memberList.size());
		Assert.assertEquals("test1", memberList.get(0).getUserId());
	}
	
	//@Test
	public void  getMemberListByInfo() throws SQLException {
		MemberVO memberVo = null;
		List<MemberVO> memberList = service.getMemberListByInfo(memberVo);
		
		Assert.assertEquals(1, memberList.size());
		Assert.assertEquals("test1", memberList.get(0).getUserId());
	}
	
	//@Test
	public void getMemberById() throws SQLException {
		String userId = "";
		MemberVO member = service.getMemberById(userId);
		
		Assert.assertEquals("test1", member.getUserId());
	}
	
	@Test
	public void insertMemberByInfo() throws SQLException {
		MemberVO memberVo = null;
		
		int cnt = service.insertMemberByInfo(memberVo);
		
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void updateMemberByInfo() throws SQLException {
		MemberVO memberVo = null;
		
		int cnt = service.updateMemberByInfo(memberVo);
		
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void deleteMemberById() throws SQLException {
		String userId = "";
		
		int cnt = service.deleteMemberById(userId);
		
		Assert.assertEquals(1, cnt);
	}
}
