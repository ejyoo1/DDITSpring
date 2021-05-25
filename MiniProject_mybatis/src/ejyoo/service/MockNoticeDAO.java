package ejyoo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ejyoo.dao.INoticeDAO;
import ejyoo.dto.NoticeVO;

public class MockNoticeDAO implements INoticeDAO{

	@Override
	public List<NoticeVO> selectNoticeList(SqlSession session) throws SQLException {
		List<NoticeVO> noticeList = null;
		
		if(session.getConnection() == null) throw new SQLException();
		
		NoticeVO notice = new NoticeVO();
		notice.setNoticeNo("20");
		
		noticeList = new ArrayList<NoticeVO>();
		noticeList.add(notice);
		
		return noticeList;
	}

	@Override
	public List<NoticeVO> selectNoticeByInfo(SqlSession session, NoticeVO noticeVo) throws SQLException {
		List<NoticeVO> noticeList = null;
		
		if(session.getConnection() == null) throw new SQLException();
		
		NoticeVO notice = new NoticeVO();
		notice.setNoticeNo("20");
		
		noticeList = new ArrayList<NoticeVO>();
		noticeList.add(notice);
		
		return noticeList;
	}

	@Override
	public NoticeVO selectNoticeByNo(SqlSession session, String noticeNo) throws SQLException {
		NoticeVO notice = null;
		
		if(session.getConnection() == null) throw new SQLException();
		
		notice = new NoticeVO();
		notice.setNoticeNo("20");
		
		return notice;
	}

	@Override
	public int insertNoticeByInfo(SqlSession session, NoticeVO noticeVo) throws SQLException {
		int cnt = 0;
		
		if(session.getConnection() == null) throw new SQLException();
		cnt = 1;
		
		return cnt;
	}

	@Override
	public int updateNoticeByInfo(SqlSession session, NoticeVO noticeVo) throws SQLException {
		int cnt = 0;
		
		if(session.getConnection() == null) throw new SQLException();
		cnt = 1;
		
		return cnt;
	}

	@Override
	public int deleteNoticeByNo(SqlSession session, String noticeNo) throws SQLException {
		int cnt = 0;
		
		if(session.getConnection() == null) throw new SQLException();
		cnt = 1;
		
		return cnt;
	}

}
