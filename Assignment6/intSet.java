import java.util.*;
class intSet{
        private Set<Integer> set;
	private final int minRange=1;
	private final int maxRange=1000;
	
	//Constructor
	public intSet(int arr[]){
	   Set<Integer> temp=new HashSet<>();
	   for(int i=0;i<arr.length;i++){
	      if(!temp.contains(arr[i])){
	         temp.add(arr[i]);
	      }
	   }
	   this.set=temp;
	}
	
	//To print set elements
	public void printSet(){
	   System.out.println(this.set);
	}
	
	//check whether x is a member of the set and return a boolean value
	public boolean isMember(int x){
	   if(this.set.contains(x)){
	      return true;
	   } 
	   return false;
	}
	
	//return the size of the set
	public int size(){
	   return this.set.size();
	}
	
	//check whether s is a subset of the set
	public boolean isSubSet(intSet s){
	   return this.set.containsAll(s.set);			
	}
	
	//return the union of s1 and s2
	public Set union(intSet s1, intSet s2){
	   Set<Integer> Union=s1.set;
	   Union.addAll(s2.set);
	   this.set=Union;
	   return this.set;
	}
	
	//return the complement set
	public Set getComplement(){
	   Set<Integer> complementSet=new HashSet<>();
	   for(int i=minRange;i<=maxRange;i++){
	      if(this.set.contains(i))
	         continue;
		 complementSet.add(i);
	      }	 
	      return complementSet;
	}
	
	public static void main(String args[]){
	   Scanner sc=new Scanner(System.in);	
	   Set<Integer> Union=new HashSet<Integer>();
	   Set<Integer> complementSet=new HashSet<Integer>();	
	   System.out.println("Enter number of elements in set : ");
	   int n=sc.nextInt();
	   int arr[]=new int[n];
           for(int i=0;i<n;i++){
	      System.out.println("Enter element " + (i+1) + " : ");
	      arr[i]=sc.nextInt();
	   }
	   intSet setArray=new intSet(arr);
	   System.out.println("Set is : ");
	   setArray.printSet();		
	   System.out.println("Enter number to check a member is present in a set or not : ");
	   n=sc.nextInt();
	   System.out.println("It is a member of set : " + setArray.isMember(n));
	   System.out.println("Size of set is : " + setArray.size());
	   System.out.println("Enter number of elements of subset : ");
	   n=sc.nextInt();
           int arr2[]=new int[n];
	   for(int i=0;i<n;i++){
	      System.out.println("Enter element " + (i+1) + " : ");
              arr2[i]=sc.nextInt();    
	   }
	   intSet newSetArray=new intSet(arr2);
	   System.out.println("Subset is : ");
	   newSetArray.printSet();
	   System.out.println(); 
	   System.out.println("New set is subset of given Set : " + setArray.isSubSet(newSetArray));
	   int arr3[]=new int[1]; 
	   intSet unionSetArray=new intSet(arr3);
	   Union=unionSetArray.union(setArray, newSetArray);
	   System.out.println();
	   System.out.println("Union of set and subset is: " + Union);
	   complementSet=newSetArray.getComplement();
	   System.out.println();
	   System.out.println("Complement of subset is : " + complementSet);	
	}
}
