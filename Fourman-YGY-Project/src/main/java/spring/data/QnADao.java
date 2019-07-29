package spring.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class QnADao extends SqlSessionDaoSupport{

	public int getTotalQuestionCount()
	  {
		  int n = getSqlSession().selectOne("question.questionTotalCount");
		  return n;
	  }

	public QnADto questionGetData(int num)
	{
		return getSqlSession().selectOne("question.questionSelectData",num);
	}

	public List<QnADto> getQuestionList(int offset,int block)
	{
		Map<String, Integer>map=new HashMap<String, Integer>();
		map.put("offset", offset);
		map.put("block", block);

		return getSqlSession().selectList("question.questionPagingList",map);
	}

	 public void insertQuestion(QnADto qdto)
	  {
		  getSqlSession().insert("question.questionInsert", qdto);
	  }

	 public void AnswerQuestion(QnADto qdto)
	  {
		  getSqlSession().insert("question.questionAnswer", qdto);
	  }

	//qna_pk 최대값 구하기 위해서
		public int getQuestionMaxNum()
		{

			int max = getSqlSession().selectOne("question.questionMaxPk");
			return max;			

		}

}