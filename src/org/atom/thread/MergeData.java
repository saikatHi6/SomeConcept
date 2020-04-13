package org.atom.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		List<Integer> merged = new ArrayList<Integer>();
		CompletionService<List<Integer>> completionService = 
			       new ExecutorCompletionService<>(ex);
		completionService.submit(()->{
			List<Integer> list = new ArrayList<>();
			for(int i=1;i<=100;i++){
				System.out.println(i);
				list.add(i);	
			}
			return list;
		});
		completionService.submit(()->{
			List<Integer> list = new ArrayList<>();
			for(int i=101;i<=200;i++){
				System.out.println(i);
				list.add(i);	
			}
			return list;
		});
		completionService.submit(()->{
			List<Integer> list = new ArrayList<>();
			for(int i=201;i<=300;i++){
				System.out.println(i);
				list.add(i);	
			}
			return list;
		});
		
		int rec = 0;
		
		boolean error=false;
		while(rec<3 && !error){
			try {
				Future<List<Integer>> f = completionService.take();
				for (Integer val : f.get()) {
					merged.add(val);
				}
				rec++;
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				error = true;
				e.printStackTrace();
			}
			
		}
		
		ex.shutdown();
		
		System.out.println(merged.size());
		
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
