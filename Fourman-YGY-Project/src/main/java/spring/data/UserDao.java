package spring.data;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends SqlSessionDaoSupport {
	public int userSelectCount(String email) {
		int n = getSqlSession().selectOne("user.userSelectCount",email);
		return n;
	}
	public int userNickCount(String nickName) {
		int n = getSqlSession().selectOne("user.userNickCount",nickName);
		return n;
	}
	public UserDto userGradeCheck(String email,String pass) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("pass",pass);
		UserDto n = getSqlSession().selectOne("user.userGradeCheck", map);
		return n;
	}
	public void userInsert(UserDto dto) {
		getSqlSession().insert("user.userInsert",dto);
		return;
	}
	public void userStateUpdate(String email) {
		getSqlSession().update("user.userStateUpdate", email);
		return;
	}
	public int userLoginCheck(String email,String pass) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email",email);
		map.put("pass",pass);
		return getSqlSession().selectOne("user.userLoginCheck", map);
	}
	public void userMailPassSet(String email,String pass) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email",email);
		map.put("pass",pass);
		getSqlSession().update("user.userMailPassSet",map);
		return ;				
	}
	public UserDto userUpdateDataGet(String email) {
		UserDto dto = getSqlSession().selectOne("user.userUpdateDataGet", email);
		return dto;
	}
	public void userUpdate(UserDto dto) {
		getSqlSession().update("user.userUpdate",dto);
		return;
	}
	public void userLeave(String email) {
		getSqlSession().update("user.userLeave", email);
	}
}
