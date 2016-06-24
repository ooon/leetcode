package string;

public class Additive_Number {
	public static void main(String[] args) {
		Additive_Number an = new Additive_Number();
		System.out.println(an.isAdditiveNumber("1991001"));
	}
	public boolean isAdditiveNumber(String num) {
		int L = num.length ();
        //通过合适的方式找到第一个数 A，根据A找到B，用A,B 迭代去判断
		for(int i = 1 ; i <= (L-1)/2 ; i ++){
			if(num.charAt(0) == '0' && i >= 2) break;
			//第一个数长度为 i ，第二个数长度为 j-i ， 剩余的长度(L-j)必须>=max(i,j-i)
			for(int j = i + 1; L-j >= i && L-j >= j-i ;j++){
				if(num.charAt(i) =='0'&& j-i > 2) break;
				long n1 = Long.parseLong(num.substring(0, i));
				long n2 = Long.parseLong(num.substring(i, j));
				String rest = num.substring(j); //余下的串
				if(ok(rest,n1,n2)) return true;
			}
		}
		return false;
    }
	public boolean ok(String rest,long n1, long n2){

		if(rest.length() == 0) return true;
		long sum = n1 + n2;
		int len = (sum+"").length();
		if(rest.length() < len || !rest.startsWith(sum+"")) return false;
		String next = rest.substring(0, len);
		return ok(rest.substring(len),n2,Long.parseLong(next));
		
	}
}
