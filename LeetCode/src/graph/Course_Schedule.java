package graph;
import java.util.*;
public class  Course_Schedule {
	public static void main(String[] args) {
		Course_Schedule cs = new Course_Schedule();
		int[][] prerequisites ={{1,0},{2,1},{2,0}};
		System.out.println(cs.canFinish(3, prerequisites));
	}
	
	
	 public boolean canFinish(int numCourses, int[][] prerequisites) {
	        if(prerequisites.length == 0) return true;
	        //入度数组
	        int[] in = new int[numCourses];
	        //图
	        int[][] graph = new int[numCourses][numCourses];
	        //加入到排序的序列
	        List<Integer> top = new ArrayList<Integer>();
	        //构件图，统计入度
	        for(int i = 0 ; i < prerequisites.length ; i ++){
	            in[prerequisites[i][1]] += 1;
	            graph[prerequisites[i][0]][prerequisites[i][1]] =1;
	        }
	        while(top.size() < numCourses){
	            int cur = find(in,top);
	            if(cur == -1) break;
	            top.add(cur);
	            for(int j = 0 ; j < numCourses ; j++){
	                if(graph[cur][j] == 1)  in[j] -- ;
	            }
	        }
	       return top.size() == numCourses ? true :false;
	    }
	    public int find(int[] in,List<Integer> top){
	        for(int i = 0 ; i < in.length ; i ++)
	            //入度为0，且没有排序过的节点
	            if(in[i]  == 0 && !top.contains(i)) return i;
	        return -1;
	    }
}

