package spring.data.restaurant;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantIntroDao extends SqlSessionDaoSupport {
	public int selectIsRestaurantIntro (int restaurant_rest_pk) {
		return getSqlSession().selectOne("restaurant.is_restaurant_introCountSelect", restaurant_rest_pk);
	}
	public void insertRestaurantIntro (RestaurantIntroDto ridto) {
		getSqlSession().insert("restaurant_introInsert", ridto);
	}
	public void insertRestaurantIntroImage (RestaurantIntroImageDto riimgdto) {
		getSqlSession().insert("restaurant_intro_imageInsert", riimgdto);
	}
	public RestaurantIntroDto selectOneRestaurantIntro (int restaurant_rest_pk) {
		return getSqlSession().selectOne("restaurant_introOneSelect", restaurant_rest_pk);
	}
	public int selectIsRestaurantIntroImage (int restaurant_rest_pk) {
		return getSqlSession().selectOne("is_restaurant_intro_ImageCountSelect", restaurant_rest_pk);
	}
	public List<RestaurantIntroImageDto> selectListRestaurantIntroImage (int restaurant_rest_pk) {
		return getSqlSession().selectList("restaurant_intro_imageListByRestPkSelect", restaurant_rest_pk);
	}
	public void updateRestaurantIntro(RestaurantIntroDto ridto) {
		getSqlSession().update("restaurant_introUpdate", ridto);
	}
	public int selectRestaurantIntroImageMaxPriority (int restaurant_rest_pk) {
		return getSqlSession().selectOne("restaurant_intro_imageMaxPrioritySelect", restaurant_rest_pk);
	}
}
