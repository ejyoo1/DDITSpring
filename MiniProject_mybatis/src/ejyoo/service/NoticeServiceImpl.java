package ejyoo.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ejyoo.dao.INoticeDAO;
import ejyoo.dao.NoticeDAOImpl;
import ejyoo.dto.NoticeVO;
import ejyoo.servlet.util.OracleMyBatisSqlSessionFactory;

public class NoticeServiceImpl implements INoticeService{
	
	private INoticeDAO noticeDao = new NoticeDAOImpl();
	public void setNoticeDao(INoticeDAO noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	private SqlSessionFactory sqlSessionFactory = new OracleMyBatisSqlSessionFactory();
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<NoticeVO> getNoticeList() throws SQLException {
		List<NoticeVO> noticeList = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		noticeList = noticeDao.selectNoticeList(session);
		session.close();
		
		return noticeList;
	}

	@Override
	public List<NoticeVO> getNoticeByInfo(NoticeVO noticeVo) throws SQLException {
		List<NoticeVO> noticeList = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		noticeList = noticeDao.selectNoticeByInfo(session, noticeVo);
		session.close();
		
		return noticeList;
	}

	@Override
	public NoticeVO getNoticeByNo(String noticeNo) throws SQLException {
		NoticeVO notice = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		notice = noticeDao.selectNoticeByNo(session, noticeNo);
		session.close();
		
		return notice;
	}

	@Override
	public int insertNoticeByInfo(NoticeVO noticeVo) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		cnt = noticeDao.insertNoticeByInfo(session, noticeVo);
		session.close();
		
		return cnt;
	}

	@Override
	public int updateNoticeByInfo(NoticeVO noticeVo) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		cnt = noticeDao.updateNoticeByInfo(session, noticeVo);
		session.close();
		
		return cnt;
	}

	@Override
	public int deleteNoticeByNo(String noticeNo) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		cnt = noticeDao.deleteNoticeByNo(session, noticeNo);
		session.close();
		
		return cnt;
	}
}
