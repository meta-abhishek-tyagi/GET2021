import java.util.*;
class ViratKohli {
	private int[] Heap;
	private int size;
	private int capacity;

	public ViratKohli(int maxsize) {
		capacity = maxsize;
		this.size = 0;
		Heap = new int[capacity + 1];
		Heap[0] = Integer.MAX_VALUE;
	}

	//return true if maxHeap is empty otherwise false
	public boolean isEmpty(){
		if(size < 1)
			return true;
		return false;
	}

	//return position of parent
	private int parent(int pos) {
		return pos / 2;
	}

	
	//return position of left child
	private int leftChild(int pos) {
		return (2 * pos);
	}

	//return position of right child
	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	//return true if the node is leaf otherwise false
	private boolean isLeaf(int pos) {
		if (pos > (size / 2))
			return true;
		return false;
	}

	//Method to swap the elements in the heap
	private void swap(int fpos, int spos) {
		int tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

    //Recursive Method to heapify max heap in correct order
	private void maxHeapify(int pos) {
		if (isLeaf(pos))
			return;
		if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
			if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			} 
			else {
				swap(pos, rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}

	//Method to insert a new element
	public void insert(int element) {
		Heap[++size] = element;
		int current_position = size;
		while (Heap[current_position] > Heap[parent(current_position)]) {
			swap(current_position, parent(current_position));
			current_position = parent(current_position);
		}
	}

	//Method to print element of the heap
	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
			System.out.println();
		}
	}

	//Method to remove a element from the max heap 
	public int removeMaxHeap() {
		int deletedElement = Heap[1];
		Heap[1] = Heap[size--];
		maxHeapify(1);
		return deletedElement;
	}
    
	public static void main(String[] arg) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of bowlers :");
		int numberOfBowler=sc.nextInt();
		ViratKohli viratKohli = new ViratKohli(numberOfBowler);
		for(int i=1; i<=numberOfBowler; i++){
			System.out.print("Enter number of bowl left of bowler " + i + " : ");
			int bowl = sc.nextInt();
			viratKohli.insert(bowl);
		}
		System.out.println("The order of bowling according to their bowl left :");
		while(!viratKohli.isEmpty())
	  	System.out.println("The bowler having bowl left :" + viratKohli.removeMaxHeap());
	}
}
