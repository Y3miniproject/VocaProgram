package com.y3.mini.user;

public class UserDTO {
	
	private String ID;
	private String pwd;
	private String name;
	private int count;
	private int sore;

	public UserDTO() {}

	public UserDTO(String iD, String pwd, String name) {
		super();
		ID = iD;
		this.pwd = pwd;
		this.name = name;
	}

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
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
		return "회원정보 [ID=" + ID + ", pwd=" + pwd + ", 이름=" + name + ", 퀴즈횟수=" + count + ", 누적점수=" + sore + "]";
	}
	
	
	
	
	

}
