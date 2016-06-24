package Array;

public class Increasing_Triplet_Subsequence_334 {
	public static void main(String[] args) {
		Increasing_Triplet_Subsequence_334 its = new Increasing_Triplet_Subsequence_334();
		int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(its.increasingTriplet(nums));
		
	}
	 public boolean increasingTriplet(int[] nums) {
		 int small = Integer.MAX_VALUE;
	       int big = Integer.MAX_VALUE;
	       for(int n : nums){
	           if( n <= small){
	               small = n;//记录第一小
	           }else if( n <= big){
	               big = n;//记录第二小
	           }else{
	               return true;
	           }
	       }
       return false;
   
	    }
}
