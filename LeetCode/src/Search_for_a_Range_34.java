import java.util.Arrays;


public class Search_for_a_Range_34 {
	public static void main(String[] args) {
		int a []= {1,3};
		Search_for_a_Range_34 d = new Search_for_a_Range_34();
		System.out.println(Arrays.toString(d.searchRange(a, 1)));
	}
	 public int[] searchRange(int[] nums, int target) {
	        int[] result = new int[2];
	        result[0] = result[1] = -1;
	        int low  = 0;
	        int high = nums.length-1 ;
	        int mid = (low + high)/2;
	        while(low <= high){
	            mid = (low + high)/2;
	            if(nums[mid] == target){
	                //找到之后以mid为中心进行搜索
	                int left =mid;
	                int right = mid;
	                while(left  >  low && nums[left-1]  == target )left --;
	                while(right < high && nums[right+1] == target )right++;
	                result[0] = left;
	                result[1] = right;
	                return result;
	            } else if(target <nums[mid]){
	                high = mid-1;
	            }else{
	                low = mid+1;
	            }
	        }
	        return result;
	    }
}

