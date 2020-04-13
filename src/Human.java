import java.util.Hashtable;

public class Human  extends Animal{
	
	{
		System.out.println("Empty");
	}
	
	private int htl;
	
	static{
		System.out.println("Static");
	}
	
	public Human() throws Throwable{
		//super();
		
		System.out.println("Human");
	}

	public void display(int i) throws Exception{
		this.htl = i;
		
		
	}
	
}
class Animal{
	
	public Animal() throws Exception{
		System.out.println("Animal");
	}
	
	protected void display() throws Throwable{
		
	}
}