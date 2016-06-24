import java.util.*;


public class Repeated_DNA_Sequences_187 {
	public static void main(String[] args) {
		String s = "AAAAAAAAAAA";
		Repeated_DNA_Sequences_187 R = new Repeated_DNA_Sequences_187();
		R.findRepeatedDnaSequences(s);
	}
	// DNA长度为10，从0-10开始滑动长度为10的窗口即可
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();
	    Map<String,Integer> dic = new HashMap<String,Integer>();
		for(int i = 0 ; i < 10 ; i ++){
			int start = i;
			while(start <= s.length()-10){
				String cur = s.substring(start, start+10);
				if(dic.containsKey(cur) && !res.contains(cur)){
					res.add(cur);
				}else{
					dic.put(cur, 1);
				}
				start += 10;
			}
		}
		System.out.println(res);
	    return res;
	}
}
