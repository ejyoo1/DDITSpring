package ejyoo.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ejyoo.dto.NoticeVO;

public interface INoticeDAO {
	List<NoticeVO> selectNoticeList(SqlSession session) throws SQLException;

	List<NoticeVO> selectNoticeByInfo(SqlSession session, NoticeVO noticeVo) throws SQLException;
	
	NoticeVO selectNoticeByNo(SqlSession session, String noticeNo) throws SQLException;
	
	int insertNoticeByInfo(SqlSession session, NoticeVO noticeVo) throws SQLException;
	
	int updateNoticeByInfo(SqlSession session, NoticeVO noticeVo) throws SQLException;
	
	int deleteNoticeByNo(SqlSession session, String noticeNo) throws SQLException;
}
