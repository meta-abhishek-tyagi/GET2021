//Multivariable Polynomial
import java.util.*;
class LinkedList {
    Node head; // head of list
 
    // Node is a static nested class
    static class Node {
        int coefficient, degreeOfX, degreeOfY, degreeOfZ;
        Node next;
     
        // Constructor
        Node(int cofficient, int degreeOfX, int degreeOfY, int degreeOfZ){
            this.coefficient = cofficient;
            this.degreeOfX = degreeOfX;
            this.degreeOfY = degreeOfY;
            this.degreeOfZ = degreeOfZ;
            next = null;
        }
    }
 
    // Method to insert a new node
    public static LinkedList insert(LinkedList list, int cofficient, int degreeOfX, int degreeOfY, int degreeOfZ){
        // Create a new node with given data
        Node new_node = new Node(cofficient, degreeOfX, degreeOfY, degreeOfZ);
        //new_node.next = null;
        if(list.head == null){
           list.head = new_node;
        }
        else{
           Node last = list.head;
           while (last.next != null) {
              last = last.next;
           }
         
           // Insert the new_node at last node
           last.next = new_node;
        }
        return list;
    }
 
    // Method to print the LinkedList.
    public static void printList(LinkedList list){
        Node currentNode = list.head;
        System.out.print("LinkedList : ");
        while (currentNode != null) {
            System.out.print(currentNode.coefficient + "X^" + currentNode.degreeOfX + "Y^" + currentNode.degreeOfY + "Z^" + currentNode.degreeOfZ);
            if(currentNode.next != null)
              System.out.print(" + ");
            currentNode = currentNode.next;
        }
    }
    
    // Method to find degree of Polynomial.
    public static int degreePoly(LinkedList list){
    	   Node currentNode = list.head;
    	   int sum=0;
    	   int degree=0;
    	   while(currentNode != null){
    		    sum = currentNode.degreeOfX + currentNode.degreeOfY + currentNode.degreeOfZ;
    	      	if(sum > degree)
    		         degree=sum;
    		    currentNode=currentNode.next;  
    	       }
    	       return degree;
        }
    
    public static void main(String args[]){
         Scanner sc=new Scanner(System.in);
    	 int cofficient, degreeOfX , degreeOfY, degreeOfZ;
    	 LinkedList list = new LinkedList();
    	 System.out.println("Enter No. Of Terms in polynomial : ");
    	 int noOfTerms = sc.nextInt();
    	 for(int i=0;i<noOfTerms;i++){
    		System.out.println("Enter Coefficient " + (i+1) + " : ");
    		cofficient=sc.nextInt();
    		System.out.println("Enter  degree " + (i+1) + " of X " + " : ");
    		degreeOfX=sc.nextInt();
    		System.out.println("Enter  degree " + (i+1) + " of Y " + " : ");
    		degreeOfY=sc.nextInt();
    		System.out.println("Enter  degree " + (i+1) + " of Z " + " : ");
    		degreeOfZ=sc.nextInt();
    		list=insert(list, cofficient, degreeOfX, degreeOfY, degreeOfZ);
    }
    System.out.println("Polynomial is :");
    printList(list);
    System.out.print("\nDegree of Polynomial is : " + degreePoly(list));
  }
}
