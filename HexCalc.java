import java.util.*;
class HexCalc{
	
	 //add two hexadecimal number
	 public static String add(String a,String b){
		int a1=Integer.parseInt(a,16);
		int b1=Integer.parseInt(b,16);
		return Integer.toHexString(a1+b1);
	 }
	
	 //subtract two hexadecimal number
	 public static String subtract(String a,String b){
		int a1=Integer.parseInt(a,16);
		int b1=Integer.parseInt(b,16);
		if(a1>b1)
		 return Integer.toHexString(a1-b1);
		else
		 return Integer.toHexString(b1-a1);
	 }
	
	 //multiply two hexadecimal number
	 public static String multiply(String a,String b){
			int a1=Integer.parseInt(a,16);
			int b1=Integer.parseInt(b,16);
			return Integer.toHexString(a1*b1);
	 }
	 
	 //divide two hexadecimal number
	 public static String divide(String a,String b){
		int a1=Integer.parseInt(a,16);
		int b1=Integer.parseInt(b,16);
		return Integer.toHexString(a1/b1);
	 }
	 
	 //compare equality of two hexadecimal number
	 public static boolean equalCompare(String a,String b){
		if(a.compareTo(b)==0)
			return true;
		else
		    return false;
	 }
	 
	 //compare two hexadecimal number which is greater
	 public static boolean greaterCompare(String a,String b){
		if(a.compareTo(b)>0)
			return true;
		else
		    return false;
     }
	 
	 //compare two hexadecimal number which is lesser
	 public static boolean lessCompare(String a,String b){
		if(a.compareTo(b)<0)
			return true;
		else
		    return false;
	 }
	 
	 //convert Hexadecimal number to Decimal number
	 public static int decimalRep(String s){
	 	return Integer.parseInt(s,16);
	 }
	 
	 //convert Decimal number to Hexadecimal number
	 public static String hexadecimalRep(int d){
	 	return Integer.toHexString(d);
	 }
	 
	 
	 public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int ch=0;
		System.out.println("Enter two Hexadecimal Numbers : ");
		String a=sc.nextLine();
		String b=sc.nextLine();
		System.out.println("1. Add"+"\n"+"2. Subtract"+"\n"+"3. Multiply"+"\n"+"4. Divide"+"\n"+"5. Equal or not"+"\n"+"6. First greater than second or not"+"\n"+"7. First less than second or not"+"\n"+"8. Decimal Represrentation of Hexadecimal number"+"\n"+"9. Hexadecimal Represrentation of Decimal number."+"\n"+"10. Done!"+"\n"+" Enter Your Choice : ");
		do{
			 ch=sc.nextInt();
				switch(ch){
					case 1:  System.out.println("Addition is :  "+add(a,b));
					         break;
					         
					case 2:  System.out.println("Subtraction is :  "+subtract(a,b));
					         break;
					         
					case 3:  System.out.println("Multiplication is :  "+multiply(a,b));
					         break;
					         
					case 4:  System.out.println("division is :  "+divide(a,b));
					         break;
					         
					case 5:  System.out.println("Status of Equality :  "+equalCompare(a,b));
					         break;
					         
					case 6:  if(greaterCompare(a,b)==false)
					            System.out.println("second number is greater than first");
					         else
					         	System.out.println("First number is greater than second");
					         break;
					         
					case 7:  if(lessCompare(a,b)==false)
					            System.out.println("second number is less than first");
					         else
					         	System.out.println("First number is less than second");
					         break;
					         
			    	case 8:  sc.nextLine();
			    	         System.out.println("Enter Hexadecimal number to convert in Decimal number");        
				             String s=sc.nextLine();
				             System.out.println("Decimal Representation is :  "+decimalRep(s));
					         break;
					         
					case 9:  System.out.println("Enter Decimal number to convert in Hexadecimal number");        
				             int d=sc.nextInt();
				             System.out.println("Hexadecimal Representation is :  "+hexadecimalRep(d));
					         break;
					          
					case 10: System.out.println("Thanks For Using !!");
					         break;
					                         
					default: System.out.println("Invalid Choice");
				}
		} while(ch!=10);
	}
}