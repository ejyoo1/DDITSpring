package ejyoo.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ejyoo.dao.interfaces.IMenuDAO;
import ejyoo.dto.MenuVO;
import ejyoo.service.interfaces.IMenuService;

public class MenuServiceImpl implements IMenuService {
	
	private IMenuDAO menuDAO;
	public void setMenuDAO(IMenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}
	
	private SqlSessionFactory sqlSessionFactory;
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
		MenuVO menu = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		menu = menuDAO.selectMenuByMcode(session, mCode);
		session.close();
		
		return menu;
	}

}
