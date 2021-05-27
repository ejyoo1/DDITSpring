package kr.or.ddit.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ejyoo.dao.MenuDAO;
import ejyoo.dao.MenuDAOImpl;
import ejyoo.dto.MenuVO;
import ejyoo.mybatis.OracleMyBatisSqlSessionFactory;

public class TestMenuDAOImpl {

	private SqlSession session;
	private MenuDAO menuDAO;
	
	@Before
	public void init() {
		session = new OracleMyBatisSqlSessionFactory().openSession(false);
		menuDAO = new MenuDAOImpl();
	}
	
	@Test
	public void testSelectMainMenu() throws Exception{
		List<MenuVO> menuList = menuDAO.selectMainMenu(session);
		Assert.assertEquals(5, menuList.size());
	}
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
}
