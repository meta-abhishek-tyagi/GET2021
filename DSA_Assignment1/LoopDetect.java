//LoopDetect
import java.util.*;
import java.io.*;
class LinkedList{
	
	Node head;
	
	// Node is a static nested class
    static class Node{
		int data,flag;
		Node next;
        // Constructor
		public Node(int d){
            data=d;
            flag=0;
            next = null;
		}
	}
	
	// Method to insert new node.
	public static LinkedList insert(LinkedList list,int d){ 
        // Create a new node with given data
        Node new_node = new Node(d);
        new_node.next = null;
 
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
 
            // Insert the new_node at last node
            last.next = new_node;
        }
        return list;
    }
    
    // Method to create a loop.
    public static LinkedList creatingLoop(LinkedList list){
    	Node currNode = list.head;
    	while(currNode.next!=null){
    		currNode=currNode.next;
    	}
    	currNode.next=list.head;
    	return list;
    }
    
    // Method to detect a loop.
    public static boolean detectingLoop(LinkedList list){
    	Node currNode = list.head;
    	while(currNode!=null){
    		if(currNode.flag==1){
    			return true;
    		}
    		currNode.flag=1;
    		currNode=currNode.next;
    	}
    	return false;
    }
   
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		LinkedList list=new LinkedList();
		list=insert(list,1);
		list=insert(list,3);
		list=insert(list,2);
		list=insert(list,4);
		list=insert(list,5);
		
		list=creatingLoop(list);
		
		if(detectingLoop(list)){
		    System.out.println("There is a Loop in a LinkedList");	
		}
		else{
			System.out.println("There is no Loop in a LinkedList");
		}
	}
}
