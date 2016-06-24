
public class Palindrome_Number_9 {
	public static void main(String[] args) {
		
		System.out.println(new Palindrome_Number_9().isPalindrome(-2147447412));
	}
	/**
	 * 1） 把x逆转，逆转后若等于原数字即可，若溢出则必定不等于原数字
	 * 2）每次分别取最高位与最低位进行比较，之前要先遍历数字得到其最高位。
	 * @param x
	 * @return
	 */
	 public boolean isPalindrome(int x) {
		  if( x < 0 ){
              return false;//负数不用看，没回文这一说？
          }
	       int t = 0;
	       int y = x;
	       while(true){
	           //遇到以下情况会发生溢出；正向无溢出，反向却溢出，说明正反不相等
	         if( t > Integer.MAX_VALUE/10 
	            || (t == Integer.MAX_VALUE/10 && x%10 >Integer.MAX_VALUE%10)){
	                return false;
	            }
	         t = t*10 +y%10;    
	         y = y /10; 
	         if(y ==0) break;
	       }
	      if(x ==t) return true;
	      return false;
	    }
}
