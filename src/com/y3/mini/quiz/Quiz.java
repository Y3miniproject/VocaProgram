package com.y3.mini.quiz;

import java.util.Scanner;

import com.y3.mini.user.UserManager;
import com.y3.mini.voca.VocaManager;

public class Quiz {
	Scanner sc = new Scanner(System.in);
	public void playQuiz(String id,UserManager user,VocaManager voca ) {
		int score = 0;
		while(true) {
			System.out.println("****퀴즈*****");
			System.out.println("1. 뜻 맞추기");
			System.out.println("2. 단어 맞추기");
			System.out.println("3. 퀴즈 종료");
			int n = sc.nextInt();
			sc.nextLine();
			if(n==3) {
				System.out.println("퀴즈를 종료하겠습니다");
				break;
			}
			switch(n) {
			case 1:user.countUpdate(id);meanProblem();score += 5;break;
			case 2:user.countUpdate(id);wordProblem();score += 10;break;
			default: System.out.println("번호를 잘못입력했습니다");
			}
		}
		
		user.addScore(id, score);
//		3-1. 영단어 제시 후 영어정의 선택지 3가지 중 정답 맞추는 객관식 퀴즈
//
//		   3-2. 한국어 제시 후 영단어 정답 맞추는 주관식 퀴즈
//		   
//		   3-3. 객관식 퀴즈는 5점 배점, 주관식 퀴즈는 10점 배점
	}
	
	public void wordProblem() {}
	

	public void meanProblem() {}
	
}
