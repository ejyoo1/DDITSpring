package ejyoo.service;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
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
	public void Test1_getNoticeList() throws Exception{
		List<NoticeVO>  
		
	}
	List<NoticeVO> getNoticeByInfo(NoticeVO noticeVo)
	NoticeVO getNoticeByNo(String noticeNo)
	int insertNoticeByInfo(NoticeVO noticeVo)
	int updateNoticeByInfo(NoticeVO noticeVo)
	int deleteNoticeByNo(String noticeNo)
	
}
