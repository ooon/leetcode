package Array;

public class Find_Minimum_in_RSA {
	public static void main(String[] args) {
		Find_Minimum_in_RSA f= new Find_Minimum_in_RSA();
		int [] nums = {2,1};
		System.out.println(f.findMin(nums));
	}
	 public int findMin(int[] nums) {
	        int lo = 0;
	        int hi = nums.length -1;
	        while(lo < hi){
	            if(nums[lo] <= nums[hi]) 
	                return nums[lo] ;
	            int mid = (lo + hi) /2;
	            if(nums[mid] > nums[hi]){
	                lo = mid + 1;
	            }else{
	                hi = mid;
	            }
	        }
	        return nums[lo];
	    }
}
