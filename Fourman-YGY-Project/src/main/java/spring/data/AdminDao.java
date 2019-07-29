package spring.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.data.restaurant.RestaurantDto;

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
	

	public List<RestaurantDto> allFoodList(int perPage, int no) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage",perPage);
		map.put("no",no);
		return getSqlSession().selectList("admin.allFoodList",map);
	}

	public List<RestaurantDto> leaveFoodList(int perPage, int no) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage",perPage);
		map.put("no",no);
		return getSqlSession().selectList("admin.leaveFoodList",map);
	}

	public List<RestaurantDto> searchAllFoodList(UserSearchDto dto) {
		return getSqlSession().selectList("admin.searchAllFoodList",dto);
	}

	public List<RestaurantDto> searchLeaveFoodList(UserSearchDto dto) {
		return getSqlSession().selectList("admin.searchLeaveFoodList",dto);
	}
	

	public void foodStateChange(RestaurantDto dto) {
		getSqlSession().update("admin.foodStateChange",dto);
		return;
	}

	public void foodLeaveChange(RestaurantDto dto) {
		getSqlSession().update("admin.foodLeaveChange",dto);
		return;
	}
	
	public int allFoodTotalCount() {
		return getSqlSession().selectOne("admin.allFoodTotalCount");
	}
	
	public int leaveFoodTotalCount() {
		return getSqlSession().selectOne("admin.leaveFoodTotalCount");
	}
	
	public int searchAllFoodTotalCount(String targetEmail) {
		return getSqlSession().selectOne("admin.searchAllFoodTotalCount",targetEmail);
	}
	
	public int searchLeaveFoodTotalCount(String targetEmail) {
		return getSqlSession().selectOne("admin.searchLeaveFoodTotalCount",targetEmail);
	}
	
	public int selectRestaurantCount(int rest_pk) {
		return getSqlSession().selectOne("admin.selectRestaurantCount",rest_pk);
	}
	
	public int userSelectCount(String email) {
		return getSqlSession().selectOne("admin.userSelectCount",email);
	}
	
	public List<noticeDto> notice_boardList(int perPage, int no) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage",perPage);
		map.put("no",no);
		return getSqlSession().selectList("admin.notice_boardList",map);
	}
	
	public int notice_boardTotalCount() {
		return getSqlSession().selectOne("admin.notice_boardTotalCount");
	}
	
	public void notice_boardListEdit(noticeDto dto) {
		getSqlSession().insert("admin.notice_boardListEdit",dto);
		return;
	}
	
	public void notice_boardDelete(int notice_pk) {
		getSqlSession().delete("admin.notice_boardDelete",notice_pk);
		return;
	}
	
	public int notice_boardListSelectCount(int notice_pk) {
		return getSqlSession().selectOne("admin.notice_boardListSelectCount",notice_pk);
	}
	
	public noticeDto notice_boardListSelect(int notice_pk) {
		return getSqlSession().selectOne("admin.notice_boardListSelect",notice_pk);
	}
	
	public void notice_boardListUpdate(noticeDto dto) {
		getSqlSession().update("admin.notice_boardListUpdate",dto);
		return;
	}
	
	//반환 리스트 qna dto 타입 
	public void qna_boardList(int perPage, int no) {
		Map<String, Integer>map = new HashMap<String, Integer>();
		map.put("perPage", perPage);
		map.put("no", no);
		//return getSqlSession().selectList("admin.qna_boardList",map);
		return;
	}
	
	public int qna_boardListTotalCount() {
		return getSqlSession().selectOne("admin.qna_boardListTotalCount");
	}
	
	public int qna_boardListSelectCount(int qna_pk) {
		return getSqlSession().selectOne("admin.qna_boardListSelectCount",qna_pk);
	}
	
	public int qna_boardListContentSelect(int qna_pk) {
		return getSqlSession().selectOne("admin.qna_boardListContentSelect",qna_pk);
	}
	
	//파라미터 해당 dto
	public void qna_boardListDelete() {
		getSqlSession().update("admin.qna_boardListDelete" );
		return;
	}
	
	//파라미터 해당 dto
	public void qna_boardListReplyInsert() {
		getSqlSession().insert("admin.qna_boardListReplyInsert");
		return;
	}
	
	//파라미터 해당 dto
	public void qna_boardListContent(int qna_pk) {
		getSqlSession().selectOne("admin.qna_boardListContent", qna_pk);
		return;
	}
}
