package ejyoo.service;

import java.sql.SQLException;
import java.util.List;

import ejyoo.dto.MenuVO;

public interface MenuService {
	
	List<MenuVO> getMainMenuList() throws SQLException;
	
	List<MenuVO> getSubMenuList(String mCode) throws SQLException;
	
	MenuVO getMenuByMcode(String mCode) throws SQLException;
	
}
