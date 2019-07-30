package spring.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class noticeDao extends SqlSessionDaoSupport {

	public List<noticeDto> notice_boardList(int perPage, int no) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("perPage", perPage);
		map.put("no", no);
		return getSqlSession().selectList("notice.notice_boardList", map);
	}

	public int notice_boardTotalCount() {
		return getSqlSession().selectOne("notice.notice_boardTotalCount");
	}

	public void notice_boardListReadCountUpdate(int notice_pk) {
		getSqlSession().update("notice.notice_boardListReadCountUpdate", notice_pk);
		return;
	}

	public int notice_boardListSelectCount(int notice_pk) {
		return getSqlSession().selectOne("notice.notice_boardListSelectCount", notice_pk);
	}

	public noticeDto notice_boardListSelect(int notice_pk) {
		return getSqlSession().selectOne("notice.notice_boardListSelect", notice_pk);
	}
}
