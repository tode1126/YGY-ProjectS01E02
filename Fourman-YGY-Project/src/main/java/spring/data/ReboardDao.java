package spring.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository  //xml 에 자동 등록
public class ReboardDao extends SqlSessionDaoSupport{

	public int reboardListTotalCount() {
		return getSqlSession().selectOne("reboard.reboardListTotalCount");
	}
	
	public List<ReboardDto> reboardList(int perPage, int no){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage", perPage);
		map.put("no", no);
		
		return getSqlSession().selectList("reboard.reboardList", map);
	}
	
	public void reboardListHappyUpdate(int reboard_pk){
		getSqlSession().update("reboard.reboardListHappyUpdate",reboard_pk);
		return ;
	}
	
	public int reboardListHappySelect(int reboard_pk){
		return getSqlSession().selectOne("reboard.reboardListHappySelect",reboard_pk);
	}
	
	public void reboardListUnHappyUpdate(int reboard_pk) {
		getSqlSession().update("reboard.reboardListUnHappyUpdate",reboard_pk);
		return ;
	}
	
	public int reboardListUnHappySelect(int reboard_pk) {
		return getSqlSession().selectOne("reboard.reboardListUnHappySelect",reboard_pk);
	}
	
	public ReboardDto reboardListSelectContent(int reboard_pk) {
		return getSqlSession().selectOne("reboard.reboardListSelectContent", reboard_pk);
	}
	
	public int reboardListSelectCount(int reboard_pk) {
		return getSqlSession().selectOne("reboard.reboardListSelectCount", reboard_pk);
	}
	
	public void reboardListUpdateRestep(int groupno, int restep) {
		Map<String, Integer>map = new HashMap<String, Integer>();
		map.put("groupno", groupno);
		map.put("restep", restep);
		
		getSqlSession().update("reboard.reboardListUpdateRestep", map);
		return;
	}
	
	public int reboardListMaxPk() {
		return getSqlSession().selectOne("reboard.reboardListMaxPk");
	}
	
	public void reboardListInsert(ReboardDto dto) {
		int groupno=dto.getGroupno();
		int restep=dto.getRestep();
		int relevel=dto.getRelevel();
		int reboard_pk=dto.getReboard_pk();
		
		//답글인경우
		if(reboard_pk!=0) {
			//같은 그룹중 전달받은 restep 보다 큰 값은 1증가
			reboardListUpdateRestep(groupno, restep);
			//현재 저장할 데이타의 restep,relevel을 1증가
			restep++;
			relevel++;
		}else {//새글인 경우
			//현재 게시글이 없으면 그룹번호는 1로
			//있을경우에는 num의 최대값 +1 로 주기로한다
			if(reboardListTotalCount()==0)
				groupno=1;
			else
				groupno=reboardListMaxPk()+1;
			
			restep=0;
			relevel=0;
		}
			//새로 구한값들을(새글,답글 모두) dto 에 담는다
			dto.setGroupno(groupno);
			dto.setRestep(restep);
			dto.setRelevel(relevel);
		
			getSqlSession().insert("reboard.reboardListInsert", dto);
		return;
	}
	
	public void reboardListUpdateReadCount(int reboard_pk) {
		getSqlSession().update("reboard.reboardListUpdateReadCount", reboard_pk);
		return;
	}
	
	public void reboardListDelete(int reboard_pk) {
		getSqlSession().delete("reboard.reboardListDelete", reboard_pk);
		return;
	}
	
	public void reboardListDeleteUpdate(int reboard_pk) {
		getSqlSession().update("reboard.reboardListDeleteUpdate", reboard_pk);
		return;
	}
	
	public int reboardListDeleteCount(int groupno) {
		return getSqlSession().selectOne("reboard.reboardListDeleteCount", groupno);
	}
	
	public void reboardListUpdate(ReboardDto dto) {
		getSqlSession().update("reboard.reboardListUpdate", dto);
		return;
	}
}
