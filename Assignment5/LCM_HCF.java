package Assignment5;
import java.util.*;
class LCM_HCF {
	
	private static Scanner sc;

	public static int hcf(int x, int y){
		if(y == 0)
			return x;
		return hcf(y, x % y);
	}
	
	public static int lcm(int x, int y){
		return (x / hcf(x,y)) * y;
	}
	
	public static void main(String args[]){
		sc = new Scanner(System.in);
		System.out.println("Enter two positive integers : ");
		int x=sc.nextInt();
		int y=sc.nextInt();
		
		System.out.println("LCM is " + lcm(x,y));
		System.out.println("HCF is " + hcf(x,y));
		
	} 
}

