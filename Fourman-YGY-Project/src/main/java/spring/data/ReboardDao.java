package spring.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository  //xml 에 자동 등록
public class ReboardDao extends SqlSessionDaoSupport{
	public int getTotalCount()
	{
		int n=getSqlSession().selectOne("reboard.reboardTotalCount");
		return n;
	}
	
	public void insertReboard(ReboardDto dto)
	{
		getSqlSession().insert("reboard.reboardInsert",dto);
		return;
	}
	
	public List<ReboardDto> getList(int offset,int block)
	{
		Map<String, Integer>map=new HashMap<String, Integer>();
		map.put("offset", offset);
		map.put("block", block);
		
		return getSqlSession().selectList("reboard.reboardPagingList",map);
	}
	
	public void updateReadCount(int num)
	{
		getSqlSession().update("reboardUpdateReadcount",num);
	}
	
	public ReboardDto getData(int num)
	{
		return getSqlSession().selectOne("reboardSelectData",num);
	}
	
	public void reboardUpdate(ReboardDto dto)
	{
		getSqlSession().update("reboardUpdate",dto);
	}
	
	public void reboardDelete(int num)
	{
		getSqlSession().delete("reboard.reboardDelete",num);
	}
	
	public void reboardHappyUpdate(int num)
	{
		getSqlSession().update("reboardHappyUpdate",num);
	}
	
	public int getSelectHappy(int num)
	{
		return getSqlSession().selectOne("reboardHappySelect",num);
	}
}
