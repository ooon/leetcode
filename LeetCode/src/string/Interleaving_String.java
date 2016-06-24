package string;


public class Interleaving_String {
	//s3 是由交错的s1 s2形成的
	public static void main(String[] args) {
		String s1 = "ab";
		String	s2 = "bc";
		
		
		
		System.out.println(isInterleave(s1,s2,"bbac"));
//	
//				When s3 = "aadbbcbcac", return true.
//				When s3 = "aadbbbaccc", return false.
	}
	 public static boolean isInterleave(String s1, String s2, String s3) {
	      int l1 = s1.length();
	      int l2 = s2.length();
	      int l3 = s3.length();
	      if(l1 +l2 != l3) return false;  
	      int[][] dp = new int[l1+1][l2+1];
	      dp[0][0] = 1;  
	      //横向放S2
	      for(int j = 0; j < l2 ;j ++){
	    	 if(s3.charAt(j) == s2.charAt(j))dp[0][j+1] = 1;
	    	 else break;
	      }
	      //纵向放S1
	      for(int i = 0; i < l1; i ++){
	    	  if(s3.charAt(i) == s1.charAt(i))dp[i+1][0] = 1;
		      else break;
	      }
//	      
//	  	String s1 =  "aabaac";
//		String	s2 = "aadaaeaaf";
//		String s3 =  "aadaaeaabaafaac";
	      for(int i = 1 ; i < dp.length ; i ++){
	    	  for(int j = 1 ; j < dp[0].length ; j ++){
	    		if(s3.charAt(i+j-1) == s2.charAt(j-1) 
	    				&&  dp[i][j-1] == 1) dp[i][j] =1;
	    		if(s3.charAt(i+j-1) == s1.charAt(i-1) 
	    				&& dp[i-1][j] ==1) dp[i][j] =1;
	    		
	    	  }
	      }
	      for(int i = 0 ; i < dp.length ; i ++){
	    	  for(int j = 0 ; j < dp[0].length ; j ++){
	    		System.out.print(dp[i][j]+"   ");
	    		
	    	  }
	    	  System.out.println();
	      }
	      return dp[l1][l2]==1 ?true :false ;
	        
	 }
}
