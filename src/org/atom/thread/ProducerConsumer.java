package org.atom.thread;

public class ProducerConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("==="+Runtime.getRuntime().availableProcessors());
		ArrayBlockingQueu<Integer> queu = new ArrayBlockingQueu<>(100);
		
		Thread producer = new Thread(()->{
			for(int i=0;i<1000;i++){
				try {
					queu.put(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread consumer = new Thread(()->{
			while (!queu.isEmpty()) {
				try {
					System.out.println(queu.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		producer.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		consumer.start();
	}

}
