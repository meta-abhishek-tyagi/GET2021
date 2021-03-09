import java.util.*;
class Poly{
	Scanner sc=new Scanner(System.in);
	private int[][] polynomial;
	
	//Constructor
	public Poly(){
	   System.out.print("Enter number of terms in a polynomial : ");
	   int noOfTerms=sc.nextInt();
	   int[][] tempPoly=new int[noOfTerms][2];
	   for(int i=0;i<noOfTerms;i++){
	       System.out.print("Enter coefficient " + (i+1) + " : ");
	       int coef=sc.nextInt();
	       tempPoly[i][0]=coef;
	       System.out.print("Enter degree " + (i+1) + " : ");
	       int deg=sc.nextInt();
	       tempPoly[i][1]=deg;
	   }
	   this.polynomial=tempPoly;
	}
	
	public void printPoly(){
	   int len=this.polynomial.length;
	   for(int i=0;i<len;i++){
	       System.out.print(this.polynomial[i][0] + "x^" + this.polynomial[i][1]);
	       if(i != len-1)
		  System.out.print(" + ");
	       }
	       System.out.println();
	}
	
        //Evaluate polynomial equation for the given variable number
        public double evaluate(){
           System.out.println("Enter Variable number to evaluate : ");
           double varNum=sc.nextDouble();
           double ans=0.0;
           int len=this.polynomial.length;
	   for(int i=0;i<len;i++){
	       ans += this.polynomial[i][0] * Math.pow(varNum, (double)this.polynomial[i][1]);
	   }
	   return ans; 		
	}
	
        //Return the degree of the polynomial                     
	public int degree(){
           int ans=0;
           int len=this.polynomial.length;
	   for(int i=0;i<len;i++){
	       if(ans<this.polynomial[i][1])
	       ans=this.polynomial[i][1];
	   }
	   return ans; 	
           /*or
	     return this.polynomial[len-1][1]; */
	}
	
        //Return the sum of the polynomial p1 and p2                     
	public static void addPoly(Poly p1, Poly p2){
	   int cntp1=0, cntp2=0, cntTP=0;	
	   int lenp1=p1.polynomial.length;
	   int lenp2=p2.polynomial.length;
	   int[][] tempPoly=new int[lenp1+lenp2][2];
		
	   // Adding polynomial p1 & p2:
	   while(lenp1 > cntp1 && lenp2 > cntp2){
	       if(p1.polynomial[cntp1][1] == p2.polynomial[cntp2][1]){
	          tempPoly[cntTP][0] = p1.polynomial[cntp1][0] + p2.polynomial[cntp2][0];
	          tempPoly[cntTP][1] = p1.polynomial[cntp1][1];
	          cntp1++;
	          cntp2++;
	       }
	       else if(p1.polynomial[cntp1][1] < p2.polynomial[cntp2][1]){
	          tempPoly[cntTP][0]=p1.polynomial[cntp1][0];
	          tempPoly[cntTP][1]=p1.polynomial[cntp1][1];
	          cntp1++;
	       }
	       else if(p1.polynomial[cntp1][1] > p2.polynomial[cntp2][1]){
	          tempPoly[cntTP][0]=p2.polynomial[cntp2][0];
	          tempPoly[cntTP][1]=p2.polynomial[cntp2][1];
	          cntp2++;
	       }
	       cntTP++;
	    }
		
	    // Adding polynomial p1 which left to add.
	    while(lenp1 > cntp1){
	        tempPoly[cntTP][0]=p1.polynomial[cntp1][0];
	        tempPoly[cntTP][1]=p1.polynomial[cntp1][1];
	        cntp1++;
	        cntTP++;
	    } 
		
	    // Adding polynomial p2 which left to add.
	    while(lenp2 > cntp2){
	        tempPoly[cntTP][0]=p2.polynomial[cntp2][0];
	        tempPoly[cntTP][1]=p2.polynomial[cntp2][1];
	        cntp2++;
	        cntTP++;
            }
		
	    // print the addition of polynomial
	    System.out.print("Addition is :  ");
	    for(int i=0;i<cntTP;i++){
	       System.out.print(tempPoly[i][0] + "x^" + tempPoly[i][1]);
	       if(i != cntTP-1)
	         System.out.print(" + ");
	    }
	    System.out.println();	
	}
	
        //Return the product of the polynomial p1 and p2                     
	public static void multPoly(Poly p1, Poly p2){
	   int lenp1=p1.polynomial.length;
	   int lenp2=p2.polynomial.length;
	   int limit = lenp1 * lenp2;
	   int[][] tempPoly=new int[limit][2];
	   int k=0;
	   for(int i=0;i<lenp1;i++){
	      for(int j=0;j<lenp2;j++){
		 tempPoly[k][0] = p1.polynomial[i][0] * p2.polynomial[j][0];
		 tempPoly[k][1] = p1.polynomial[i][1] + p2.polynomial[j][1];
		 k++;
	      }
	   }
		
           //Print the multiplication of polynomial p1 and p2
	   System.out.print("Multiplication is :  ");
	   for(int i=0;i<k;i++){
	      System.out.print(tempPoly[i][0] + "x^" + tempPoly[i][1]);
	      if(i != k-1)
	         System.out.print(" + ");
	      }
	      System.out.println();
	 }
                       
	 //Sort the polynomial in ascending order
         public static void sort(Poly poly){
	     int temp;
	     for(int i=0;i<poly.polynomial.length;i++){
		for(int j=0;j<poly.polynomial.length-(i+1);j++){
		    if(poly.polynomial[j][1] > poly.polynomial[j+1][1]){
		       temp=poly.polynomial[j][1];
		       poly.polynomial[j][1]=poly.polynomial[j+1][1];
		       poly.polynomial[j+1][1]=temp;
		       temp=poly.polynomial[j][0];
		       poly.polynomial[j][0]=poly.polynomial[j+1][0];
		       poly.polynomial[j+1][0]=temp;	
		    }
		 }
	      }
	   }
	
	public static void main(String args[]){
	  System.out.println("FOR FIRST POLYNOMIAL");
	  Poly p1=new Poly();
	  System.out.println();
	  System.out.println("FOR SECOND POLYNOMIAL");
	  Poly p2=new Poly();
	  System.out.println();
          sort(p1);
	  System.out.println("First Polynomial Expression is : ");
	  p1.printPoly();
   	  System.out.println(); 
   	  sort(p2);
          System.out.println("Second Polynomial Expression is : ");
	  p2.printPoly();
	  System.out.println();
	  System.out.println("After evaluation value Of Polynomial first is : " + p1.evaluate());
	  System.out.println();
	  System.out.println("After evaluation value Of Polynomial second is : " + p2.evaluate());
	  System.out.println();
	  System.out.println("Degree of 1st Polynomial is : " + p1.degree());
	  System.out.println();
	  System.out.println("Degree of 2nd Polynomial is : " + p2.degree());
	  System.out.println();
	  addPoly(p1, p2);
	  System.out.println();
	  multPoly(p1, p2);
	}
}
