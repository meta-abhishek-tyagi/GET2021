import java.util.*;
class ShoppingCart{
      public static void removeItem(String s, ArrayList<String> itemsCount, ArrayList<Integer> priceCount){
           for(int i=0;i<itemsCount.size();i++){
	        if(s.equals(itemsCount.get(i))){
		      itemsCount.remove(i);
		      priceCount.remove(i);
		      break;	
                }
           }
      }
     public static int display(ArrayList<String> itemsCount,ArrayList<Integer> priceCount){
           int count[]=new int[5];
	   int total=0;
	   for(int i=0;i<itemsCount.size();i++){
                if((itemsCount.get(i)).equals("shoes")){
		        count[0]++;
	        } 
	        else if((itemsCount.get(i)).equals("clothes")){
		        count[1]++;
	        } 
	        else if((itemsCount.get(i)).equals("socks")){
		        count[2]++;
	        }
	        else if((itemsCount.get(i)).equals("earphones")){
		        count[3]++;
		} 
		else if((itemsCount.get(i)).equals("watch")){
		        count[4]++;
	        }
	        total+=priceCount.get(i);      	
	        }
		System.out.println("shoes :  "+count[0]+"\n"+"clothes :  "+count[1]+"\n"+"socks :  "+count[2]+"\n"+"earphones :  "+count[3]+"\n"+"watch :  "+count[4]);  
                return total;	         
	    }
	    public static void main(String args[]){
	        Scanner sc=new Scanner(System.in);
		int choice;
	        int totalBill=0;
	        ArrayList<String> itemsCount=new ArrayList<>();
	        ArrayList<Integer> priceCount=new ArrayList<>();
		System.out.println("1.Add shoes        2000Rs." + "\n" +"2.Add clothes      1000Rs."+"\n"+"3.Add socks        500Rs."+"\n"+"4.Add earphones    1500Rs."+"\n"+"5.Add watch        1300Rs."+"\n"+"6.Remove item from cart"+"\n"+"7.Your Order"+"\n"+"8.Done!");
		label:while(true){
		     System.out.println("enter your choice:");
		     choice=sc.nextInt();
	             switch(choice){
	                 case 1:  
	                     itemsCount.add("shoes");
			     priceCount.add(2000);
			     break;
			case 2:  
			     itemsCount.add("clothes");
			     priceCount.add(1000);
		             break;
		        case 3:  
			     itemsCount.add("socks");
			     priceCount.add(500);
		             break;
			case 4:  
	                     itemsCount.add("earphones");
			     priceCount.add(1500);
			     break;
		        case 5:  
			     itemsCount.add("watch");
			     priceCount.add(1300);
			     break;
			case 6:  
			     System.out.println("enter item name to remove from cart");
			     String itemName=sc.next();
			     if(itemsCount.size()!=0 && priceCount.size()!=0)
			         removeItem(itemName.toLowerCase(),itemsCount,priceCount);
			     break;
		        case 7:  
		             System.out.println("items in your cart:");
		             totalBill=display(itemsCount,priceCount);
			     break;         
		        case 8:  
			     System.out.println("Your Final Order:\n");
			     if(itemsCount.size()!=0)
			         totalBill=display(itemsCount,priceCount);
			     System.out.println("Final Bill Amount is :  "+totalBill);
			     System.out.println("If you want to change item or add more press 1 otherwise 0"); 
			     if(sc.nextInt()!=1){
			          break label;
			     }
			     break;
		        default: 
		             System.out.println("Invalid Choice!!");
		    }
             } 
      }
}
