import java.util.*;
class Rotate{
	
     //Method to rotate a subLinkedList	
     public static LinkedList rotateSubList(LinkedList<Integer> subLinkedList, int noOfSteps){	
	int length=subLinkedList.size();	
	if(noOfSteps > length)
	   noOfSteps = noOfSteps % length;	   
	noOfSteps = length - noOfSteps;	
	if(noOfSteps==0 || noOfSteps == length)
	   return subLinkedList;
	int cnt=0;
	int i=0; 
	while(cnt < noOfSteps){
	   int temp=subLinkedList.get(i);
	   subLinkedList.remove(i);
	   subLinkedList.addLast(temp);
	   cnt++;
	}	
	return subLinkedList;
     } 
	 
     //Method to print final linkedList	
     public static void printList(LinkedList<Integer> list){
	System.out.println("Modified Linked list : ");
	for(int i=0;i<list.size();i++){
	    System.out.print(list.get(i)+" ");
	}
     }
	
     //Method to create final linkedList	
     public static LinkedList outputList(LinkedList<Integer> subLinkedList, LinkedList<Integer> linkedList, int L, int R){
	for(int i=0;i<L-1;i++){
	    subLinkedList.addFirst(linkedList.get(i));
	}
	for(int i=R;i<linkedList.size();i++){
	    subLinkedList.addLast(linkedList.get(i));
	}
	return subLinkedList;
     }
	
     public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	LinkedList<Integer> linkedList=new LinkedList<>();
	LinkedList<Integer> subLinkedList=new LinkedList<>();
	LinkedList<Integer> rotatedList=new LinkedList<>();	
	System.out.println("Enter number of elements in linked list : ");
	int noOfElements=sc.nextInt();	
	for(int i=0;i<noOfElements;i++){
	   System.out.print("Enter Element " + (i+1) + " : ");
	   linkedList.add(sc.nextInt());
	}	
	System.out.println("Enter Left position of sub-list : ");
	int L=sc.nextInt();	
	System.out.println("Enter Right position of sub-list : ");
	int R=sc.nextInt();	
	for(int i=L-1;i<R;i++){
	   subLinkedList.add(linkedList.get(i));
	}		
	System.out.println("Enter no. of steps to rotate sub-list : ");
	int noOfSteps=sc.nextInt();	
	subLinkedList=rotateSubList(subLinkedList, noOfSteps);
	rotatedList=outputList(subLinkedList, linkedList, L, R);
	printList(rotatedList);
     }
}
