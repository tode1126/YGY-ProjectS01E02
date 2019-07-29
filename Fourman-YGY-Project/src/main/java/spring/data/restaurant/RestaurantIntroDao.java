package spring.data.restaurant;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantIntroDao extends SqlSessionDaoSupport {
	public int selectIsRestaurantIntro (int restaurant_rest_pk) {
		return getSqlSession().selectOne("restaurant.is_restaurant_introCountSelect", restaurant_rest_pk);
	}
}
