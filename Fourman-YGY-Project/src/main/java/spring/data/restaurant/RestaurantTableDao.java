package spring.data.restaurant;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantTableDao extends SqlSessionDaoSupport {
	public int selectIsRestaurantTable(int restaurant_rest_pk) {
		int count = getSqlSession().selectOne("restaurant.is_restaurant_tableCountSelect", restaurant_rest_pk);
		return count;
	}
}
