package ejyoo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ejyoo.dto.NoticeVO;
import ejyoo.servlet.util.OracleMyBatisSqlSessionFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestNoticeDAOImpl {
	private SqlSession session;
	
	@Before
	public void init() {
		session = new OracleMyBatisSqlSessionFactory().openSession(false);
	}
	
	//@Test
	public void Test1_selectNoticeList() throws Exception {
		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.selectNoticeList");
		Assert.assertEquals(1,noticeList.size());
	}
	
	//@Test
	public void Test2_selectNoticeByInfo() throws Exception {
		NoticeVO notice = new NoticeVO();
		notice.setNoticeNo("20");
		notice.setNoticeTitle("5");
		notice.setNoticeContents("4");
		notice.setNoticeWriter("유은지");
		notice.setNoticeEditer("김철수");
		notice.setNoticeCreate("21/05/24");
		notice.setNoticeModify("21/05/24");
		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.selectNoticeByInfo",notice);
		Assert.assertEquals(1, noticeList.size());
	}
	
	//@Test
	public void Test3_selectNoticeByNo() throws Exception {
		String noticeNo = "20";
		NoticeVO notice = session.selectOne("Notice-Mapper.selectNoticeByNo",noticeNo);
		Assert.assertEquals("20", notice.getNoticeNo());
	}
	
	//@Test
	public void Test2_insertNoticeByInfo() throws Exception {
		NoticeVO notice = new NoticeVO();
		notice.setNoticeTitle("게시글 제목");
		notice.setNoticeContents("게시글 내용");
		notice.setNoticeWriter("유은지");
		int cnt = session.insert("Notice-Mapper.insertNoticeByInfo",notice);
		Assert.assertEquals(1, cnt);
	}
	
	//@Test
	public void Test2_updateNoticeByInfo() throws Exception {
		NoticeVO notice = new NoticeVO();
		notice.setNoticeNo("23");
		notice.setNoticeTitle("게시글 제목");
		notice.setNoticeContents("게시글 내용");
		notice.setNoticeEditer("김철수");
		int cnt = session.insert("Notice-Mapper.updateNoticeByInfo",notice);
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void Test2_deleteMemberByNo() throws Exception {
		String noticeNo = "22";
		int cnt = session.insert("Notice-Mapper.deleteMemberByNo",noticeNo);
		Assert.assertEquals(1, cnt);
	}
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
}
