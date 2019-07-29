package spring.data.restaurant;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public class RestaurantIntroImageDto {
	private int restaurant_intro_image_pk;
	private int restaurant_rest_pk;
	private String restaurant_intro_image;
	private String restaurant_intro_image_realpath;
	private int restaurant_intro_image_size;
	private String restaurant_intro_image_realname;
	private int restaurant_intro_priority;
	private ArrayList<MultipartFile> upfile;
	
	public int getRestaurant_intro_image_pk() {
		return restaurant_intro_image_pk;
	}
	public void setRestaurant_intro_image_pk(int restaurant_intro_image_pk) {
		this.restaurant_intro_image_pk = restaurant_intro_image_pk;
	}
	public int getRestaurant_rest_pk() {
		return restaurant_rest_pk;
	}
	public void setRestaurant_rest_pk(int restaurant_rest_pk) {
		this.restaurant_rest_pk = restaurant_rest_pk;
	}
	public String getRestaurant_intro_image() {
		return restaurant_intro_image;
	}
	public void setRestaurant_intro_image(String restaurant_intro_image) {
		this.restaurant_intro_image = restaurant_intro_image;
	}
	public String getRestaurant_intro_image_realpath() {
		return restaurant_intro_image_realpath;
	}
	public void setRestaurant_intro_image_realpath(String restaurant_intro_image_realpath) {
		this.restaurant_intro_image_realpath = restaurant_intro_image_realpath;
	}
	public int getRestaurant_intro_image_size() {
		return restaurant_intro_image_size;
	}
	public void setRestaurant_intro_image_size(int restaurant_intro_image_size) {
		this.restaurant_intro_image_size = restaurant_intro_image_size;
	}
	public String getRestaurant_intro_image_realname() {
		return restaurant_intro_image_realname;
	}
	public void setRestaurant_intro_image_realname(String restaurant_intro_image_realname) {
		this.restaurant_intro_image_realname = restaurant_intro_image_realname;
	}
	public int getRestaurant_intro_priority() {
		return restaurant_intro_priority;
	}
	public void setRestaurant_intro_priority(int restaurant_intro_priority) {
		this.restaurant_intro_priority = restaurant_intro_priority;
	}
	public ArrayList<MultipartFile> getUpfile() {
		return upfile;
	}
	public void setUpfile(ArrayList<MultipartFile> upfile) {
		this.upfile = upfile;
	}
}
