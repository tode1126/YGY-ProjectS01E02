package spring.data.restaurant;

import java.sql.Timestamp;

public class RestaurantDto {
	private int rest_pk;
	private String user_info_email;
	private String rest_name;
	private String rest_category;
	private String rest_phone;
	private String rest_addr;
	private String rest_start;
	private String rest_end;
	private int rest_state;
	private Timestamp rest_regdate;
	
	public int getRest_pk() {
		return rest_pk;
	}
	public void setRest_pk(int rest_pk) {
		this.rest_pk = rest_pk;
	}
	public String getUser_info_email() {
		return user_info_email;
	}
	public void setUser_info_email(String user_info_email) {
		this.user_info_email = user_info_email;
	}
	public String getRest_name() {
		return rest_name;
	}
	public void setRest_name(String rest_name) {
		this.rest_name = rest_name;
	}
	public String getRest_category() {
		return rest_category;
	}
	public void setRest_category(String rest_category) {
		this.rest_category = rest_category;
	}
	public String getRest_phone() {
		return rest_phone;
	}
	public void setRest_phone(String rest_phone) {
		this.rest_phone = rest_phone;
	}
	public String getRest_addr() {
		return rest_addr;
	}
	public void setRest_addr(String rest_addr) {
		this.rest_addr = rest_addr;
	}
	public String getRest_start() {
		return rest_start;
	}
	public void setRest_start(String rest_start) {
		this.rest_start = rest_start;
	}
	public String getRest_end() {
		return rest_end;
	}
	public void setRest_end(String rest_end) {
		this.rest_end = rest_end;
	}
	public int getRest_state() {
		return rest_state;
	}
	public void setRest_state(int rest_state) {
		this.rest_state = rest_state;
	}
	public Timestamp getRest_regdate() {
		return rest_regdate;
	}
	public void setRest_regdate(Timestamp rest_regdate) {
		this.rest_regdate = rest_regdate;
	}
}
