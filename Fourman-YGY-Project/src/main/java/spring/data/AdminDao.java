package spring.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao extends SqlSessionDaoSupport {
	public List<UserDto> allUserList(int perPage, int no) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage", perPage);
		map.put("no", no);
		return getSqlSession().selectList("admin.allUserList", map);
	}

	public List<UserDto> leaveUserList(int perPage, int no) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage", perPage);
		map.put("no", no);
		return getSqlSession().selectList("admin.leaveUserList", map);
	}

	public List<UserDto> allFoodUserList(int perPage, int no) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage", perPage);
		map.put("no", no);
		return getSqlSession().selectList("admin.allFoodUserList", map);
	}

	public List<UserDto> leaveFoodUserList(int perPage, int no) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage", perPage);
		map.put("no", no);
		return getSqlSession().selectList("admin.leaveFoodUserList", map);
	}

	public List<UserDto> adminList(int perPage, int no) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage", perPage);
		map.put("no", no);
		return getSqlSession().selectList("admin.adminList", map);
	}

	public int allUserTotalCount() {
		return getSqlSession().selectOne("admin.allUserTotalCount");
	}

	public int leaveUserTotalCount() {
		return getSqlSession().selectOne("admin.leaveUserTotalCount");
	}

	public int allFoodUserTotalCount() {
		return getSqlSession().selectOne("admin.allFoodUserTotalCount");
	}

	public int leaveFoodUserTotalCount() {
		return getSqlSession().selectOne("admin.leaveFoodUserTotalCount");
	}

	public int adminListTotalCount() {
		return getSqlSession().selectOne("admin.adminListTotalCount");
	}

	public void userEnable(String email) {
		getSqlSession().update("admin.userEnable", email);
		return;
	}

	public void userDisable(String email) {
		getSqlSession().update("admin.userDisable", email);
		return;
	}

	public int adminCheck(String email) {
		return getSqlSession().selectOne("admin.adminCheck", email);
	}

	public void userUpdate(String email) {
		getSqlSession().update("admin.userUpdate", email);
		return;
	}

	public void adminUpdate(String email) {
		getSqlSession().update("admin.adminUpdate", email);
		return;
	}

	public List<UserDto> mailGetList(int target) {
		return getSqlSession().selectList("admin.mailGetList", target);
	}

	public List<UserDto> searchUser(UserSearchDto dto) {
		return getSqlSession().selectList("admin.searchUser", dto);
	}

	public List<UserDto> searchLeaveUser(UserSearchDto dto) {
		return getSqlSession().selectList("admin.searchLeaveUser", dto);
	}

	public List<UserDto> searchFoodUser(UserSearchDto dto) {
		return getSqlSession().selectList("admin.searchFoodUser", dto);
	}

	public List<UserDto> searchLeaveFoodUser(UserSearchDto dto) {
		return getSqlSession().selectList("admin.searchLeaveFoodUser", dto);
	}

	public int searchUserTotalCount(String targetEmail) {
		return getSqlSession().selectOne("admin.searchUserTotalCount", targetEmail);
	}

	public int searchLeaveUserTotalCount(String targetEmail) {
		return getSqlSession().selectOne("admin.searchLeaveUserTotalCount", targetEmail);
	}

	public int searchFoodUserTotalCount(String targetEmail) {
		return getSqlSession().selectOne("admin.searchFoodUserTotalCount", targetEmail);
	}

	public int searchLeaveFoodUserTotalCount(String targetEmail) {
		return getSqlSession().selectOne("admin.searchLeaveFoodUserTotalCount", targetEmail);
	}
	
	//해당 dto 타입을 반환값으로
	public void allFoodList() {
		getSqlSession().selectList("admin.allFoodList");
		return;
	}
	//해당 dto 타입을 반환값으로
	public void leaveFoodList() {
		getSqlSession().selectList("admin.leaveFoodList");
		return;
	}
	//해당 dto 타입을 반환값으로
	public void searchAllFoodList() {
		getSqlSession().selectList("admin.searchAllFoodList");
		return;
	}
	//해당 dto 타입을 반환값으로
	public void searchLeaveFoodList() {
		getSqlSession().selectList("admin.searchLeaveFoodList");
		return;
	}
	
	//해당 dto 타입을 인자로
	public void foodStateChange() {
		getSqlSession().update("admin.foodStateChange");
		return;
	}
	//해당 dto 타입을 인자로
	public void foodLeaveChange() {
		getSqlSession().update("admin.foodLeaveChange");
		return;
	}
	
	public int allFoodTotalCount() {
		return getSqlSession().selectOne("admin.allFoodTotalCount");
	}
	
	public int leaveFoodTotalCount() {
		return getSqlSession().selectOne("admin.leaveFoodTotalCount");
	}
	
	public int searchAllFoodTotalCount() {
		return getSqlSession().selectOne("admin.searchAllFoodTotalCount");
	}
	
	public int searchLeaveFoodTotalCount() {
		return getSqlSession().selectOne("admin.searchLeaveFoodTotalCount");
	}
	
	public int selectRestaurantCount(int rest_pk) {
		return getSqlSession().selectOne("admin.selectRestaurantCount",rest_pk);
	}
	
	public int userSelectCount(String email) {
		return getSqlSession().selectOne("admin.userSelectCount",email);
	}
}
