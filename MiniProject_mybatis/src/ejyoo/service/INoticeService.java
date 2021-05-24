package ejyoo.service;

import java.sql.SQLException;
import java.util.List;

import ejyoo.dto.NoticeVO;

public interface INoticeService {
	List<NoticeVO> getNoticeList() throws SQLException;
	
	List<NoticeVO> getNoticeByInfo(NoticeVO noticeVo) throws SQLException;
	
	NoticeVO getNoticeByNo(String noticeNo) throws SQLException;
	
	int insertNoticeByInfo(NoticeVO noticeVo) throws SQLException;
	
	int updateNoticeByInfo(NoticeVO noticeVo) throws SQLException;
	
	int deleteNoticeByNo(String noticeNo) throws SQLException;
}
