package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.MenuVO;

public class MenuDAOImpl implements MenuDAO{

	@Override
	public List<MenuVO> selectMainMenu(SqlSession session) throws SQLException {
		List<MenuVO> menuVoList = session.selectList("Menu-Mapper.selectMainMenu");
		return menuVoList;
	}

	@Override
	public List<MenuVO> selectSubMenu(SqlSession session, String mCode) throws SQLException {
		List<MenuVO> menuVoList = session.selectList("Menu-Mapper.selectSubMenu", mCode);
		return menuVoList;
	}

	@Override
	public MenuVO selectMenuByMcode(SqlSession session, String mCode) throws SQLException {
		MenuVO menuVo = session.selectOne("Menu-Mapper.selectMenuByMcode", mCode);
		return menuVo;
	}

}
