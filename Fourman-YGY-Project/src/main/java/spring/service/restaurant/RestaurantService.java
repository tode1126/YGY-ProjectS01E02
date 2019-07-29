package spring.service.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.data.restaurant.RestaurantDao;
import spring.data.restaurant.RestaurantDto;
import spring.data.restaurant.RestaurantIntroDao;
import spring.data.restaurant.RestaurantIntroDto;
import spring.data.restaurant.RestaurantIntroImageDto;
import spring.data.restaurant.RestaurantMenuDao;
import spring.data.restaurant.RestaurantMenuDto;
import spring.data.restaurant.RestaurantTableDao;

@Service
public class RestaurantService {
	@Autowired
	private RestaurantDao rdao;
	@Autowired
	private RestaurantMenuDao rmdao;
	@Autowired
	private RestaurantTableDao rtdao;
	@Autowired
	private RestaurantIntroDao ridao;
	
	/*** 식당 관련 서비스*/
	public void insertRestaurant(RestaurantDto dto) {
		rdao.insertRestaurant(dto);
	}
	public int selectRestPkByEmail(String email) {
		int rest_pk = rdao.selectRestPkByEmail(email);
		return rest_pk;
	}
	public List<RestaurantDto> selectRestaurantListByEmail(String email) {
		return rdao.selectRestaurantListByEmail(email);
	}
	
	/*** 메뉴 관련 서비스*/
	public void insertRestaurantMenu(RestaurantMenuDto rmdto) {
		rmdao.insertRestaurantMenu(rmdto);
	}
	public int selectCountRestaurantMenu(int Restaurant_rest_pk) {
		return rmdao.selectCountRestaurantMenu(Restaurant_rest_pk);
	}
	public List<RestaurantMenuDto> selectRestaurantMenu(int Restaurant_rest_pk) {
		return rmdao.selectRestaurantMenu(Restaurant_rest_pk);
	}
	public RestaurantMenuDto selectOneRestaurantMenu(int menu_pk) {
		return rmdao.selectOneRestaurantMenu(menu_pk);
	}
	public void updateRestaurantMenuImage(RestaurantMenuDto rmdto) {
		rmdao.updateRestaurantMenuImage(rmdto);
	}
	public void updateRestaurantMenuContent(RestaurantMenuDto rmdto) {
		rmdao.updateRestaurantMenuContent(rmdto);
	}
	public void deleteRestaurantMenu(int menu_pk) {
		rmdao.deleteRestaurantMenu(menu_pk);
	}
	
	/*** 테이블 관련 서비스*/
	public int selectIsRestaurantTable(int restaurant_rest_pk) {
		return rtdao.selectIsRestaurantTable(restaurant_rest_pk);
	}
	
	
	/*** 식당 소개 관련 서비스*/
	public int selectIsRestaurantIntro (int restaurant_rest_pk) {
		return ridao.selectIsRestaurantIntro(restaurant_rest_pk);
	}
	public void insertRestaurantIntro (RestaurantIntroDto ridto) {
		ridao.insertRestaurantIntro(ridto);
	}
	public void insertRestaurantIntroImage (RestaurantIntroImageDto riimgdto) {
		ridao.insertRestaurantIntroImage(riimgdto);
	}
	public RestaurantIntroDto selectOneRestaurantIntro (int restaurant_rest_pk) {
		return ridao.selectOneRestaurantIntro(restaurant_rest_pk);
	}
	public int selectIsRestaurantIntroImage (int restaurant_rest_pk) {
		return ridao.selectIsRestaurantIntroImage(restaurant_rest_pk);
	}
	public List<RestaurantIntroImageDto> selectListRestaurantIntroImage (int restaurant_rest_pk) {
		return ridao.selectListRestaurantIntroImage(restaurant_rest_pk);
	}
	public void updateRestaurantIntro(RestaurantIntroDto ridto) {
		ridao.updateRestaurantIntro(ridto);
	}
	public int selectRestaurantIntroImageMaxPriority (int restaurant_rest_pk) {
		return ridao.selectRestaurantIntroImageMaxPriority(restaurant_rest_pk);
	}
}
