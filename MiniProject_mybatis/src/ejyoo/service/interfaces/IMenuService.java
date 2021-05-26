package ejyoo.service.interfaces;

import java.sql.SQLException;
import java.util.List;

import ejyoo.dto.MenuVO;

public interface IMenuService {
	
	List<MenuVO> getMainMenuList() throws SQLException;
	
	List<MenuVO> getSubMenuList(String mCode) throws SQLException;
	
	MenuVO getMenuByMcode(String mCode) throws SQLException;
	
}
