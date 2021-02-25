import java.util.*;
class JobScheduler{
	
	//Completion Time
	public static void completionTime(int[][] arr,int numberOfProcesses,int[] ct){
		ct[0]=arr[0][0]+arr[0][1];
		for(int i=1;i<numberOfProcesses;i++)
			ct[i]=ct[i-1]+arr[i][1];		
	}
	
	//Turn Around Time
	public static void turnAroundTime(int[][] arr,int numberOfProcesses,int ct[],int tat[]){
		for(int i=0;i<numberOfProcesses;i++){
			tat[i]=ct[i]-arr[i][0];
		}	
	}
	
	//Waiting Time
	public static void waitingTime(int[][] arr,int numberOfProcesses,int wt[],int tat[]){	
		for(int i=0;i<numberOfProcesses;i++){
			wt[i]=tat[i]-arr[i][1];
		}	
	}
	
	//Average Waiting Time
	public static void avgWaitingTime(int numberOfProcesses,int wt[]){
		int total=0;
		for(int i=0;i<numberOfProcesses;i++){
		  total+=wt[i];
		}
		int res=total/numberOfProcesses;
		System.out.println(res);
	}
	
	//Max Waiting Time
	public static void maxWaitingTime(int numberOfProcesses,int wt[]){   
		int max=0;
		for(int i=0;i<numberOfProcesses;i++){
		  if(wt[i]>max)
		    max=wt[i];
		}
		System.out.println(max);
	}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int arr[][]=new int[20][2];
		System.out.println("Enter number of process : ");
		int i;
		int numberOfProcesses=sc.nextInt();
		int ct[]=new int[numberOfProcesses];
		int tat[]=new int[numberOfProcesses];
		int wt[]=new int[numberOfProcesses];
		
		for(i=0;i<numberOfProcesses;i++){
			System.out.println(" Process " + (i+1) + ": \nArriving Time  Burst Time");
			int a=sc.nextInt();
			int b=sc.nextInt();
			arr[i][0]=a;
			arr[i][1]=b;
		}
		System.out.println(" Completion time"+"    "+"Turn Around Time"+"    "+"Waiting Time");

		completionTime(arr,numberOfProcesses,ct);

		turnAroundTime(arr,numberOfProcesses,ct,tat);
		
		waitingTime(arr,numberOfProcesses,wt,tat);
		
		for(i=0;i<numberOfProcesses;i++){
		   System.out.println("\t"+ct[i]+"\t"+"\t"+"  "+tat[i]+"\t"+"\t"+"    "+wt[i]);
		}
		
		System.out.println("Average Wiating Time:");
		avgWaitingTime(numberOfProcesses,wt);
		
		System.out.println("Max Wiating Time:");
		maxWaitingTime(numberOfProcesses,wt);	
	
	}
}