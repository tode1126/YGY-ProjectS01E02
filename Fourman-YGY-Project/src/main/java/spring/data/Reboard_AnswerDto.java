package spring.data;

import java.sql.Timestamp;

public class Reboard_AnswerDto {
	private int answer_pk;
	private int reboard_reboard_pk;
	private String answer_nickname;
	private String answer_content;
	private int answer_happy;
	private int answer_unhappy;
	private Timestamp answer_wrtieday;

	public int getAnswer_pk() {
		return answer_pk;
	}

	public void setAnswer_pk(int answer_pk) {
		this.answer_pk = answer_pk;
	}

	public int getReboard_reboard_pk() {
		return reboard_reboard_pk;
	}

	public void setReboard_reboard_pk(int reboard_reboard_pk) {
		this.reboard_reboard_pk = reboard_reboard_pk;
	}

	public String getAnswer_nickname() {
		return answer_nickname;
	}

	public void setAnswer_nickname(String answer_nickname) {
		this.answer_nickname = answer_nickname;
	}

	public String getAnswer_content() {
		return answer_content;
	}

	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}

	public int getAnswer_happy() {
		return answer_happy;
	}

	public void setAnswer_happy(int answer_happy) {
		this.answer_happy = answer_happy;
	}

	public int getAnswer_unhappy() {
		return answer_unhappy;
	}

	public void setAnswer_unhappy(int answer_unhappy) {
		this.answer_unhappy = answer_unhappy;
	}

	public Timestamp getAnswer_wrtieday() {
		return answer_wrtieday;
	}

	public void setAnswer_wrtieday(Timestamp answer_wrtieday) {
		this.answer_wrtieday = answer_wrtieday;
	}

}
