package Assignment5;
import java.util.*;
import javax.json.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
		final String JSON_FILE="json.txt";
		InputStream file = new FileInputStream(JSON_FILE);  
		//initializing JSON Reader to read the JSON file
		JsonReader jsonReader = Json.createReader(file); 
		JsonObject jsonObject = jsonReader.readObject(); 
		jsonReader.close();
		file.close();
		Iterator<String> keys = jsonObject.keySet().iterator();
		Iterator<JsonValue> values = jsonObject.values().iterator(); 
		BinMap map = new BinMap(keys,values); 
		String key;
		while(true){
		    System.out.println("\n1.Enter data");
		    System.out.println("2.Delete Node");
	    	System.out.println("3.Find");
	    	System.out.println("4.Display");
		    System.out.println("5.Get all key pairs Key>=k1 and Key<=K2");
		    System.out.println("6.Exit");
		    System.out.println("\nEnter choice");
		    int choice = sc.nextInt();
		    switch(choice){
			    case 1:
				   System.out.println("Enter key");
				   key = sc.next();
				   System.out.println("Enter value");
				   String value = sc.next();
				   map.insert(key, value);
				   break;
			    case 2:
				   System.out.println("Enter key to be deleted");
				   key = sc.next();
				   map.delete(key);
				   System.out.println("Key deletion successfull");
				   break;
			    case 3:
			       System.out.println("Enter key whose value to be find ");	 
				   key  = sc.next();
				   System.out.println(map.getValue(key));
				   break;
			    case 4:
			       map.display();
				   break;
			    case 5:
				   System.out.println("Enter lower bound");
				   String lowerBound = sc.next();
				   System.out.println("Enter upper bound");
				   String upperBound = sc.next();
				   map.getKeyPairsBetween(lowerBound, upperBound);
				   break;
			    default:
				   return;
			}
		}
	}
}