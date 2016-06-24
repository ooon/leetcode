
public class ZigZag {
	
	public static void mian(String args[]){
		ZigZag zz = new ZigZag();
		System.out.println(zz.convert("PZNSADF", 3));
	}
	 public String convert(String s, int numRows) {
	        StringBuffer res = new StringBuffer();
	        if(s.length() ==0) return null;
	        if(s.length() ==1)return s;
	        if(numRows ==1)return s;
	        char[][] mat=  new char[numRows][s.length()];
	        mat[0][0] = s.charAt(0);
	        int j = 0;
	        for(int i = 1 ; i < s.length() ; i ++){
	           if((i/numRows) %2 ==0)
	                j++;
	            
	             if((i/numRows) %2 ==1)
	                j--;
	            
	            mat[i][j] =s.charAt(i);
	        }
	          for(int K = 1 ; K < s.length() ; K ++){
	              for(int L = 0 ; L <numRows ; L++){
	                  if(mat[K][L]!='\0'){
	                      res.append(mat[K][L]);
	                  }
	              } 
	          }
	          return res.toString();
	    }
}
