package kr.or.ddit.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ejyoo.servlet.util.OracleMyBatisSqlSessionFactory;

public class TestOracleMyBatisSqlSessionFactory {
	private SqlSessionFactory factory = new OracleMyBatisSqlSessionFactory();
	
	private SqlSession session;
	
	@Before
	public void openSession() {
		session = factory.openSession();
	}
	
	@Test
	public void testSqlSession() throws Exception{
		Assert.assertNotNull(session.getConnection());
	}
	
	public void closeSession() {
		session.close();
	}
}
