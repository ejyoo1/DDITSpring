package ejyoo.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.vo.MemberVO;

public interface IMemberDao {
	/**
	 * 로그인할 ID가 존재하는지 확인하는 다오
	 * @param smc SqlMapClient 객체
	 * @param mv 로그인 ID를 담은 MemberVO 객체
	 * @return cnt 수 반환
	 */
	public boolean memberSearchId(SqlMapClient smc, MemberVO mv) throws SQLException;
	
	/**
	 * 로그인할 ID의 PW가 존재하는지 확인하는 다오
	 * @param smc SqlMapClient 객체
	 * @param mv 로그인 ID와 PW를 담은 MemberVO 객체
	 * @return cnt 수 반환
	 */
	public boolean memberSearchPw(SqlMapClient smc, MemberVO mv) throws SQLException;
	
	/**
	 * 로그인 ID, PW를 담은 MemberVO를 가져오는 다오
	 * @param smc 로그인ID, PW 정보를 담은 MemberVO 객체
	 * @param mv 로그인 ID와 PW를 담은 MemberVO 객체
	 * @return 회원정보 반환
	 */
	public MemberVO memberSearch(SqlMapClient smc, MemberVO mv) throws SQLException;
}
