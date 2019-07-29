package spring.data;

import java.sql.Timestamp;

public class QnADto {

	private int qna_pk;
	private String qna_writer;
	private String qna_subject;
	private String qna_content;
	private int qna_ref;
	private Timestamp qna_writeday;

	public int getQna_pk() {
		return qna_pk;
	}
	public void setQna_pk(int qna_pk) {
		this.qna_pk = qna_pk;
	}
	public String getQna_writer() {
		return qna_writer;
	}
	public void setQna_writer(String qna_writer) {
		this.qna_writer = qna_writer;
	}
	public String getQna_subject() {
		return qna_subject;
	}
	public void setQna_subject(String qna_subject) {
		this.qna_subject = qna_subject;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public int getQna_ref() {
		return qna_ref;
	}
	public void setQna_ref(int qna_ref) {
		this.qna_ref = qna_ref;
	}
	public Timestamp getQna_writeday() {
		return qna_writeday;
	}
	public void setQna_writeday(Timestamp qna_writeday) {
		this.qna_writeday = qna_writeday;
	}

}