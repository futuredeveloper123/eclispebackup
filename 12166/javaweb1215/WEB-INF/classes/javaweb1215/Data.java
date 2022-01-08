package javaweb1215;

import java.io.Serializable;
import java.util.Arrays;

//Comparable은 크기 비교를 위한 compareTo 메서드를 소유한 인터페이스
//Cloneable 은 인스턴스를 복제할 수 있는 clone 메서드를 소유한 인터페이스
//Serializable은 인스턴스를 직렬화하는데 사용 - 다른 곳으로 전송
public class Data implements Comparable, Cloneable, Serializable {
	private int num;
	private String name;
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
	//배열이나 List가 있을 때는 인덱스를 받아서 1개의 리턴하고
	//설정하는 메서드도 추가해주면 좋습니다.
	public int getScore(int idx) {
		return scores[idx];
	}
	public void setScore(int score, int idx) {
		scores[idx] = score;
	}
	
	//등가성을 위한 메서드
	//빠르게 비교하기 위해서는 hashCode를 이용하는 방법이 있습니다.
	//num을 해시코드로 이용
	@Override
	public int hashCode() {
		return num;
	}
	
	//equals 메서드
	@Override
	public boolean equals(Object other) {
		//매개변수로 대입된 데이터를 원래의 자료형으로 변환
		Data data = (Data)other;
		
		if(num == data.num && name.equals(data.name)) {
			return true;
		}
		return false;
	}
	
	
	//디버깅을 위한 메서드
	@Override
	public String toString() {
		return "Data [num=" + num + ", name=" + name + ", scores=" + Arrays.toString(scores) + "]";
	}
	
	@Override
	//크기 비교할 때 사용하는 메서드
	//배열이나 List의 데이터를 정렬할 때 사용
	public int compareTo(Object o) {
		Data data = (Data)o;
		//return num - data.num;
		return name.compareTo(data.name);
	}
	
	//인스턴스를 복제하기 위한 메서드
	@Override
	public Data clone() {
		Data data = new Data();
		
		data.num = num;
		//문자열은 복사 생성자를 이용해서 복제
		data.name = new String(name);
		//배열이나 List를 메모리를 공간을 생성한 후 
		//요소를 하나씩 복제를 합니다.
		data.scores = new int[scores.length];
		for(int i=0; i<scores.length; i=i+1) {
			data.scores[i] = scores[i];
		}
		
		return data;
	}
	
}







