//leetcode 2nd 2015/2/11
//Mingxuan Wang
//subsetsWithDup

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0){
			return result;
		}
		
		Arrays.sort(num);
		List<Integer> path = new ArrayList<Integer>();
		dfs(num, result, path, 0);
		return result;
    }
	
	private void dfs(int[] num, List<List<Integer>> result, List<Integer> path, int start){
		result.add(new ArrayList<Integer>(path));
		for (int i = start; i < num.length; i++){
			if (i != start && num[i] = num[i -1 ]){
				continue;
			}
			path.add(num[i]);
			dfs(num, result, path, i + 1);
			path.remove(path.size() - 1);
		}
	}
}