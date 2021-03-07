package Assignment5;
import java.util.*;
class Search{
	static Scanner sc=new Scanner(System.in);
	
	//Linear Search
	public static int linearSearch(int arr[], int leftmost, int rightmost, int itemToSearch){
		if(rightmost < 1)
			return -1;
		if(arr[leftmost] == itemToSearch)
			return leftmost;
		if(arr[rightmost] == itemToSearch)
			return rightmost;
		return linearSearch(arr, leftmost+1, rightmost-1, itemToSearch);	
	}
	
	//Binary Search
	public static int binarySearch(int arr[], int leftmost, int rightmost, int itemToSearch){
        if(rightmost<leftmost){
        	return -1;
        }
		if(rightmost >= 1 && leftmost < arr.length-1 ){
        	int mid = (leftmost+rightmost-1)/2;
		    if(arr[mid] == itemToSearch)
			   return mid;
		    if(arr[mid] > itemToSearch)
			   return binarySearch(arr, leftmost, mid-1, itemToSearch);
		    return binarySearch(arr, mid+1, rightmost, itemToSearch);
        }
        return -1;
	}
	
	//Creating an array
	public static int[] createArray(){
		System.out.print("Enter size of an array : ");
		int sizeOfArray=sc.nextInt();
		int arr[]=new int[sizeOfArray];
		for(int i=0;i<sizeOfArray;i++){
			System.out.print("Enter element " + (i+1) + " : ");
			arr[i]=sc.nextInt();
		}
		return arr;
	}
	   
	
	public static void main(String args[]){
		int itemToSearch=0;
		int ch, index;
	    do{
	      System.out.print("\n1. Linear search \n" + "2. Binary Search \n" + "3. Exit \n" + "Enter your choice : ");
	      ch=sc.nextInt();
	      switch(ch){
	    	case 1: 
	    		
	    		int arr[]=createArray();
	    		System.out.print("Enter item to search : ");
	    		itemToSearch=sc.nextInt();
	    	 	index=linearSearch(arr, 0, arr.length-1, itemToSearch);
	            if(index != -1)
	                System.out.print("Element " + itemToSearch + " is present at index " + (index+1));
	        	else
	        		System.out.print("Element " + itemToSearch + " is not present in the given array");
	            break;
	            
	    	case 2: 
	    		System.out.println("(Assume array must be sorted)");
	    		int arr1[]=createArray();
	    		System.out.print("Enter item to search : ");
	    		itemToSearch=sc.nextInt();
         	    index=binarySearch(arr1, 0, arr1.length-1, itemToSearch);
         	    if(index != -1)
                    System.out.print("Element " + itemToSearch + " is present at index " + (index+1));
    		    else
    		     	System.out.print("Element " + itemToSearch + " is not present in the given array");
        	    break;
	    	case 3:
	    		System.out.println("Thanks for using !!");
	    		System.exit(0);
	            break;
	    	default: 
	    		System.out.print("Invalid choice");
	       }
	    
		}
	    while(ch != 3);     
	}
}
