package spring.data.restaurant;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantDao extends SqlSessionDaoSupport {
	public void insertRestaurant(RestaurantDto dto) {
		getSqlSession().insert("restaurant.restaurantInsert", dto);
	}
	public int selectRestPkByEmail(String email) {
		int rest_pk = getSqlSession().selectOne("restaurant.restaurant_pkByEmailSelect", email);
		return rest_pk;
	}
	public List<RestaurantDto> selectRestaurantListByEmail(String email) {
		List<RestaurantDto> list = getSqlSession().selectList("restaurant.restaurantListByEmailSelect", email);
		return list;
	}
}