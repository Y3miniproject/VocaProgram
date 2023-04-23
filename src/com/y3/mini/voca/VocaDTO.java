package com.y3.mini.voca;

import java.util.Arrays;

public class VocaDTO {
	
	private String word;
	private String kormean;
	private String definition;
	private String[] similar; //유의어를 두개저장
	
	public VocaDTO() {}
	
	
	public VocaDTO(String word, String kormean, String definition, String[] similar) {
		super();
		this.word = word;
		this.kormean = kormean;
		this.definition = definition;
		this.similar = similar;
	}
	
	
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getKormean() {
		return kormean;
	}
	public void setKormean(String kormean) {
		this.kormean = kormean;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public String[] getSimilar() {
		return similar;
	}
	public void setSimilar(String[] similar) {
		this.similar = similar;
	}


	@Override
	public String toString() {
		return "[영단어=" + word + ", 한국어 뜻=" + kormean + ", 영어 정의=" + definition 
				+ ", 유의어=" + Arrays.toString(similar) + "]";
	}
	
	
	
}



