package org.atom.model;

public class Employee implements Comparable<Employee>{

	private String userName;
	//private String password;
	private int id;
	private double salary;
	private String dept;
	
	
	
	public Employee(String userName, int id, double salary, String dept) {
		super();
		this.userName = userName;
		this.id = id;
		this.salary = salary;
		this.dept = dept;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Employee(String userName, int id, double salary) {
		super();
		this.userName = userName;
		this.id = id;
		this.salary = salary;
	}
	/*public Employee(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}*/
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", id=" + id + ", salary=" + salary + ", dept=" + dept + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	@Override
	public int compareTo(Employee o) {
		
		if(this.salary==o.salary){
			return 0;
		}
		else if(this.getSalary()>o.getSalary())
			return 1;
		else
			return -1;
		
	}
	
	
	
}
