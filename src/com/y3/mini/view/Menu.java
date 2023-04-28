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
			System.out.println("단어장에 접속했습니다");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 프로그램 종료");
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

			} else if (n.equals("2")) {
				System.out.print("아이디 : ");
				id = sc.nextLine();
				System.out.print("비밀번호 : ");
				pwd = sc.nextLine();
				System.out.print("이름 : ");
				name = sc.nextLine();
				
				if(!user.signUp(id, pwd, name))
					System.out.println("회원가입에 실패했습니다");
				
			} else if (n.equals("3")) {
				System.out.println("프로그램을 종료하겠습니다");
				return;
			} else {
				System.out.println("번호를 잘못입력했습니다");
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