
public class Bitwise_AND_of_Numbers_Range {
	public static void main(String[] args) {
		Bitwise_AND_of_Numbers_Range ba = new Bitwise_AND_of_Numbers_Range();
		System.out.println(ba.rangeBitwiseAnd(5, 7));
	}
	public int rangeBitwiseAnd(int m, int n) {
        if(m == 0){
            return 0;
        }
        int moveFactor = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }
}
