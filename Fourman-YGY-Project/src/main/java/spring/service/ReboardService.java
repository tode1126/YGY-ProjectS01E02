package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.data.ReboardDao;
import spring.data.ReboardDto;


@Service
public class ReboardService {
	@Autowired
	private ReboardDao dao;
	
	public int getTotalCount() { return dao.getTotalCount(); }
	 
	public void insertReboard(ReboardDto dto)
	{
		 dao.insertReboard(dto);
		 return;
	}
	
	public List<ReboardDto> getList(int offset,int block)
	{
		return dao.getList(offset, block);
	}
	
	public void updateReadCount(int num)
	{
		dao.updateReadCount(num);
	}
	
	public ReboardDto getData(int num)
	{
		return dao.getData(num);
	}
	
	public void reboardUpdate(ReboardDto dto)
	{
		dao.reboardUpdate(dto);
	}
	
	public void reboardDelete(int num)
	{
		dao.reboardDelete(num);
	}
	
	public void reboardHappyUpdate(int num)
	{
		dao.reboardHappyUpdate(num);
	}
	
	public int getSelectHappy(int num)
	{
		return dao.getSelectHappy(num);
	}
	
	public void reboardUnHappyUpdate(int num)
	{
		dao.reboardUnHappyUpdate(num);
	}
	
	public int getSelectUnHappy(int num)
	{
		return dao.getSelectUnHappy(num);
	}
	
}
