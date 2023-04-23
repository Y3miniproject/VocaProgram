package com.y3.mini.voca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VocaManager {
	
	
	public List<VocaDTO> vocalist = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	
	
	//단어장 조회
	public void showVoca() {
		if(vocalist.isEmpty()) {
			System.out.println("현재 단어장에 등록된 단어가 없습니다. 단어를 등록해주세요.");
			return;
		}
		System.out.println("=====단어장======"); //출력형태 둘 중 선택
		
//		for(VocaDTO v : vocalist) {
//			System.out.println("영단어 : " + v.getWord());
//			System.out.println("한국어뜻 : " + v.getKormean());
//			System.out.println("영어정의 : " + v.getDefinition());
//			System.out.print("유의어 : ");
//			for(String s : v.getSmiliar()) {
//				System.out.print(s + " ");
//			}
//			
//		    System.out.println("----------------"); 
//		}
		
		for(VocaDTO v : vocalist) {
			System.out.println(v.toString());
			System.out.println("-----------------");
		}
	}
	
	
	//단어검색 - 영단어, 한국어뜻 검색
		public void searchWord() { 
			
			if(vocalist.isEmpty()) {
				System.out.println("현재 단어장에 등록된 단어가 없습니다. 단어를 등록해주세요.");
				return;
			}
			
			System.out.println("검색하려는 단어를 입력하세요 : ");
			String word = sc.nextLine();
			
			for(VocaDTO v : vocalist) { 
				if(v.getWord().equals(word) || v.getKormean().equals(word)) {
//					System.out.println(v.toString()); //간단히 조회
					System.out.println("영단어 : " + v.getWord());
					System.out.println("한국어뜻 : " + v.getKormean());
					System.out.println("영어정의 : " + v.getDefinition());
					System.out.print("유의어 : ");
					for(String s : v.getSimilar()) {
						System.out.print(s + " ");
					}
					System.out.println();
					return;
					
				}
			} 
			if(!(vocalist.contains(word))) { 
		    	System.out.println(word + " 은/는 단어장에 등록되지 않은 단어입니다.");
		    }
			
		}
	
	
	
	//단어추가
	public void addWord() {
		 System.out.print("영단어 입력 : ");
		    String word = sc.nextLine();

		    System.out.print("한국어 뜻 입력 : ");
		    String kormean = sc.nextLine();

		    System.out.print("영어 정의 입력 : ");
		    String engdefinition = sc.nextLine();

		    System.out.print("첫번째 유의어 : ");
		    String similar1 = sc.nextLine();

		    System.out.print("두번째 유의어 : ");
		    String similar2 = sc.nextLine();

		    VocaDTO voca = new VocaDTO(word, kormean, engdefinition, new String[]{similar1, similar2});
		    vocalist.add(voca);
		    
		    System.out.println("단어 등록 완료!");
		    
		    System.out.println("---새로 추가된 단어---");
		    System.out.println(voca.toString());
		    System.out.println("-------------------");
		    
	}
	
	//단어 삭제
	public void deleteWord() {
		
		if(vocalist.isEmpty()) {
			System.out.println("현재 단어장에 등록된 단어가 없습니다. 단어를 등록해주세요.");
			return;
		}
		
		System.out.println("삭제할 단어 : ");
		String word = sc.nextLine();
		
		for(VocaDTO v : vocalist) {
			if(v.getWord().equals(word) || v.getKormean().equals(word)) {
				vocalist.remove(v); 
				System.out.println(word + "이/가 단어장에서 삭제되었습니다.");
				return;
			}
		}
		System.out.println(word + " 은/는 단어장에 등록되지 않은 단어입니다.");
		
	}





}
