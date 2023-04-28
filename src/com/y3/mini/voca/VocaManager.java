package com.y3.mini.voca;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class VocaManager {

	public HashSet<VocaDTO> vocalist = new HashSet<>();
	Scanner sc = new Scanner(System.in);
	
	
    //초기 단어
	public VocaManager() {
		VocaDTO voca1 = new VocaDTO("benefit", "이익", "a good or helpful result or effect", new String[] {"abvantage", "profit"});
		VocaDTO voca2 = new VocaDTO("cracker", "과자", "a thin, crisp snack" , new String[] {"cookie", "biscuit"});
		VocaDTO voca3 = new VocaDTO("value", "가치", "something that can be bought for a low or fair price", new String[] {"worth", "price"});
		VocaDTO voca4 = new VocaDTO("only", "유일한", "nothing other than", new String[] {"just", "simply"});
		VocaDTO voca5 = new VocaDTO("puppy", "강아지", "a young dog", new String[] {"dog", "kitty"});	
		
		vocalist.add(voca1);
		vocalist.add(voca2);
		vocalist.add(voca3);
		vocalist.add(voca4);
		vocalist.add(voca5);
	}
	
	
	// 단어장 조회
	public void showVoca() {

		if (vocalist.isEmpty()) {
			System.out.println("현재 단어장에 등록된 단어가 없습니다. 단어를 등록해주세요.");
			return;
		}
		

		// 영단어 오름차순 정렬
		List<VocaDTO> sortedList = new ArrayList<>(vocalist);
		sortedList.sort(new Comparator<VocaDTO>() {

			@Override
			public int compare(VocaDTO o1, VocaDTO o2) {
				return o1.getWord().compareTo(o2.getWord());
			}
		});
		
		System.out.println("=======단어장=======");
		if (!sortedList.isEmpty()) {
			
			for(VocaDTO v : sortedList) {
				System.out.println(v.toString());
				System.out.println("-----------------");
			}
		}

	}

	
	// 단어검색
	public void searchWord() {
	    while(true) {
	        Iterator<VocaDTO> itr = vocalist.iterator();
	        if (!itr.hasNext()) {
	            System.out.println("현재 단어장에 등록된 단어가 없습니다. 단어를 등록해주세요.");
	            return;
	        }

	        System.out.print("검색할 단어를 입력하세요(영단어/한국어뜻) : ");
	        String word = sc.nextLine();
	        System.out.println();


	        //전체 검색결과 수의 출력을 위해 임시HashSet 생성하여 복제
	        int tmpCount = 0;
	        HashSet<VocaDTO> tmpHashSet = new HashSet<VocaDTO>();
	        tmpHashSet.addAll(vocalist);
	        Iterator<VocaDTO> tmpItr = tmpHashSet.iterator();
	        while(tmpItr.hasNext()) {
	        	VocaDTO tmpVoca = tmpItr.next();
	        	if(tmpVoca.getWord().contains(word) || tmpVoca.getKormean().contains(word)) {
	        		tmpCount++;
	        	}
	        }
	        System.out.println("=====================검색 완료=====================");
	        System.out.println("총 " + tmpCount + "건이 검색되었습니다.");
	        
	        
	        boolean isRegistered = false;
	        int count = 0;
	        while(itr.hasNext()) {
	            VocaDTO voca = itr.next();
	            
	            if(voca.getWord().contains(word) || voca.getKormean().contains(word)) {
	            	++count;
	            	
	                isRegistered = true;
	                
	                System.out.println("#" + count);
					System.out.println("영단어 : " + voca.getWord());
					System.out.println("한국어뜻 : " + voca.getKormean());
					System.out.println("영어정의 : " + voca.getDefinition());
					System.out.print("유의어 : ");
	                for (String s : voca.getSimilar()) {
	                    System.out.print(s + " ");
	                }
	            }
	            System.out.println();
	        }
	        
	        
	        if(!isRegistered) {
	            System.out.println(word + " 은/는 단어장에 등록되지 않은 단어입니다.");
	        }
	        
	        System.out.println("=============================================");
	        System.out.println();
	        System.out.print("계속 검색하시겠습니까?(y/n) : ");
	        String s = sc.nextLine();

	        if(s.equalsIgnoreCase("n")) {
	            break;
	        }
	    }
	}
	
	
	// 단어추가 - 수정필요
	
	//중복저장 안되도록 
	//중복된 영단어 입력시 안내문 출력과 함께 메소드를 나가도록 return 
	//(추후 반복기능 추가할경우 break하여 영단어를 다시 입력하게함)
	public void addWord() {
	
		//영단어 입력 유효성검사
			String word = "";
			while(true) {
				
				System.out.print("영단어 입력 : ");
				word = sc.nextLine().trim(); 
				
				if(word.length() == 0) {
					System.out.println("잘못 입력하셨습니다. 영단어를 다시 입력해주세요.");
				}
				else if(word.length() > 0) {
					break; //영단어입력반복문을 끝낸다
				}
			}
			
			
			HashSet<VocaDTO> tmpHashSet = new HashSet<VocaDTO>();
			tmpHashSet.addAll(vocalist);
			Iterator<VocaDTO> tmpItr = tmpHashSet.iterator();
			while(tmpItr.hasNext()) {
				VocaDTO tmpVoca = tmpItr.next();
				if(tmpVoca.getWord().equals(word) || tmpVoca.getKormean().equals(word)) {
					System.out.println(word + "는 이미 등록된 단어입니다.");
					
					//이미 등록된 해당 단어를 보여주기
					System.out.println("==================등록된 단어정보====================");
					System.out.println("영단어 : " + tmpVoca.getWord());
					System.out.println("한국어뜻 : " + tmpVoca.getKormean());
					System.out.println("영어정의 : " + tmpVoca.getDefinition());
					System.out.print("유의어 : ");
					for (String s : tmpVoca.getSimilar()) {
						System.out.print(s + " ");
					}
					System.out.println();
					System.out.println("==================================================");
					System.out.println();
					
					return;
				}
			}	
			
			//한국어뜻 입력 유효성검사	
			String kormean = "";
			while(true) {
				
				System.out.print("한국어뜻 입력 : ");
				kormean = sc.nextLine().trim(); 
				
				if(kormean.length() == 0) {
					System.out.println("잘못 입력하셨습니다. 한국어뜻를 다시 입력해주세요.");
				}
				else if(kormean.length() > 0) {
					break; //한국어뜻입력반복문을 끝낸다
				}
			}
			
			//영영정의 입력 유효성검사	
			String engdefinition = "";
			while(true) {
				
				System.out.print("영어정의 입력 : ");
				engdefinition = sc.nextLine().trim(); 
				
				if(engdefinition.length() == 0) {
					System.out.println("잘못 입력하셨습니다. 영어정의를 다시 입력해주세요.");
				}
				else if(engdefinition.length() > 0) {
					break; //영어정의입력반복문을 끝낸다
				}
			}
			
			//유의어1 입력 유효성검사	
			String similar1 = "";
			while(true) {
				
				System.out.print("첫번째 유의어 입력 : ");
				similar1 = sc.nextLine().trim(); 
				
				if(similar1.length() == 0) {
					System.out.println("잘못 입력하셨습니다. 첫번째 유의어를 다시 입력해주세요.");
				}
				else if(similar1.length() > 0) {
					break; //유의어1입력반복문을 끝낸다
				}
			}
			
			//유의어2 입력 유효성검사	
			String similar2 = "";
			while(true) {
				
				System.out.print("두번째 유의어 입력 : ");
				similar2 = sc.nextLine().trim(); 
				
				if(similar2.length() == 0) {
					System.out.println("잘못 입력하셨습니다. 두번째 유의어를 다시 입력해주세요.");
				}
				else if(similar2.length() > 0) {
					break; //유의어2입력반복문을 끝낸다
				}
			}

		VocaDTO voca = new VocaDTO(word, kormean, engdefinition, new String[] { similar1, similar2 });
		vocalist.add(voca);

		System.out.println("단어 등록 완료!");

		System.out.println("==================추가된 단어정보====================");
		System.out.println("영단어 : " + voca.getWord());
		System.out.println("한국어뜻 : " + voca.getKormean());
		System.out.println("영어정의 : " + voca.getDefinition());
		System.out.print("유의어 : ");
        for (String s : voca.getSimilar()) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("==================================================");

	}//addWord()		
			

		

	// 단어 삭제
	public void deleteWord() {
		
		while(true) {
			Iterator<VocaDTO> itr = vocalist.iterator();
			
			if (!itr.hasNext()) {
				System.out.println("현재 단어장에 등록된 단어가 없습니다. 단어를 등록해주세요.");
				return;
			}
			
			showVoca();
		
			System.out.print("삭제할 단어를 입력하세요(영단어/한국어뜻) : ");
			String input = sc.nextLine();

			
			boolean removedSuccess = false;
			while(itr.hasNext()) {
				
				VocaDTO willRemoved = itr.next();
				
				if(willRemoved.getWord().equals(input) || willRemoved.getKormean().equals(input)) {
					itr.remove();
					System.out.println(input + "이/가 단어장에서 삭제되었습니다.");
					
					removedSuccess = true;
				}
			}
			
			if(!removedSuccess) {
				System.out.println(input + " 은/는 단어장에 등록되지 않은 단어입니다.");
			}
			
			
			System.out.print("단어를 더 삭제하시겠습니까?(y/n) : ");
			String s = sc.nextLine();
			
			if(s.equalsIgnoreCase("n")) {
				break;
			}
			
		}

	}

}


