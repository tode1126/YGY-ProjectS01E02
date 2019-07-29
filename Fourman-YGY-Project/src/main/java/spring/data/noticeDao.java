package spring.data;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class noticeDao extends SqlSessionDaoSupport{
	
  public int getTotalNoticeCount()
  {
	  int n = getSqlSession().selectOne("notice.noticeTotalCount");
	  return n;
  }
  
  public void insertNotice(noticeDto ndto)
  {
	  getSqlSession().insert("notice.noticeInsert", ndto);
  }
}
