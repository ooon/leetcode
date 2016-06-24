import java.util.LinkedList;
import java.util.List;


public class Letter_Combinations_of_a_Phone_Number_17 {
	public static void main(String[] args) {
		
		Letter_Combinations_of_a_Phone_Number_17 dp = new Letter_Combinations_of_a_Phone_Number_17();
		System.out.println(dp.letterCombinations("23456"));
	}
	/**
	 * 随手一写居然写了个DFS，我真的是惊呆了，半个小时完成，哈哈！
	 */
//	 String[] mapping = {"0","1", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz" };

//	 public List<String> letterCombinations(String digits) {
//	      List<String> result = new LinkedList<String>();
//	      if(digits.length() == 0) return result;
//	      dfs(digits,0,result,new String());
//		  return result;
//	   }
//	  public void dfs(String digits,int begin,List<String> result,String temp){
//		  if(temp.length() == digits.length()){
//			  result.add(temp);
//			  return;
//		  }
//		  for(int i = begin ; i < digits.length() ; i++){
//			  String button = mapping[digits.charAt(i)-'0'];
//			  for(char ch : button.toCharArray()){
//				  temp += ch; //加上当前的字符，开始执行递归
//				  dfs(digits,i+1,result,temp);//i+1 虽然会越界，但不满足下次的条件，所以会回到递归调用的地方
//				  temp = temp.substring(0, temp.length()-1);//递归完成后就清楚上一次不满足的结果
//			  }
//		  }
//	  }
	//大牛的用FIFO队列的方法，也是一种思想，可以参考一下
	public List<String> letterCombinations(String digits) {
	    LinkedList<String> ans = new LinkedList<String>();
	    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	    ans.add("");
	    for(int i =0; i<digits.length();i++){
	        int x = Character.getNumericValue(digits.charAt(i));
	        while(ans.peek().length()==i){
	            String t = ans.remove();
	            for(char s : mapping[x].toCharArray())
	                ans.add(t+s);
	        }
	    }
	    return ans;
	}
}
