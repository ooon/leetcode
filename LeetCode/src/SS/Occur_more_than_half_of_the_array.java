package SS;

public class Occur_more_than_half_of_the_array {
	public static void main(String[] args) {
		Occur_more_than_half_of_the_array om = new Occur_more_than_half_of_the_array();
		int[] a = {8,8,1,8,2,8,3,8,4,8,5};
		om.find(a);
	}
	public void find(int a[]){
		int number = a[0];
		int time =1;
		for(int i = 1 ; i < a.length ; i ++){
			if(a[i] == number) ++time;
			else {
				--time;
				if(time > 0) continue;
				number = a[i];
				if(time <0 ) time = 1;
			}
		}
		System.out.println(number);
	}
	
}

