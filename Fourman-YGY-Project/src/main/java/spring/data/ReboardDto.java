package spring.data;

import java.sql.Timestamp;

public class ReboardDto {
	private int reboard_pk;
	private String user_info_nickname;
	private String user_info_email;
	private int restaurant_rest_pk;
	private String reboard_subject;
	private String reboard_content;
	private int reboard_rating;
	private int readcount;
	private int groupno;
	private int restep;
	private int relevel;
	private int reboard_ref;
	private Timestamp reboard_writedate;
	private int reboard_happy;
	private int reboard_unhappy;
	
	public int getReboard_pk() {
		return reboard_pk;
	}
	public void setReboard_pk(int reboard_pk) {
		this.reboard_pk = reboard_pk;
	}
	public String getUser_info_nickname() {
		return user_info_nickname;
	}
	public void setUser_info_nickname(String user_info_nickname) {
		this.user_info_nickname = user_info_nickname;
	}
	public String getUser_info_email() {
		return user_info_email;
	}
	public void setUser_info_email(String user_info_email) {
		this.user_info_email = user_info_email;
	}
	public int getRestaurant_rest_pk() {
		return restaurant_rest_pk;
	}
	public void setRestaurant_rest_pk(int restaurant_rest_pk) {
		this.restaurant_rest_pk = restaurant_rest_pk;
	}
	public String getReboard_subject() {
		return reboard_subject;
	}
	public void setReboard_subject(String reboard_subject) {
		this.reboard_subject = reboard_subject;
	}
	public String getReboard_content() {
		return reboard_content;
	}
	public void setReboard_content(String reboard_content) {
		this.reboard_content = reboard_content;
	}
	public int getReboard_rating() {
		return reboard_rating;
	}
	public void setReboard_rating(int reboard_rating) {
		this.reboard_rating = reboard_rating;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getGroupno() {
		return groupno;
	}
	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}
	public int getRestep() {
		return restep;
	}
	public void setRestep(int restep) {
		this.restep = restep;
	}
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}
	public int getReboard_ref() {
		return reboard_ref;
	}
	public void setReboard_ref(int reboard_ref) {
		this.reboard_ref = reboard_ref;
	}
	public Timestamp getReboard_writedate() {
		return reboard_writedate;
	}
	public void setReboard_writedate(Timestamp reboard_writedate) {
		this.reboard_writedate = reboard_writedate;
	}
	public int getReboard_happy() {
		return reboard_happy;
	}
	public void setReboard_happy(int reboard_happy) {
		this.reboard_happy = reboard_happy;
	}
	public int getReboard_unhappy() {
		return reboard_unhappy;
	}
	public void setReboard_unhappy(int reboard_unhappy) {
		this.reboard_unhappy = reboard_unhappy;
	}
		
}

