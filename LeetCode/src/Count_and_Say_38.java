
public class Count_and_Say_38 {
	public static void main(String[] args) {
		Count_and_Say_38 c = new Count_and_Say_38();
		System.out.println(c.countAndSay(6));
	}
	 public String countAndSay(int n) {
		 if( n <= 0 ) return "";
		 String say = "1";
		 for(int i = 1 ; i < n ; i ++){
			 say = listen(say);
		 }
		 return say;
	 }
	 public String listen(String say){
		 String ss= "";
		 int count = 0 ;
		 char last = say.charAt(0);
		 for(int i = 0 ; i < say.length() ; ++i )
		 {
			 if(say.charAt(i) == last)
			 {
				 ++ count;
			 }else{
				 ss = ss + (count+"") + last;
			 	 count = 1;
			 	 last = say.charAt(i);
			 }
		 }
		 ss = ss + (count+"") + last;
		 return ss;
	 }
}
