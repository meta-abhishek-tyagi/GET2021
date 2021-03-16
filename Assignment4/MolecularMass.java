import java.util.*;
class MolecularMass{
   
  //Return Molecular Mass of the mentioned Atom
	public static int getMass(char ch){
		if(ch == 'C')
			return 12;
		else if(ch == 'H')
			return 1;
		else if(ch == 'O')
			return 16;
		return 0;
	}
	
  //Return Molecular Mass of a Compound
	public static int molecularMass(String compound){
		int total = 0, i = 0;
		String number = "";
		while(i < compound.length()){
			if(compound.charAt(i) == 'C' || compound.charAt(i) == 'H' || compound.charAt(i) == 'O')
				total += getMass(compound.charAt(i));
			else if(compound.charAt(i) >= '0' && compound.charAt(i) <= '9')
				total = total - getMass(compound.charAt(i-1)) + (int)compound.charAt(i) * getMass(compound.charAt(i-1));
			else if(compound.charAt(i) == '('){
				int temp = 0;
				i++;
				while(i < compound.length() && compound.charAt(i) != ')'){
					if(compound.charAt(i) == 'C' || compound.charAt(i) == 'H' ||compound.charAt(i) == 'O')
						temp += getMass(compound.charAt(i));
					else if(i < compound.length() && compound.charAt(i) >= '0' && compound.charAt(i) <= '9')
		        temp = temp - getMass(compound.charAt(i-1)) + (int)compound.charAt(i) * getMass(compound.charAt(i-1));
					i++;
				} 	
				i++;
				if(i < compound.length() && compound.charAt(i) >= '0' && compound.charAt(i) <= '9'){
	        while(i  < compound.length() && (compound.charAt(i) >= '0' && compound.charAt(i) <= '9')){
	      		number += compound.charAt(i);
	      		i += 1;
	        }
	        if(number.length() != 0)
	      		temp *= (Integer.parseInt(number));
				 }        
				 total += temp;
			}
		  i++;
		}
		return total;
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Formula of Organic Compound : ");
		String compound = sc.next().toUpperCase();
		System.out.println("Molecular Mass of Compound is : " + molecularMass(compound));	
	}
}
