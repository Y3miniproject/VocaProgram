package com.y3.mini.user;


import java.util.HashMap;


public class UserManager {
	
	HashMap<String, UserDTO> userInfo = new HashMap<>();
	
		
	//사용자의 정보(id,pwd,name) 추가 메소드 
	public void addUser(String id, String pwd, String name) {
		UserDTO user = new UserDTO(id,pwd,name);
		userInfo.put(id, user); 
	}
	

	//사용자가 맞춘 퀴즈의 누적 개수(count) 업데이트 하는 메소드 

    public void countUpdate(String id) {
        UserDTO user = userInfo.get(id);  
        user.setCount(user.getCount() + 1);
    }
    

    //사용자의 누적 퀴즈 점수(score) *현재 사용자의 점수에 누적 점수를 더해주는 메소드
    public void addScore(String id, int score) {
        UserDTO user = userInfo.get(id);
        int cureentScore = user.getScore();
        user.setScore(cureentScore + score);
    }
    
    
    public HashMap<String, UserDTO> getUserInfo() {
        return userInfo;
    }
	
	// 로그인 성공 여부를 반환하는 메소드 
	public boolean signIn(String id, String pwd) {
		UserDTO user = userInfo.get(id);
		if(user == null) {
			System.out.println("해당 아이디가 존재하지 않습니다.");
			return false;
		} else if (!user.getPwd().equals(pwd)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return false;
		} else {
			System.out.println(user.getName() + "님, 로그인에 성공하셨습니다. ");
		return true;
		}
	}
	
	// 회원가입 기능을 위한 singUp() 메소드를 작성하여 사용자 정보를 저장하고 회원가입 결과를 반환
	public boolean singUp(String id, String pwd, String name) {
		if(userInfo.containsKey(id)) {
			System.out.println("이미 존재하는 아이디 입니다.");
			return false;
		} else {
			userInfo.put(id, new UserDTO(id,pwd,name));
			System.out.println(name + "님, 회원가입이 완료되었습니다.");
			return true;
		}
	}
	
	// 메뉴에서 사용자가 마이페이지 조회 선택시 사용자의 계정 정보 출력하는 메소드 
	// userList에서 아이디를 검색하여 일치하는 사용자를 찾음 
	public void showMypage(String id) 	{
		if(userInfo.containsKey(id) ) {
			UserDTO user = userInfo.get(id);
				System.out.println("아이디 : " + user.getID());
				System.out.println("이름 : " + user.getName());
				System.out.println("퀴즈 푼 횟수 : " + user.getCount());
				System.out.println("누적 점수 : " + user.getScore());
	    } else {
				System.out.println("해당 아이디가 존재하지 않습니다.");
		}
	}

}


