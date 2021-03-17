import java.util.*;

interface PriorityQueueInterface{
	boolean isFull();
	boolean isEmpty();
	boolean Enqueue(int data, int priority);
	boolean Dequeue();
	int peek();
	void Display();
}

class PriorityQueue implements PriorityQueueInterface {
	private int front, rear, capacity;
	private int priority_queue[][];

	//Constructor for initializing size of the queue
	PriorityQueue(int capacity) {
		front = rear = 0;
		this.capacity = capacity;
		priority_queue = new int[capacity][2];
	}

	//return true is queue is full otherwise false
	public boolean isFull() {
		if (capacity == rear)
			return true;
		return false;
	}

	//Method to insert element in the queue
	public boolean Enqueue(int data, int priority) {
		if (isFull())
			return false; 
		else {
			if (isEmpty()) {
				priority_queue[rear][0] = priority;
				priority_queue[rear][1] = data;
				rear++;
			}
			else {
				int i;
				// Insertion sort according to priority (Low value having highest priority)
				for (i = rear - 1; i >= 0; --i) {
					if (priority_queue[i][0] > priority) {
						priority_queue[i + 1][0] = priority_queue[i][0];
						priority_queue[i + 1][1] = priority_queue[i][1];
					} 
					else 
						break;
				}
				priority_queue[i + 1][0] = priority;
				priority_queue[i + 1][1] = data;
				rear++;
			}
		}
		return true;
	}
 
	//return true is queue is empty otherwise false
	public boolean isEmpty() {
		if (front == rear)
			return true;
		return false;
	}

	//Method to delete element from queue
	public boolean Dequeue() {
		if (isEmpty())
			return false;
		else {
			for (int i = front; i < rear - 1; i++) {
				priority_queue[i][0] = priority_queue[i + 1][0];
				priority_queue[i][1] = priority_queue[i + 1][1];
			}
			rear--;
		}
		return true;
	}

	//Method to get peek value in the priority queue
	public int peek() {
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty");
		return priority_queue[front][1];
	}

	//Method to display queue
	public void Display() {
		int i;
		if (isEmpty()) {
			System.out.printf("\nQueue is Empty\n");
			return;
		}
		for (i = front; i < rear; i++)
			System.out.println(priority_queue[i][0] + "->" + priority_queue[i][1]);
	}
	
	public static void menu(){
		System.out.println("1. Enqueue");
		System.out.println("2. Dequeue");
		System.out.println("3. Peek");
		System.out.println("4. Display");
		System.out.println("5. Exit");
		System.out.println("Enter the choice : ");
	}
	public static void main(String[] args) {
		int choice, priority, value;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Size of the queue : ");
		int size=sc.nextInt();
		PriorityQueue priorityQueue=new PriorityQueue(size);
		do{
			menu();
			choice=sc.nextInt();
			switch(choice){
			case 1:
				System.out.print("Enter priority :");
				priority=sc.nextInt();
				System.out.print("Enter value :");
				value=sc.nextInt();
				if(priorityQueue.Enqueue(value, priority))
					System.out.println("Added successfully.");
				else
					System.out.println("Error.");
				break;
			case 2:
				if(priorityQueue.Dequeue())
					System.out.println("Element Deleted successfully");
				else
					System.out.println("Error.");
				break;
			case 3:
				System.out.println("Peek value : " + priorityQueue.peek());
				break;
			case 4:
				System.out.println("Elements in priority queue : ");
				priorityQueue.Display();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("INVALID INPUT");
				break;
			}
		}while(choice != 5);
	}
}
