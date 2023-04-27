package com.y3.mini.quiz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.y3.mini.user.UserManager;
import com.y3.mini.voca.VocaDTO;
import com.y3.mini.voca.VocaManager;

public class Quiz {
	Scanner sc = new Scanner(System.in);
	public void playQuiz(String id,UserManager user,VocaManager voca) {
		int score = 0;			// 현재 점수
		int cnt = 0;			// 현재 문제 푼 횟수
		if(voca.vocalist.size()<3) {
			System.out.println("단어장에 단어가 부족합니다. 단어를 추가하세요");
			return;
		}
		while(true) {
			System.out.println("****퀴즈*****");
			System.out.println("1. 뜻 맞추기");
			System.out.println("2. 단어 맞추기");
			System.out.println("3. 퀴즈 종료");
			System.out.print("번호 입력 : ");
			String s = sc.nextLine();
			if(s.equals("3")) {
				System.out.println("퀴즈를 종료하겠습니다");
				break;
			}
			switch(s) {
			case "1":user.countUpdate(id);cnt++;
					 if(meanProblem(voca)) {
						 score +=5; 
					 }
					 break;  // 성공시 5점
			case "2":user.countUpdate(id);cnt++;
				     if(wordProblem(voca)) {
				    	 score +=10;
				     }
				     break;  // 성공시 10점
			default: System.out.println("번호를 잘못입력했습니다");
			}
			System.out.println("현재 문제 푼 횟수 : " + cnt);
			System.out.println("현재 점수 : " + score);
		}
//		 객관식 퀴즈는 5점 배점, 주관식 퀴즈는 10점 배점		
		user.addScore(id, score);
	}

	//	영단어 제시 후 영어정의 선택지 3가지 중 정답 맞추는 객관식 퀴즈
	public boolean meanProblem(VocaManager voca) {
		String s;
		boolean isSuccess = false;
//		Set<VocaDTO> vocaSet = new HashSet<>();
//		while(vocaSet.size()<3) {
////		vocaSet.add(voca.vocalist.get((int)(Math.random()*voca.vocalist.size())));              //hy:원래 작성하셨던 코드입니다.
//			vocaSet.add(((List<VocaDTO>) voca.vocalist).get((int)(Math.random()*voca.vocalist.size()))); //hy:(1)vocalist를 HashSet으로 변경하자 컴파일오류가 생겨 형변환한 코드입니다.
//		}
		//hy:(2)런타입에러 발생하여 HashSet객체생성과 while문을 주석처리
		//원래는 ArrayList(인덱스)였기 때문에 Set으로 랜덤하게 저장한뒤 다시 새ArrayList(인덱스)에 담아 복사했던 코드라고 추측.
		//이제는 단어장이 HashSet이기떄문에, 인덱스를 쓰기 위해 새 ArrayList복사한다
		
//		ArrayList<VocaDTO> vocaList = new ArrayList<>(vocaSet);       //hy:원래 작성하셨던 코드
		ArrayList<VocaDTO> vocaList = new ArrayList<>(voca.vocalist); //hy:매개변수 수정
	    VocaDTO answer = vocaList.get((int)(Math.random()*3));
	    System.out.println(answer.getWord()+"의 뜻을 보기에서 골라주세요");
	    System.out.println("1 . " + vocaList.get(0).getDefinition());
	    System.out.println("2 . " + vocaList.get(1).getDefinition());
	    System.out.println("3 . " + vocaList.get(2).getDefinition());
	    System.out.print("정답은 : ");
	    s = sc.nextLine();
	    switch(s) {
	    case "1":if(answer.getWord().equals(vocaList.get(0).getWord())) {
	    		System.out.println("정답입니다");
	    		isSuccess = true;
	    	}	else {
	    		System.out.println("오답입니다");
	    		isSuccess =false;
	    	}break;
	    case "2":if(answer.getWord().equals(vocaList.get(1).getWord())) {
    		System.out.println("정답입니다");
    		isSuccess = true;
    	}	else {
    		System.out.println("오답입니다");
    		isSuccess =false;
    	}break;
	    case "3":if(answer.getWord().equals(vocaList.get(2).getWord())) {
    		System.out.println("정답입니다");
    		isSuccess = true;
    	}	else {
    		System.out.println("오답입니다");
    		isSuccess =false;
    	}break;
    	default:System.out.println("번호를 잘못입력했습니다");
    	
    }
    	
	    return isSuccess;
}	
	    
	    
	
	
//	한국어 제시 후 영단어 정답 맞추는 주관식 퀴즈
	public boolean wordProblem(VocaManager voca) {
		int ran = (int)(Math.random()*voca.vocalist.size()); // 영어단어장 사이즈만큼 랜덤 정수 만듬
		boolean isSuccess = false;
//		VocaDTO vocaQ = voca.vocalist.get(ran);                   //hy:원래 작성하셨던 코드입니다.
//		VocaDTO vocaQ = ((List<VocaDTO>) voca.vocalist).get(ran); //hy:(1)vocalist를 HashSet으로 변경하자 컴파일오류가 생겨 형변환한 코드입니다. 
		
		//hy:(2)인덱스를 이용하기 위해 새ArrayList에 HashSet인 vocalist를 복사해 담기
		ArrayList<VocaDTO> vocaList2 = new ArrayList<>(voca.vocalist);
		VocaDTO vocaQ = vocaList2.get(ran); 
		
		System.out.print(vocaQ.getKormean()+" :  ");
		String s = sc.nextLine();
		if(s.equals(vocaQ.getWord())) {
			System.out.println("정답입니다!!");
			isSuccess = true;
		}else {
			System.out.println("오답입니다!!");
			isSuccess = false;
		}
		return isSuccess;
	}
	
}
