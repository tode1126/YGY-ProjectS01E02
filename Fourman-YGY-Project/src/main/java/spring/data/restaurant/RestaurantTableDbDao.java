package spring.data.restaurant;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantTableDbDao extends SqlSessionDaoSupport {
	public int selectIsRestaurantTableDb(int restaurant_rest_pk) {
		return getSqlSession().selectOne("is_restaurant_tableDbSelect", restaurant_rest_pk);
	}
	public void insertRestaurantTableDb(RestaurantTableDbDto rtdbdto) {
		getSqlSession().insert("restaurant_tableDbInsert", rtdbdto);
	}
	public void deleteRestaurantTableDb(int restaurant_rest_pk) {
		getSqlSession().delete("restaurant_tableDbDelete", restaurant_rest_pk);
	}
	public List<RestaurantTableDbDto> selectRestaurantTableDb (int restaurant_rest_pk) {
		List<RestaurantTableDbDto> list = getSqlSession().selectList("restaurant_tableDbSelect", restaurant_rest_pk);
		return list;
	}
}
