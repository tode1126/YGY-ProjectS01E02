package spring.data.restaurant;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantMenuDao extends SqlSessionDaoSupport {
	public void insertRestaurantMenu(RestaurantMenuDto rmdto) {
		getSqlSession().insert("restaurant_menuInsert", rmdto);
	}
	public int selectCountRestaurantMenu(int restraunt_rest_pk) {
		return getSqlSession().selectOne("restaurant_menuCountSelect", restraunt_rest_pk);
	}
	public List<RestaurantMenuDto> selectRestaurantMenu(int restraunt_rest_pk) {
		return getSqlSession().selectList("restaurant_menuSelect", restraunt_rest_pk);
	}
	public RestaurantMenuDto selectOneRestaurantMenu(int menu_pk) {
		return getSqlSession().selectOne("one_restaurant_menuSelect", menu_pk);
	}
	public void updateRestaurantMenuImage(RestaurantMenuDto rmdto) {
		getSqlSession().update("restaurant_menuImageUpdate", rmdto);
	}
	public void updateRestaurantMenuContent(RestaurantMenuDto rmdto) {
		getSqlSession().update("restaurant_menuContentUpdate", rmdto);
	}
	public void deleteRestaurantMenu(int menu_pk) {
		getSqlSession().delete("restaurant_menuDelete", menu_pk);
	}
}
