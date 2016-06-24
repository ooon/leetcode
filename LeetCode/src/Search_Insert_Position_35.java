
public class Search_Insert_Position_35 {
	public static void main(String[] args) {
		Search_Insert_Position_35 s= new Search_Insert_Position_35();
		int a[] = {1,3};
		System.out.println(s.searchInsert(a, 4));
	}
	 public int searchInsert(int[] nums, int target) {
	        int low = 0;
	        int high = nums.length-1;
	        int mid = 0;
	        while(low <= high){
	            mid = (low + high) / 2;
	            if(nums[mid] == target){
	                return mid;
	            }else if (nums[mid] < target){ 
	                low = mid+1;
	            }else{
	                high = mid-1;
	            }
	        }
	        return low;
	    }
}
