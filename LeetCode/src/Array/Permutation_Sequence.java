package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation_Sequence {
	public static void main(String[] args) {
		System.out.println(new Permutation_Sequence().getPermutation(9, 171669));
	}
	
	 public String getPermutation(int n, int k) {
		   StringBuilder sb = new StringBuilder();
		   int arr[] = new int[n];
		   for(int i = 0 ; i < n ; i ++){
			   arr[i] = i+1;
		   }
		   List<String> ss  = new ArrayList<String>();
		   Permutation(arr,new Integer(k),0,sb,ss);
		   return ss.get(k-1);
	    }
	    public void Permutation(int[] arr, Integer k, int start,StringBuilder res,List<String> ss){
	        if(res.length() == arr.length){
	        	ss.add(res.toString());
	        	if(ss.size() == k ) return;
	        }
	        for(int i = start ; i < arr.length ; i ++){
	        	swap(arr,start,i);
	        	res.append(arr[start]);
	            Permutation(arr,k,start+1,res,ss);
	            swap(arr,i,start);
	        	res.deleteCharAt(res.length()-1);
	        }
	    }
	    public void swap(int[] arr,int i,int j){
	    	int tmp = arr[i];
	    	arr[i] =arr[j];
	    	arr[j] = tmp;
	    }
}
