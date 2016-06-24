package Array;

import java.util.Arrays;

public class Next_Permutation {
	public static void main(String[] args) {
		Next_Permutation np = new Next_Permutation();
		int[] nums = {3,2,1};
		np.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
	 public void nextPermutation(int[] nums) {
	        if(nums.length < 2 ) return;
	        int pos = -1, k = 0;
	        //从倒数第2个数向前遍历，，找到一对为升序的相邻元素
	        for(int i = nums.length-2 ; i >=0 ; --i ){
	            if(nums[i] < nums[i+1]) {
	            	pos = i; 
	            	break;
	            }
	        }
	        //不存在升序元素
	        if(pos < 0){
	        	reverse(nums,0,nums.length-1);
	        	return;
	        }
	        //存在相邻的升序元素，找到i之后最后一个比nums[i]大的元素
	        for(k = nums.length-1 ; k > pos ; --k ){
	            if(nums[pos] < nums[k] )  {
	            //  swap  pos 和 k
		            int tmp = nums[k];
		            nums[k] = nums[pos];
		            nums[pos] = tmp;
	            	break;
	            }
	        }
	        
	        
	        reverse(nums,pos+1,nums.length-1);
	    }
	    public void reverse(int nums[], int start, int end){
	        while( start < end){
	            int tmp = nums[start];
	            nums[start] = nums[end];
	            nums[end] = tmp;
	            ++start;
	            --end;
	        }
	    }
}
