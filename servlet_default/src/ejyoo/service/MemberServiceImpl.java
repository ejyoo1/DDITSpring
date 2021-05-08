package ejyoo.service;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.util.SqlMapClientUtil;
import com.servlet.vo.MemberVO;

import ejyoo.dao.IMemberDao;
import ejyoo.dao.MemberDaoImpl;

public class MemberServiceImpl implements IMemberService{
	
	private IMemberDao memDao;
	private SqlMapClient smc;
	private static IMemberService memService;
	
	private MemberServiceImpl() {
		memDao = MemberDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
		
	}
	
	public static IMemberService getInstance() {
		if(memService == null) {
			memService = new MemberServiceImpl();
		}
		return memService;
	}

	@Override
	public boolean memberSearchId(MemberVO mv) {
		boolean chk = false;
		try {
			chk = memDao.memberSearchId(smc, mv);
			if(!chk) {
				throw new NotFoundIdException("아이디를 찾을 수 없습니다.");
			}
		} catch (NotFoundIdException e) {
			e.printStackTrace();
			return chk;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public boolean memberSearchPw(MemberVO mv) {
		boolean chk = false;
		try {
			chk = memDao.memberSearchPw(smc, mv);
			if(!chk) {
				throw new InvalidPasswordException("잘못된 패스워드입니다.");
			}
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
			return chk;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public MemberVO memberSearch(MemberVO mv) {
		MemberVO mv1 = null;
		try {
			mv1 = memDao.memberSearch(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv1;
	}
}

class NotFoundIdException extends Exception {
	NotFoundIdException(String msg){
		super(msg);
	}
}

class InvalidPasswordException extends Exception {
	InvalidPasswordException(String msg){
		super(msg);
	}
}
