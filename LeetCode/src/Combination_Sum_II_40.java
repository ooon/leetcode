import java.util.*;


public class Combination_Sum_II_40 {
	public static void main(String[] args) {
		Combination_Sum_II_40 c = new Combination_Sum_II_40();
		int[] candidates = {3,5,6,7,8,8};
		int target = 16;
		System.out.println(c.combinationSum2(candidates, target));
	}
	 //之前做过 combine sum， 这个是 sum 2，先dfs一下试试
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> C = new ArrayList<Integer>();
        dfs(candidates,result,0,C,target);
        return result;
    }
    /**
     * 这是递归，注意递归的退出条件
     * @result：结果集
     * @index : 当前下标
     * @C ：满足条件的集合
     * @target ： 求和的目标值
    **/
    public void dfs(int[] candidates, List<List<Integer>> result,int index, List<Integer> C, int target){
        System.out.println(C);
    	if (target == 0){
        	result.add(new ArrayList<Integer>(C));
            return;
        }
        for(int i = index ; i < candidates.length ; i ++){
            //关键1：去重环节
            if (i > index && candidates[i] == candidates[i-1]) continue;
            if(target < 0 ) return;
            C.add(candidates[i]);
            //关键2： cpmbine sum 是允许元素重复，注意和combine sum的区别
            dfs(candidates,result,i+1,C,target-candidates[i]);
            C.remove(C.size()-1);
        }
    }
}
