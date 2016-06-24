
public class Search_in_Rotated_Sorted_Array_33 {
	public static void main(String[] args) {
		Search_in_Rotated_Sorted_Array_33 p = new Search_in_Rotated_Sorted_Array_33();
		int a [] = {1};
		System.out.println(p.search(a, 3));
	}
	
	public int search(int[] nums, int target){
		 int pivot = 0;//代表最小元素的位置
		 for(int i = 1 ; i < nums.length ; i ++){
			 if( nums[i] < nums[i-1] ){
				 pivot = i;
				 break;
			 }
		 } 
		return binserach(nums,target,0,nums.length-1,pivot);
	 }
	 public int binserach(int[] nums, int target ,int left ,int right,int pivot){
		 if(left > right ) return -1;
		 int mid = ( left + right ) / 2;
		 int realmid  = (mid +pivot) % nums.length;//用realmid的值进行比较
		 if(target == nums[realmid])
			 return realmid;
		 else if(target > nums[realmid])
			 return binserach(nums, target, mid+1 ,right,pivot);
		 else
			 return binserach(nums, target ,left,mid-1,pivot);
	 }
//		public int search(int[] A, int target){
//			int n = A.length;
//		        int lo=0,hi=n-1;
//		        // find the index of the smallest value using binary search.
//		        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
//		        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
//		        while(lo<hi){
//		            int mid=(lo+hi)/2;
//		            if(A[mid]>A[hi]) lo=mid+1;
//		            else hi=mid;
//		        }
//		        // lo==hi is the index of the smallest value and also the number of places rotated.
//		        int rot=lo;
//		        lo=0;hi=n-1;
//		        // The usual binary search and accounting for rotation.
//		        while(lo<=hi){
//		            int mid=(lo+hi)/2;
//		            int realmid=(mid+rot)%n;
//		            if(A[realmid]==target)return realmid;
//		            if(A[realmid]<target)lo=mid+1;
//		            else hi=mid-1;
//		        }
//		        return -1;
//	}
}
