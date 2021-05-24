package ejyoo.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ejyoo.dto.NoticeVO;

public class NoticeDAOImpl implements INoticeDAO{

	@Override
	public List<NoticeVO> selectNoticeList(SqlSession session) throws SQLException {
		List<NoticeVO> noticeList = null;
		
		if(session.getConnection()==null) throw new SQLException();
		noticeList = session.selectList("Notice-Mapper.selectNoticeList");
		
		return noticeList;
	}

	@Override
	public List<NoticeVO> selectNoticeByInfo(SqlSession session, NoticeVO noticeVo) throws SQLException {
		List<NoticeVO> noticeList = null;
		
		if(session.getConnection()==null) throw new SQLException();
		noticeList = session.selectList("Notice-Mapper.selectNoticeByInfo",noticeVo);
		
		return noticeList;
	}

	@Override
	public NoticeVO selectNoticeByNo(SqlSession session, String noticeNo) throws SQLException {
		NoticeVO notice = null;
		
		if(session.getConnection()==null) throw new SQLException();
		notice = session.selectOne("Notice-Mapper.selectNoticeByNo",noticeNo);
		
		return notice;
	}

	@Override
	public int insertNoticeByInfo(SqlSession session, NoticeVO noticeVo) throws SQLException {
		int cnt = 0;
		
		if(session.getConnection()==null) throw new SQLException();
		cnt = session.insert("Notice-Mapper.insertNoticeByInfo",noticeVo);
		
		return cnt;
	}

	@Override
	public int updateNoticeByInfo(SqlSession session, NoticeVO noticeVo) throws SQLException {
		int cnt = 0;
		
		if(session.getConnection()==null) throw new SQLException();
		cnt = session.update("Notice-Mapper.updateNoticeByInfo",noticeVo);
		
		return cnt;
	}

	@Override
	public int deleteNoticeByNo(SqlSession session, String noticeNo) throws SQLException {
		int cnt = 0;
		
		if(session.getConnection()==null) throw new SQLException();
		cnt = session.delete("Notice-Mapper.deleteMemberByNo", noticeNo);
		
		return cnt;
	}
	
}
