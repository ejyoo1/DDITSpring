package ejyoo.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ejyoo.dto.MemberVO;

public interface IMemberDAO {
	List<MemberVO> selectMemberList(SqlSession session) throws SQLException;
	
	// VO 멤버 리스트
	List<MemberVO> selectMemberListByInfo(SqlSession session, MemberVO memberVo) throws SQLException;
	
	// VO 멤버 조회
	MemberVO selectMemberByInfo(SqlSession session, MemberVO memberVo) throws SQLException;
	
	// userId 멤버 조회
	MemberVO selectMemberById(SqlSession session, String userId) throws SQLException;
	
	// 멤버 등록
	int insertMemberByInfo(SqlSession session, MemberVO memberVo) throws SQLException;
	
	// 멤버 업데이트
	int updateMemberByInfo(SqlSession session, MemberVO memberVo) throws SQLException;
	
	// 멤버 삭제
	int deleteMemberById(SqlSession session, String userId) throws SQLException;
}
