import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.RecursiveAction;

public class Elephant  extends RecursiveAction{

	
	public static void main(String[] args) throws Throwable {
		
		final Animal a = new Human();
		
		final Human h = new Human();
		h.display(1);
		
		/*Set<ContType> contTypes = new TreeSet<>();
		Set<ContType> contTypes1 = new HashSet<>();
		Set<ContType> contTypes2 = new LinkedHashSet<>();
		System.out.println(createList(contTypes).size());
		System.out.println(createList(contTypes1).size());
		System.out.println(createList(contTypes2).size());*/
		
	}
	
	public static Set<ContType> createList(Set<ContType> contTypes){
		contTypes.add(new ContType(1, "A"));
		contTypes.add(new ContType(2, "A"));
		contTypes.add(new ContType(3, "B"));
		contTypes.add(new ContType(4, "C"));
		return contTypes;
	}

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		
	}
	
}
