
public class Reverse_Integer {
	public static void main(String args[]){
		System.out.println(reverse(1463847412));
	}
	 public static int reverse(int x) {
	       int flag = 0;
	       if(x<0){
	    	   if(x<-2147483647){
	    		   return 0;
	    	   }
	           x *=(-1);
	           flag = 1;
	       }
	       int sum =0;
	       while(true){
	           int y = x/10;
	           sum  += x%10;
	           x=y;
	           if(y<1) break;
	           //这里sum马上就要*10了，如果sum>MAX_INT/10，那么必然导致溢出，溢出就返回0就好了
	           if(sum>214748364) return 0;
	          
	           sum*=10;
	       }
	       if(flag == 1)
	        return sum*(-1);
	       else
	        return sum;
	    }
}


