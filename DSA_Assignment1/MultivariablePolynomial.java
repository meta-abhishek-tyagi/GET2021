//Multivariable Polynomial
import java.util.*;
class LinkedList {
    Node head; // head of list
 
    // Node is a static nested class
    static class Node {
        int coef, degX, degY, degZ;
        Node next;
     
        // Constructor
        Node(int c, int d1, int d2, int d3){
            coef = c;
            degX=d1;
            degY=d2;
            degZ=d3;
            next = null;
        }
    }
 
    // Method to insert a new node
    public static LinkedList insert(LinkedList list, int c, int d1, int d2, int d3){
        // Create a new node with given data
        Node new_node = new Node(c, d1, d2, d3);
        new_node.next = null;
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
        Node currNode = list.head;
        System.out.print("LinkedList : ");
        while (currNode != null) {
            System.out.print(currNode.coef + "X^" + currNode.degX + "Y^" + currNode.degY + "Z^" + currNode.degZ);
            if(currNode.next != null)
              System.out.print(" + ");
              currNode = currNode.next;
        }
    }
    
    // Method to find degree of Polynomial.
    public static int degreePoly(LinkedList list){
    	   Node currNode = list.head;
    	   int sum=0;
    	   int degree=0;
    	   while(currNode != null){
    		      sum = currNode.degX + currNode.degY + currNode.degZ;
    	      	if(sum > degree)
    		         degree=sum;
    		         currNode=currNode.next;  
    	       }
    	       return degree;
        }
    
    public static void main(String args[]){
     	Scanner sc=new Scanner(System.in);
    	 int c, d1 ,d2, d3;
    	 LinkedList list = new LinkedList();
    	 System.out.println("Enter No. Of Terms in polynomial : ");
    	 int noOfTerms=sc.nextInt();
    	 for(int i=0;i<noOfTerms;i++){
    		System.out.println("Enter Coefficient " + (i+1) + " : ");
    		c=sc.nextInt();
    		System.out.println("Enter  degree " + (i+1) + " of X " + " : ");
    		d1=sc.nextInt();
    		System.out.println("Enter  degree " + (i+1) + " of Y " + " : ");
    		d2=sc.nextInt();
    		System.out.println("Enter  degree " + (i+1) + " of Z " + " : ");
    		d3=sc.nextInt();
    		list=insert(list, c, d1, d2, d3);
    }
    System.out.println("Polynomial is :");
    printList(list);
    System.out.print("\nDegree of Polynomial is : " + degreePoly(list));
  }
}
