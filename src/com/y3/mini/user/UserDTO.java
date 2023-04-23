package com.y3.mini.user;

public class UserDTO {
	
	private String id; 		//아이디
	private String pwd;		//비밀번호 
	private String name;	//이름 
	private int count;		//퀴즈 푼 횟수
	private int score;		//누적 점수 

	public UserDTO() {}

	public UserDTO(String id, String pwd, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}

	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "회원정보 [id=" + id + ", pwd=" + pwd + ", 이름=" + name + ", 퀴즈 푼 횟수=" + count + ", 누적 점수=" + score + "]";
	}
	
	
	
	
	

}
