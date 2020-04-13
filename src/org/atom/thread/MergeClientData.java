package org.atom.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeClientData {

	static String[] clients = {"Morgan Stanly","Tata","Wework","Microsoft","Google"};
	static int count = 0;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String[] dataA = new String[5];
		String[] dataB = new String[5];
		String[] dataC = new String[5];

		Runnable fectchDataFromSourceA = ()->{
			for (int i = 0; i < 5; i++) {
				String clientName = pickRandomClient();
				if(clientName==null)break;
				dataA[i] = clientName;
				System.out.println(Thread.currentThread().getName()+" is fetch data for client "+clientName+" from source A");
			}
		};
		
		Runnable fectchDataFromSourceB = ()->{
			for (int i = 0; i < 5; i++) {
				String clientName = pickRandomClient();
				if(clientName==null)break;
				dataB[i] = clientName;
				System.out.println(Thread.currentThread().getName()+" is fetch data for client "+clientName+" from source B");
			}
		};
		
		Runnable fectchDataFromSourceC = ()->{
			for (int i = 0; i < 5; i++) {
				String clientName = pickRandomClient();
				if(clientName==null)break;
				dataC[i] = clientName;
				System.out.println(Thread.currentThread().getName()+" is fetch data for client "+clientName+" from source C");
			}
		};
		
		Thread t1 = new Thread(fectchDataFromSourceA);
		Thread t2 = new Thread(fectchDataFromSourceB);
		Thread t3 = new Thread(fectchDataFromSourceC);
		
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		
		
		
		t3.join();
		
		List<String> list = new ArrayList<>();
		mergeData(dataA, list);
		mergeData(dataB, list);
		mergeData(dataC, list);
		
		System.out.println(list.size());
		
		
	}

	private static String pickRandomClient() {
		// TODO Auto-generated method stub
		if(count>clients.length-1)
			return null;
		synchronized (clients) {
			
			return clients[count++];
		}
		
	}
	
	private static List<String> mergeData(String[] data,List<String> list){
		for (int i = 0; i < data.length; i++) {
			if(data[i]==null)
				return list;
			list.add(data[i]);
		}
		return list;
	}
	
	

}
