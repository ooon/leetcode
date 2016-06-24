import java.util.*;
public class Combinations {
	public static void main(String[] args) {
		Combinations c = new Combinations();
		System.out.println(c.combine(3, 2));
	}
	 public List<List<Integer>> combine(int n, int k) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        List<Integer> tmp = new ArrayList<Integer>();
	        dfs(res,1,n,k,tmp);
	        return res;
	    }
	    public void dfs(List<List<Integer>> res ,int idx, int n , int k, List<Integer> tmp){
	        if(tmp.size() == k){
	            res.add(new ArrayList<Integer>(tmp));
	            return;
	        }
	        for(int i =idx ; i <= n ; i ++){
	        	tmp.add(i);
	            dfs(res, ++idx, n ,k ,tmp);
	            tmp.remove(tmp.size()-1);
	        }
	    }
}
