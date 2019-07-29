package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.data.UserDao;
import spring.data.UserDto;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	public int userSelectCount(String email) {
		return dao.userSelectCount(email);
	}
	
	public int userNickCount(String nickName) {
		return dao.userNickCount(nickName);
	}
	
	public UserDto userGradeCheck(String email,String pass) {
		UserDto dto = dao.userGradeCheck(email, pass);
		return dto;
	}
	public void userInsert(UserDto dto) {
		dao.userInsert(dto);
		return;
	}
	public void userStateUpdate(String email) {
		dao.userStateUpdate(email);
		return;
	}
	public int userLoginCheck(String email,String pass) {
		return dao.userLoginCheck(email, pass);
	}
	public void userMailPassSet(String email,String pass) {
		dao.userMailPassSet(email, pass);
		return;
	}
	public UserDto userUpdateDataGet(String email) {
		UserDto dto = dao.userUpdateDataGet(email);
		return dto;
	}
	public void userUpdate(UserDto dto) {
		dao.userUpdate(dto);
		return;
	}
	public void userLeave(String email) {
		dao.userLeave(email);
		return;
	}
}
