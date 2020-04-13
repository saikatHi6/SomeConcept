package org.atom.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayBlockingQueu<E> {

	Queue<E> queue;
	int size;
	ReentrantLock lock = new ReentrantLock();
	Condition notFull = lock.newCondition();
	Condition notEmpty = lock.newCondition();

	public ArrayBlockingQueu(int size) {
		this.size = size;
		queue = new LinkedList<>();
	}

	public void put(E e) throws InterruptedException{

		lock.lock();
		try{
			while(queue.size()==size){
				System.out.println("Queue is Full");
				notFull.await();
				
			}
			queue.add(e);
			notEmpty.signal();
		}
		finally {
			lock.unlock();
		}
	}

	public E get() throws InterruptedException{
		lock.lock();
		try {
			while(queue.size()==0){
				System.out.println("Queue is Empty");
				notEmpty.await();
				
			}
			E item = queue.remove(); 
			notFull.signal();
			return  item;
		} finally {
			lock.unlock();
		}

	}
	
	public boolean isEmpty() {
		return queue.size()==0;
	}

}
