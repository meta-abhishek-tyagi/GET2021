package Assignment4;
import java.util.*;
class ArrOperation{
	
	//Return the size of the largest mirror section found in the input array.
      public static int largestMirror(int[] arr){
	      int max=0;
	      if(arr.length == 0)
		      throw new ArrayIndexOutOfBoundsException("Array is empty");
	      for(int i = 0; i < arr.length; i++) {
	              int count = 0;
	              for(int j = arr.length - 1; j >= 0 && i + count < arr.length; j--) {
	                      if(arr[i + count] == arr[j]) {
	                             count++;
	                      } 
	                      else {
	                             max = Math.max(max, count);
	                             count = 0;
	                      }
	                }                                                    
	        }
	        return max;
	}
	
	//Return the number of clumps in the input array.
	public static int clumps(int arr[]){
		int cnt=0;
		int flag=0;
		if(arr.length == 0)
			throw new ArrayIndexOutOfBoundsException("Array is empty");
		for(int i=0;i<arr.length-1;i++){
			flag=0;
			while(i < arr.length-1 && arr[i] == arr[i+1]){
				flag=1;
				i++;
			}
			if(flag == 1){
				cnt++;
			}
		}
		return cnt;
	}
	
	//Return an array that contains exactly the same numbers as the input array, but rearranged so that every X is immediately followed by a Y.
	public static int[] fixXY(int arr[], int x, int y){
		if(arr.length == 0)
			throw new ArrayIndexOutOfBoundsException("Array is empty");
		int[] tempArray=new int[arr.length];
		tempArray=arr;
		int temp=0, xi=0, yi=0;
		ArrayList<Integer> xindex = new ArrayList<>();
		ArrayList<Integer> yindex = new ArrayList<>();
		for(int i=0;i<tempArray.length;i++){
			if(tempArray[i] == x){
				xindex.add(i);
			}
			else if(tempArray[i] == y){
				yindex.add(i);
			}
			// If x at the last index
			if(i == arr.length - 1 && arr[i] == x)
		 			throw new IllegalStateException("X is the at the last Index");
		 	// If there are two adjacent x then throw exception
		 	if( i < arr.length -1 && (arr[i] == x && arr[i+1] == x ))
		 			throw new IllegalStateException("Two Adjacent X values are there");
		}
		if(xindex.size() > 0 && yindex.size() > 0){
		  for(int i=0;i<xindex.size();i++){
			xi=xindex.get(i);
			yi=yindex.get(i);
			temp=tempArray[yi];
			tempArray[yi]=tempArray[xi+1];
			tempArray[xi+1]=temp;
		  }
		}  	
		return tempArray;		
	}
	
	//Return the index if there is a place to split the input array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
	public static int splitArray(int arr[]){
		int n=arr.length;
	        int frontSum[]=new int[n];
	        int backSum[]=new int[n];
	        if(arr.length == 0)
		             	throw new ArrayIndexOutOfBoundsException("Array is empty");
       	       // forming sum of array from left side.
	       frontSum[0]=arr[0];
	       for(int i=1;i<n;i++){
	   	    frontSum[i] = frontSum[i-1] + arr[i];
	       }
	   
	      // forming sum of array from right side.
	      backSum[0]=arr[n-1];
	      for(int i=n-2;i>=0;i--){
	   	   backSum[i] = backSum[i+1] + arr[i];
	      }
	    
	     //finding index for split.
	     for(int i=1;i<n-1;i++){
	   	   if(frontSum[i] == backSum[i]){
	   	   	   return i+1;
	   	   }
	     }
	     return -1;
	}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter No. Of Elements in Array : ");
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			System.out.println("Enter Element "+(i+1)+" : ");
			arr[i]=sc.nextInt();
		}
		
		System.out.println("largest mirror in array is of length : " + largestMirror(arr));
		
		System.out.println("Clumps in array is : " + clumps(arr));
		
		System.out.println("Enter X and Y for Fixing : ");
		int x=sc.nextInt();
		int y=sc.nextInt();
		int res[]=fixXY(arr, x, y);
		System.out.println("Modified array is : ");
		for(int e : res){
			System.out.print(e + " ");
		}
		
		System.out.println("\n Splitting index is : " + splitArray(arr));
	}
}
