package Array;

public class First_Missing_Positive_41 {
	public static void main(String[] args) {
		First_Missing_Positive_41 f = new First_Missing_Positive_41();
		int nums[] = {8,7,3,2,6,7,8,9};
		System.out.println(f.firstMissingPositive(nums));
	}
	 public int firstMissingPositive(int[] nums) {
		 if(nums.length == 0 ) return 1;
		 int temp = 0;
		 int pos = 0 ;
		 while(pos < nums.length){
			 if(nums[pos]>0 && nums[pos]<=nums.length
					 && nums[pos]!=pos+1 && nums[pos]!=nums[nums[pos]-1]){
				 temp = nums[pos];
				 nums[pos] = nums[temp-1];
				 nums[temp - 1] = temp;
			 }else{
				 ++ pos;
			 }
		 }
		 for(int i = 0 ; i < nums.length ; i ++){
			 if(nums[i] !=i+1 )return i+1;
		 }
		 return nums.length+1;
	 }
}
 