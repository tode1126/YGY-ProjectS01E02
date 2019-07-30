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
	
	public List<ReboardDto> reboardList(int perPage, int no){
		return dao.reboardList(perPage, no);
	}
	
	public int reboardListTotalCount() {
		return dao.reboardListTotalCount();
	}
	
	public void reboardListHappyUpdate(int reboard_pk) {
		dao.reboardListHappyUpdate(reboard_pk);
		return;
	}
	
	public int reboardListHappySelect(int reboard_pk) {
		return dao.reboardListHappySelect(reboard_pk);
	}
	
	public void reboardListUnHappyUpdate(int reboard_pk) {
		dao.reboardListUnHappyUpdate(reboard_pk);
		return;
	}
	
	public int reboardListUnHappySelect(int reboard_pk) {
		return dao.reboardListUnHappySelect(reboard_pk);
	}
	
	public ReboardDto reboardListSelectContent(int reboard_pk) {
		return dao.reboardListSelectContent(reboard_pk);
	}
	
	public int reboardListSelectCount(int reboard_pk) {
		return dao.reboardListSelectCount(reboard_pk);
	}
	
	public void reboardListInsert(ReboardDto dto) {
		dao.reboardListInsert(dto);
		return;
	}
	
	public void reboardListUpdateReadCount(int reboard_pk) {
		dao.reboardListUpdateReadCount(reboard_pk);
		return;
	}
	
	public void reboardListDelete(int reboard_pk) {
		dao.reboardListDelete(reboard_pk);
		return;
	}
	
	public void reboardListDeleteUpdate(int reboard_pk) {
		dao.reboardListDeleteUpdate(reboard_pk);
		return;
	}

	public int reboardListDeleteCount(int groupno) {
		return dao.reboardListDeleteCount(groupno);
	}
	
	public void reboardListUpdate(ReboardDto dto) {
		dao.reboardListUpdate(dto);
		return;
	}
}
