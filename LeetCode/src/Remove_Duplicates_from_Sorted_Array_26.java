
public class Remove_Duplicates_from_Sorted_Array_26 {
	public static void main(String[] args) {
		Remove_Duplicates_from_Sorted_Array_26 p = new Remove_Duplicates_from_Sorted_Array_26();
		int[] nums = {1,1};
		System.out.println(p.removeDuplicates(nums));
	}
	 public int removeDuplicates(int[] nums) {
		  if(nums.length <=1) return nums.length;
		    int index = 0;
		    for(int i =0 ; i < nums.length ; i ++){
		        if( i>0 && nums[i]!= nums[i-1]) {
		            nums[index++] = nums[i];
		        }
		    }
		    return index;
	    }
	 public int removeElement(int[] nums, int val) {
	        if(nums == null) return 0;
	        //记录之前有没有遇到过val
	        boolean flag =false;
	        int index = 0;
	        for(int i = 0 ; i < nums.length ; i ++)
	        {
	           if( nums[i] == val){
	               flag = true;
	               continue;
	           }
	           nums[index ++] = nums[i];
	        }
	        if(flag) return index;
	        return nums.length;
	    }
	 public int removeElement1(int[] A, int elem) {
		   int m = 0;    
		   for(int i = 0; i < A.length; i++){

		       if(A[i] != elem){
		           A[m] = A[i];
		           m++;
		       }
		   }

		   return m;
		}
}
