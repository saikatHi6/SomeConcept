package org.atom.thread;

public class PrintByThreads {

	int increm = 0;
	int range;
	volatile boolean flag;

	public PrintByThreads(int range) {
		this.range = range;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrintByThreads prin = new PrintByThreads(20);
		new Thread(()->{
			try {
				prin.printOdd();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		new Thread(()->{
			try {
				prin.prinEven();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();

	}

	public void printOdd() throws InterruptedException{
		while(increm!=range){
			synchronized (this) {
				while(flag){
					wait();
				}
				increm++;
				System.out.println(increm);
				flag = true;
				notify();
			}
		}
	}

	public void prinEven() throws InterruptedException{
		while(increm!=range){
			synchronized (this) {
				while(!flag){
					wait();
				}
				increm++;
				System.out.println(increm);
				flag = false;
				notify();
			}
		}
	}


	class Printer{

	}







}
