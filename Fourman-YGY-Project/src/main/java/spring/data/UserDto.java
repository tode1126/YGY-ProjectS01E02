package spring.data;

import java.sql.Timestamp;

public class UserDto {
	private String email;
	private String pass;
	private String hp;
	private String hp1;
	private String hp2;
	private String hp3;
	private String nickName;
	private int grade;
	private int state;
	private Timestamp regday;
	private Timestamp dropday;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Timestamp getRegday() {
		return regday;
	}

	public void setRegday(Timestamp regday) {
		this.regday = regday;
	}

	public Timestamp getDropday() {
		return dropday;
	}

	public void setDropday(Timestamp dropday) {
		this.dropday = dropday;
	}

	public String getHp1() {
		return hp1;
	}

	public void setHp1(String hp1) {
		this.hp1 = hp1;
	}

	public String getHp2() {
		return hp2;
	}

	public void setHp2(String hp2) {
		this.hp2 = hp2;
	}

	public String getHp3() {
		return hp3;
	}

	public void setHp3(String hp3) {
		this.hp3 = hp3;
	}

}
