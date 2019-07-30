package spring.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class Reboard_AnswerDao extends SqlSessionDaoSupport {
	
	public void boardAnswerInsert(Reboard_AnswerDto dto) {
		getSqlSession().insert("reboard_answer.boardAnswerInsert", dto);
		return;
	}
	
	public int boardAnswerGetCount(int reboard_reboard_pk) {
		return getSqlSession().selectOne("reboard_answer.boardAnswerGetCount", reboard_reboard_pk);
	}
	
	public List<Reboard_AnswerDto> boardAnswerGetData(int reboard_reboard_pk){
		return getSqlSession().selectList("reboard_answer.boardAnswerGetData", reboard_reboard_pk);
	}
	
	public void boardAnswerDelete(int answer_pk) {
		getSqlSession().delete("reboard_answer.boardAnswerDelete", answer_pk);
		return;
	}
	
	public void answerDeleteByNum(int reboard_reboard_pk) {
		getSqlSession().delete("reboard_answer.answerDeleteByNum", reboard_reboard_pk);
		return;
	}
}
