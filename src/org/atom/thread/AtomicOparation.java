package org.atom.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class AtomicOparation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		AtomicLong counter = new AtomicLong();
		LongAdder counterAdd = new LongAdder();
		LongAccumulator aCounter = new LongAccumulator((x,y)->x+y, 0);
		List<List<Integer>> result = new ArrayList<>();
	    
		
		ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		for(int i=0;i<100;i++){
			ex.submit(()->{
				counter.incrementAndGet();
				counterAdd.increment();
				aCounter.accumulate(1);
			});
		}
		
		//Thread.sleep(20);
		
		System.out.println(counter.get());
		System.out.println(counterAdd.sum());
		System.out.println(aCounter.get());
		ex.shutdown();

	}

}
