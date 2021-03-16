import java.util.Scanner;
interface Queue{
	boolean isEmpty();
	boolean isFull();
	void enQueue(int data);
	int deQueue();
	void display();
}
class QueueOperation implements Queue {
	private int front = -1;
	private int rear = -1;
	private int MAXSIZE = 50;
	private int[] queue = new int[MAXSIZE];
  
	//if queue is Empty then return true otherwise false
	public boolean isEmpty(){
		if(front == -1)
			return true;
		return false;
	}
	
	//if the queue is full then return true otherwise false
	public boolean isFull(){
		if((front == 0 && rear == MAXSIZE) || (front > rear) ) 
			return true;
		return false;
	}
	
	//add a data to the queue 
	public void enQueue(int data){
		if(isFull()){
			System.out.println("Queue is Full");
			return;
		}
		if(front == -1){
			front = rear = 0;
		}
		else {
			if(rear == MAXSIZE)
				rear = 0;
			else
				rear++;
		}
		queue[rear] = data;
	}
	
	//return the deleted data from the queue
	public int deQueue(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
			return -1;
		}
		int data = queue[front];
		if(front == rear){
			front = rear = -1;
		}
		else {
			if(front == MAXSIZE)
				front = 0;
			else
				front++;
		}
		return data;
	}
	
	//Display the data items in the queue
	public	void display(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
			return;
		}
		int front = this.front;
		int rear = this.rear;
		while(front <= rear){
			System.out.print(queue[front++] + " ");
			if(front == MAXSIZE && front != rear){
				front = 0;
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		QueueOperation queue =  new QueueOperation();
		while(true){
			System.out.println("1. Add data to queue");
			System.out.println("2. Remove data from queue");
			System.out.println("3. Is Queue full");
			System.out.println("4. Is Queue empty");
			System.out.println("5. Display Queue");
			System.out.println("6. Exit");
			int choice = sc.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter data : ");
				int data = sc.nextInt();
				queue.enQueue(data);
				break;
			case 2:
				System.out.println(queue.deQueue());
				break;
			case 3:
				System.out.println(queue.isFull());
				break;
			case 4:
				System.out.println(queue.isEmpty());
				break;
			case 5:
				queue.display();
				break;
			default:
				return;
			}
		}
	}
}
