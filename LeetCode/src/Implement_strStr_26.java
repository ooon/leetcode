
public class Implement_strStr_26 {
	public static void main(String[] args) {
		Implement_strStr_26 i = new Implement_strStr_26();
		System.out.println(i.strStr("aaa", "a"));
	}
	public int strStr(String haystack, String needle) {
        if(needle == "") return 0;
        int index = -1;
        for(int i = 0 ; i < haystack.length() ; i ++){
            if(needle.charAt(0) == haystack.charAt(i)){
                if(haystack.length() - i  < needle.length() ) return -1;
                index = i;
                int j = i;
                int k = 0;
                while(k<needle.length() && j < haystack.length() 
                		&& needle.charAt(k) == haystack.charAt(j)){
                	k++;
                	j++;
                }
                if(k != needle.length()){
                    index =-1;
                    continue;
                } 
                return index;
            }
        }
        return index;
}
	}
