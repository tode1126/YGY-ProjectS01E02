package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.data.QnADao;
import spring.data.QnADto;

@Service
public class QnAService {

	@Autowired
	private QnADao dao;

	public List<QnADto> qna_boardSelectList(String qna_writer, int perPage, int no){
		return dao.qna_boardSelectList(qna_writer, perPage, no);
	}
	
	public int qna_boardListSelectTotalCount(String qna_writer) {
		return dao.qna_boardListSelectTotalCount(qna_writer);
	}
	
	public int qna_boardListSelectCount(int qna_pk) {
		return dao.qna_boardListSelectCount(qna_pk);
	}
	
	public QnADto qna_boardListSelectContent(int qna_pk) {
		return dao.qna_boardListSelectContent(qna_pk);
	}
	
	public void qna_boardListInsert(QnADto dto) {
		dao.qna_boardListInsert(dto);
		return;
	}
}