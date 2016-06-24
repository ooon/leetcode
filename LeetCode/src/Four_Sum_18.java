import java.util.*;
public class Four_Sum_18 {
    //应该是dfs
	public static void main(String[] args) {
		Four_Sum_18 f = new Four_Sum_18();
		int[] nums = {-1,-5,-5,-3,2,5,0,4
				};
				
 		int target = -7;
 		System.out.println(f.fourSum(nums,target));
	}
	/**
	 * 注意思路，找两个pivot，左右的pivot都要去重复的
	 * 找到pivot之后，找另外两个数的时候注意做去重操作
	 * 时间复杂度为O（N^2）
	 * @param nums
	 * @param target
	 * @return
	 */
    public List<List<Integer>> fourSum(int[] nums, int target) {
       List<List<Integer>> result= new ArrayList<List<Integer>>();
       Arrays.sort(nums);
       System.out.println(Arrays.toString(nums));
		for(int i = 0; i < nums.length - 3 ; i ++){
			if(i > 0 && nums[i] == nums[i-1]) continue;//左去重
			for(int j =i+1 ; j < nums.length -2 ; j++){
				if(nums[j] == nums[j-1] && j !=i+1) continue;//左去重
				find(nums,target,i,j,result);
			}
		}
       return result;
    }
    public void find(int[] nums,int target,int i,int j,List<List<Integer>> result){
    	int left =  j+1;
    	int right = nums.length-1;
    	while(right > left){
    		if(nums[i]+nums[j]+nums[left]+nums[right] == target){
    		    result.add(
    		    		Arrays.asList(
    		    				nums[i] ,nums[j], nums[left] ,nums[right]));
    		    //右去重
    		    while(right > left && nums[right] == nums[right-1]) right--;
        		while(left < right && nums[left] == nums[left+1]) left++;
    		    ++ left;
    		    --right;
    		}else if(nums[i]+nums[j]+nums[left]+nums[right] < target){
    			++left;
    		}else{
    			--right;
    		}
    	}
    }
}
