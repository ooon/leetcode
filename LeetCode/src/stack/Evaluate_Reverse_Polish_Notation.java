package stack;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
	
	public static void main(String[] args) {
		Evaluate_Reverse_Polish_Notation f = new Evaluate_Reverse_Polish_Notation();
		String[] s = {"3","-4","+"};
		System.out.println(f.evalRPN(s));
		System.out.println((char)('A'^256));
	}
	 public int evalRPN(String[] tokens) {
	        Stack<String> s = new Stack<String>();
	        for(String str : tokens){
	          if(str.length() > 1 || str.charAt(0) -'0' 
	        		  <= 9 && str.charAt(0) - '0' >= 0 )
	        	  s.push(str);
	          else 
	        	  s.push(operate(s,str));
	        }
	        return Integer.valueOf(s.pop());
	    }
	    public String operate(Stack<String> s, String op){
	        int num2 = Integer.valueOf(s.pop());
	        int num1 = Integer.valueOf(s.pop());
	        int res = 0;
	        switch(op){
	            case "+":
	                res = num1+num2;
	                break;
	            case "-":
	                res = num1-num2;
	                break;
	            case "*":
	                res = num1*num2;
	                break;
	            case "/":
	                res = num1/num2;
	                break;
	        }
	        return res+"";
	    }
}
