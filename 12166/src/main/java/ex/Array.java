package ex;

import java.util.Arrays;
import java.util.Comparator;

public class Array {

	public static void main(String[] args) {
		
		Integer [] ar = {91 , 89, 93 , 04};
		
		Integer [] br = ar ;
		
		br[0] =101 ; 
		
		System.out.println(Arrays.toString(ar));
		
		Integer [] cr = Arrays.copyOf(ar,ar.length);
		
		cr[0] = 102;
		
		System.out.println(Arrays.toString(ar));
		
		System.out.println(Arrays.equals(ar, br));
		System.out.println(Arrays.equals(ar,cr));
		
		Arrays.sort(ar);
		System.out.println(Arrays.toString(ar));
		
		Arrays.sort(ar, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		System.out.println(Arrays.toString(ar));
	}

}
