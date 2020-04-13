package org.atom.thread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class TestConcepts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Printer print  = new Printer(false, 1);
		AtomicInteger imInt = new AtomicInteger(1);
		AtomicBoolean imBol = new AtomicBoolean(false);
		int a=20;
		//Boolean flag = new Boolean(false);
		Thread odd = new Thread(()->{

			while(imInt.get()!=a){
				/*try {
					print.odd();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				synchronized (imBol) {
					if(imBol.get()){
						try {
							imBol.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName()+" "+imInt);
					imInt.incrementAndGet();
					imBol.set(true);
					
					imBol.notify();

				}

			}

		});

		Thread even = new Thread(()->{
			while(imInt.get()!=a){
				/*try {
					print.even();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/

				synchronized (imBol) {
					if(!imBol.get()){
						try {
							imBol.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName()+" "+imInt);
					imInt.incrementAndGet();
					imBol.set(false);
					imBol.notify();
				}


			}

		});

		odd.start();
		even.start();

	}


}

class Printer{
	boolean flag ;
	int val ;
	private Object obj = new Object();
	public Printer(boolean flag,int val) {
		this.flag = flag;
		this.val = val;
	}
	public synchronized void odd() throws InterruptedException{
		//synchronized (obj) {
		while(flag)
			wait();
		System.out.println(Thread.currentThread().getName()+" "+val);
		val++;
		flag = true;
		notify();
		//}

	}

	public synchronized void even() throws InterruptedException{
		//synchronized (obj) {
		while(!flag)
			wait();
		System.out.println(Thread.currentThread().getName()+" "+val);
		val++;
		flag = false;
		notify();
		//}

	}


}
