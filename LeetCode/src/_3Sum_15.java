import java.util.*;
public class _3Sum_15 {
	public static void main(String[] args) {
		int[] a = {-1,0,1,2,-1,-4};
		System.out.println(new _3Sum_15().threeSum(a));
	}
//	 public List<List<Integer>> threeSum(int[] nums) {
//		 Arrays.sort(nums);
//		 int target = 0;
//		 List<Integer> cur  = new ArrayList<Integer>();
//		 List<List<Integer>> result = new ArrayList<List<Integer>>(0);
//		 dfs(nums,0,result,cur,target);
//		 return result;
//	 }
//	 public void dfs(int[] nums, int j,List<List<Integer>> result, List<Integer> current, int target){
//		 if(current.size( ) > 3 ) return;
//		 if(target == 0 && current.size() == 3){
//			 if(result.contains(current)) return;
//			 result.add(new ArrayList<Integer>(current));
//			 return;
//		 }
//		 for(int i = j ; i < nums.length ; i ++){
//			 current.add(nums[i]);
//			 dfs(nums,++j,result,current,target-nums[i]);
//			 current.remove(current.size()-1);
//		 }
//	 }
	 /**
	  * 思路，本来是按照以前那个深度遍历找target的思路来的，但是那样说超出了复杂度
	  * so，另辟蹊径，固定一个数pivot，从这个数的右边开始到结尾弄俩指针找就行 
	  * 注意循环中加注释的去重部分，去重之后就不必再考虑加入结果时会出现重复的情况
	  * 一边是左端去重，一边是右端去重，这个算法很精巧
	  * @param nums
	  * @return
	  */
	 public List<List<Integer>> threeSum(int[] nums) {
		 Arrays.sort(nums);
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 if(nums == null || nums.length < 3 )return result;
		 for(int i = 0 ; i < nums.length-1 ; i ++){
			 // 左端去重，有重复的则跳过
			 if(i > 0 && nums[i] == nums[i-1]) continue;
			 find(nums ,i+1 ,nums.length-1,result);
		 }
		 return result;
	 }
	 public  void find(int[] nums,int left , int right , List<List<Integer>> result){
		 int l = left ; 
		 int r = right;
		 while(l<r){
			 if( nums[left-1]+ nums[l]+ nums[r] == 0){
				 result.add(Arrays.asList(nums[left-1],nums[l],nums[r]));
				 //为了避免遍历时的出现重复的情况，比如i= -3时出现l=-4，r=7这种情况（-4，-4,5,6,7,7）
				 //这里进行进一步的右端去重工作
				 while(l < r && nums[l] == nums[l+1]) l++;
				 while(l < r && nums[r] == nums[r-1]) r--;
				 l++;
				 r--;
			 }else if ( nums[left-1]+ nums[l]+ nums[r] < 0){
				 l++;
			 }else{
				 r--;
			 } 
		 }
	 }
}
