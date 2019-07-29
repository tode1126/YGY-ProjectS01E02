package spring.controller;

import java.util.*;
import javax.servlet.http.*;

public class LoginManager implements HttpSessionBindingListener {

	private static LoginManager loginManager = null;

//로그인한 접속자를 담기위한 해시테이블
	private static Hashtable loginUsers = new Hashtable();

	public static synchronized LoginManager getInstance() {
		if (loginManager == null) {
			loginManager = new LoginManager();
		}
		return loginManager;
	}

//이 메소드는 세션이 연결되을때 호출된다.(session.setAttribute("login", this))* Hashtable에 세션과 접속자 아이디를 저장한다.
	public void valueBound(HttpSessionBindingEvent event) {
//session값을 put한다.
		loginUsers.put(event.getSession(), event.getName());
		System.out.println(event.getName() + "님이 로그인 하셨습니다.");
		System.out.println("현재 접속자 수 : " + getUserCount());
	}

// 이 메소드는 세션이 끊겼을때 호출된다.(invalidate) Hashtable에 저장된 로그인한 정보를 제거해 준다.
	public void valueUnbound(HttpSessionBindingEvent event) {
//session값을 찾아서 없애준다.
		loginUsers.remove(event.getSession());
		System.out.println(" " + event.getName() + "님이 로그아웃 하셨습니다.");
		System.out.println("현재 접속자 수 : " + getUserCount());
	}

//해시테이블에서 입력받은 아이디 삭제
	public void removeSession(String userId) {
		Enumeration e = loginUsers.keys();
		HttpSession session = null;
		while (e.hasMoreElements()) {
			session = (HttpSession) e.nextElement();
			if (loginUsers.get(session).equals(userId)) {
//세션이 invalidate될때 HttpSessionBindingListener를 
//구현하는 클레스의 valueUnbound()함수가 호출된다.
				session.invalidate();
			}
		}
	}

//추후를 대비해 남겨줌
	public boolean isValid(String userId, String userPw) {

//db 로직
		return true;
	}

//사용중인 아이디인지 true false 반환
	public boolean isUsing(String userID) {
		return loginUsers.containsValue(userID);
	}

//로그인을 완료한 사용자의 아이디를 세션에 저장하는 메소드
	public void setSession(HttpSession session, String userId) {
//이순간에 Session Binding이벤트가 일어나는 시점
//name값으로 userId, value값으로 자기자신(HttpSessionBindingListener를 구현하는 Object)
		session.setAttribute(userId, this);// login에 자기자신을 집어넣는다.
	}

//입력받은 세션Object로 아이디를 리턴한다.
	public String getUserID(HttpSession session) {
		return (String) loginUsers.get(session);
	}

//현재 접속한 총 사용자 수
	public int getUserCount() {
		return loginUsers.size();
	}

// 현재 접속중인 모든 사용자 아이디를 출력
	public void printloginUsers() {
		Enumeration e = loginUsers.keys();
		HttpSession session = null;
		System.out.println("===========================================");
		int i = 0;
		while (e.hasMoreElements()) {
			session = (HttpSession) e.nextElement();
			System.out.println((++i) + ". 접속자 : " + loginUsers.get(session));
		}
		System.out.println("===========================================");
	}

// 현재 접속중인 모든 사용자리스트를 리턴
	public Collection getUsers() {
		Collection collection = loginUsers.values();
		return collection;
	}

	public List<String> getUsersList() {
		Enumeration e = loginUsers.keys();
		HttpSession session = null;
		int i = 0;
		List<String> list = new ArrayList<String>();

		while (e.hasMoreElements()) {
			session = (HttpSession) e.nextElement();
			String str = (String) loginUsers.get(session);
			list.add(str);
		}
		return list;
	}

}