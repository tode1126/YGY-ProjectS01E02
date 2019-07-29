package spring.data.restaurant;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public class RestaurantMenuDto {
	private int menu_pk;
	private int restaurant_rest_pk;
	private String menu_category;
	private String menu_name;
	private int menu_price;
	private String menu_desc;
	private String menu_imagefile;
	private String menu_image_realname;
	private String menu_image_realpath;
	private int menu_image_size;
	private ArrayList<MultipartFile> upfile;
	
	public int getMenu_pk() {
		return menu_pk;
	}
	public void setMenu_pk(int menu_pk) {
		this.menu_pk = menu_pk;
	}
	public int getRestaurant_rest_pk() {
		return restaurant_rest_pk;
	}
	public void setRestaurant_rest_pk(int restaurant_rest_pk) {
		this.restaurant_rest_pk = restaurant_rest_pk;
	}
	public String getMenu_category() {
		return menu_category;
	}
	public void setMenu_category(String menu_category) {
		this.menu_category = menu_category;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getMenu_price() {
		return menu_price;
	}
	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
	}
	public String getMenu_desc() {
		return menu_desc;
	}
	public void setMenu_desc(String menu_desc) {
		this.menu_desc = menu_desc;
	}
	public String getMenu_imagefile() {
		return menu_imagefile;
	}
	public void setMenu_imagefile(String menu_imagefile) {
		this.menu_imagefile = menu_imagefile;
	}
	public ArrayList<MultipartFile> getUpfile() {
		return upfile;
	}
	public void setUpfile(ArrayList<MultipartFile> upfile) {
		this.upfile = upfile;
	}
	public String getMenu_image_realname() {
		return menu_image_realname;
	}
	public void setMenu_image_realname(String menu_image_realname) {
		this.menu_image_realname = menu_image_realname;
	}
	public String getMenu_image_realpath() {
		return menu_image_realpath;
	}
	public void setMenu_image_realpath(String menu_image_realpath) {
		this.menu_image_realpath = menu_image_realpath;
	}
	public int getMenu_image_size() {
		return menu_image_size;
	}
	public void setMenu_image_size(int menu_image_size) {
		this.menu_image_size = menu_image_size;
	}
}
