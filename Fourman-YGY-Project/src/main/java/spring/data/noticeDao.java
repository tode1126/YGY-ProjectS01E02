package spring.data;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class noticeDao extends SqlSessionDaoSupport{
	
  public int getTotalNoticeCount()
  {
	  int n = getSqlSession().selectOne("notice.noticeTotalCount");
	  return n;
  }
  
  public noticeDto getData(int num)
	{
		return getSqlSession().selectOne("noticeSelectData",num);
	}
  
  public List<noticeDto> getList(int offset,int block)
	{
		Map<String, Integer>map=new HashMap<String, Integer>();
		map.put("offset", offset);
		map.put("block", block);
		
		return getSqlSession().selectList("notice.noticePagingList",map);
	}
  
  public void insertNotice(noticeDto ndto)
  {
	  getSqlSession().insert("notice.noticeInsert", ndto);
  }
  
  public void updateReadCount(int num)
	{
		getSqlSession().update("notice.noticeUpdateReadcount",num);
	}
  
  public void noticeUpdate(noticeDto ndto)
	{
		getSqlSession().update("notice.noticeUpdate",ndto);
	}
  
  public void noticeDelete(int num)
	{
		getSqlSession().delete("notice.noticeDelete",num);
	}
  
}
