package com.y3.mini.voca;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class VocaManager {

	public HashSet<VocaDTO> vocalist = new HashSet<>();
	Scanner sc = new Scanner(System.in);
	
	boolean answerY = false;
	
	
    //초기 단어
	public VocaManager() {
		VocaDTO voca1 = new VocaDTO("benefit", "이익", "a good or helpful result or effect", new String[] {"abvantage", "profit"});
		VocaDTO voca2 = new VocaDTO("cracker", "과자", "a thin, crisp snack" , new String[] {"cookie", "biscuit"});
		VocaDTO voca3 = new VocaDTO("value", "가치", "something that can be bought for a low or fair price", new String[] {"worth", "price"});
		VocaDTO voca4 = new VocaDTO("only", "유일한", "nothing other than", new String[] {"just", "simply"});
		VocaDTO voca5 = new VocaDTO("adorable", "사랑스러운", "extremely charming or appealing", new String[] {"lovely", "cute"});	
		VocaDTO voca6 = new VocaDTO("smart", "똑똑한", "very good at learning or thinking about things", new String[] {"intelligent", "clever"});	
		VocaDTO voca7 = new VocaDTO("answer", "대답하다", "to say or write something when someone asks you a question", new String[] {"respond", "reply"});	
		VocaDTO voca8 = new VocaDTO("joyful", "즐거운", "feeling, causing, or showing great happiness", new String[] {"enjoyable", "pleasant"});	
		VocaDTO voca9 = new VocaDTO("persuade", "설득하다", "to cause (someone) to do something by asking arguing", new String[] {"convince", "prevail on"});	
		VocaDTO voca10 = new VocaDTO("colleague", "동료", "a person who works with you", new String[] {"workmate", "coworker"});	
		
		vocalist.add(voca1);
		vocalist.add(voca2);
		vocalist.add(voca3);
		vocalist.add(voca4);
		vocalist.add(voca5);
		vocalist.add(voca6);
		vocalist.add(voca7);
		vocalist.add(voca8);
		vocalist.add(voca9);
		vocalist.add(voca10);
	}
	
	
	// 단어장 조회
	public void showVoca() {

		if (vocalist.isEmpty()) {
			System.out.println();
			System.out.println("현재 단어장에 단어가 없습니다. 단어를 등록해주세요.");
			System.out.println();
			
			callAddWord();
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
		
		System.out.println();
		System.out.println("==========================================단어장============================================");
		if (!sortedList.isEmpty()) {
			
			for(VocaDTO v : sortedList) {
				System.out.println(v.toString());
				System.out.println("-------------------------------------------------------------------------------------------");
			}
		}
		System.out.println();
	}

	
	// 단어검색
	public void searchWord() {
	    while(true) {
	        Iterator<VocaDTO> itr = vocalist.iterator();
	        
	        if (!itr.hasNext()) {
	        	System.out.println();
	            System.out.println("현재 단어장에 등록된 단어가 없습니다. 단어를 등록해주세요.");
	            System.out.println();

	            callAddWord();
	            return;
	        }
	        
	        
	        //검색할단어 입력에 유효성검사 추가	
			String word = "";
			while(true) {
				System.out.println();
				System.out.print("검색할 단어를 입력하세요(영단어/한국어뜻) : ");
				word = sc.nextLine().trim().toLowerCase(); 
				
				if(word.length() == 0) {
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
				else if(word.length() > 0) {
					break;
				}
			}
	        
	        
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
	        System.out.println("=====================검색 결과=====================");
	        System.out.println("총 " + tmpCount + "건이 검색되었습니다.");
	        
	        
	        boolean isRegistered = false;
	        int count = 0;
	        while(itr.hasNext()) {
	            VocaDTO voca = itr.next();
	            
	            if(voca.getWord().contains(word) || voca.getKormean().contains(word)) {
	            	++count;
	            	
	                isRegistered = true;
	                
	                System.out.println();
	                System.out.println("#" + count);
					System.out.println("영단어 : " + voca.getWord());
					System.out.println("한국어뜻 : " + voca.getKormean());
					System.out.println("영어정의 : " + voca.getDefinition());
					System.out.print("유의어 : ");
	                for (String s : voca.getSimilar()) {
	                    System.out.print(s + " ");
	                }
	            }
	        }
	        System.out.println();
	        System.out.println("==================================================");
	        
	        
	        if(!isRegistered) {
	        	System.out.println();
	            System.out.println(word + " 은/는 단어장에 등록되지 않은 단어입니다.");
	            System.out.println();
	            
	            callAddWord();
				
	        }
	        
	        askRepeat("검색");
	        if(!answerY) return;
	    }
	}
	
	
	// 단어추가
	public void addWord() {
		
		String exitKeyword = "*";
		System.out.println();
		System.out.println("※원하는 단어를 추가해보세요. 종료를 원하시는 경우 언제든 *를 입력하시어 현재 메뉴를 나가실 수 있습니다.");
		
		label:
		while(true) {
			
			//영단어 입력 유효성검사
			String word = "";
			while(true) {
				
				System.out.print("영단어 입력 : ");
				word = sc.nextLine().trim().toLowerCase(); //대문자 입력시에도 단어장에는 소문자로 저장되도록함 
				
				if(word.equals("*")) {
					System.out.println();
					System.out.println("단어 추가를 종료합니다.");
					return;
				}
				
				if(word.length() == 0) {
					System.out.println();
					System.out.println("잘못 입력하셨습니다. 영단어를 다시 입력해주세요.");
					System.out.println();
				}
				
				//빈문자열이 아니면서 영문자일 경우에만 영단어입력 반복을 종료 
				else if(word.length() > 0) {
					if(97 <= word.charAt(0) && word.charAt(0) <= 122) {
						break;
					}
					else {
						System.out.println();
						System.out.println("잘못 입력하셨습니다. 영단어를 다시 입력해주세요.");
						System.out.println();
					}
				}
				
			}
			
			
			HashSet<VocaDTO> tmpHashSet = new HashSet<VocaDTO>();
			tmpHashSet.addAll(vocalist);
			Iterator<VocaDTO> tmpItr = tmpHashSet.iterator();
			while(tmpItr.hasNext()) {
				VocaDTO tmpVoca = tmpItr.next();
				if(tmpVoca.getWord().equals(word)) {
					System.out.println(word + "은/는 이미 등록된 단어입니다.");
					
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
					
					askRepeat("추가"); 
					if(answerY) continue label;
					if(!answerY) return;
				}
			}	
			
			//한국어뜻 입력 유효성검사	
			String kormean = "";
			while(true) {
				
				System.out.print("한국어뜻 입력 : ");
				kormean = sc.nextLine().trim(); 
				
				if(kormean.equals("*")) {
					System.out.println();
					System.out.println("단어 추가를 종료합니다.");
					return;
				}
				
				if(kormean.length() == 0) {
					System.out.println();
					System.out.println("잘못 입력하셨습니다. 한국어뜻을 다시 입력해주세요.");
					System.out.println();
				}

				//빈문자열이 아니면서 한글일 경우에만 한국어뜻 입력 반복을 종료 
				else if(kormean.length() > 0) {
					if('\uAC00' < kormean.charAt(0) && kormean.charAt(0) < '\uD7AF') {
						break;
					}
					else {
						System.out.println();
						System.out.println("잘못 입력하셨습니다. 한국어뜻을 다시 입력해주세요.");
						System.out.println();
					}
				}

			}
				
			
			//영어정의 입력 유효성검사	
			String engdefinition = "";
			while(true) {
				
				System.out.print("영어정의 입력 : ");
				engdefinition = sc.nextLine().trim(); 
				
				if(engdefinition.equals("*")) {
					System.out.println();
					System.out.println("단어 추가를 종료합니다.");
					return;
				}
				
				if(engdefinition.length() == 0) {
					System.out.println();
					System.out.println("잘못 입력하셨습니다. 영어정의를 다시 입력해주세요.");
					System.out.println();
				}

				//빈문자열이 아니면서 영어일 경우에만 영어정의 입력 반복을 종료 
				else if(engdefinition.length() > 0) {
					if(97 <= engdefinition.charAt(0) && engdefinition.charAt(0) <= 122
							|| 65 <= word.charAt(0) && word.charAt(0) <= 90) {
						break;
					}
					else {
						System.out.println();
						System.out.println("잘못 입력하셨습니다. 영어정의를 다시 입력해주세요.");
						System.out.println();
					}
				}
			}
			
			
			//유의어1 입력 유효성검사	
			String similar1 = "";
			while(true) {
				
				System.out.print("첫번째 유의어 입력 : ");
				similar1 = sc.nextLine().trim().toLowerCase(); //대문자 입력시에도 단어장에는 소문자로 저장되도록함 
				
				if(similar1.equals("*")) {
					System.out.println();
					System.out.println("단어 추가를 종료합니다.");
					return;
				}
				
				if(similar1.length() == 0) {
					System.out.println("잘못 입력하셨습니다. 첫번째 유의어를 다시 입력해주세요.");
				}
				//빈문자열이 아니면서 영문자일 경우에만 유의어1 반복을 종료 
				else if(similar1.length() > 0) {
					if(97 <= similar1.charAt(0) && similar1.charAt(0) <= 122) {
						break;
					}
					else {
						System.out.println();
						System.out.println("잘못 입력하셨습니다. 첫번째 유의어를 다시 입력해주세요.");
						System.out.println();
					}
				}
			}
			
			//유의어2 입력 유효성검사	
			String similar2 = "";
			while(true) {
				
				System.out.print("두번째 유의어 입력 : ");
				similar2 = sc.nextLine().trim().toLowerCase(); //대문자 입력시에도 단어장에는 소문자로 저장되도록함 
				
				if(similar2.equals("*")) {
					System.out.println();
					System.out.println("단어 추가를 종료합니다.");
					return;
				}
				
				if(similar2.length() == 0) {
					System.out.println("잘못 입력하셨습니다. 두번째 유의어를 다시 입력해주세요.");
				}
				//빈문자열이 아니면서 영문자일 경우에만 유의어2입력 반복을 종료 
				else if(similar2.length() > 0) {
					if(97 <= similar2.charAt(0) && similar2.charAt(0) <= 122) {
						break;
					}
					else {
						System.out.println();
						System.out.println("잘못 입력하셨습니다. 두번째 유의어를 다시 입력해주세요.");
						System.out.println();
					}
				}
			}
			
			VocaDTO voca = new VocaDTO(word, kormean, engdefinition, new String[] { similar1, similar2 });
			vocalist.add(voca);
			
			System.out.println();
			System.out.println("단어 등록 완료!");
			System.out.println();
			
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
			
			
			askRepeat("추가"); if(!answerY) return;
		}
		
	}//addWord()		
			


	// 단어 삭제
	public void deleteWord() {
		
		while(true) {
			Iterator<VocaDTO> itr = vocalist.iterator();
			
			if (!itr.hasNext()) {
				System.out.println(); 
				System.out.println("현재 단어장에 등록된 단어가 없습니다. 단어를 등록해주세요.");
				System.out.println();
				
				callAddWord();
				return;
			}
			
			showVoca();
			
			//단어장비우기에 사용될 암호(OTP) 만들기
			String matarial = "BCDFGHJKLMNPQRSTVWZYZbcdfghjklmnpqrstvwyz0123456789!@#$%^&*!@#$%^&*!@#$%^&*";
			int codeSize = 5;
			Random random = new Random();
			StringBuilder sb = new StringBuilder(codeSize);
			for (int i = 0; i < codeSize; i++) {
			    int index = random.nextInt(matarial.length());
			    char randomCh = matarial.charAt(index);
			    sb.append(randomCh);
			}
			String randomStr = sb.toString();
			
			
			System.out.println("※등록된 단어의 일괄 삭제가 가능합니다. 단어장 비우기를 원하시면 [ " + randomStr + " ]를 입력하세요.");   
			System.out.print("삭제할 단어 입력(영단어/한국어뜻) : ");
			String input = sc.nextLine();
			System.out.println();
			
			boolean removedSuccess = false;
			while(itr.hasNext()) {
				
				VocaDTO willRemoved = itr.next();
				
				if(willRemoved.getWord().equals(input) || willRemoved.getKormean().equals(input)) {
					itr.remove();
					System.out.println(input + "이/가 단어장에서 삭제되었습니다.");
					
					removedSuccess = true;
				}
			}
			
			//단어장 비우기(랜덤한 암호와 일치할경우)
			if(input.equals(randomStr)) {
				vocalist.clear();
				System.out.println("단어장을 깨끗이 비웠습니다.");
				System.out.println();
				return;
			}
			
			if(!removedSuccess) {
				System.out.println(input + " 은/는 단어장에 등록되지 않은 단어입니다.");
				System.out.println();
			}
			
			askRepeat("삭제"); if(!answerY) return;
		}

	}//deleteWord()
	
	
	
	//사용자선택에 따라 addWord()호출하는 메소드
	public void callAddWord() {
		
		while(true) {
			System.out.println();
			System.out.print("단어를 등록하시겠습니까?(Y/N) : ");
			String answer = sc.nextLine().trim();
			if(answer.equalsIgnoreCase("y")) {
				addWord();
				return;
			} else if(answer.equalsIgnoreCase("n")) {
				return;
			} 
			else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
		
	}
	
	
	//해당 기능의 반복 여부를 묻는 메소드
	public boolean askRepeat(String methodName) {
		while(true) {
			System.out.println();
			System.out.print("계속 " + methodName + "하시겠습니까?(Y/N) : ");
			String s = sc.nextLine();
			System.out.println();
			
			if(s.equalsIgnoreCase("y")) {
				answerY = true;
				break;
			} else if(s.equalsIgnoreCase("n")) {
				answerY = false;
				System.out.println("메뉴로 이동합니다.");
				return answerY;
			} 
			else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
		return answerY;
	}
	
}


