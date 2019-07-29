package spring.data.restaurant;

public class RestaurantTableDto {
	private int restaurant_rest_pk;
	private int table_tot_num;
	private String table_filename;
	private String table_realpath;
	
	public int getRestaurant_rest_pk() {
		return restaurant_rest_pk;
	}
	public void setRestaurant_rest_pk(int restaurant_rest_pk) {
		this.restaurant_rest_pk = restaurant_rest_pk;
	}
	public int getTable_tot_num() {
		return table_tot_num;
	}
	public void setTable_tot_num(int table_tot_num) {
		this.table_tot_num = table_tot_num;
	}
	public String getTable_filename() {
		return table_filename;
	}
	public void setTable_filename(String table_filename) {
		this.table_filename = table_filename;
	}
	public String getTable_realpath() {
		return table_realpath;
	}
	public void setTable_realpath(String table_realpath) {
		this.table_realpath = table_realpath;
	}
}
