import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenricTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> myInts = new ArrayList<Integer>();
		myInts.add(1);
		//List<Long> myLongs = asList(1L, 2L, 3L, 4L, 5L);
		//List<Double> myDoubles = asList(1.0, 2.0, 3.0, 4.0, 5.0);
		System.out.println(sum(myInts)); //compiler error
		//System.out.println(sum(myLongs)); //compiler error
		//System.out.println(sum(myDoubles)); //compiler error
		
	}
	
	static long sum(List<? extends Number> numbers) {
		long summation = 0;
		//numbers.add(1);
		Number num = numbers.get(0);
		for(Object number : numbers) {
		//summation += number.longValue();
		}
		return summation;
		}
	
}
