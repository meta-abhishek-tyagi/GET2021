import java.util.*;
class Employee{
	private String name, address;
	private int employeeId;
	
	public static HashMap<Integer, Employee> map = new HashMap<>();
	public static List<Employee> empList = new ArrayList<>();
	
	//Parameterized Constructor
	public Employee(String name, int employeeId, String address){
		this.name = name;
		this.employeeId = employeeId;
		this.address = address;
	}
	
	//Return name of employee
	public String getName(){
		return this.name;
	}
	
	//Return address of employee
	public String getAddress(){
		return this.address;
	}
	
	//Return id of employee
	public int getId(){
		return this.employeeId;
	}
		
	//method to sort naturally 
	public static void naturalSort(){
		ArrayList<Integer> sortedKeys = new ArrayList<>(map.keySet()); 
                Collections.sort(sortedKeys);  
                System.out.println("\nEmpId \t      EmpName \t        EmpAddress \t");
                for(Integer id : sortedKeys) {
                      System.out.println(map.get(id).employeeId + " \t \t " + map.get(id).name + "\t\t" + map.get(id).address);
                }     
	}
	
	//To print HashMap sorted by name
	public static void print(List<Map.Entry<Integer, Employee>> entryList){
		Iterator<Map.Entry<Integer, Employee>> itr = entryList.iterator();
                System.out.println("EmpId \t      EmpName \t        EmpAddress \t");
		while(itr.hasNext()){
			Map.Entry<Integer, Employee> entry=itr.next();
			System.out.println(entry.getKey() + " \t \t " + entry.getValue().name + "\t\t"+entry.getValue().address);
		}
	}
   
	//To print List
        public static void printList(){
    	        System.out.println("EmpId \t      EmpName \t        EmpAddress \t");
          	for(Employee emp : empList){
    	        	System.out.println("  "+emp.getId() + " \t \t " + emp.getName()+"\t\t" + emp.getAddress() + " \t ");
    	        }
        }

	public static void main(String args[]){
		Employee emp1=new Employee("A", 1, "Ram nagar");
		Employee emp2=new Employee("C", 10, "Devi nagar");
		Employee emp3=new Employee("B", 4, "Shyam nagar");
		Employee emp4=new Employee("E", 3, "Gayatri nagar");
		Employee emp5=new Employee("D", 7, "Kateva nagar");

		map.put(emp1.employeeId, emp1);
		map.put(emp2.employeeId, emp2);
		map.put(emp3.employeeId, emp3);
		map.put(emp4.employeeId, emp4);
		map.put(emp5.employeeId, emp5);
		
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		empList.add(emp5);
		
		System.out.println(" Employee Details\n");
		printList();
		
		System.out.println("\n \n After Sorting Naturally......");
		naturalSort();
		
		System.out.println("\n \n After Sorting by Name......\n");
		List<Map.Entry<Integer, Employee>> entryList = new ArrayList<Map.Entry<Integer, Employee>>(map.entrySet());
                Collections.sort(entryList, new Comparator<Map.Entry<Integer, Employee>>() {          
	               public int compare(Map.Entry<Integer, Employee> integerEmployeeEntry, Map.Entry<Integer, Employee> integerEmployeeEntry2) {
                             return integerEmployeeEntry.getValue().name.compareTo(integerEmployeeEntry2.getValue().name);
                       }
                });
                print(entryList);    
	}	
}
