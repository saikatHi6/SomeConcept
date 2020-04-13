package org.atom.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class EmployeeTest {

	//private static Object Employee;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee e1 = new Employee("F", 5, 1000.5,"ENG");
		Employee e2 = new Employee("P", 3, 1000.5,"ENG");
		Employee e3 = new Employee("E", 2, 100.5,"IT");
		Employee e4 = new Employee("E", 4, 1050.5,"IT");
		Employee e5 = new Employee("AC", 1, 2000.5,"OP");
		Employee e6 = new Employee("E", 2, 100.5,"OP");

		Set<Employee> eSet = new HashSet<>();
		eSet.add(e1);
		eSet.add(e2);
		eSet.add(e3);
		eSet.add(e4);
		eSet.add(e5);
		eSet.add(e6);
		System.out.println(e3.equals(e6));
		System.out.println(e3==e6);
		eSet.stream().forEach(System.out::println); //unique values without maintaining any order

		System.out.println("=======================================");

		Set<Employee> eLset = new LinkedHashSet<>();
		eLset.add(e1);
		eLset.add(e2);
		eLset.add(e3);
		eLset.add(e4);
		eLset.add(e5);
		eLset.add(e6);
		eLset.stream().forEach(System.out::println); //unique values maintaining insertion order


		System.out.println("=======================================");

		Set<Employee> eTset = new TreeSet<>();
		eTset.add(e1);
		eTset.add(e2);
		eTset.add(e3);
		eTset.add(e4);
		eTset.add(e5);
		eTset.add(e6);
		eTset.stream().forEach(System.out::println);//sorted set not dependend on equals


		System.out.println("=======================================");

		Comparator<Employee> eSal = new Comparator<Employee>() {

			@Override
			public int compare(org.atom.model.Employee o1, org.atom.model.Employee o2) {
				if(o1.getSalary()==o2.getSalary()){
					return 0;
				}
				else if(o1.getSalary()>o2.getSalary())
					return 1;
				else
					return -1;
			}
		};

		Comparator<Employee> eUser = new Comparator<Employee>() {

			@Override
			public int compare(org.atom.model.Employee o1, org.atom.model.Employee o2) {
				return o1.getUserName().compareTo(o2.getUserName());
			}
		};

		Comparator<Employee> eId = new Comparator<Employee>() {

			@Override
			public int compare(org.atom.model.Employee o1, org.atom.model.Employee o2) {
				return o1.getId()-o2.getId();
			}
		};

		eSet.stream().sorted(eSal).forEach(System.out::println); //sorted set not dependend on equals
		//eSet.stream().forEach(System.out::println);//sorted set not dependend on equals
		System.out.println("=======================================");
		eSet.stream().sorted(eSal).forEach(System.out::println);
		System.out.println("=======================================");
		eTset.stream().sorted(eUser).forEach(System.out::println);

		Map<String, Integer> map = new HashMap<String, Integer>();
		Set<Map.Entry<String, Integer>> s = map.entrySet();


		List<Employee> emList = new LinkedList<>(eLset);


		EmployeeTest eT = new EmployeeTest();
		Collections.sort(emList, eT.new EmployeeComparatorChain(eT.new EmployeeSortBySalary(),eT.new EmployeeSortByUname(),eT.new EmployeeSortById()));
		System.out.println("=======================================");
		emList.stream().forEach(System.out::println);
		Map<String, Long> disMap = eSet.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));
		disMap.entrySet().stream().forEach(System.out::println);
		
		System.out.println("=======================================");
		emList.stream()
			  .filter(e->e.getDept().equals("IT"))
			  .forEach(System.out::print);
		System.out.println("=======================================");
		List<String> deprtmentList = emList.stream()
											  .filter(distinctByKey(Employee::getDept))
											  .flatMap(e -> Stream.of(e.getDept()))
											  .collect(Collectors.toList());
		System.out.println(deprtmentList);
		
		Set<String> depList = emList.stream()
									.flatMap(e -> Stream.of(e.getDept()))
									.collect(Collectors.toSet());
		System.out.println(depList);
		
		Iterator<Employee> itr = emList.iterator();
		while (itr.hasNext()) {
			if(itr.next().getId()==2){
				itr.remove();
			}
		}

	}

	
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
	  {
	    Map<Object, Boolean> seen = new HashMap<>();
	    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	  }
	
	public class EmployeeSortBySalary implements Comparator<Employee>{
		@Override
		public int compare(org.atom.model.Employee o1, org.atom.model.Employee o2) {
			if(o1.getSalary()==o2.getSalary()){
				return 0;
			}
			else if(o1.getSalary()>o2.getSalary())
				return 1;
			else
				return -1;
		}
	}

	public class EmployeeSortById implements Comparator<Employee>{
		@Override
		public int compare(org.atom.model.Employee o1, org.atom.model.Employee o2) {
			return o1.getId()-o2.getId();
		}
	}

	public class EmployeeSortByUname implements Comparator<Employee>{
		@Override
		public int compare(org.atom.model.Employee o1, org.atom.model.Employee o2) {
			return o1.getUserName().compareTo(o2.getUserName());
		}
	}


	public class EmployeeComparatorChain implements Comparator<Employee>{

		List<Comparator<Employee>> listComparator = null;

		@SafeVarargs
		public EmployeeComparatorChain(Comparator<Employee>... listComparator) {
			this.listComparator = Arrays.asList(listComparator);
		}



		@Override
		public int compare(org.atom.model.Employee o1, org.atom.model.Employee o2) {
			// TODO Auto-generated method stub

			for (Comparator<Employee> comparator : listComparator) {
				int result = comparator.compare(o1, o2);
				if(result!=0)
					return result;
			}


			return 0;
		}

	}











	public static void stackOverFlow() {
		while(true){
			//Employee e1 = new Employee("Rame","***");
		}
		//stackOverFlow();
	}



}
