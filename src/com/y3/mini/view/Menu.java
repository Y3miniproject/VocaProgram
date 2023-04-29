package com.y3.mini.view;

import java.util.Scanner;

import com.y3.mini.quiz.Quiz;
import com.y3.mini.user.UserManager;
import com.y3.mini.voca.VocaManager;

public class Menu {
	UserManager user = new UserManager();
	VocaManager voca = new VocaManager();
	Quiz quiz = new Quiz();
	Scanner sc = new Scanner(System.in);
	String id;
	String pwd;
	String name;
	boolean isLogin; // 로그인 성공여부

	public void mainMenu() {

		while (true) {
 			System.out.println("--------------------------------------------------------");
			System.out.println("단어장에 접속 했습니다");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 프로그램 종료");
 			System.out.println("--------------------------------------------------------");
			System.out.print("번호 : ");
			String n = sc.nextLine();
			if (n.equals("1")) {
				System.out.print("아이디 : ");
				id = sc.nextLine();
				System.out.print("비밀번호 : ");
				pwd = sc.nextLine();
				if (isLogin = user.signIn(id, pwd)) {
					break;
				}
				
//				--------- 기존코드( 회원가입 시 id,pwd,name 입력 받을때 공백 제한하지 않음) ---------
//			} else if (n.equals("2")) {
//				System.out.print("아이디 : ");
//				id = sc.nextLine();
//				System.out.print("비밀번호 : ");
//				pwd = sc.nextLine();
//				System.out.print("이름 : ");
//				name = sc.nextLine();
//				
//				if(!user.signUp(id, pwd, name))
//					System.out.println("회원가입에 실패했습니다");
//				
//			} else if (n.equals("3")) {
//				System.out.println("프로그램을 종료하겠습니다");
//				return;
//			} else {
//				System.out.println("번호를 잘못입력했습니다");
//			}

				
//			--------- 수정코드( 회원가입 시 id,pwd,name 입력 받을때 공백 허용 x ) ---------
			} else if (n.equals("2")) {
				String id,pwd,name;

				while(true) {
				  System.out.print("사용하실 아이디를 입력해 주세요. : ");
				  id = sc.nextLine().trim(); 			// 공백 제거
				  if (id.length() == 0) { 			// 아이디가 공백이면(아무것도 입력x)
				 System.out.println("아이디를 입력해 주세요.");
				 	continue;
				  }
				  if (id.split(" ").length > 1) { 	// 아이디에 공백이 포함되어 있으면
				 System.out.println("아이디에 공백을 포함할 수 없습니다.");
				    continue;
				  }
				 	break;
				  }
				 while (true) {
				 System.out.print("사용하실 비밀번호를 입력해 주세요. : ");
				 pwd = sc.nextLine().trim();			 // 공백 제거
				 if (pwd.length() == 0) { 			 // 비밀번호가 공백이면(아무것도 입력x)
				 System.out.println("비밀번호를 입력해주세요.");
				 continue;
				 }
				 if (pwd.split(" ").length > 1) { 	// 비밀번호에 공백이 포함되어 있으면
				 System.out.println("비밀번호에 공백을 포함할 수 없습니다.");
				 continue;
				 }
				 break;
				 }
				 while (true) {
				 System.out.println("이름을 입력해 주세요. : ");
				 name = sc.nextLine().trim(); 		// 공백 제거
				 if (name.length() == 0) {		    // 이름이 공백이면(아무것도 입력x)
				 System.out.println("이름을 입력해주세요.");
				 continue;
				 }
				 if (name.split(" ").length > 1) { 	// 이름에 공백이 포함되어 있으면
				 System.out.println("이름에 공백을 포함할 수 없습니다.");
				 continue;
				 }
				 break;
				 }

				if (!user.signUp(id, pwd, name)) {
				System.out.println("회원가입에 실패했습니다.");
				 }
		}
	}

		while (true) {
			System.out.println("***단어장 관리 프로그램***");
			System.out.println("1. 마이페이지");
			System.out.println("2. 단어장 전체 조회");
			System.out.println("3. 단어 검색");
			System.out.println("4. 단어 추가");
			System.out.println("5. 단어 삭제");
			System.out.println("6. 퀴즈 풀기");
			System.out.println("7. 종료하기");
			System.out.print("메뉴 번호: ");
			String n = sc.nextLine();
			if (n.equals("7")) {
				System.out.println("프로그램을 종료하겠습니다.");
				sc.close(); //프로그램 종료 직전 리소스 닫기
				break;
			}
			switch (n) {
			case "1" : user.showMypage(id); break;
			case "2" : voca.showVoca();; break; 
			case "3" : voca.searchWord(); break;
			case "4" : voca.addWord(); break;
			case "5" : voca.deleteWord(); break;
			case "6" : quiz.playQuiz(id,user,voca); break;
			default : System.out.println("번호를 잘못입력했습니다"); break;
		}
		}
	}

}