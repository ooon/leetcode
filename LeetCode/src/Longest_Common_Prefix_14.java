
	public class Longest_Common_Prefix_14 {
	   public static void main(String[] args) {
		   String[] arg = {"a","b"};
		   Longest_Common_Prefix_14 lcp = new Longest_Common_Prefix_14();
		   System.out.println(lcp.longestCommonPrefix(arg));
	   }
		
	    public String longestCommonPrefix(String[] strs) {
	        String result ="";
	        if(strs.length ==0) return result;
	        if(strs.length == 1) return strs[0];
	        int N = Integer.MAX_VALUE;
	        for(int i = 0 ; i < strs.length ; i++){
	        	if(strs[i].length() == 0 ) return "";
	        	if(strs[i].length()< N) N = strs[i].length();
	        }
	        for(int i = 0 ; i < N ; i ++)
	        {
		    	for(int j = 0 ; j < strs.length-1 ; j ++)
		        {
		        	 if(strs[j].charAt(i) != strs[j+1].charAt(i))
		        	 {
		        		 break;
		        	 }
		        }
		    	result+= strs[0].charAt(i);
	        }
	        return result;
	    }
	}
//	    
//	    //Tire树的代码
//	    class Node{
//			Node[] children;
//	        char content;// 节点内容
//	        String str;
//	        int depth;//记录深度
//	        int common;
//	    }
//	    //给定根节点与带插入子串，构造Tire树
//	    public void insert(Node root, String content)
//	    {
//	    	Node p = root;
//	    	String tempStr ="";
//	        for(char c : content.toCharArray())
//	        {
//	        	if(p.children[(int)c] == null)
//	        	{
//	        		Node temp = new Node();
//	        		temp.content = c;
//	        		temp.depth = p.depth+1;
//	        		temp.children = new Node[256];
//	        		p.children[(int)c] = temp;
//	        		p = temp;
//	        	}
//	        	else
//	        	{
//		        	 tempStr += c;
//		        	 p.str = tempStr;
//	        		 p.common++;
//	        		 p = p.children[(int)c];
//	        	}
//	        }
//	    }
	

