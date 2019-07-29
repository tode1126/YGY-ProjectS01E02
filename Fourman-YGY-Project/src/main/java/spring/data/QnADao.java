package spring.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class QnADao extends SqlSessionDaoSupport {

	public List<QnADto> qna_boardSelectList(String qna_writer, int perPage, int no) {
		QnAUserDto dto = new QnAUserDto();
		dto.setQna_writer(qna_writer);
		dto.setPerPage(perPage);
		dto.setNo(no);
		return getSqlSession().selectList("question.qna_boardSelectList", dto);
	}

	public int qna_boardListSelectTotalCount(String qna_writer) {
		return getSqlSession().selectOne("question.qna_boardListSelectTotalCount", qna_writer);
	}

	public int qna_boardListSelectCount(int qna_pk) {
		return getSqlSession().selectOne("question.qna_boardListSelectCount", qna_pk);
	}

	public QnADto qna_boardListSelectContent(int qna_pk) {
		return getSqlSession().selectOne("question.qna_boardListSelectContent", qna_pk);
	}

	public void qna_boardListInsert(QnADto dto) {
		getSqlSession().insert("question.qna_boardListInsert", dto);
		return;
	}

}