package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.data.AdminDao;
import spring.data.UserDto;
import spring.data.UserSearchDto;

@Service
public class AdminService {

	@Autowired
	private AdminDao dao;

	public List<UserDto> allUserList(int perPage, int no) {
		return dao.allUserList(perPage, no);
	}

	public List<UserDto> leaveUserList(int perPage, int no) {
		return dao.leaveUserList(perPage, no);
	}

	public List<UserDto> allFoodUserList(int perPage, int no) {
		return dao.allFoodUserList(perPage, no);
	}

	public List<UserDto> leaveFoodUserList(int perPage, int no) {
		return dao.leaveFoodUserList(perPage, no);
	}

	public List<UserDto> adminList(int perPage, int no) {
		return dao.adminList(perPage, no);
	}

	public int allUserTotalCount() {
		return dao.allUserTotalCount();
	}

	public int leaveUserTotalCount() {
		return dao.leaveUserTotalCount();
	}

	public int allFoodUserTotalCount() {
		return dao.allFoodUserTotalCount();
	}

	public int leaveFoodUserTotalCount() {
		return dao.leaveFoodUserTotalCount();
	}

	public int adminListTotalCount() {
		return dao.adminListTotalCount();
	}

	public void userEnable(String email) {
		dao.userEnable(email);
		return;
	}

	public void userDisable(String email) {
		dao.userDisable(email);
		return;
	}

	public int adminCheck(String email) {
		return dao.adminCheck(email);
	}

	public void userUpdate(String email) {
		dao.userUpdate(email);
		return;
	}

	public void adminUpdate(String email) {
		dao.adminUpdate(email);
		return;
	}

	public List<UserDto> mailGetList(int target) {
		return dao.mailGetList(target);
	}
	
	public List<UserDto> searchUser(UserSearchDto dto){
		return dao.searchUser(dto);
	}
	
	public List<UserDto> searchLeaveUser(UserSearchDto dto){
		return dao.searchLeaveUser(dto);
	}
	
	public List<UserDto> searchFoodUser(UserSearchDto dto){
		return dao.searchFoodUser(dto);
	}
	
	public List<UserDto> searchLeaveFoodUser(UserSearchDto dto){
		return dao.searchLeaveFoodUser(dto);
	}
	
	public int searchUserTotalCount(String targetEmail){
		return dao.searchUserTotalCount(targetEmail);
	}
	
	public int searchLeaveUserTotalCount(String targetEmail){
		return dao.searchLeaveUserTotalCount(targetEmail);
	}
	
	public int searchFoodUserTotalCount(String targetEmail){
		return dao.searchFoodUserTotalCount(targetEmail);
	}
	
	public int searchLeaveFoodUserTotalCount(String targetEmail){
		return dao.searchLeaveFoodUserTotalCount(targetEmail);
	}
	//인자를 그쪾 dto 로
	public void foodStateChange() {
		dao.foodStateChange();
		return;
	}
	//인자를 그쪾 dto 로
	public void foodLeaveChange() {
		dao.foodLeaveChange();
		return;
	}
	
	public int allFoodTotalCount() {
		return dao.allFoodTotalCount();
	}
	
	public int leaveFoodTotalCount() {
		return dao.leaveFoodTotalCount();
	}
	
	public int searchAllFoodTotalCount() {
		return dao.searchAllFoodTotalCount();
	}
	
	public int searchLeaveFoodTotalCount() {
		return dao.searchLeaveFoodTotalCount();
	}
	
	//반환 dto 필요
	public void allFoodList() {
		dao.allFoodList();
		return;
	}
	
	//반환 dto 필요
	public void leaveFoodList() {
		dao.leaveFoodList();
		return;
	}
	
	//반환 dto 필요
	public void searchAllFoodList() {
		dao.searchAllFoodList();
		return;
	}
	
	//반환 dto 필요
	public void searchLeaveFoodList() {
		dao.searchLeaveFoodList();
		return;
	}
	
	public int selectRestaurantCount(int rest_pk) {
		return dao.selectRestaurantCount(rest_pk);
	}
	
	public int userSelectCount(String email) {
		return dao.userSelectCount(email);
	}
}
