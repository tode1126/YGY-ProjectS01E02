package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import spring.data.noticeDao;
import spring.data.noticeDto;


@Service
public class noticeservice {
	@Autowired
	private noticeDao dao;
	
	 //총 갯수 구하기
	 public int getTotalNoticeCount() { return dao.getTotalNoticeCount(); }
	 
	 // 해당 글 내용 얻어오기
	 public noticeDto getData(int num)
		{
			return dao.getData(num);
		}
	 
	 //페이징 처리
	 public List<noticeDto> getList(int offset,int block)
		{
			return dao.getList(offset, block);
		}
	 
	 // 공지사항 글쓰기
	 public void insertNotice(noticeDto ndto)
	 {
		 dao.insertNotice(ndto);
	 }
	 
	 // 조회수 증가
	 public void updateReadCount(int num)
		{
			dao.updateReadCount(num);
		}
	 
	 // 공지사항 업데이트
	 public void noticeUpdate(noticeDto ndto)
		{
			dao.noticeUpdate(ndto);
		}
	 
	 // 공지사항 삭제
	 public void noticeDelete(int num)
		{
			dao.noticeDelete(num);
		}
	
}
