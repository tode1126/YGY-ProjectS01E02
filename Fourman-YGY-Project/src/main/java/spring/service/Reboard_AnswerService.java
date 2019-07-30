package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.data.Reboard_AnswerDao;
import spring.data.Reboard_AnswerDto;

@Service
public class Reboard_AnswerService {

	@Autowired
	private Reboard_AnswerDao dao;
	
	public void boardAnswerInsert(Reboard_AnswerDto dto) {
		dao.boardAnswerInsert(dto);
		return;
	}
	
	public int boardAnswerGetCount(int reboard_reboard_pk) {
		return dao.boardAnswerGetCount(reboard_reboard_pk);
	}
	
	public List<Reboard_AnswerDto> boardAnswerGetData(int reboard_reboard_pk){
		return dao.boardAnswerGetData(reboard_reboard_pk);
	}
	
	public void boardAnswerDelete(int answer_pk) {
		dao.boardAnswerDelete(answer_pk);
		return;
	}
	
	public void answerDeleteByNum(int reboard_reboard_pk) {
		dao.answerDeleteByNum(reboard_reboard_pk);
		return;
	}
}
