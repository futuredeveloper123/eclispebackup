package ex;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysMain {
	public static void main(String[] args) {
		// 배열 생성 //배열은 특별한 경우가 아니면 int - > Integer float - >float으로 써주기
		Integer[] ar = { 1, 2, 3, 4, 5, 2 };

		// 단순하게 배열을 다른 변수에 대입
		Integer[] br = ar;
		// 이랬을 때 문제가 뭐냐면 다른 변수가 배열의 데이터를 수정하면 원본의 데이터도 수정됨 !!!
		br[0] = 101;

		// 배열의 데이터를 하나의 문자열로 빠르게 출력하고 싶을 때는
		System.out.println(Arrays.toString(ar));

		// 배열의 데이터를 복제 - 배열의 데이터를 순회하면서 직접 복제해 보는 것 중요!!!!!!*****
		Integer[] cr = Arrays.copyOf(ar, ar.length);
		cr[0] = 102;

		// 그대로임 데이터를 복제했기 때문에 cr의 데이터를 변경해도 원본에는 아무런 영향이 없음
		// 배열의 데이터가 전부 같은지 비교 ! = > equals
		System.out.println(Arrays.equals(ar, br)); // true
		System.out.println(Arrays.equals(ar, cr)); // false

		// 배열의 데이터 정렬
		// 숫자나 comparable 인터페이스가 구현된 데이터의 배열은
		// Arrays.sort 메서드를 이용해서 데이터를 오름차순으로 정렬할 수 있습니다 .
		Arrays.sort(ar);
		System.out.println(Arrays.toString(ar));

		// 내림차순 정렬이나 comparable 인터페이스가 구현되지 않은
		// 데이터의 정렬은 크 기 비교 방법을 지정해 주어야 합니다
		// comparator 인터페이스를 implements 한 인스턴스를 추가로 설정해주어야합니다
		// 크기 비교 메서드는 2개의 매개변수를 받는 메서드를 제공하는데
		// 이 메서드에서 양수가 리턴되면 앞의 데이터가 크다고 보고 위치를 변경하고
		// 음수가 리턴되면 뒤의 데이터가 크다고 판단해서 그대로 둡니다

		// 숫자는 뺄셈을 이용하면 되지만 String이나 Date는
		// 뺄셈을 할 수 없어서 compareTo라는 메서드로 크기 비교를 합니다 .
		Arrays.sort(ar, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		System.out.println(Arrays.toString(ar));

	}

}
