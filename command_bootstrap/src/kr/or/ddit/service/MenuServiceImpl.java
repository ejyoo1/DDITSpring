package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.dao.MenuDAO;
import kr.or.ddit.dao.MenuDAOImpl;
import kr.or.ddit.dto.MenuVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class MenuServiceImpl implements MenuService {
	
	private MenuDAO menuDAO;// = new MenuDAOImpl(); 의존 주입
	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	private SqlSessionFactory sqlSessionFactory;// = new OracleMyBatisSqlSessionFactory(); 의존 주입
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public List<MenuVO> getMainMenuList() throws SQLException {
		List<MenuVO> menuList = null;
		SqlSession session = sqlSessionFactory.openSession(false);
		
		try {
			menuList = menuDAO.selectMainMenu(session);
			
			session.commit();
		} catch(SQLException e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
		return menuList;
	}

	@Override
	public List<MenuVO> getSubMenuList(String mCode) throws SQLException {
		List<MenuVO> menuList = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		menuList = menuDAO.selectSubMenu(session, mCode);
		session.close();
		
		return menuList;
	}

	@Override
	public MenuVO getMenuByMcode(String mCode) throws SQLException {
		// 입력
		MenuVO menu = null;
		
		// 처리
		SqlSession session = sqlSessionFactory.openSession();
		menu = menuDAO.selectMenuByMcode(session, mCode);
		session.close();
		
		// 출력
		return menu;
	}

}
