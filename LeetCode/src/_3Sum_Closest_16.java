import java.util.*;




public class _3Sum_Closest_16 {
	public static void main(String[] args) {
		int nums[] = {13,2,0,-14,-20,19,8,-5,-13,-3,20,15,20,5,13,14,-17,-7,12,-6,0,20,-19,-1,-15,-2,8,-2,-9,13,0,-3,-18,-9,-9,-19,17,-14,-19,-4,-16,2,0,9,5,-7,-4,20,18,9,0,12,-1,10,-17,-11,16,-13,-14,-3,0,2,-18,2,8,20,-15,3,-13,-12,-2,-19,11,11,-10,1,1,-10,-2,12,0,17,-19,-7,8,-19,-17,5,-5,-10,8,0,-12,4,19,2,0,12,14,-9,15,7,0,-16,-5,16,-12,0,2,-16,14,18,12,13,5,0,5,6};
				
		int target = -59;
		System.out.println(new _3Sum_Closest_16().threeSumClosest(nums, target));
	}
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result = nums[0]+nums[1]+nums[2]; 
		//O(n^2)的解法，与求三个数的和等于0类似的 方法。排序，固定一个指针，
		//移动另外两个指针，移动时用和与target比较大小
		for(int i = 0 ; i < nums.length; i ++){
			//  加上左去重
			if(i>0 && nums[i] == nums[i]-1) continue;
			int j = i+1;
			int k = nums.length-1;
			while( j < k ){
				int sum = nums[i]+ nums[j]+ nums[k];
				if(Math.abs(result-target) > Math.abs(sum-target)){
					result = sum;
				}
				if(sum == target) return result;
				else if(sum < target) j++;
				else k--;
			}
		}
		return result;
	} 
	
}
