package ejyoo.service;

import com.servlet.vo.MemberVO;

public interface IMemberService {
	
	/**
	 * 로그인할 ID가 존재하는지 확인하는 서비스
	 * @param mv 로그인 ID를 담은 MemberVO 객체
	 * @return cnt 수 반환
	 */
	public boolean memberSearchId(MemberVO mv);
	
	/**
	 * 로그인할 ID의 PW가 존재하는지 확인하는 서비스
	 * @param mv 로그인 ID와 PW를 담은 MemberVO 객체
	 * @return cnt 수 반환
	 */
	public boolean memberSearchPw(MemberVO mv);
	
	/**
	 * 로그인 ID, PW를 담은 MemberVO를 가져오는 서비스
	 * @param mv 로그인ID, PW 정보를 담은 MemberVO 객체
	 * @return 회원정보 반환
	 */
	public MemberVO memberSearch(MemberVO mv);
}
