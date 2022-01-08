package javaweb1215;

import java.util.Arrays;

public class Data {

	private int num;
	private String name ;
	private int [] scores;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getScores() {
		return scores;
	}
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	public int getScore(int idx) {
		return scores[idx];
	}
	public void setScore(int score, int idx) {
		scores[idx] = score;
		
		
		
		
		
	//등가성을 위한 메서드 
	//빠르게 비교하기 위해서는 hashCode를 이용하는 방법이 있습니다 .
	//num을 해시코드로 이용 
	@Override
	public int hashCode() {
		//매개변수로 대입된 데이터를 원래의 자료형으로 변환 
		Data data = (Data)other;
	}
		return num;
	}
	
	//equals 메서드 
	@Override
	public boolean equals ( Data other ) {
		
	}
	
	//디버깅을 위한 메서드  
	@Override
	public String toString() {
		return "Data [num=" + num + ", name=" + name + ", scores=" + Arrays.toString(scores) + "]";
	}
	
	
	
}
