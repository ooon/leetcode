import java.util.Arrays;
import java.util.Stack;


public class Longest_Valid_Parentheses_32 {
	public static void main(String[] args) {
		String s ="(((()(()";				
		System.out.println(new Longest_Valid_Parentheses_32().longestValidParentheses(s));
	}
	/**
	 * Dynamic Program DP算法
	 * @param s
	 * @return max Valid seq
	 * dp[s.length - 1] = 0;
	 * 
	 * i从n - 2 -> 0逆向求dp[]，并记录其最大值。
	 * 若s[i] == '('，则在s中从i开始到s.length - 1计算dp[i]的值。
	 * 这个计算分为两步，通过dp[i + 1]进行的（注意dp[i + 1]已经在上一步求解）：
	 * 在s中寻找从i + 1开始的有效括号匹配子串长度，即dp[i + 1]，
	 * 跳过这段有效的括号子串，查看下一个字符，其下标为j = i + 1 + dp[i + 1]。
	 * 若j没有越界，并且s[j] == ‘)’，则s[i ... j]为有效括号匹配，dp[i] =dp[i + 1] + 2。
	 * 在求得了s[i ... j]的有效匹配长度之后，若j + 1没有越界，
	 * 则dp[i]的值还要加上从j + 1开始的最长有效匹配，即dp[j + 1]。
	 * 
	 */
	 public int longestValidParentheses(String s) {
	     int ridx = 0;// 当前可以匹配内容的右边的下标
		 int[] dp = new int[s.length()];
	     int max = 0 ;
	     dp[s.length()-1] = 0;
	     
	     for(int i =s.length()-2 ; i >= 0  ; i --){
	    	 
	    	 if(s.charAt(i) == '('){
	    		 ridx = i + dp[i+1] +1 ;
	    		 
	    		 if( ridx < s.length() && s.charAt(ridx) == ')'){
	    			 dp[i] = dp[i+1] + 2 ;
	    			 //解决（（（）））（）,这种问题
	    			 if(ridx + 1 < s.length()){
		    			 dp[i] += dp[ridx+1];
		    		 }
	    		 }
	    	 }
	    	 max = max > dp[i] ? max : dp[i];
	     }
	     System.out.println(Arrays.toString(dp));
		 return max;
	        
	    }
}
