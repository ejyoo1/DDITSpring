package ejyoo.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ejyoo.dto.NoticeVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestNoticeService {
	private NoticeServiceImpl service;
	
	@Before
	public void init() {
		service = new NoticeServiceImpl();
		service.setNoticeDao(new MockNoticeDAO());
	}
	
	@Test
	public void Test1_getNoticeList() throws SQLException {
		List<NoticeVO> noticeList = service.getNoticeList();
		
		Assert.assertEquals(1, noticeList.size());
		Assert.assertEquals("20", noticeList.get(0).getNoticeNo());
		
	}
	
	@Test
	public void Test2_getNoticeByInfo() throws SQLException {
		NoticeVO noticeVo = new NoticeVO();
		List<NoticeVO> noticeList = service.getNoticeByInfo(noticeVo);
		
		Assert.assertEquals(1, noticeList.size());
		Assert.assertEquals("20", noticeList.get(0).getNoticeNo());
	}
	
	@Test
	public void Test3_getNoticeByNo() throws SQLException {
		NoticeVO noticeVo = new NoticeVO();
		List<NoticeVO> noticeList = service.getNoticeByInfo(noticeVo);
		
		Assert.assertEquals(1, noticeList.size());
		Assert.assertEquals("20", noticeList.get(0).getNoticeNo());
	}
	
	@Test
	public void Test4_insertNoticeByInfo() throws SQLException {
		int cnt = 0;
		NoticeVO noticeVo = new NoticeVO();
		
		cnt = service.insertNoticeByInfo(noticeVo);
		
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void Test5_updateNoticeByInfo() throws SQLException {
		int cnt = 0;
		NoticeVO noticeVo = new NoticeVO();
		
		cnt = service.insertNoticeByInfo(noticeVo);
		
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void Test6_deleteNoticeByNo() throws SQLException {
		int cnt = 0;
		NoticeVO noticeVo = new NoticeVO();
		
		cnt = service.insertNoticeByInfo(noticeVo);
		
		Assert.assertEquals(1, cnt);
	}
}
