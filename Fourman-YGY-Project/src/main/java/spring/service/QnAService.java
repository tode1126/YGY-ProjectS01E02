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

	 //총 갯수 구하기
     public int getTotalQuestionCount() { return dao.getTotalQuestionCount(); }

     // 해당 글 내용 얻어오기
 	 public QnADto getQuestionData(int num)
 		{
 			return dao.questionGetData(num);
 		}

 	 //페이징 처리
	 public List<QnADto> getQuestionList(int offset,int block)
		{
			return dao.getQuestionList(offset, block);
		}

	// 1:1문의 글쓰기
		 public void insertQuestion(QnADto qdto)
		 {
			 dao.insertQuestion(qdto);
		 }

		// 1:1문의 답글쓰기
		public void AnswerQuestion(QnADto qdto)
		 {
			 dao.AnswerQuestion(qdto);
		 }

		// qna_pk 최대값 구하기
		public int getQuestionMaxNum() { return dao.getQuestionMaxNum(); }
}