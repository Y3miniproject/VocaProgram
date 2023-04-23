package com.y3.mini.voca;

import java.util.ArrayList;
import java.util.List;

public class VocaManager {
	
	public List<VocaDTO> vocalist = new ArrayList<>();
	
	
	//단어장 호출
	public List<VocaDTO> selectAll() { 
		return vocalist;
	}
	
	//단어검색후 프린트 - 일치하는 단어 없을경우
	public VocaDTO searchWord(String word) {

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
	public void addWord(VocaDTO voca) {
		vocalist.add(voca);
	}
	
	//단어 삭제
	public void deleteWord(String word) {
		
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
