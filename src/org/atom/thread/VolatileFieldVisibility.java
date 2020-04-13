package org.atom.thread;

public class VolatileFieldVisibility {
	
	int a=0,b=0,c=0;
	volatile int v = 0;
	
	public void writerThread(){
		v=1;
		a=1;
		b=1;
		c=1;
		
		
	}
	
	public void readThread(){
		
		int x = v;
		
		int d1 = a;
		int d2 = b;
		int d3 = c;
		
		System.out.println(x+" "+d1+" "+d2+" "+d3);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VolatileFieldVisibility vb = new VolatileFieldVisibility();
		vb.writerThread();
		vb.readThread();

	}

}
