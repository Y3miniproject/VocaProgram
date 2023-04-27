package com.y3.mini.voca;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class VocaManager {

	public List<VocaDTO> vocalist = new ArrayList<>();
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

		Iterator<VocaDTO> itr = sortedList.iterator();

		System.out.println("=======단어장=======");
		while (itr.hasNext()) {
			System.out.println(itr.next().toString());
			System.out.println("-----------------");
		}

	}

	// 단어검색 - 수정필요
	public void searchWord() {

		while(true) {
			
			Iterator<VocaDTO> itr = vocalist.iterator();
			if (!itr.hasNext()) {
				System.out.println("현재 단어장에 등록된 단어가 없습니다. 단어를 등록해주세요.");
				return;
			}
			
			System.out.print("검색하려는 단어를 입력하세요 : ");
			String word = sc.nextLine();
			
			
			while (itr.hasNext()) {  //출력문 중복실행되므로 수정필요
				VocaDTO v = itr.next();
				if (v.getWord().contains(word) || v.getKormean().contains(word)) {
					System.out.println("영단어 : " + v.getWord());
					System.out.println("한국어뜻 : " + v.getKormean());
					System.out.println("영어정의 : " + v.getDefinition());
					System.out.print("유의어 : ");
					for (String s : v.getSimilar()) {
						System.out.print(s + " ");
					}
					System.out.println();
//					return;
				} 
			}
			System.out.println(word + " 은/는 단어장에 등록되지 않은 단어입니다.");
			
			System.out.print("계속 검색하시겠습니까?(y/n) : ");
			String s = sc.nextLine();
			
			if(s.equalsIgnoreCase("n")) {
				break;
			}
		
		}//while
	}

	// 단어추가 - 수정필요
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

		VocaDTO voca = new VocaDTO(word, kormean, engdefinition, new String[] { similar1, similar2 });
		vocalist.add(voca);

		System.out.println("단어 등록 완료!");

		System.out.println("---새로 추가된 단어---");
		System.out.println(voca.toString());
		System.out.println("-------------------");

	}

	// 단어 삭제
	public void deleteWord() {
		
		while(true) {
			Iterator<VocaDTO> itr = vocalist.iterator();
			
			if (!itr.hasNext()) {
				System.out.println("현재 단어장에 등록된 단어가 없습니다. 단어를 등록해주세요.");
				return;
			}
			
			showVoca();
		
			System.out.print("삭제할 단어를 입력하세요 : ");
			String word = sc.nextLine();
			
			for (VocaDTO v : vocalist) {
				if (v.getWord().equals(word) || v.getKormean().equals(word)) {
					vocalist.remove(v);
					System.out.println(word + "이/가 단어장에서 삭제되었습니다.");
//					return;
				}
			}
			System.out.println(word + " 은/는 단어장에 등록되지 않은 단어입니다.");
			
			
			System.out.print("단어를 더 삭제하시겠습니까?(y/n) : ");
			String s = sc.nextLine();
			
			if(s.equalsIgnoreCase("n")) {
				break;
			}
			
		}//while

	}

}


