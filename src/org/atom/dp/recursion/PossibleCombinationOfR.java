package org.atom.dp.recursion;

import java.util.ArrayList;
import java.util.List;

public class PossibleCombinationOfR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr ={1, 2, 3, 4, 5};
		int r = 3;
		List<List<Integer>> result = new ArrayList<>();
		combinationR(arr, r, result, 0,new ArrayList<>());
		for (List<Integer> list : result) {
			list.stream().forEach(System.out::println);
		}
	}

	public static void combinationR(int[] arr,int r,List<List<Integer>> result,int index,List<Integer> list){
		if(list.size()==r){
			result.add(new ArrayList<>(list));
			return;
		}
		if(arr.length==index)
			return ;
		List<Integer> withCurVal = new ArrayList<>(list);
		withCurVal.add(arr[index]);

		//for (int i = index+1; i < arr.length; i++) {

		combinationR(arr, r, result, index+1,list);
		combinationR(arr, r, result, index+1,withCurVal);
		//list.remove(list.size()-1);
		//}


		//result.add(list);
	}

}
