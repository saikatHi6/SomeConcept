
public class RearrangePosNeg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {12, 11, -13, -5, 6, -7, 5, -3, -6};
		int arr1[] = {-12, 11, 0, -5, 6, -7, 5, -3, -6};
		positiveNegative(arr);
	}
	
	
	public static void positiveNegative(int arr[]){
		
		int count = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]<0){
				int temp = arr[i];
				int j = i-1;
				while(j >= 0 && arr[j] > 0){
					arr[j+1] = arr[j];
					j--;
				}
				arr[count] = temp;
				count++;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
