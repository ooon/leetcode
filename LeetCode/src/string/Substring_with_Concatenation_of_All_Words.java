package string;
import java.util.*;

public class Substring_with_Concatenation_of_All_Words {
	
	public static void main(String[] args) {
		Substring_with_Concatenation_of_All_Words scaw = new Substring_with_Concatenation_of_All_Words();
		String s = "barbarbarfoothefoobarman";
		String words[] = {"foo","bar"};
		scaw.findSubstring(s, words);

	}
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> ans = new ArrayList<Integer>();
	    int n = S.length(), // n  代表待匹配长度 
	    		cnt = L.length;// cnt 代表带模式串的个数
	    if (n <= 0 || cnt <= 0) return ans;
	
	    // init word occurence
	    Map<String, Integer> dict = new HashMap<String , Integer>();
	    for (int i = 0; i < cnt; ++i) {
	    	if(dict.containsKey(L[i])){
	    		dict.put(L[i], dict.get(L[i])+1);
	    	}else{
	    		dict.put(L[i], 1);
	    	}
	    }
	
	    // travel all sub string combinations
	    int wl = L[0].length();
	    //分别从 <i= 0...1...2...word_len> 的位置开始维持一个滑动窗口来进行判断
	    for (int i = 0; i < wl; ++i) {
	        int left = i, count = 0;
	        Map<String, Integer> tdict = new HashMap<String , Integer>();
	        for (int j = i; j <= n - wl; j += wl) {
	            String str = S.substring(j, j + wl);
	            // 合法串，累加结果
	            if (dict.containsKey(str)) {
	            	if(tdict.containsKey(str))
	            		tdict.put(str, tdict.get(str)+1);
	            	else
	            		tdict.put(str, 1);
	            	
	                if (tdict.get(str) <= dict.get(str)) 
	                    count++;
	                else {
	                    // 遇到多于的串，尽可能右移 、滑动窗口 、
	                    while (tdict.get(str)> dict.get(str)) {
	                        String str1 = S.substring(left, left+wl);
	                        tdict.put(str1, tdict.get(str1)-1);
	                        if (tdict.get(str1) < dict.get(str1)) count--;
	                        left += wl;
	                    }
	                }
	                
	                // 字典没超，且计数达到，自然而然的就得到了一个结果
	                if (count == cnt) {
	                    ans.add(left);
	                    // advance one word
	                    String wd = S.substring(left, left+wl);
	                    tdict.put(wd,tdict.get(wd)-1);
	                    count--;
	                    left += wl;
	                }
	            }
	            // 非法串，重新开始累计计数
	            else {
	                tdict.clear();
	                count = 0;
	                left = j + wl;
	            }
	        }
	    }
	    return ans;
	}
}

