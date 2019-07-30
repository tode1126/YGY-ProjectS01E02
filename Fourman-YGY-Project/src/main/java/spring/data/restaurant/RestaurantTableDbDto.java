package spring.data.restaurant;

public class RestaurantTableDbDto {
	private int restaurant_table_pk;
	private int restaurant_rest_pk;
	private String restaurant_table_status;
	private int restaurant_table_no;
	private String restaurant_table_pw;
	private String restaurant_table_res;
	private String restaurant_table_res_name;
	public int getRestaurant_table_pk() {
		return restaurant_table_pk;
	}
	public void setRestaurant_table_pk(int restaurant_table_pk) {
		this.restaurant_table_pk = restaurant_table_pk;
	}
	public int getRestaurant_rest_pk() {
		return restaurant_rest_pk;
	}
	public void setRestaurant_rest_pk(int restaurant_rest_pk) {
		this.restaurant_rest_pk = restaurant_rest_pk;
	}
	public String getRestaurant_table_status() {
		return restaurant_table_status;
	}
	public void setRestaurant_table_status(String restaurant_table_status) {
		this.restaurant_table_status = restaurant_table_status;
	}
	public int getRestaurant_table_no() {
		return restaurant_table_no;
	}
	public void setRestaurant_table_no(int restaurant_table_no) {
		this.restaurant_table_no = restaurant_table_no;
	}
	public String getRestaurant_table_pw() {
		return restaurant_table_pw;
	}
	public void setRestaurant_table_pw(String restaurant_table_pw) {
		this.restaurant_table_pw = restaurant_table_pw;
	}
	public String getRestaurant_table_res() {
		return restaurant_table_res;
	}
	public void setRestaurant_table_res(String restaurant_table_res) {
		this.restaurant_table_res = restaurant_table_res;
	}
	public String getRestaurant_table_res_name() {
		return restaurant_table_res_name;
	}
	public void setRestaurant_table_res_name(String restaurant_table_res_name) {
		this.restaurant_table_res_name = restaurant_table_res_name;
	}
}
