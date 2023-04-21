//package com.y3.mini.view;
//
//import java.util.Scanner;
//
//import com.y3.mini.quiz.Quiz;
//import com.y3.mini.user.UserManager;
//import com.y3.mini.voca.VocaManager;
//
//public class Menu {
//	UserManager user = new UserManager();
//	VocaManager voca = new VocaManager();
//	Quiz quiz;
//	Scanner sc = new Scanner(System.in);
//	String id;
//	boolean isLogin;	// 로그인 성공여부
//	public void mainMenu() {
//		
//		while(true) {
//	    System.err.println("단어장에 접속했습니다");
//		System.out.println("1. 로그인");
//		System.out.println("2. 회원가입");
//		System.out.println("3. 프로그램 종료");
//		System.out.println("번호를 입력해주세요");
//		int n = sc.nextInt();
//		sc.nextLine();
//		if(n==1) {
//		System.out.println("아이디를 입력해주세요 ");
//		id = sc.nextLine();
//		if(isLogin =user.signIn(id)) {//매니저: 로그인성공여부를 true/false리턴받고 프린트			// id가 있어야지 후에 퀴즈풀때 점수추가할려면 필요함
//			System.out.println("로그인 성공");
//			break;
//		}
//		
//		}else if(n==2) {
//			user.signUp();  
//		//매니저:id, pwd, name으로 메소드 만들고 생성성공여부에 따라 true/false리턴
//		}else if(n==3) {
//			System.out.println("프로그램을 종료하겠습니다");
//		return;
//		}else {
//			System.out.println("번호를 잘못입력했습니다");
//		}
//		
//	}
//		while(true) {
//		System.out.println("***단어장 관리 프로그램***");
//		System.out.println("1. 마이페이지");
//		System.out.println("2. 단어장 전체 조회");
//		System.out.println("3. 단어 검색");
//		System.out.println("4. 단어 추가");
//		System.out.println("5. 단어 삭제");
//		System.out.println("6. 퀴즈 풀기");
//		System.out.println("7. 종료하기");
//		int n = sc.nextInt();
//		if(n==7) {
//			System.out.println("프로그램을 종료하겠습니다.");
//			break;
//		}
//		switch(n) {
//		case 1: user.myInfo(id);break; //매니저:print하는 메소드 매개변수는 String id    // 로그인한 id의 정보 출력
//		case 2: voca.selectAll();break;//book 단어장 호출
//		case 3: voca.seachWord();break;//단어매니저 : 단어검색후 프린트하는 메소드 구현
//		case 4: voca.addWord();break;//단어매니저 : 단어와 단어 관련 정보 추가
//		case 5: voca.deletWord();break;//단어매니저 : 단어 삭제
//		case 6: quiz.playQuiz();break;//quiz
//		default: System.out.println("번호를 잘못입력했습니다");
//		
//	
//			}
//		}
//	}	
//	
//}
