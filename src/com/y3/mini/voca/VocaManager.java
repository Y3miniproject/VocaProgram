package com.y3.mini.voca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VocaManager {
	
	
	
	public List<VocaDTO> vocalist = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	
	
	//단어장 호출
	public void selectAll() {
	    if (vocalist.isEmpty()) {
	        System.out.println("등록된 단어가 없습니다.");
	        return;
	    }

	    System.out.println("=====단어장=====");
	    for (VocaDTO voca : vocalist) {
	        System.out.println("영단어 : " + voca.getWord());
	        System.out.println("한국어 뜻 : " + voca.getKormean());
	        System.out.println("영어 정의 : " + voca.getDefinition());
	        System.out.print("유의어 : ");
	        for (String similar : voca.getSimilar()) {
	            System.out.print(similar + " ");
	        }
	        System.out.println("");
	    }
	}
	
	
	//단어검색 - 오류 수정하기
	public VocaDTO searchWord(Scanner sc) {
		
		System.out.print("검색하려는 영단어를 입력하세요 : ");
		String word = sc.nextLine();
		
	    for (VocaDTO v : vocalist) {
	        if (v.getWord().equals(word)) {
	            System.out.println(v.toString());
	            return v;
	        }
	    }

	    System.out.println("입력하신 단어 " + word + " 은/는 단어장에 등록되지 않은 단어입니다.");

	    
	    return null;
	}
	
	
	
	//단어와 단어 관련 정보 추가
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
		    
		    System.out.println("단어 등록 완료");
	}
	
	//단어 삭제
	public void deleteWord(Scanner sc) {
		
		System.out.print("삭제할 영단어 입력 : ");
        String word = sc.nextLine();
		
		for (VocaDTO v : vocalist) {
	        if (v.getWord().equals(word)) {
	        	vocalist.remove(v);
	        	System.out.println("입력하신 단어" + word + "이/가 단어장에서 삭제되었습니다.");
	            return;
	        }
	    }
	    System.out.println("입력하신 단어 " + word + " 은/는 단어장에 등록되지 않은 단어입니다.");
		
	}





}
