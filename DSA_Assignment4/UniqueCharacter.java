import java.util.*;
class UniqueCharacter{
	
	// hashMap to store the Key : String and Value : Number of Unique Characters in String.
	private static HashMap<String, Integer> hashMap  = new HashMap<>();
	
	// Method to calculate Number of Unique Characters in a givan String.
	public static Integer calcUniqueCharacter(String inputString){
		List tempList=new ArrayList();
		if(hashMap.containsKey(inputString)){
			return hashMap.get(inputString);
		}
		else{
			for(int i=0;i<inputString.length();i++){
				if(tempList.contains(inputString.charAt(i))){
					continue;
				}
				else{
					tempList.add(inputString.charAt(i));
				}
			}
			hashMap.put(inputString, tempList.size());
		}
		return tempList.size();
	}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		UniqueCharacter object=new UniqueCharacter();
		System.out.println("For terminate program press -1 ");
		System.out.println("Enter String :");
		String inputString=sc.next();
		if(inputString.equals("-1"))
		   System.exit(0);
		else{
		   while(!inputString.equals("-1")){
		   	  System.out.println("Number of unique charcter in String is : " + object.calcUniqueCharacter(inputString));
		   	  inputString=sc.next();
		   }
		}   
	}
}