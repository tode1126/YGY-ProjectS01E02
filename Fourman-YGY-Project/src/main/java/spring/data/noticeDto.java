package spring.data;

import java.sql.Timestamp;

public class noticeDto {
	private int notice_pk;
	private String notice_writer;
	private String notice_subject;
	private String notice_content;
	private int notice_readcount;
	private Timestamp notice_writedate;

	public int getNotice_pk() {
		return notice_pk;
	}

	public void setNotice_pk(int notice_pk) {
		this.notice_pk = notice_pk;
	}

	public String getNotice_writer() {
		return notice_writer;
	}

	public void setNotice_writer(String notice_writer) {
		this.notice_writer = notice_writer;
	}

	public String getNotice_subject() {
		return notice_subject;
	}

	public void setNotice_subject(String notice_subject) {
		this.notice_subject = notice_subject;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public int getNotice_readcount() {
		return notice_readcount;
	}

	public void setNotice_readcount(int notice_readcount) {
		this.notice_readcount = notice_readcount;
	}

	public Timestamp getNotice_writedate() {
		return notice_writedate;
	}

	public void setNotice_writedate(Timestamp notice_writedate) {
		this.notice_writedate = notice_writedate;
	}

}
