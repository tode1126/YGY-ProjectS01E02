package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.data.AdminDao;
import spring.data.UserDto;
import spring.data.UserSearchDto;
import spring.data.noticeDto;
import spring.data.restaurant.RestaurantDto;

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

	public void foodStateChange(RestaurantDto dto) {
		dao.foodStateChange(dto);
		return;
	}

	public void foodLeaveChange(RestaurantDto dto) {
		dao.foodLeaveChange(dto);
		return;
	}
	
	public int allFoodTotalCount() {
		return dao.allFoodTotalCount();
	}
	
	public int leaveFoodTotalCount() {
		return dao.leaveFoodTotalCount();
	}
	
	public int searchAllFoodTotalCount(String targetEmail) {
		return dao.searchAllFoodTotalCount(targetEmail);
	}
	
	public int searchLeaveFoodTotalCount(String targetEmail) {
		return dao.searchLeaveFoodTotalCount(targetEmail);
	}
	
	public List<RestaurantDto> allFoodList(int perPage, int no) {
		return dao.allFoodList(perPage,no);
	}
	
	public List<RestaurantDto> leaveFoodList(int perPage, int no) {
		return dao.leaveFoodList(perPage,no);
	}
	
	public List<RestaurantDto> searchAllFoodList(UserSearchDto dto) {
		return dao.searchAllFoodList(dto);

	}
	
	public List<RestaurantDto> searchLeaveFoodList(UserSearchDto dto) {
		return dao.searchLeaveFoodList(dto);
	}
	
	public int selectRestaurantCount(int rest_pk) {
		return dao.selectRestaurantCount(rest_pk);
	}
	
	public int userSelectCount(String email) {
		return dao.userSelectCount(email);
	}
	
	public List<noticeDto> notice_boardList(int perPage, int no){
		return dao.notice_boardList(perPage,no);
	}
	
	public int notice_boardTotalCount() {
		return dao.notice_boardTotalCount();
	}
	
	public void notice_boardListEdit(noticeDto dto) {
		dao.notice_boardListEdit(dto);
		return;
	}
	
	public void notice_boardDelete(int notice_pk) {
		dao.notice_boardDelete(notice_pk);
		return;
	}
	
	public int notice_boardListSelectCount(int notice_pk) {
		return dao.notice_boardListSelectCount(notice_pk);
	}
	
	public noticeDto notice_boardListSelect(int notice_pk) {
		return dao.notice_boardListSelect(notice_pk);
	}
	
	public void notice_boardListUpdate(noticeDto dto) {
		dao.notice_boardListUpdate(dto);
		return;
	}
}
