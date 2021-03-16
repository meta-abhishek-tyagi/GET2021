import java.util.Scanner;
import java.util.Stack;
class StackInfix{
	
    //Evaluate Infix Expression
    public static int evaluate(String infix){
	char[] terms=infix.toCharArray();
	Stack<Integer> operand = new Stack<>();
	Stack<Character> operator = new Stack<>();	
	for(int i=0;i<terms.length;i++){
           if(terms[i] == ' '){
	     continue;
           }
           if(terms[i] >= '0' && terms[i] <= '9'){
             StringBuffer temp = new StringBuffer();
             while(i < terms.length && terms[i] >= '0' && terms[i] <= '9') 	
		temp.append(terms[i++]);
	     operand.push(Integer.parseInt(temp.toString()));
	     i--;  
           }
           else if(terms[i] == '('){
	     operator.push(terms[i]);
           }
           else if(terms[i] == ')'){
	     while(operator.peek() != '('){
		operand.push(applyOperation(operator.pop(), operand.pop(), operand.pop()));
	     }	
	     operator.pop();
           } 
           else if(terms[i] == '+' || terms[i] == '-' || terms[i] == '*' || terms[i] == '/'){
             while (!operator.empty() &&  checkPrecedence(terms[i], operator.peek()) && operand.size() >= 2){
                operand.push(applyOperation(operator.pop(), operand.pop(), operand.pop()));
             }                
             operator.push(terms[i]);
           }
	 } 
	 while(!operator.empty() && operand.size() >= 2){
            operand.push(applyOperation(operator.pop(), operand.pop(), operand.pop()));
	 }
         return operand.pop();
   }
	
   //Check Precedence of an Operators
   public static boolean checkPrecedence (char operator1, char operator2){
      if(operator2 == '(' || operator2 == ')')
        return false;
      else if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-'))
        return false;
      else
        return true;
    }
    
   //Evaluate  
   public static int applyOperation(char operator, int operand2, int operand1){
      switch (operator){
        case '+':
            return operand1 + operand2;
        case '-':
            return operand1 - operand2;
        case '*':
            return operand1 * operand2;
        case '/':
            if (operand2 == 0)
                throw new UnsupportedOperationException("Cannot divide by zero");
            return operand1 / operand2;
        }
        return 0;
    }
	
    public static void main(String args[]){
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter Infix Expression : ");
       String infix=sc.next();
       System.out.println("value of infix expression is : " + evaluate(infix));
    }
}	
