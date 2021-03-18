import java.util.Scanner;
class Employees implements Comparable<Employees> {
	private String name;
	private int age;
	private double salary;

	//Employee Constructor to initialize employee details
	public Employees(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	//Method to get age of the employee
	public int getAge() {
		return age;
	}

	//Method to get salary of the employee
	public double getSalary() {
		return salary;
	}

	//overriding toString() method
	public String toString() {
		return name + "\t" + age + "\t " + salary;
	}

	/*
	 return 1 if the passed employee salary is greater otherwise it return -1
	 else if both employee having same salary then it return 1 if passed
	 employee age is lesser otherwise -1
	*/
	@Override
	public int compareTo(Employees employee) {
		if (salary < employee.getSalary())
			return 1; 
		else if (salary == employee.getSalary()) {
			if (age > employee.getAge())
				return 1;
			return -1;
		}
		return -1;
	}
}

class LinkedList {
	class Node {
		Employees employee;
		Node next;

		Node(Employees employee) {
			this.employee = employee;
			next = null;
		}
	}
  
	public Node head;
	public LinkedList() {
		head = null;
	}

	//Method to implement insertion sort
	void sortedInsert(Employees passedEmployee) {
		Node newnode = new Node(passedEmployee);
		if (head == null || head.employee.compareTo(newnode.employee) > 0) {
			newnode.next = head;
			head = newnode;
		} 
		else {
			Node currentNode = head;
			while (currentNode.next != null && currentNode.next.employee.compareTo(newnode.employee) < 0)
				currentNode = currentNode.next;
			newnode.next = currentNode.next;
			currentNode.next = newnode;
		}
	}

	public void traverse() {
		Node tempHead = head;
		System.out.println("\nName    Age \t Salary\n");
		while (tempHead != null) {
			System.out.println(tempHead.employee);
			tempHead = tempHead.next;
		}
	}
	
	static Scanner sc = new Scanner(System.in);

	//Method to get employee data
	public static Employees insertEmployee() {
		System.out.print("Enter employee name :");
		String name = sc.nextLine();
		System.out.print("Enter employee age :");
		int age = sc.nextInt();
		System.out.print("Enter employee salary :");
		double salary = sc.nextDouble();
		return new Employees(name, age, salary);
	}

	public static void main(String[] args) {
		LinkedList employees = new LinkedList();
		Employees employee;
		System.out.println("Enter Number of Employees : ");
		int noOfEmployee=sc.nextInt();
		sc.nextLine();
		int i=0;
		while(noOfEmployee > 0){
			System.out.println("\nEnter Detail of Employee " + (i+1) + "\n");
			employee = insertEmployee();
			employees.sortedInsert(employee);
			sc.nextLine(); //Used to clear buffer
			noOfEmployee--;
			i++;
		} 
		employees.traverse();
	}
}
