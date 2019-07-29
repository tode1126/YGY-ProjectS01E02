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

	public List<noticeDto> notice_boardList(int perPage, int no) {
		return dao.notice_boardList(perPage, no);
	}

	public int notice_boardTotalCount() {
		return dao.notice_boardTotalCount();
	}

	public void notice_boardListReadCountUpdate(int notice_pk) {
		dao.notice_boardListReadCountUpdate(notice_pk);
		return;
	}

	public int notice_boardListSelectCount(int notice_pk) {
		return dao.notice_boardListSelectCount(notice_pk);
	}

	public noticeDto notice_boardListSelect(int notice_pk) {
		return dao.notice_boardListSelect(notice_pk);
	}
}
