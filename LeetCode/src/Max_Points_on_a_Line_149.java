/**
 *  这个题目简直是太2了，三层循环跑吧，两个点确定一条线后，看第三个点是否落在这条线上，注意相同的店特殊处理就好
 * @author Administrator
 *
 */
public class Max_Points_on_a_Line_149 {
	/**
	 * Definition for a point.
	 * class Point {
	 *     int x;
	 *     int y;
	 *     Point() { x = 0; y = 0; }
	 *     Point(int a, int b) { x = a; y = b; }
	 * }
	 */
	public static void main(String[] args) {
		Max_Points_on_a_Line_149  mp = new Max_Points_on_a_Line_149();
		
		//[[84,250],[0,0],[1,0],[0,-70],[0,-70],[1,-1],[21,10],[42,90],[-42,-230]]
		Point b = mp.new Point(1,1);
		Point c = mp.new Point(1,1);
		Point d = mp.new Point(3,2);
		
//		Point e = mp.new Point(2,2);
//		Point f = mp.new Point(0,-70);
//		Point g = mp.new Point(1,-1);
//		Point h = mp.new Point(21,10);
//		Point i= mp.new Point(42,90);
//		Point j = mp.new Point(-42,-230);
		
		Point[] p = {b,c,d};
		System.out.println(mp.maxPoints(p));
	}
	class Point {
		     int x;
		     int y;
		     Point() { x = 0; y = 0; }
		     Point(int a, int b) { x = a; y = b; }
		     public String toString(){
		    	 return "["+x+" ,"+y+"]";
		     }
		}
	    public int maxPoints(Point[] points) {
 	        int max=0;
 	        if(points.length == 1) return 1;
 	        if(points.length == 2) return 2;
	    	for(int i = 0 ; i < points.length ; i ++){
	    		int temp = 1;
	    		for(int j = i+1 ; j < points.length ; j ++){
		    		if((points[j].x == points[i].x)&&(points[j].y == points[i].y)){
		    			temp++;
			    		max = max > temp ? max : temp;
		    			continue;
		    		}
		    		//这行代码处理前边有一样的点 ，突然出现不一样的情况
		    		if(max > 0) temp =1;
		    		temp++;
		    		for(int k = 0 ; k<points.length ;k++){
		    			if(k ==i || k == j ) continue;
		    			if((points[k].x-points[i].x)*(points[j].y-points[i].y) == (points[k].y-points[i].y)*(points[j].x-points[i].x)){
	        				temp++;
	        			}
		    		}
		    		max = max > temp ? max : temp;
		    		temp = 1;
		        }
	        }
	    	return max;
	    }
	
}
