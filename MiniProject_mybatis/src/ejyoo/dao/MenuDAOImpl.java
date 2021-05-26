package ejyoo.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ejyoo.dao.interfaces.IMenuDAO;
import ejyoo.dto.MenuVO;

public class MenuDAOImpl implements IMenuDAO {

	@Override
	public List<MenuVO> selectMainMenu(SqlSession session) throws SQLException {
		List<MenuVO> menuList = session.selectList("Menu-Mapper.selectMainMenu");
		return menuList;
	}

	@Override
	public List<MenuVO> selectSubMenu(SqlSession session, String mCode) throws SQLException {
		List<MenuVO> menuList = session.selectList("Menu-Mapper.selectSubMenu");
		return menuList;
	}

	@Override
	public MenuVO selectMenuByMcode(SqlSession session, String mCode) throws SQLException {
		MenuVO menu = session.selectOne("Menu-Mapper.selectMenuByMcode");
		return menu;
	}
	
}
