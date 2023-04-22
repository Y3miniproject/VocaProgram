package com.y3.mini.user;

public class UserDTO {
	
	private String id;
	private String pwd;
	private String name;
	private int count;
	private int sore;

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
	public int getSore() {
		return sore;
	}
	public void setSore(int sore) {
		this.sore = sore;
	}

	@Override
	public String toString() {
		return "회원정보 [id=" + id + ", pwd=" + pwd + ", 이름=" + name + ", 퀴즈횟수=" + count + ", 누적점수=" + sore + "]";
	}
	
	
	
	
	

}
