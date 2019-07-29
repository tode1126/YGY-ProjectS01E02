package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.data.noticeDao;
import spring.data.noticeDto;


@Service
public class noticeservice {
	@Autowired
	private noticeDao dao;
	
	
	 public int getTotalNoticeCount() { return dao.getTotalNoticeCount(); }
	 
	 public void insertNotice(noticeDto ndto)
	 {
		 dao.insertNotice(ndto);
	 }
	
}
