package spring.data.restaurant;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantAuthorityDao extends SqlSessionDaoSupport {
	public int selectIsRestaurantAuthority(int restaurant_rest_pk) {
		return getSqlSession().selectOne("is_restaurant_authoritySelect", restaurant_rest_pk);
	}
	public void insertRestaurantAuthority(RestaurantAuthorityDto radto) {
		getSqlSession().insert("restaurant_authorityInsert", radto);
	}
	public RestaurantAuthorityDto selectRestaurantAuthority(int restaurant_rest_pk) {
		return getSqlSession().selectOne("restaurant_authoritySelect", restaurant_rest_pk);
	}
	public void updateRestaurantAuthority(RestaurantAuthorityDto radto) {
		getSqlSession().update("restaurant_authorityUpdate", radto);
	}
}
