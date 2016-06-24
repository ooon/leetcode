package Array;
import java.util.*;

public class Permutations_46 {
	public static void main(String[] args) {
		int[] a = {-1,2,-1,2,1,-1,2,1};
		Permutations_46 p = new Permutations_46();
		System.out.println(p.permute(a));
	}
	// 基本思路: permutation of A[1..n] equals to
    // A[1] + permutation of (A[1..n] - A[1])
    // A[2] + permutation of (A[1..n] - A[2])
    // ...
    // A[n] + permutation of (A[1..n] - A[n]).
	public List<List<Integer>> permute(int[] nums) {
	   List<List<Integer>> result = new ArrayList<List<Integer>>();
	   find(nums,0,result);
	   return result;
	 }
	/**
	 * 
	 * @param nums 待枚举的数组
	 * @param begin 起始位置
	 * @param res 结果集
	 * 
	 */
	
	public void find(int[] nums, int begin ,List<List<Integer>> result){
		if (begin == nums.length){
			List<Integer> tmp = new ArrayList<Integer>();
			for(int i = 0 ; i < nums.length ; i ++){
				tmp.add(nums[i]);
			}
			result.add(tmp);
			return;
		}
		for(int i = begin ; i < nums.length ; i ++){
			if( begin != i && nums[begin] == nums[i]) continue;
			swap(nums,begin ,i);
			find(nums,begin +1 , result);
			swap(nums,i, begin);
		}
		
	}
	public void swap(int[] nums,int a,int b){
		if(a== b ) return;
		int temp ;
		temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
